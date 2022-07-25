package ru.inrtu.backend.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.inrtu.backend.customException.StudyActivityAlreadyExistException;
import ru.inrtu.backend.entity.StudyActivity;
import ru.inrtu.backend.service.StudyActivityService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/schoolchild-page/api/v1")
public class StudyActivityController {


    private StudyActivityService studyActivityService;

    @Autowired
    public StudyActivityController(StudyActivityService studyActivityService){
        this.studyActivityService = studyActivityService;
    }

    @GetMapping("/study-activities/{id}")
    public ResponseEntity<?> getStudyActivity(@PathVariable Long id) {
        try {
            StudyActivity studyActivity = studyActivityService.get(id);
            return ResponseEntity.ok().body(studyActivity);
        }catch(NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/study-activities")
    public ResponseEntity<?> getAllStudyActivities() {
        List<StudyActivity> studyActivities = studyActivityService.getAll();
        return ResponseEntity.ok().body(studyActivities);
    }

    @PostMapping("/study-activities")
    public ResponseEntity<?> createStudyActivity(@RequestBody StudyActivity studyActivity) {
        try {
            studyActivityService.create(studyActivity);
            return ResponseEntity.ok().body("Study activity successfully created");
        }catch(StudyActivityAlreadyExistException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.exceptionReason);
        }
    }

    @PutMapping("/study-activities/{id}")
    public ResponseEntity<?> updateStudyActivity(@PathVariable Long id, @RequestBody StudyActivity studyActivity) {
        studyActivityService.update(studyActivity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/study-activities/{id}")
    public ResponseEntity<?> deleteStudyActivity(@PathVariable Long id) {
        studyActivityService.delete(id);
        return ResponseEntity.ok().build();
    }
}
