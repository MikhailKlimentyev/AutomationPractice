package utils;

import models.User;
import org.openqa.selenium.WebDriver;

public class TestData {

    public TestData(WebDriver driver) {
    }

    public User newUser(){
        User user = User.builder()
                .firstName("TestFirstName")
                .lastName("TestLastName")
                .email("TestEmail1@malinator.com")
                .password("12345qwer")
                .address("Test address 12")
                .city("Minsk")
                .state("Florida")
                .postalCode("12345")
                .country("United States")
                .phone("37529123456")
                .build();
        return user;
    }
}
