package utils;

import models.User;

public class TestData {

    public static User newUser() {
        return User.builder()
                .firstName("TestFirstName")
                .lastName("TestLastName")
                .email("TestEmail11@malinator.com")
                .password("12345qwer")
                .address("Test address 12")
                .city("Minsk")
                .state("Florida")
                .postalCode("12345")
                .country("United States")
                .phone("37529123456")
                .build();
    }
}
