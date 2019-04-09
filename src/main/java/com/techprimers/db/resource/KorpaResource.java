package com.techprimers.db.resource;

import com.techprimers.db.model.Korpa;
import com.techprimers.db.repository.KorpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value="/rest/korpa")
public class KorpaResource {
    @Autowired
    KorpaRepository korpaRepository;

    @GetMapping(value="/all")
    public ResponseEntity<?> getAll()
    {
        Collection<Korpa> korpa = this.korpaRepository.findAll();
        if (korpa.isEmpty()){
            return new ResponseEntity<>("Nema podataka u bazi Korpa", HttpStatus.OK);
        }
        return new ResponseEntity<Collection<Korpa>>(korpa, HttpStatus.OK);
    }

    @PostMapping(value="/load")
    public ResponseEntity<?> persist(@RequestBody final Korpa korpa)
    {
        Korpa korpa1=korpaRepository.findById(korpa.getId_korpe());
        if(korpa1==null){
            return new ResponseEntity<>("Ne postoji unosa",HttpStatus.OK);
        }
        if(korpa1.getBroj_proizvoda()==0){
            return new ResponseEntity<>("Broj proizvoda ne smije biti jednak nuli!",HttpStatus.OK);
        }
        korpaRepository.save(korpa);
        return new ResponseEntity<Collection<Korpa>>(this.korpaRepository.findAll(),HttpStatus.OK);
    }
    @GetMapping(value="/one/{id}")
    public ResponseEntity<?> getOne(@PathVariable int id)
    {
        Korpa korpa=this.korpaRepository.findById(id);
        if(korpa==null){
            return new ResponseEntity<>("Ne postoji unos sa idom:"+id,HttpStatus.OK);
        }
        return new ResponseEntity<Korpa>(korpa,HttpStatus.OK);
    }

    @DeleteMapping(value="/deleteOne/{id}")
    ResponseEntity<?> deleteOneRecord(@PathVariable Integer id){
        Korpa korpa=korpaRepository.findOne(id);
        if(korpa==null) return new ResponseEntity<>("Ne postoji trazeni podatak "+id, HttpStatus.OK);
        korpaRepository.delete(korpa);
        return new ResponseEntity<>("Podatak uspjesno obrisan "+id,HttpStatus.OK);
    }

    @PutMapping(value="/updateBrojProizvoda/{id}")
    public ResponseEntity<?> updateOne(@PathVariable Integer id,@RequestBody final Korpa korpa){
        Korpa korpa1=korpaRepository.findOne(id);
        if(korpa1==null) return new ResponseEntity<>("Ne postoji trazeni podatak "+id,HttpStatus.OK);
        korpa1.setBroj_proizvoda(korpa.getBroj_proizvoda());
        return new ResponseEntity<Korpa>(korpaRepository.save(korpa1),HttpStatus.OK);
    }
}
