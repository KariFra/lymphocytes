package com.example.lymphocytes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lymph")
public class LymphocyteController {

    private final LymphocyteService service;

    public LymphocyteController(LymphocyteService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<LymphocyteDto>> getAllLymphocytes(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(value = "/{lymphocyteId}")
    public ResponseEntity<LymphocyteDto> getLymphocyteWithId(@PathVariable Long lymphocyteId){
        return ResponseEntity.ok(service.getLymphocyte(lymphocyteId));
    }


    @PostMapping()
    public ResponseEntity<LymphocyteDto> createLymphocyte(){
        return ResponseEntity.ok(service.createLymphocyte());
    }

}
