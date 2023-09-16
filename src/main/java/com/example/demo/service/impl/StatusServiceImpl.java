package com.example.demo.service.impl;

import com.example.demo.model.Status;
import com.example.demo.repository.StatusRepository;
import com.example.demo.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements IStatusService {

    @Autowired
    StatusRepository statusRepository;

    @Override
    public Status add(Status o) {
        return statusRepository.save(o);
    }

    @Override
    public Boolean delete(Long id) {
        Status status = statusRepository.getById(id);
        statusRepository.delete(status);
        for (Status status1: statusRepository.findAll()
             ) {
            if(status1.getId()==id){
                return false;
            }
        }
        return true;
    }

    @Override
    public Status update(Long id, Status o) {
        Status status = statusRepository.getById(id);
        status.setStatus_name(o.getStatus_name());
        return statusRepository.save(status);
    }

    @Override
    public List<Status> getAll() {
        return statusRepository.findAll();
    }
}
