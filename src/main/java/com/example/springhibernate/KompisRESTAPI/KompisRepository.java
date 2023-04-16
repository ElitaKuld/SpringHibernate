package com.example.springhibernate.KompisRESTAPI;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KompisRepository extends JpaRepository<Kompis, Long> {

    public List<Kompis> findByNamn(String namn);
    public List<Kompis> findByAdress(String adress);
    public List<Kompis> findByTelefonnummer(String telefonnummer);
}
