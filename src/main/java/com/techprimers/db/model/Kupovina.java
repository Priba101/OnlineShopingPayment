package com.techprimers.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Kupovina {
    @Id
    @GeneratedValue
    @Column(name="kupovina_id")
    private long kupovina_id;
    @Column(name="proizvod_id")
    private long proizvod__id;
    @Column(name="kolicina")
    private int kolicina;
    @Column(name="datum")
    private String date;
    @Column(name="kartica_id")
    private long kartica_id;

    public Kupovina(){}

    public long getKupovina_id() {
        return kupovina_id;
    }

    public void setKupovina_id(long kupovina_id) {
        this.kupovina_id = kupovina_id;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getKartica_id() {
        return kartica_id;
    }

    public void setKartica_id(long kartica_id) {
        this.kartica_id = kartica_id;
    }

    public long getProizvod__id() {
        return proizvod__id;
    }

    public void setProizvod__id(long proizvod__id) {
        this.proizvod__id = proizvod__id;
    }
}
