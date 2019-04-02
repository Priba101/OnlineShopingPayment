package com.techprimers.db.resource;

import com.techprimers.db.model.Korpa;
import com.techprimers.db.repository.KorpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping(value="/{id}")
    Korpa getOne(@PathVariable int id){
        return korpaRepository.findById(id);
    }

}
