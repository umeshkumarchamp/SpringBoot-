package com.codizworld.codizworld.service;

import java.util.List;

import com.codizworld.codizworld.model.springdatajpa.Parent;

public interface ParentService {

    public Parent addParent(Parent parent);

    public List<Parent> getParentList();
    
}
