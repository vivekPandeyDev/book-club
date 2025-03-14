package com.bookhive.service;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        var cache = cacheManager.getCache("users");
        if (cache != null) {
            cache.evict(user.getUserId());
            cache.evict(user.getUsername());
            cache.evict(user.getEmail());
        }

        userRepository.deleteById(id);

    }
}
