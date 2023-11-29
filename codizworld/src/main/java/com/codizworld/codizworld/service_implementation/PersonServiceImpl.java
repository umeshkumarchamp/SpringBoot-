package com.codizworld.codizworld.service_implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codizworld.codizworld.model.Passport;
import com.codizworld.codizworld.model.Person;
import com.codizworld.codizworld.repository.PersonRepository;
import com.codizworld.codizworld.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepo;

    // @Override
    // public Person addPerson(Person person) {
    //     System.out.println("Received Person: " + person.toString());
    //     Person savedPerson = personRepo.save(person);
    //     System.out.println("Saved Person: " + savedPerson.toString());
    //     return savedPerson;
    // }

    @Override
    public Person addPerson(Person person) {
        System.out.println("Received Person: ");
        // Save the Person entity to obtain the generated ID
        Person savedPerson = personRepo.save(person);

        // Set the person reference in the Passport entity
        Passport passport = person.getPassport();
        if (passport != null) {
            passport.setPerson(savedPerson);
        }

        // Save the updated Passport entity
        personRepo.save(savedPerson);
        System.out.println("Saved Person: ");

        return savedPerson;
    }

}
