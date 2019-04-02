package com.techprimers.db.resource;

import com.techprimers.db.model.Kupovina;
import com.techprimers.db.repository.KupovinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
