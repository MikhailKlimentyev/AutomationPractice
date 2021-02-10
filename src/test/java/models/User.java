package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    String firstName;
    String lastName;
    String email;
    String password;
    String address;
    String city;
    String state;
    String postalCode;
    String country;
    String phone;
}
