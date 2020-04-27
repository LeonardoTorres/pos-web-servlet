/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fjn.edu.pos.web.domain;

/**
 *
 * @author leonardo
 */
public class Address {
    
    private String street;
    private String number;

    public Address(String street, String number) {
        this.street = street;
        this.number = number;
    }
   
    public Address(){
        
    }
    
    public String getNumber() {
        return number;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }
    
}
