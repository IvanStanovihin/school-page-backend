package ru.inrtu.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inrtu.backend.customException.StudyActivityAlreadyExistException;
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

    public StudyActivity get(Long id){
        return studyActivityRepository.getOne(id);
    }

    public List<StudyActivity> getAll(){
        return studyActivityRepository.findAll();
    }

    public StudyActivity update(StudyActivity studyActivity){
        return studyActivityRepository.saveAndFlush(studyActivity);
    }

    public StudyActivity create(StudyActivity studyActivity) throws StudyActivityAlreadyExistException{
        StudyActivity existingStudyActivity = studyActivityRepository.findExistingInDB(studyActivity.getName(), studyActivity.getStartDate());
        if (existingStudyActivity == null){
            return studyActivityRepository.save(studyActivity);
        }else{
            throw new StudyActivityAlreadyExistException();
        }
    }

    public void delete(Long id){
        studyActivityRepository.deleteById(id);
    }
}
