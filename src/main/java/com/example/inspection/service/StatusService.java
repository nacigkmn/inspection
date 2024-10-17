package com.example.inspection.service;

import com.example.inspection.entity.Status;
import com.example.inspection.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public Status createStatus(Status status) {
        return statusRepository.save(status);
    }

    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    public Optional<Status> getStatusById(int id) {
        return statusRepository.findById(id);
    }

    public Status updateStatus(int id, Status status) {
        return statusRepository.findById(id)
                .map(existingStatus -> {
                    existingStatus.setStatusOption(status.getStatusOption());
                    return statusRepository.save(existingStatus);
                })
                .orElseThrow(() -> new NoSuchElementException("Status not found with id: " + id));
    }


    public void deleteStatus(int id) {
        statusRepository.deleteById(id);
    }
}
