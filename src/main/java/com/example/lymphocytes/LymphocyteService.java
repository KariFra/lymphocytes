package com.example.lymphocytes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class LymphocyteService {

    private final LymphocyteRepository lymphocyteRepository;

    public LymphocyteService(LymphocyteRepository lymphocyteRepository) {
        this.lymphocyteRepository = lymphocyteRepository;
    }

    public List<Lymphocyte> getAll(){
        return lymphocyteRepository.findAll();
    }

    public Lymphocyte createLymphocyte(){
        var random = new Random();

        var lymphocyte = new Lymphocyte();
        lymphocyte.setId((long) getLymphocyteId());
        lymphocyte.setType(assignTypeOfLymphocyte(random));
        lymphocyte.setIdentifiedInvader(random.nextBoolean());

        return lymphocyteRepository.save(lymphocyte);
    }

    private int getLymphocyteId(){
        return getAll().size();
    }

    private String assignTypeOfLymphocyte(Random random){
        String[] types = {"Type B","Type T","Natural Killer"};
        int typeElementNumber = random.nextInt(3);
        return types[typeElementNumber];
    }
}
