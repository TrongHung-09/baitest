package com.example.demo.controller;

import com.example.demo.model.Status;
import com.example.demo.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    IStatusService iStatusService;

    @PostMapping("/add")
    public Status add(@RequestBody Status status){
        return iStatusService.add(status);
    }

    @PutMapping("/update/{id}")
    public Status update(@PathVariable Long id, @RequestBody Status status){
        return iStatusService.update(id, status);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return iStatusService.delete(id);
    }

    @GetMapping("/")
    public List<Status> getAll(){
        return iStatusService.getAll();
    }
}
