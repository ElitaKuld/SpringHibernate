package com.example.springhibernate.KompisRESTAPI;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Kompis {
    @Id
    @GeneratedValue
    protected long id;
    protected String namn;
    protected String adress;
    protected String telefonnummer;

    public Kompis(String namn, String adress, String telefonnummer) {
        this.namn = namn;
        this.adress = adress;
        this.telefonnummer = telefonnummer;
    }
}
