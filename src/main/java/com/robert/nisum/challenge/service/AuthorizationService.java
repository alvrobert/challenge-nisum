package com.robert.nisum.challenge.service;

import com.robert.nisum.challenge.dto.UserRegisterDTO;
import com.robert.nisum.challenge.entity.User;
import com.robert.nisum.challenge.repository.UserRepository;
import com.robert.nisum.challenge.exception.NisumException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class AuthorizationService {

    final UserRepository userRepository;
    final UsersService usersService;

    @Autowired
    public AuthorizationService(UserRepository userRepository, UsersService usersService) {
        this.userRepository = userRepository;
        this.usersService = usersService;
    }

    @Transactional
    public User register(UserRegisterDTO registerDto) throws NisumException {
        log.info("register | registerDto={}", registerDto);
        usersService.validNotExistByEmail(registerDto.getEmail());
        User users = usersService.save(registerDto);
        return users;
    }

}
