package models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonatoretDto {
    private long id;
    private String name;
    private String surname;
    private String donationCategory;
    private LocalDate birthdate;
    private LocalDate registerDate;
    private boolean active = true;
}