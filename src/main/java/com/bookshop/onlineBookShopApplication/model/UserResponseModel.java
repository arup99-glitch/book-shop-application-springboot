package com.bookshop.onlineBookShopApplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseModel {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String role;
}
