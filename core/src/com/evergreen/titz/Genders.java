package com.evergreen.titz;

/**
 * Created by apollo on 11/22/2016.
 */
public enum Genders {
    MALE("male"),
    FEMALE("female"),
    GENDER_FLUID("genderfluid");
    
    public final String commonName;

    Genders(String name) {
        this.commonName = name;
    }
}
