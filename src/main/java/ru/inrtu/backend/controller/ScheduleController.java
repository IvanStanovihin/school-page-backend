package ru.inrtu.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.inrtu.backend.customException.ScheduleAlreadyExistException;
import ru.inrtu.backend.entity.Schedule;
import ru.inrtu.backend.service.ScheduleService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/schoolchild-page/api/v1")
public class ScheduleController {

    private ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/schedules/{id}")
    public ResponseEntity<?> getSchedule(@PathVariable Long id) {
        try {
            Schedule schedule = scheduleService.get(id);
            return ResponseEntity.ok(schedule);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/schedules")
    public ResponseEntity<?> getSchedules() {
        List<Schedule> schedules = scheduleService.getAll();
        return ResponseEntity.ok(schedules);
    }

    @PostMapping("/schedules")
    public ResponseEntity<?> createSchedule(@RequestBody Schedule schedule) {
        try {
            scheduleService.create(schedule);
            return ResponseEntity.ok("Schedule successfully created");
        } catch (ScheduleAlreadyExistException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.exceptionReason);
        }
    }

    @PutMapping("/schedules/{id}")
    public ResponseEntity<?> updateSchedule(@PathVariable Long id, @RequestBody Schedule schedule) {
        //TODO Дописать исключения для всех методов
        scheduleService.update(schedule);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/schedules/{id}")
    public ResponseEntity<?> deleteSchedule(@PathVariable Long id) {
        scheduleService.delete(id);
        return ResponseEntity.ok().build();
    }

}
