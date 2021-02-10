package utils;

import models.User;

import java.util.Random;

public class TestData {

    public static User newUser() {
        return User.builder()
            .firstName("Mike")
            .lastName("John")
            .email("TestEmail2" + generateNewEmail() + "@malinator.com")
            .password("12345qwer")
            .address("Real Madrid, 5")
            .city("Milan")
            .state("Arizona")
            .postalCode("00000")
            .country("United States")
            .phone("666")
            .build();
    }

    private static String generateNewEmail() {
        Random random = new Random();
        return String.valueOf(random.nextInt(135));
    }
}
