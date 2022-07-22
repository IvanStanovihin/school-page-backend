package ru.inrtu.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inrtu.backend.customException.SchoolchildAlreadyExistException;
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

    public Schoolchild create(Schoolchild schoolchild) throws SchoolchildAlreadyExistException{
        Schoolchild existingSchoolchild = schoolchildRepository.findExistingInDB(schoolchild.getName(), schoolchild.getSurname(),
                schoolchild.getFatherName(), schoolchild.getEducationalClass());
        if (existingSchoolchild == null){
            return schoolchildRepository.save(schoolchild);
        }else{
            throw new SchoolchildAlreadyExistException();
        }
    }

    public Schoolchild update(Schoolchild schoolchild){
        return schoolchildRepository.save(schoolchild);
    }

    public void delete(Long id){
        schoolchildRepository.deleteById(id);
    }

    public List<Schoolchild> getAll(){
        return schoolchildRepository.findAll();
    }

    public Schoolchild get(Long id){
        return schoolchildRepository.getOne(id);
    }
}
