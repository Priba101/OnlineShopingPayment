package com.techprimers.db.resource;

import com.techprimers.db.model.Korpa;
import com.techprimers.db.repository.KorpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/rest/korpa")
public class KorpaResource {
    @Autowired
    KorpaRepository korpaRepository;

    @GetMapping(value="/all")
    public List<Korpa> getAll(){
        return korpaRepository.findAll();
    }

    @PostMapping(value="/load")
    public List<Korpa> persist(@RequestBody final Korpa korpa)
    {
        korpaRepository.save(korpa);
        return korpaRepository.findAll();
    }
    @GetMapping(value="/one/{id}")
    Korpa getOne(@PathVariable int id)
    {
        return korpaRepository.findById(id);
    }

    @DeleteMapping(value="/deleteOne/{id}")
    ResponseEntity<?> deleteOneRecord(@PathVariable Integer id){
        Korpa korpa=korpaRepository.findOne(id);
        if(korpa==null) return new ResponseEntity<>("Ne postoji trazeni podatak "+id, HttpStatus.OK);
        korpaRepository.delete(korpa);
        return new ResponseEntity<>("Podatak uspjesno obrisan "+id,HttpStatus.OK);
    }

    @PutMapping(value="/updateOne/{id}")
    public ResponseEntity<?> updateOne(@PathVariable Integer id,@RequestBody final Korpa korpa){
        Korpa korpa1=korpaRepository.findOne(id);
        if(korpa1==null) return new ResponseEntity<>("Ne postoji trazeni podatak "+id,HttpStatus.OK);
        korpa1.setId_korpe(korpa.getId_korpe());
        return new ResponseEntity<Korpa>(korpaRepository.save(korpa1),HttpStatus.OK);
    }
}
