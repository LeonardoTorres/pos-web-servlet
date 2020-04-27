/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fjn.edu.pos.web.components;

import br.fjn.edu.pos.web.domain.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author leonardo
 */
@ApplicationScoped
public class CustomersRepository {
    
    private List<Customer> customersDB;

    public CustomersRepository() {
       this.customersDB = new ArrayList<>();
    }
    
    public void create(Customer customer){
        this.customersDB.add(customer);
    }
    
    public Customer findById(String id){
        return null;
    }
    
    public List<Customer> list(){
        return this.customersDB;
    }
    
    public Customer update(Customer customer){
        return null;
    }
    
    public void delete(String id){
        
    }
}
