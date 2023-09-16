package com.example.demo.service;

import com.example.demo.model.Status;

import java.util.List;

public interface IStatusService extends IService<Status, Long> {
    @Override
    Status add(Status o);

    @Override
    Boolean delete(Long id);

    @Override
    Status update(Long id, Status o);

    @Override
    List<Status> getAll();
}
