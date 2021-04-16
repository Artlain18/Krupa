package com.example.Krupa.service;

import com.example.Krupa.models.game;
import com.example.Krupa.models.status;
import com.example.Krupa.repo.gameRepository;
import com.example.Krupa.repo.statusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    private statusRepository statusRepository;

    @Autowired
    public StatusService(statusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }
    public status findBystatusID (int STATUS_ID) {
        return statusRepository.findBystatusID(STATUS_ID);
    }
    public status addStatus(String statusMessage) {
        status newStatus = new status(statusMessage);
        return statusRepository.save(newStatus);
    }
}
