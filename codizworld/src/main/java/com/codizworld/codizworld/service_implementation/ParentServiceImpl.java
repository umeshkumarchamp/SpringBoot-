package com.codizworld.codizworld.service_implementation;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codizworld.codizworld.model.springdatajpa.Child;
import com.codizworld.codizworld.model.springdatajpa.Parent;
import com.codizworld.codizworld.repository.ParentRepository;
import com.codizworld.codizworld.service.ParentService;

@Service
public class ParentServiceImpl implements ParentService{

    @Autowired
    private ParentRepository parentRepo;

    @Override
    public Parent addParent(Parent parent) {
        Parent saveParent = parentRepo.save(parent);
        Set<Child> children = parent.getChildren();
        for(Child child : children){
            child.setParent(saveParent);
        }
        parentRepo.save(saveParent);
        return saveParent;
    }

    @Override
    public List<Parent> getParentList() {
        return parentRepo.findAll();
    }
    
}
