package com.careerit.yml;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String line;
    private String city;
    private String state;
    private Integer zip;
}