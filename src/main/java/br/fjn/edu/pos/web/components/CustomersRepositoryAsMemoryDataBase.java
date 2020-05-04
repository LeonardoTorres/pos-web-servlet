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
public class CustomersRepositoryAsMemoryDataBase implements CustomersRepository {

    private List<Customer> customersDB;

    public CustomersRepositoryAsMemoryDataBase() {
        this.customersDB = new ArrayList<>();
        this.customersDB.add(new Customer("joao", "123", 20));
    }

    @Override
    public void create(Customer customer) {
        this.customersDB.add(customer);
    }

    @Override
    public Customer findById(String id) {
        return customersDB.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Customer> list() {
        return this.customersDB;
    }

    @Override
    public Customer update(Customer customer) {
        for (int i = 0; i < customersDB.size(); i++) {
           if (customersDB.get(i).getId().equals(customer.getId())){
               customersDB.set(i, customer);
           } 
        }
        return customer;
    }

    @Override
    public void delete(String id) {
        customersDB.removeIf(customer -> customer.getId().equals(id));
    }
}
