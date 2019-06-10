package com.techprimers.db.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@EqualsAndHashCode(exclude = "kupovine")
@Entity
public class Korpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "idProizvoda")
    private int idProizvoda;
    @Column(name = "idKorisnika")
    private int idKorisnika;
    @Column(name = "brojProizvoda")
    private int brojProizvoda;

    @OneToMany(mappedBy = "korpa",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Kupovina> kupovine;

    @ManyToOne
    @JoinColumn
    private Kartice kartice;

    public Korpa() {
    }
    public Korpa(int id, int idProizvoda, int idKorisnika, int brojProizvoda,Kupovina... kupovine) {
        this.id = id;
        this.idProizvoda = idProizvoda;
        this.idKorisnika = idKorisnika;
        this.brojProizvoda = brojProizvoda;
        this.kupovine=Stream.of(kupovine).collect(Collectors.toSet());
        this.kupovine.forEach(x->x.setKorpa(this));
    }
    public void setKartica(Kartice kartice) {
        this.kartice=kartice;
    }

    public int getId(int id) {
        return id;
    }

    public int getBrojProizvoda() {
        return brojProizvoda;
    }

    public void setBrojProizvoda(int brojProizvoda) {
        this.brojProizvoda = brojProizvoda;
    }
}

