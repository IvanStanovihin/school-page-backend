package ru.inrtu.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.inrtu.backend.customException.ActivityHistoryAlreadyExistException;
import ru.inrtu.backend.customException.ActivityHistoryNotExistException;
import ru.inrtu.backend.entity.logic.ActivityHistory;
import ru.inrtu.backend.service.ActivityHistoryService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/schoolchild-page/api/v1")
public class ActivityHistoryController {

    private ActivityHistoryService activityHistoryService;

    @Autowired
    public ActivityHistoryController(ActivityHistoryService activityHistoryService){
        this.activityHistoryService = activityHistoryService;
    }


    @GetMapping("/activity-history/{id}")
    public ResponseEntity<?> getActivityHistory(@PathVariable Long id) {
        try {
            ActivityHistory activityHistory = activityHistoryService.get(id);
            return ResponseEntity.ok(activityHistory);
        }catch(NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/activity-history")
    public ResponseEntity<?> getAllActivityHistory() {
        List<ActivityHistory>allActivityHistory = activityHistoryService.getAll();
        return ResponseEntity.ok(allActivityHistory);
    }

    @PostMapping("/activity-history")
    public ResponseEntity<?> createActivityHistory(@RequestBody ActivityHistory activityHistory) {
        try {
            activityHistoryService.create(activityHistory);
            return ResponseEntity.ok("Activity history successfully created");
        }catch(ActivityHistoryAlreadyExistException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.exceptionReason);
        }
    }

    @PutMapping("/activity-history/{id}")
    public ResponseEntity<?> updateActivityHistory(@PathVariable Long id, @RequestBody ActivityHistory activityHistory) {
        try {
            //TODO Дописать исключения для всех методов
            activityHistoryService.update(activityHistory);
            return ResponseEntity.ok().build();
        }catch(ActivityHistoryNotExistException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Activity history record not exist in the database");
        }
    }

    @DeleteMapping("/activity-history/{id}")
    public ResponseEntity<?>deleteActivityHistory(@PathVariable Long id){
        activityHistoryService.delete(id);
        return ResponseEntity.ok().build();
    }

}
