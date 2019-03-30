package com.techprimers.db.resource;

import com.techprimers.db.model.Kartice;
import com.techprimers.db.model.Users;
import com.techprimers.db.repository.KarticeRepository;
import com.techprimers.db.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

}

