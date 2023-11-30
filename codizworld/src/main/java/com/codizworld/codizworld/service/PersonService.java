package com.codizworld.codizworld.service;

import java.util.List;

import com.codizworld.codizworld.model.springdatajpa.Person;

public interface PersonService {

    public Person addPerson(Person person);

    public List<Person> getPersonList();

    public Person getPersonById(Integer id);

    public String removePerson(Integer id);
}
