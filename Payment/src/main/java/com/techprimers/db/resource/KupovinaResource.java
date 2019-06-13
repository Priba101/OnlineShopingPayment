package com.techprimers.db.resource;

import com.techprimers.db.model.Kupovina;
import com.techprimers.db.repository.KupovinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/rest/kupovina")
public class KupovinaResource {
    @Autowired
    KupovinaRepository kupovinaRepository;
    @CrossOrigin
    @GetMapping(value="/all")
    public ResponseEntity<?> getAll()
    {
        Collection<Kupovina> kupovina = this.kupovinaRepository.findAll();
        Map<String,Object> message = new HashMap<String,Object>();
        if (kupovina.isEmpty()){
            message.put("MESSAGE","Nema podataka u bazi Kupovina");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        return new ResponseEntity<Collection<Kupovina>>(kupovina, HttpStatus.OK);
    }
    /*@CrossOrigin
    @PostMapping(value="/insert")
    public ResponseEntity<?> persist(@RequestBody final Kupovina kupovina)
    {
        System.out.println(kupovina.getId());
        Kupovina kupovina1 =kupovinaRepository.findById(kupovina.getId());
        Map<String,Object> message = new HashMap<String,Object>();
        /*if(kupovina1==null){
            message.put("MESSAGE","Ne postoji unos sa idom:"+kupovina1.getId());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        if(kupovina1.getKolicina().equals(0)){
            message.put("MESSAGE","Kolicina ne smije biti jednaka 0!");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        if(kupovina1.getDate().equals("")){
            message.put("MESSAGE","Datum ne smije biti prazan!");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        kupovinaRepository.save(kupovina);
        return new ResponseEntity<Collection<Kupovina>>(this.kupovinaRepository.findAll(),HttpStatus.OK);
    }*/
    @CrossOrigin
    @GetMapping(value="/{id}")
    public ResponseEntity<?> getOne(@PathVariable int id){
        Kupovina kupovina=this.kupovinaRepository.findById(id);
        Map<String,Object> message = new HashMap<String,Object>();
        if(kupovina==null){
            message.put("MESSAGE","Ne postoji trazeni podatak!"+id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        message.put("MESSAGE","Podatak uspjesno dobavljen "+id);
        return new ResponseEntity<Kupovina>(kupovina,HttpStatus.OK);
    }
    /*@CrossOrigin
    @DeleteMapping(value="/{id}")
    ResponseEntity<?> deleteOneRecord(@PathVariable Integer id){
        Kupovina kupovina=kupovinaRepository.findOne(id);
        Map<String,Object> message = new HashMap<String,Object>();
        if(kupovina==null){
            message.put("MESSAGE","Ne postoji trazeni podatak!"+id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        kupovinaRepository.delete(kupovina);
        message.put("MESSAGE","Podatak uspjesno obrisan "+id);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
    @CrossOrigin
    @PutMapping(value="/datum/{id}")
    public ResponseEntity<?> updateDatum(@PathVariable Integer id,@RequestBody final Kupovina kupovine){
        Kupovina kupovina=kupovinaRepository.findById(id);
        Map<String,Object> message = new HashMap<String,Object>();
        if(kupovina==null){
            message.put("MESSAGE","Ne postoji trazeni podatak!"+id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        kupovina.setDatum(kupovine.getDatum());
        kupovinaRepository.save(kupovina);
        message.put("MESSAGE","Datum uspjesno promjenjen "+id);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }*/
    @CrossOrigin
    @PutMapping(value="/kolicina/{id}")
    public ResponseEntity<?> updatekolicina(@PathVariable int id,@RequestBody final Kupovina kupovine){
        Kupovina kupovina=kupovinaRepository.findById(id);
        Map<String,Object> message = new HashMap<String,Object>();
        if(kupovina==null){
            message.put("MESSAGE","Ne postoji trazeni podatak!"+id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        kupovina.setKolicina(kupovine.getKolicina());
        kupovinaRepository.save(kupovina);
        message.put("MESSAGE","Kolicina uspjesno promjenjena "+id);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
}
