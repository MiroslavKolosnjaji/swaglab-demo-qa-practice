package com.myproject.swaglabsdemo.entity.strategy.impl;

import com.myproject.swaglabsdemo.entity.User;
import com.myproject.swaglabsdemo.entity.strategy.TestDataStrategy;

/**
 * @author Miroslav Kološnjaji
 */
public class ErrorUserStrategy implements TestDataStrategy {
    @Override
    public User generateTestUserData() {
        return User.builder()
                .firstName("John")
                .lastName("Doe")
                .postalCode("123512")
                .userName("error_user")
                .password("secret_sauce")
                .build();
    }
}
