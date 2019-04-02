package com.techprimers.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Korpa {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name="id_proizvoda")
    private int id_proizvoda;
    @Column(name="id_korisnika")
    private int id_korisnika;
    @Column(name="broj_proizvoda")
    private int broj_proizvoda;

    public Korpa(int id,int id_proizvoda,int id_korisnika,int broj_proizvoda){
        super();
        this.id=id;
        this.id_proizvoda=id_proizvoda;
        this.id_korisnika=id_korisnika;
        this.broj_proizvoda=broj_proizvoda;

    }
    public int getId_korpe() {
        return id;
    }

    public void setId_korpe(int id) {
        this.id = id;
    }

    public int getId_proizvoda() {
        return id_proizvoda;
    }

    public void setId_proizvoda(int id_proizvoda) {
        this.id_proizvoda = id_proizvoda;
    }

    public int getId_korisnika() {
        return id_korisnika;
    }

    public void setId_korisnika(int id_korisnika) {
        this.id_korisnika = id_korisnika;
    }

    public int getBroj_proizvoda() {
        return broj_proizvoda;
    }

    public void setBroj_proizvoda(int broj_proizvoda) {
        this.broj_proizvoda = broj_proizvoda;
    }
}
