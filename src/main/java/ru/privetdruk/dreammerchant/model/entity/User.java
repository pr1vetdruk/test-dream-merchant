package ru.privetdruk.dreammerchant.model.entity;

import lombok.Data;
import ru.privetdruk.dreammerchant.model.enums.State;

import java.time.LocalDate;

public class User {
    private State state;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;
    private String passportSeries; // 3 первые символа
    private String passportNumber; // 3 последних символа

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
