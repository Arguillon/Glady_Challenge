package com.glady.challenge.service;

import com.glady.challenge.data.entity.UserClient;
import com.glady.challenge.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;


    @Value("${number.days.validity.gifts.deposit}")
    private int nbDaysGiftsValidity;

    public UserClient findByIdWithError(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found, id = " + id));

    }


}
