package ru.inrtu.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.inrtu.backend.customException.TrajectoryAlreadyExistException;
import ru.inrtu.backend.customException.TrajectoryNotFoundException;
import ru.inrtu.backend.entity.Trajectory;
import ru.inrtu.backend.service.TrajectoryService;

import java.util.List;

@RestController
@RequestMapping("/schoolchild-page/api/v1")
public class TrajectoryController {

    private TrajectoryService trajectoryService;

    @Autowired
    public TrajectoryController(TrajectoryService trajectoryService) {
        this.trajectoryService = trajectoryService;
    }

    @GetMapping("/trajectories/{id}")
    public ResponseEntity<?> getTrajectory(@PathVariable Long id) {
        try {
            Trajectory trajectory = trajectoryService.get(id);
            return ResponseEntity.ok(trajectory);
        } catch (TrajectoryNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.exceptionReason);
        }
    }

    @GetMapping("/trajectories")
    public ResponseEntity<?> getAllTrajectories() {
        List<Trajectory> trajectories = trajectoryService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(trajectories);
    }

    @PostMapping("/trajectories")
    public ResponseEntity<?> create(@RequestBody Trajectory trajectory) {
        try {
            trajectoryService.create(trajectory);
            return ResponseEntity.ok("Trajectory successfully created");
        } catch (TrajectoryAlreadyExistException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.exceptionReason);
        }
    }

    @PutMapping("/trajectories/{id}")
    public ResponseEntity<?> updateTrajectory(@PathVariable Long id, @RequestBody Trajectory trajectory) {
        trajectoryService.update(trajectory);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/trajectories/{id}")
    public ResponseEntity<?>deleteTrajectory(@PathVariable Long id){
        trajectoryService.delete(id);
        return ResponseEntity.ok().build();
    }
}
