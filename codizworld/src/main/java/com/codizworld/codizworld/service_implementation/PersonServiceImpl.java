package com.codizworld.codizworld.service_implementation;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codizworld.codizworld.model.springdatajpa.Aadhar;
import com.codizworld.codizworld.model.springdatajpa.BankAccount;
import com.codizworld.codizworld.model.springdatajpa.Passport;
import com.codizworld.codizworld.model.springdatajpa.Person;
import com.codizworld.codizworld.repository.PersonRepository;
import com.codizworld.codizworld.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepo;

    // @Override
    // public Person addPerson(Person person) {
    // System.out.println("Received Person: " + person.toString());
    // Person savedPerson = personRepo.save(person);
    // System.out.println("Saved Person: " + savedPerson.toString());
    // return savedPerson;
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

        // Set the person reference in the Aadhar entity
        Aadhar aadhar = person.getAadhar();
        if (aadhar != null) {
            aadhar.setPerson(savedPerson);
        }

        // Set the person reference in the BankAccount entity
        Set<BankAccount> bankAccounts = person.getBankAccounts();
        if (bankAccounts != null && !bankAccounts.isEmpty()) {
            for (BankAccount bankAccount : bankAccounts) {
                bankAccount.setAccountHolder(savedPerson);
            }
        }

        // Save the updated Passport entity
        personRepo.save(savedPerson);
        System.out.println("Saved Person: ");
        return savedPerson;
    }

    @Override
    public List<Person> getPersonList() {
        return personRepo.findAll();
    }

    @Override
    public String removePerson(Integer id) {
        if (personRepo.existsById(id)) {
            personRepo.deleteById(id);
            return "Person Deleted Successfully";
        }
        return "Person Not Found !";
    }

    @Override
    public Person getPersonById(Integer id) {
        Person person = personRepo.findById(id).orElse(null);
        return person;
    }

}
