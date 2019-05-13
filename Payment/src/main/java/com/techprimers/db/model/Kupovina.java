package com.techprimers.db.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Kupovina {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "proizvodId")
    private Integer proizvodId;
    @Column(name = "kolicina")
    private Integer kolicina;
    @Column(name = "datum")
    private String datum;

    @ManyToOne
    @JoinColumn
    private Korpa korpa;

    public Kupovina(){}

    public Kupovina(Integer id,Integer proizvodId,Integer kolicina,String datum) {
        this.id=id;
        this.proizvodId=proizvodId;
        this.kolicina=kolicina;
        this.datum=datum;
    }

    public void setKorpa(Korpa korpa) {
        this.korpa=korpa;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getId() {
        return id;
    }
}
