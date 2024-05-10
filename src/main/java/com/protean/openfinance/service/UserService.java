package com.protean.openfinance.service;

import com.protean.openfinance.dto.UserDto;
import com.protean.openfinance.entity.User;
import com.protean.openfinance.exception.GenericException;
import com.protean.openfinance.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier("modelMapper")
    private ModelMapper modelMapper;

    public UserDto save(UserDto user){
        User userEntity = modelMapper.map(user, User.class);
        userRepository.save(userEntity);
        return user;
    }

    public UserDto getByUserCode(String userCode) throws Exception {

        User byUserCode = userRepository.findByUserCode(userCode);

        if(!Objects.nonNull(byUserCode)){
            throw new GenericException("No record matching record found for usercode "+userCode);
        }
        return modelMapper.map(byUserCode, UserDto.class);
    }
}
