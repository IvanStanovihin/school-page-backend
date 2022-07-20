package ru.inrtu.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inrtu.backend.entity.StudyActivity;
import ru.inrtu.backend.repository.StudyActivityRepository;

import java.util.List;

@Service
public class StudyActivityService {

    private StudyActivityRepository studyActivityRepository;

    @Autowired
    public StudyActivityService(StudyActivityRepository studyActivityRepository){
        this.studyActivityRepository = studyActivityRepository;
    }

    public List<StudyActivity> getAll(){
        return studyActivityRepository.findAll();
    }
}
