package com.evergreen.titz;

/**
 * Created by apollo on 11/22/2016.
 */
public enum Genders {
    GENDERS("male", "female", "genderfluid");

    public String MALE, FEMALE, GENDER_FLUID;

    Genders(String male, String female, String genderFluid) {
        MALE = male;
        FEMALE = female;
    }
}
