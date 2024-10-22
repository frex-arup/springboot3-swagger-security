package com.arup.service;

import com.arup.dto.UserDto;
import com.arup.entity.User;
import com.arup.mapper.UserMapper;
import com.arup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserDto getUser(String id) {
        User user = userRepository.findById(id)
                .orElseThrow();
        return userMapper.toDto(user);
    }

    public UserDto saveUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    public UserDto updateUser(String id, UserDto userDto) {
        userRepository.findById(id).orElseThrow();
        User updated = userMapper.toEntity(userDto);
        updated.setId(id);
        User updatedUser = userRepository.save(updated);
        return userMapper.toDto(updatedUser);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public Page<UserDto> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toDto);
    }

}
