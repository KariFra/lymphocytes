package com.example.lymphocytes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attack")
public class LymphocyteController {

    private final LymphocyteService service;

    public LymphocyteController(LymphocyteService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Lymphocyte>> getAllLymphocytes(){
        return ResponseEntity.ok(service.getAll());
    }


    @PostMapping(value = "/create")
    public ResponseEntity<Lymphocyte> createLymphocyte(){
        return ResponseEntity.ok(service.createLymphocyte());
    }

}
