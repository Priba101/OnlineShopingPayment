package com.techprimers.db.resource;

import com.techprimers.db.model.Kartice;
import com.techprimers.db.repository.KarticeRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/rest/kartice")
public class KarticeResource {

    @Autowired
    KarticeRepository karticeRepository;


    @Autowired
    private RestTemplate restTemplate;
    @CrossOrigin
    @GetMapping(value="/karticaUp")
    public ResponseEntity<?> getKarticaUp(){
        String str=null;
        Kartice kt = restTemplate.getForObject("http://payments/rest/kartice/hello",Kartice.class);
        System.out.println("poruka"+kt);
        return new ResponseEntity<Kartice>(kt,HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping(value="usersUp")
    public ResponseEntity<?> getUsersUp(){
       String str = restTemplate.getForObject("http://USERS/rest/users/hello",String.class);
       System.out.println("poruka"+str);
       return new ResponseEntity<String>(str,HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping(value = "/all")
    public ResponseEntity<?> getAll()
    {
        Collection<Kartice> kartice = this.karticeRepository.findAll();
        Map<String,Object> message = new HashMap<String,Object>();
        if (kartice.isEmpty()){
            message.put("MESSAGE","Nema podataka u bazi Kartice");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        return new ResponseEntity<Collection<Kartice>>(kartice, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/insert")
    public ResponseEntity<?> persist(@RequestBody final Kartice kartice)
    {
        Kartice kartica=karticeRepository.findById(kartice.getId());
        Map<String,Object> message = new HashMap<String,Object>();
        /*if(kartica == null){
            message.put("MESSAGE","Vec postoji podatak sam idom:"+kartica.getId());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        if(!restTemplate.getForObject("http://Users/rest/users/exist/"+kartica.getId(),Boolean.class)){
            message.put("MESSAGE","Ne postoji user sa id:"+kartica.getId());
            return new ResponseEntity<>(message,HttpStatus.OK);
        }
        if(kartica.getStanje()<0){
            message.put("MESSAGE","Iznos na kartici mora biti pozitivan broj!");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        if(kartica.getTip().equals(null)){
            message.put("MESSAGE","Unesite tip kartice!");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        if(kartica.getSecurity_code()==0){
            message.put("MESSAGE","Unesite sigurnosni kod kartice!");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        if(kartica.getDatum_isteka().equals("")){
            message.put("MESSAGE","Unesite datum isteka kartice!");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        if(kartica.getBroj()==0){
            message.put("MESSAGE","Unesite broj kartice!");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }*/
        karticeRepository.save(kartice);
        return new ResponseEntity<Collection<Kartice>>(this.karticeRepository.findAll(),HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping(value="/{id}")
    public ResponseEntity<?> getOne(@PathVariable long id){
        Map<String,Object> message = new HashMap<String,Object>();
        Kartice kartice =this.karticeRepository.findById(id);
        if(kartice==null){
            message.put("MESSAGE","Ne postoji unos sa idom:"+id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        return new ResponseEntity<Kartice>(kartice,HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping(value="/{id}")
    ResponseEntity<?> deleteOneRecord(@PathVariable Long id){
        Map<String,Object> message = new HashMap<String,Object>();
        Kartice kartice =karticeRepository.findOne(id);
        if(kartice==null){
            message.put("MESSAGE","Ne postoji trazeni podatak!"+id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        karticeRepository.delete(kartice);
        message.put("MESSAGE","Podatak uspjesno obrisan"+id);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
    @CrossOrigin
    @PutMapping(value="/datum/{id}")
    public ResponseEntity<?> updateDatum(@PathVariable long id,@RequestBody final Kartice kartice){
        Map<String,Object> message = new HashMap<String,Object>();
        Kartice kartica=karticeRepository.findById(id);
        if(kartica==null){
            message.put("MESSAGE","Ne postoji trazeni podatak "+id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        kartica.setDatum_isteka(kartice.getDatum_isteka());
        karticeRepository.save(kartica);
        message.put("MESSAGE","Datum uspjesno izmjenjen "+id);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
    @CrossOrigin
    @PutMapping(value="/stanje/{id}")
    public ResponseEntity<?> updateStanje(@PathVariable long id,@RequestBody final Kartice kartice){
        Map<String,Object> message = new HashMap<String,Object>();
        Kartice kartica=karticeRepository.findById(id);
        if(kartica==null){
            message.put("MESSAGE","Ne postoji trazeni podatak "+id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        kartica.setStanje(kartice.getStanje());
        message.put("MESSAGE","Uspjesno izmjenjeno stanje "+id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    /*@PostMapping(value="")
    public Kartice createKartice(@RequestBody @Valid final Kartice kartice, Errors errors) throws Exception {

           if(errors.hasErrors()){
             throw new Exception(errors.getAllErrors().get(0).getDefaultMessage());
        }

	        List<ServiceInstance> instances=discoveryClient.getInstances("HistorijaClanak-service");
	        List<ServiceInstance> instances2=discoveryClient.getInstances("Clanak-service");


	        if(instances.isEmpty()) ;
			ServiceInstance serviceInstance=instances.get(0);

			 if(instances2.isEmpty()) ;
				ServiceInstance serviceInstance2=instances2.get(0);

			String baseUrl=serviceInstance.getUri().toString()+ "/korisnik/insert"; //+id.toString();
			System.out.println(baseUrl);
			String baseUrl2=serviceInstance2.getUri().toString()+ "/korisnik/insert"; //+id.toString();
			System.out.println(baseUrl2);

			String requestJson = "{\"username\":\""  + korisnik.getUsername() +  "\"}";
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
				RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response=null;
			try{
				response = restTemplate.postForEntity( baseUrl, entity , String.class );
				RestTemplate restTemplate2 = new RestTemplate();
				ResponseEntity<String> response2 = restTemplate2 .postForEntity( baseUrl2, entity , String.class );
				System.out.println(response2.getBody());
			}catch (Exception ex)
			{
				System.out.println(ex);
			}
			System.out.println(response.getBody());

        return karticeRepository.save(kartice);
    }*/

}

