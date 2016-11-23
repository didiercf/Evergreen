package com.evergreen.titz;

/**
 * Created by apollo on 11/22/2016.
 */
public enum Genders {
    MALE("male"),
    FEMALE("female"),
    GENDER_FLUID("genderfluid");
    
    public final String friendlyName; 

    Genders(String name) {
        this.friendlyName = name;
    }
}
