package com.myblog.myblog11.controller;

import com.myblog.myblog11.entity.Registration;
import com.myblog.myblog11.exception.ResourceNotFoundException;
import com.myblog.myblog11.payload.PostRegDto;
import com.myblog.myblog11.repository.RegistrationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// http://localhost:8080/api/saveData
@RestController
@RequestMapping("/api/saveData")
public class Registraion_Controller {


    RegistrationRepository repo;

    public Registraion_Controller(RegistrationRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody Registration r){

        Registration reg = repo.save(r);
        PostRegDto dto = new PostRegDto();
        dto.setReg(reg);
        dto.setMessage("The record is saved");

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    // http://localhost:8080/api/saveData/particular?id=5
    @GetMapping("/particular")
    public ResponseEntity<?> getAlldata(@RequestParam("id") int id){

        Registration reg = repo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Record not found with id " + id)
        );


        return new ResponseEntity<>(reg,HttpStatus.OK);
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReg(@PathVariable int id){

       repo.deleteById(id);

       return new ResponseEntity<>("Record is deleted",HttpStatus.OK);

    }
    @GetMapping
    //  http://localhost:8080/api/saveData?pageNo=0&pageSize=2
    public ResponseEntity<?> pagination(

        @RequestParam(name="pageNo", required = false, defaultValue = "0") int pageNo,
        @RequestParam(name="pageSize", required = false, defaultValue = "2") int pageSize
    ){
        PageRequest pageable = PageRequest.of(pageNo, pageSize);
        Page<Registration> pages = repo.findAll(pageable);
        List<Registration> result = pages.getContent();

        return new ResponseEntity<>(result, HttpStatus.OK);

    }
}
