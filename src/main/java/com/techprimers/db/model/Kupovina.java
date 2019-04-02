package com.techprimers.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Kupovina {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "proizvod_id")
    private Integer proizvod_id;
    @Column(name = "kolicina")
    private Integer kolicina;
    @Column(name = "datum")
    private String datum;
    @Column(name = "kartica_id")
    private Integer kartica_id;

    public Kupovina(Integer id,Integer proizvod_id,Integer kolicina,String datum,Integer kartica_id) {
        this.id=id;
        this.proizvod_id=proizvod_id;
        this.kolicina=kolicina;
        this.datum=datum;
        this.kartica_id=kartica_id;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProizvod_id() {
        return proizvod_id;
    }

    public void setProizvod_id(Integer proizvod_id) {
        this.proizvod_id = proizvod_id;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public String getDate() {
        return datum;
    }

    public void setDate(String date) {
        this.datum=datum;
    }

    public Integer getKartica_id() {
        return kartica_id;
    }

    public void setKartica_id(Integer kartica_id) {
        this.kartica_id = kartica_id;
    }
}
