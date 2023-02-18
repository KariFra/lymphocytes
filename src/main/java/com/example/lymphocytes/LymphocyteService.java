package com.example.lymphocytes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class LymphocyteService {

    private final LymphocyteRepository lymphocyteRepository;
    private final ObjectMapper objectMapper;


    public LymphocyteService(LymphocyteRepository lymphocyteRepository, ObjectMapper objectMapper) {
        this.lymphocyteRepository = lymphocyteRepository;
        this.objectMapper = objectMapper;
    }

    public List<LymphocyteDto> getAll() {
        return lymphocyteRepository.findAll().stream().map(lymphocyte -> objectMapper.convertValue(lymphocyte, LymphocyteDto.class)).collect(Collectors.toList());
    }

    public LymphocyteDto createLymphocyte() {
        var random = new Random();

        var lymphocyte = new Lymphocyte();
        lymphocyte.setId(0L);
        lymphocyte.setType(assignTypeOfLymphocyte(random));
        lymphocyte.setIdentifiedInvader(random.nextBoolean());

        return objectMapper.convertValue(lymphocyteRepository.save(lymphocyte), LymphocyteDto.class);
    }

    public LymphocyteDto getLymphocyte(Long id) {
        var foundEntity = lymphocyteRepository.findById(id);
        if (foundEntity.isPresent()) {
            return objectMapper.convertValue(foundEntity.get(), LymphocyteDto.class);
        }
        throw new NoSuchElementException();
    }

    private String assignTypeOfLymphocyte(Random random) {
        String[] types = {"Type B", "Type T", "Natural Killer"};
        int typeElementNumber = random.nextInt(3);
        return types[typeElementNumber];
    }
}
