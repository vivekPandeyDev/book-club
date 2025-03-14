package com.bookhive.service;

import java.util.ArrayList;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookhive.dto.user.UserRequestDto;
import com.bookhive.dto.user.UserResponseDto;
import com.bookhive.entity.User;
import com.bookhive.repository.UserRepository;
import com.bookhive.util.UserMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CacheManager cacheManager;

    public Page<UserResponseDto> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(UserMapper::toDto);
    }

    @Cacheable(value = "users", key = "#id != null ? #id : (#name != null ? #name : (#email != null ? #email : 'undefined'))")
    public UserResponseDto getUser(Long id, String name, String email) {

        if (id != null) {
            return userRepository.findById(id).map(UserMapper::toDto)
                    .orElseThrow(() -> new EntityNotFoundException("User not found with name: " + name));
        }

        if (name != null && !name.isEmpty()) {
            return userRepository.findUserByUsername(name)
                    .map(UserMapper::toDto)
                    .orElseThrow(() -> new EntityNotFoundException("User not found with name: " + name));
        }

        if (email != null && !email.isEmpty()) {
            return userRepository.findUserByEmail(email)
                    .map(UserMapper::toDto)
                    .orElseThrow(() -> new EntityNotFoundException("User not found with email: " + email));
        }

        throw new IllegalArgumentException("Either id, name, or email must be provided");
    }

    @Transactional
    @CacheEvict(value = "users", key = "#id")
    public void deleteUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        // Remove from cache by id, name, and email
        evictCache(user);

        userRepository.deleteById(id);

    }



    @Transactional
    public UserResponseDto addUser(UserRequestDto request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = getUser(request);
        User savedUser = userRepository.save(user);

        // Convert to DTO
        UserResponseDto userDto = UserMapper.toDto(savedUser);

        // Add to cache
        putCache(userDto);

        return userDto;
    }

    private void putCache(UserResponseDto userDto) {
        var cache = cacheManager.getCache("users");
        if (cache != null) {
            cache.put(userDto.getUserId(), userDto);
            cache.put(userDto.getUsername(), userDto);
            cache.put(userDto.getEmail(), userDto);
        }
    }
    
    private void evictCache(User user) {

        var cache = cacheManager.getCache("users");
        if (cache != null) {
            cache.evict(user.getUserId());
            cache.evict(user.getUsername());
            cache.evict(user.getEmail());
        }
    }
    private User getUser(UserRequestDto request) {
        // Create User using new keyword
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        // TODO : add passwordEncode
        user.setPassword(request.getPassword()); // Encode password
        user.setRole(request.getRole());
        user.setAvatar(request.getAvatar());
        user.setBio(request.getBio());

        // Initialize list fields as empty lists
        user.setMemberships(new ArrayList<>());
        user.setDiscussions(new ArrayList<>());
        user.setComments(new ArrayList<>());
        user.setNotifications(new ArrayList<>());
        user.setReviews(new ArrayList<>());
        user.setFollowers(new ArrayList<>());
        user.setFollwings(new ArrayList<>());
        user.setAchievements(new ArrayList<>());
        user.setRecommendations(new ArrayList<>());

        return user;
    }
}
