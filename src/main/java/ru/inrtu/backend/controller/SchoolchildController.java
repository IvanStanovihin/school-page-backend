package ru.inrtu.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.inrtu.backend.customException.SchoolchildAlreadyExistException;
import ru.inrtu.backend.entity.logic.Schoolchild;
import ru.inrtu.backend.service.SchoolchildService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/schoolchild-page/api/v1")
public class SchoolchildController {

    private SchoolchildService schoolchildService;

    @Autowired
    public SchoolchildController(SchoolchildService schoolchildService){
        this.schoolchildService = schoolchildService;
    }

    @GetMapping("/schoolchildren/{id}")
    public ResponseEntity<?> getSchoolchild(@PathVariable Long id) {
        try {
            Schoolchild schoolchild = schoolchildService.get(id);
            return ResponseEntity.ok(schoolchild);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/schoolchildren")
    public ResponseEntity<?> getSchoolchildren() {
        List<Schoolchild> schoolchildren = schoolchildService.getAll();
        return ResponseEntity.ok(schoolchildren);
    }

    @PostMapping("/schoolchildren")
    public ResponseEntity<?> createSchoolchild(@RequestBody Schoolchild schoolchild) {
        try {
            schoolchildService.create(schoolchild);
            return ResponseEntity.ok("Schedule successfully created");
        } catch (SchoolchildAlreadyExistException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.exceptionReason);
        }
    }

    @PutMapping("/schoolchildren/{id}")
    public ResponseEntity<?> updateSchoolchild(@PathVariable Long id, @RequestBody Schoolchild schoolchild) {
        //TODO Дописать исключения для всех методов
        schoolchildService.update(schoolchild);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/schoolchildren/{id}")
    public ResponseEntity<?> deleteSchoolchild(@PathVariable Long id) {
        schoolchildService.delete(id);
        return ResponseEntity.ok().build();
    }
}
