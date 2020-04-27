/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fjn.edu.pos.web.domain;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author leonardo
 */
public class Customer {
    
    private String id; 
    private String name;
    private String cpf;
    private Integer age;
    private Address address;
    private Date createdAt;

    public Customer(String name, String cpf, Integer age) {
        this.name = name;
        this.cpf = cpf;
        this.age = age;
        this.createdAt = new Date();
        this.id = UUID.randomUUID().toString();
    }

    public Customer() {
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }  

    public String getId() {
        return id;
    }
    
    
}
