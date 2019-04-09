package com.techprimers.db.resource;

import com.techprimers.db.model.Kupovina;
import com.techprimers.db.repository.KupovinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value="/rest/kupovina")
public class KupovinaResource {
    @Autowired
    KupovinaRepository kupovinaRepository;

    @GetMapping(value="/all")
    public ResponseEntity<?> getAll()
    {
        Collection<Kupovina> kupovina = this.kupovinaRepository.findAll();
        if (kupovina.isEmpty()){
            return new ResponseEntity<>("Nema podataka u bazi Kupovina", HttpStatus.OK);
        }
        return new ResponseEntity<Collection<Kupovina>>(kupovina, HttpStatus.OK);
    }
    @PostMapping(value="/load")
    public ResponseEntity<?> persist(@RequestBody final Kupovina kupovina)
    {
        Kupovina kupovina1 =kupovinaRepository.findById(kupovina.getId());
        if(kupovina1==null){
            return new ResponseEntity<>("Ne postoji unos sa idom:"+kupovina1.getId(),HttpStatus.OK);
        }
        if(kupovina1.getKolicina().equals(0)){
            return new ResponseEntity<>("Kolicina ne smije biti jednaka 0!",HttpStatus.OK);
        }
        if(kupovina1.getDate().equals("")){
            return new ResponseEntity<>("Datum ne smije biti prazan!",HttpStatus.OK);
        }
        kupovinaRepository.save(kupovina);
        return new ResponseEntity<Collection<Kupovina>>(this.kupovinaRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping(value="/one/{id}")
    public ResponseEntity<?> getOne(@PathVariable int id){
        Kupovina kupovina=this.kupovinaRepository.findById(id);
        if(kupovina==null){
            return new ResponseEntity<>("Ne postoji unos sa idom:"+id,HttpStatus.OK);
        }
        return new ResponseEntity<Kupovina>(kupovina,HttpStatus.OK);
    }

    @DeleteMapping(value="/deleteOne/{id}")
    ResponseEntity<?> deleteOneRecord(@PathVariable Integer id){
        Kupovina kupovina=kupovinaRepository.findOne(id);
        if(kupovina==null) return new ResponseEntity<>("Ne postoji trazeni podatak!"+id, HttpStatus.OK);
        kupovinaRepository.delete(kupovina);
        return new ResponseEntity<>("Podatak uspjesno obrisan"+id,HttpStatus.OK);
    }

    @PutMapping(value="/updateDatum/{id}")
    public ResponseEntity<?> updateDatum(@PathVariable Integer id,@RequestBody final Kupovina kupovine){
        Kupovina kupovina=kupovinaRepository.findById(id);
        if(kupovina==null) return  new ResponseEntity<>("Ne postoji trazeni podatak "+id,HttpStatus.OK);
        kupovina.setDate(kupovine.getDate());
        return new ResponseEntity<Kupovina>(kupovinaRepository.save(kupovina),HttpStatus.OK);
    }
    @PutMapping(value="/updateKolicina/{id}")
    public ResponseEntity<?> updatekolicina(@PathVariable int id,@RequestBody final Kupovina kupovine){
        Kupovina kupovina=kupovinaRepository.findById(id);
        if(kupovina==null) return  new ResponseEntity<>("Ne postoji trazeni podatak "+id,HttpStatus.OK);
        kupovina.setKolicina(kupovine.getKolicina());
        return new ResponseEntity<Kupovina>(kupovinaRepository.save(kupovina),HttpStatus.OK);
    }
}
