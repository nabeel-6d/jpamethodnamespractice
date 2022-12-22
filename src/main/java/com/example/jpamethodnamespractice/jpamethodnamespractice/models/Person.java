package com.example.jpamethodnamespractice.jpamethodnamespractice.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;
    private String firstname;
    private String lastname;
    private int age;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    private Date dateOfBirth;

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Person() {
        System.out.println("in person no-arg cnstr");
    }
    public Person(String firstname, String lastname,int age,String dateOfBirth){
        if(firstname==null || firstname.isEmpty())
            throw new IllegalArgumentException("firstname not valid");
        this.firstname=firstname;
        if(lastname==null || lastname.isEmpty())
            throw new IllegalArgumentException("lastname not valid");
        this.lastname=lastname;
        if(dateOfBirth==null || dateOfBirth.isEmpty())
            throw new IllegalArgumentException("dateOfBirth not valid");
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
            this.dateOfBirth=sdf.parse(dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(age<0)
            throw new IllegalArgumentException("age is invalid");
        this.age=age;
        System.out.println("in person param cnstr");
    }
    public int getPersonId() {
        return personId;
    }
    public void setPersonId(int personId) {
        this.personId = personId;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + personId;
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (personId != other.personId)
            return false;
        if (firstname == null) {
            if (other.firstname != null)
                return false;
        } else if (!firstname.equals(other.firstname))
            return false;
        if (lastname == null) {
            if (other.lastname != null)
                return false;
        } else if (!lastname.equals(other.lastname))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Person [personId=" + personId + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age +"]";
    }

}