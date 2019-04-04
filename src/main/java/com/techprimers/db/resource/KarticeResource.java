package com.techprimers.db.resource;

import com.techprimers.db.model.Kartice;
import com.techprimers.db.repository.KarticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/kartice")
public class KarticeResource {

    @Autowired
    KarticeRepository karticeRepository;

    @GetMapping(value = "/all")
    public List<Kartice> getAll()
    {
        return karticeRepository.findAll();
    }

    @PostMapping(value = "/load")
    public List<Kartice> persist(@RequestBody final Kartice kartice)
    {
        karticeRepository.save(kartice);
        return karticeRepository.findAll();
    }
    @GetMapping(value="/{id}")
    Kartice getOne(@PathVariable long id){
        return karticeRepository.findById(id);
    }

    @DeleteMapping(value="/deleteOne/{id}")
    ResponseEntity<?> deleteOneRecord(@PathVariable Long id){
        Kartice kartice =karticeRepository.findOne(id);
        if(kartice==null) return new ResponseEntity<>("Ne postoji trazeni podatak!"+id, HttpStatus.OK);
        karticeRepository.delete(kartice);
        return new ResponseEntity<>("Podatak uspjesno obrisan"+id,HttpStatus.OK);
    }
    @PutMapping(value="/updateOne/{id}")
    ResponseEntity<?> updateOneRecord(@PathVariable long id,@RequestBody final Kartice kartice){
        Kartice kartica=karticeRepository.findOne(id);
        if(kartica==null) return  new ResponseEntity<>("Ne postoji trazeni podatak "+id,HttpStatus.OK);
        kartica.setId(kartice.getId());
        return new ResponseEntity<Kartice>(karticeRepository.save(kartica),HttpStatus.OK);
    }

}

