package com.techprimers.db.resource;

import com.techprimers.db.model.Kupovina;
import com.techprimers.db.repository.KupovinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/rest/kupovina")
public class KupovinaResource {
    @Autowired
    KupovinaRepository kupovinaRepository;

    @GetMapping(value="/all")
    public List<Kupovina> getAll(){
        return kupovinaRepository.findAll();
    }
    @PostMapping(value="/load")
    public List<Kupovina> persist(@RequestBody final Kupovina kupovina)
    {
        kupovinaRepository.save(kupovina);
        return kupovinaRepository.findAll();
    }

    @GetMapping(value="/one/{id}")
    Kupovina getOne(@PathVariable int id){
        return  kupovinaRepository.findById(id);
    }

    @DeleteMapping(value="/deleteOne/{id}")
    ResponseEntity<?> deleteOneRecord(@PathVariable Integer id){
        Kupovina kupovina=kupovinaRepository.findOne(id);
        if(kupovina==null) return new ResponseEntity<>("Ne postoji trazeni podatak!"+id, HttpStatus.OK);
        kupovinaRepository.delete(kupovina);
        return new ResponseEntity<>("Podatak uspjesno obrisan"+id,HttpStatus.OK);
    }

    @PutMapping(value="/updateOne/{id}")
    ResponseEntity<?> updateOneRecord(@PathVariable Integer id,@RequestBody final Kupovina kupovina){
        Kupovina kupovine=kupovinaRepository.findOne(id);
        if(kupovine==null) return  new ResponseEntity<>("Ne postoji trazeni podatak "+id,HttpStatus.OK);
        kupovine.setId(kupovine.getId());
        return new ResponseEntity<Kupovina>(kupovinaRepository.save(kupovina),HttpStatus.OK);
    }
}
