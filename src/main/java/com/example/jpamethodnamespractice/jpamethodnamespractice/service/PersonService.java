package com.example.jpamethodnamespractice.jpamethodnamespractice.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpamethodnamespractice.jpamethodnamespractice.models.Person;
import com.example.jpamethodnamespractice.jpamethodnamespractice.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void addPerson(Collection<Person> col){
        col.forEach(person -> personRepository.save(person));
    }

    public Collection<Person> getAllPersons(){
        List<Person> list=new ArrayList<Person>();
        personRepository.findAll().forEach(list::add);
        return list;
    }
    public Collection<Person> findPersonByfirstname(String name){
        System.out.println();
        System.out.println(personRepository.findByFirstname(name));
        return personRepository.findByFirstname(name);
    }
    public Collection<Person> findPersonIfAgeGreater(int age){
        return personRepository.findByAgeGreaterThan(age);
    }
}
