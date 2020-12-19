package utils;

import models.User;

import java.util.Random;

public class TestData {

    public static User newUser() {
        return User.builder()
                .firstName("TestFirstName")
                .lastName("TestLastName")
                .email("TestEmail" + generateNewEmail() + "@malinator.com")
                .password("12345qwer")
                .address("Test address 12")
                .city("Minsk")
                .state("Florida")
                .postalCode("12345")
                .country("United States")
                .phone("37529123456")
                .build();
    }

    private static String generateNewEmail() {
        Random random = new Random();
        return String.valueOf(random.nextInt(135));
    }
}
