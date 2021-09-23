package com.robert.nisum.challenge.helper;

import com.robert.nisum.challenge.dto.UserRegisterDTO;
import com.robert.nisum.challenge.entity.Phone;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHelper {

    public UserRegisterDTO getRegisterDefaultEmpty() {
        return  new UserRegisterDTO();
    }

    public UserRegisterDTO getRegisterDefault() {
        UserRegisterDTO registerDto = new UserRegisterDTO();
        registerDto.setName("Juan Rsodriguez");
        registerDto.setEmail("jua@2rgss.com");
        registerDto.setPassword("RobertAlv33");
        registerDto.setPhones(getPhonesDefault());
        return registerDto;
    }

    public List<Phone> getPhonesDefault() {
        List<Phone> phoneDtos = new ArrayList<>();
        Phone phones = new Phone();
        phones.setNumber("1234567890");
        phones.setCitycode("1");
        phones.setContrycode("56");
        phoneDtos.add(phones);
        return phoneDtos;
    }

}
