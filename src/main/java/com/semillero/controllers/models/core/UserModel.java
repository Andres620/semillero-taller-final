package com.semillero.controllers.models.core;

public class UserModel {
    private String name;
    private String surname;
    private String identificationCard;

    public UserModel(String name, String surname, String identificationCard) {
        this.name = name;
        this.surname = surname;
        this.identificationCard = identificationCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(String identificationCard) {
        this.identificationCard = identificationCard;
    }
    
}

