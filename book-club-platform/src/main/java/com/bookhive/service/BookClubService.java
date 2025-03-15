package com.bookhive.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookhive.converter.CachedPageDTO;
import com.bookhive.converter.PageConverter;
import com.bookhive.dto.club.BookClubDto;
import com.bookhive.dto.club.BookClubResponseDto;
import com.bookhive.dto.user.MembershipDto;
import com.bookhive.entity.BookClub;
import com.bookhive.entity.Membership;
import com.bookhive.entity.User;
import com.bookhive.repository.BookClubRepository;
import com.bookhive.repository.MembershipRepository;
import com.bookhive.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookClubService {



    private final BookClubRepository bookClubRepository;
    private final UserRepository userRepository;
    private final MembershipRepository membershipRepository;
    private final MessageSource messageSource;
    private final CacheManager cacheManager;
    private final PageConverter<BookClubResponseDto> pageConverter;
    private static final String BOOK_CLUB_ALREADY_EXIST = "Book club with this name already exists";
    private static final String BOOK_CLUB_NOT_FOUND_WITH_ID = "BookClub not found with ID: ";

    // Create BookClub
    @CachePut(value = "bookClubs", key = "#result.clubId")
    public BookClubResponseDto createBookClub(BookClubDto bookClubDto) {
        // Check if name is already taken
        if (bookClubRepository.existsByName(bookClubDto.getName())) {
            String message = messageSource.getMessage("book.club.name.exists", null, BOOK_CLUB_ALREADY_EXIST,
                    Locale.getDefault());
            throw new IllegalArgumentException(message);
        }

        User owner = userRepository.findById(bookClubDto.getOwnerId())
                .orElseThrow(() -> new IllegalArgumentException("Owner not found"));

        BookClub bookClub = new BookClub();
        bookClub.setName(bookClubDto.getName());
        bookClub.setDescription(bookClubDto.getDescription());
        bookClub.setOwner(owner);
        bookClub.setCreatedAt(LocalDateTime.now());
        BookClub savedBookClub;
        savedBookClub = bookClubRepository.save(bookClub);

        // Create response DTO using builder
        return BookClubResponseDto.builder()
                .clubId(savedBookClub.getClubId())
                .name(savedBookClub.getName())
                .description(savedBookClub.getDescription())
                .ownerName(savedBookClub.getOwner().getUsername())
                .createdAt(savedBookClub.getCreatedAt())
                .build();
    }

    private CachedPageDTO<BookClubResponseDto> getCachedResult(Cache cache,String key){
        // Try to get from cache
        try {
            if (cache != null) {

                CachedPageDTO<BookClubResponseDto> cachedData = cache.get(key, CachedPageDTO.class);
                if (cachedData != null) {
                    log.info("Cache hit for key: {}", key);
                    return cachedData;
                }
                log.info("Cache miss for key: {}", key);
            }
        } catch (Exception e) {
            log.error("expection while caching: {}", e.getMessage());
        }
        return null;
    }
    public CachedPageDTO<BookClubResponseDto> getAllBookClubsCached(int page, int size, String sortBy) {
        page = Math.max(page, 0);
        size = Math.max(size, 10);
        sortBy = (sortBy != null) ? sortBy : "name";
        // Create cache key
        String key = page + "," + size + "," + sortBy;
        var cache = cacheManager.getCache("allBookClubs");
        // check value in cache
        CachedPageDTO<BookClubResponseDto> cachedPageDTO =getCachedResult(cache,key);
        if(cachedPageDTO!=null){
            return cachedPageDTO;
        }
        Pageable pageable = PageRequest.of(page,size,Sort.by(sortBy).ascending());
        Page<BookClub> bookClubPage = bookClubRepository.findAll(pageable);

        List<BookClubResponseDto> dtoList = bookClubPage.getContent().stream()
                .map(bookClub -> BookClubResponseDto.builder()
                        .clubId(bookClub.getClubId())
                        .name(bookClub.getName())
                        .description(bookClub.getDescription())
                        .ownerName(bookClub.getOwner().getUsername())
                        .createdAt(bookClub.getCreatedAt())
                        .memberCount(bookClub.getMemberships().size())
                        .build())
                .toList();
        
        // Return as CachedPageDTO instead of Page
        CachedPageDTO<BookClubResponseDto> newCachedPageDTO = new CachedPageDTO<>(dtoList,page,size,sortBy,bookClubPage.getTotalElements());
        if (cache != null) {
            cache.put(key, newCachedPageDTO);
        }
        return newCachedPageDTO;
    }

    // Get All BookClubs with Paging and Sorting
    public Page<BookClubResponseDto> getAllBookClubs(int page, int size, String sortBy) {
        CachedPageDTO<BookClubResponseDto> cachedPage = getAllBookClubsCached(page, size, sortBy);
        return pageConverter.convertToPage(cachedPage);
    }

    // Get BookClub by ID
    @Cacheable(value = "bookClubs", key = "#id")
    public BookClubResponseDto getBookClubById(Long id) {
        String message = getBookClubByIdMessage(id);
        BookClub bookClub = bookClubRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(message));

        return BookClubResponseDto.builder()
                .clubId(bookClub.getClubId())
                .name(bookClub.getName())
                .description(bookClub.getDescription())
                .ownerName(bookClub.getOwner().getUsername())
                .createdAt(bookClub.getCreatedAt())
                .build();
    }

    private String getBookClubByIdMessage(Long id) {
        String message = messageSource.getMessage(
                "book.club.not.found",
                new Object[] { id },
                BOOK_CLUB_NOT_FOUND_WITH_ID + id, // Default message
                Locale.getDefault());
        return message;
    }

    // Delete BookClub
    @CacheEvict(value = "bookClubs", key = "#id")
    public void deleteBookClub(Long id) {
        String message = getBookClubByIdMessage(id);
        if (bookClubRepository.existsById(id)) {
            bookClubRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(message);
        }
    }

    // -------------------------------
    // ✅ Member Management
    // -------------------------------

    @Transactional
    public MembershipDto addMember(Long clubId, MembershipDto membershipDto) {
        BookClub bookClub = bookClubRepository.findById(clubId)
                .orElseThrow(() -> new EntityNotFoundException("Book club not found"));

        User user = userRepository.findUserByUsername(membershipDto.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Membership membership = new Membership();
        membership.setBookClub(bookClub);
        membership.setUser(user);
        // TODO update role
        membership.setRole("USER");
        membership = membershipRepository.save(membership);

        return new MembershipDto(membership.getMembershipId(), bookClub.getName(), user.getUsername(),
                membership.getJoinedAt());
    }

    public List<MembershipDto> getMembers(Long clubId) {
        return membershipRepository.findMembersByClubId(clubId)
                .stream()
                .map(m -> new MembershipDto(m.getMembershipId(), m.getBookClub().getName(), m.getUser().getUsername(),
                        m.getJoinedAt()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void removeMember(Long clubId, Long userId) {
        membershipRepository.deleteByBookClubIdAndUserId(clubId, userId);
    }
}
