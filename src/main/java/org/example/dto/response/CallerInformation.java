package org.example.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class CallerInformation {
    private String phoneNumber;
    private String country;
    private String location;
    private String carrier;
}
