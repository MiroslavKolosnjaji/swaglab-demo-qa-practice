package com.myproject.swaglabsdemo.entity;

import lombok.*;

/**
 * @author Miroslav Kološnjaji
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private String userName;
    private String password;
    private String postalCode;
    private String firstName;
    private String lastName;

}
