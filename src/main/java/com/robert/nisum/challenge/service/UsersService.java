package com.robert.nisum.challenge.service;

import com.robert.nisum.challenge.config.helper.CryptoHelper;
import com.robert.nisum.challenge.config.helper.JwtHelper;
import com.robert.nisum.challenge.config.helper.MessageHelper;
import com.robert.nisum.challenge.dto.UserRegisterDTO;
import com.robert.nisum.challenge.entity.User;
import com.robert.nisum.challenge.exception.NisumException;
import com.robert.nisum.challenge.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UsersService {

    private static final ModelMapper modelMapper = new ModelMapper();
    private final UserRepository userRepository;
    private final CryptoHelper cryptoHelper;
    private final JwtHelper jwtHelper;

    public User save(UserRegisterDTO registerDto) {
        log.info("save | registerDto={}", registerDto);
        registerDto.setPassword(cryptoHelper.encode(registerDto.getPassword()));
        registerDto.setToken(jwtHelper.createToken(registerDto.getEmail()));
        return userRepository.save(modelMapper.map(registerDto, User.class));
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void validNotExistByEmail(String email) throws NisumException {
        Optional<User> users = findByEmail(email);
        if (users.isPresent()) {
            throw new NisumException(MessageHelper.MESSAGE_EMAIL_EXISTS);
        }
    }
}
