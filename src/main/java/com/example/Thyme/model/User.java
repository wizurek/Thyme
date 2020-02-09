package com.example.Thyme.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

public class User {


    int id;
    @NotEmpty
    String imie;
    @NotEmpty
    String nazwisko;
    @PositiveOrZero
    int wiek;

    public User(int id, String imie, String nazwisko, int wiek) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }
}