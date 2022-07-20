package ru.inrtu.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inrtu.backend.entity.Schoolchild;
import ru.inrtu.backend.repository.SchoolchildRepository;

import java.util.List;

@Service
public class SchoolchildService {

    private SchoolchildRepository schoolchildRepository;

    @Autowired
    public SchoolchildService(SchoolchildRepository schoolchildRepository){
        this.schoolchildRepository = schoolchildRepository;
    }

    public void create(Schoolchild schoolchild){
        schoolchildRepository.save(schoolchild);
    }

    public List<Schoolchild> getAll(){
        return schoolchildRepository.findAll();
    }

    public Schoolchild get(Long id){
        return schoolchildRepository.getOne(id);
    }
}
