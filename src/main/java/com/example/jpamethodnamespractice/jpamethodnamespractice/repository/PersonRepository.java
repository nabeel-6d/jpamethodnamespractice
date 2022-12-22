package com.example.jpamethodnamespractice.jpamethodnamespractice.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.example.jpamethodnamespractice.jpamethodnamespractice.models.Person;

public interface PersonRepository extends CrudRepository<Person,Integer>{
    Collection<Person> findByFirstname(String firstname);
    Collection<Person> findByAgeGreaterThan(int age);
}   
