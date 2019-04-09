package com.techprimers.db.resource;

import com.techprimers.db.model.Kartice;
import com.techprimers.db.repository.KarticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/rest/kartice")
public class KarticeResource {

    @Autowired
    KarticeRepository karticeRepository;

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAll()
    {
        Collection<Kartice> kartice = this.karticeRepository.findAll();
        if (kartice.isEmpty()){
            return new ResponseEntity<>("Nema podataka u bazi Kartice", HttpStatus.OK);
        }
        return new ResponseEntity<Collection<Kartice>>(kartice, HttpStatus.OK);
    }

    @PostMapping(value = "/load")
    public ResponseEntity<?> persist(@RequestBody final Kartice kartice)
    {
        Kartice kartica=karticeRepository.findById(kartice.getId());
        if(kartica == null){
            return new ResponseEntity<>("Vec postoji podatak sam idom:"+kartica.getId(),HttpStatus.OK);
        }
        if(kartica.getStanje()<0){
            return new ResponseEntity<>("Iznos na kartici mora biti pozitivan broj!",HttpStatus.OK);
        }
        if(kartica.getTip().equals(null)){
            return new ResponseEntity<>("Unesite tip kartice!",HttpStatus.OK);
        }
        if(kartica.getSecurity_code()==0){
            return new ResponseEntity<>("Unesite sigurnosni kod kartice!",HttpStatus.OK);
        }
        if(kartica.getDatum_isteka().equals("")){
            return new ResponseEntity<>("Unesite datum isteka kartice!",HttpStatus.OK);
        }
        if(kartica.getBroj()==0){
            return new ResponseEntity<>("Unesite broj kartice!",HttpStatus.OK);
        }
        karticeRepository.save(kartice);
        return new ResponseEntity<Collection<Kartice>>(this.karticeRepository.findAll(),HttpStatus.OK);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<?> getOne(@PathVariable long id){
        Kartice kartice =this.karticeRepository.findById(id);
        if(kartice==null){
            return new ResponseEntity<>("Ne postoji unos sa idom:"+id,HttpStatus.OK);
        }
        return new ResponseEntity<Kartice>(kartice,HttpStatus.OK);
    }

    @DeleteMapping(value="/deleteOne/{id}")
    ResponseEntity<?> deleteOneRecord(@PathVariable Long id){
        Kartice kartice =karticeRepository.findOne(id);
        if(kartice==null) return new ResponseEntity<>("Ne postoji trazeni podatak!"+id, HttpStatus.OK);
        karticeRepository.delete(kartice);
        return new ResponseEntity<>("Podatak uspjesno obrisan"+id,HttpStatus.OK);
    }
    @PutMapping(value="/updateDatum/{id}")
    public ResponseEntity<?> updateDatum(@PathVariable long id,@RequestBody final Kartice kartice){
        Kartice kartica=karticeRepository.findById(id);
        if(kartica==null) return  new ResponseEntity<>("Ne postoji trazeni podatak "+id,HttpStatus.OK);
        kartica.setDatum_isteka(kartice.getDatum_isteka());
        return new ResponseEntity<Kartice>(karticeRepository.save(kartica),HttpStatus.OK);
    }
    @PutMapping(value="/updateStanje/{id}")
    public ResponseEntity<?> updateStanje(@PathVariable long id,@RequestBody final Kartice kartice){
        Kartice kartica=karticeRepository.findById(id);
        if(kartica==null) return  new ResponseEntity<>("Ne postoji trazeni podatak "+id,HttpStatus.OK);
        kartica.setStanje(kartice.getStanje());
        return new ResponseEntity<Kartice>(karticeRepository.save(kartica),HttpStatus.OK);
    }

}

