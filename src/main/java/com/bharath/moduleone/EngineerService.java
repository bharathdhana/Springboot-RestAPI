package com.bharath.moduleone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineerService {


    private final EngineerRepository engineerRepository;

    public EngineerService(EngineerRepository engineerRepository) {
        this.engineerRepository = engineerRepository;
    }

    public List<Engineer> getAllEngineers() {
        return engineerRepository.findAll();
    }

    public void insertEngineer(Engineer engineer) {
         engineerRepository.save(engineer);
    }

    public Engineer getAllEngineerById(Integer id) {
        return engineerRepository.findById(id).orElseThrow(() ->
           new IllegalStateException(id + "Not found"));
        }

    }


