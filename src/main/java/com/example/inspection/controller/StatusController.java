package com.example.inspection.controller;

import com.example.inspection.entity.Status;
import com.example.inspection.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/statuses")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @PostMapping("/add")
    public ResponseEntity<Status> addStatus(@RequestBody Status status) {
        return new ResponseEntity<>(statusService.createStatus(status), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Status>> getAllStatuses() {
        return ResponseEntity.ok(statusService.getAllStatuses());
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Status> getStatusById(@PathVariable int id) {
        return statusService.getStatusById(id)
                .map(status -> ResponseEntity.ok().body(status))
                .orElseThrow(() -> new NoSuchElementException("Status not found with id: " + id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Status> updateStatus(@PathVariable int id, @RequestBody Status status) {
        return ResponseEntity.ok(statusService.updateStatus(id, status));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable int id) {
        statusService.deleteStatus(id);
        return ResponseEntity.noContent().build();
    }
}
