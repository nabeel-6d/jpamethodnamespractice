package com.example.jpamethodnamespractice.jpamethodnamespractice.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpamethodnamespractice.jpamethodnamespractice.models.Person;
import com.example.jpamethodnamespractice.jpamethodnamespractice.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    
    @PostMapping("/addperson")
    public void add(){

        Collection<Person> col=new ArrayList<Person>();
        col.add(new Person("mohammed", "nabeel",22,"02/12/2000"));
        col.add(new Person("mohammed", "shamsher",27,"12/07/2009"));
        col.add(new Person("saint", "andrews",42,"05/04/1995"));
        col.add(new Person("kim", "bakerly",17,"03/11/2005"));
        personService.addPerson(col);
    }

    @GetMapping("/name/{name}")
    public Collection<Person> getbyfirstname(@PathVariable String name){
        return personService.findPersonByfirstname(name);
    }

    @GetMapping("/age/{age}")
    public Collection<Person> getPersonByageIfGreater(@PathVariable int age){
        return personService.findPersonIfAgeGreater(age);
    }

}
