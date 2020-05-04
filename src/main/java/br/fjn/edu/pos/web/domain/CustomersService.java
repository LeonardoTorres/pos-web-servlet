/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fjn.edu.pos.web.domain;

import br.fjn.edu.pos.web.components.CustomersRepository;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author leonardo
 */
@RequestScoped
public class CustomersService {
    
    @Inject
    private CustomersRepository customersRepository;
    
    public void create(Customer customer) throws Exception{
        this.isValidCPF(customer.getCpf());
        this.customersRepository.create(customer);
    }
    
    public void delete(String id){
      this.customersRepository.delete(id);
    }

    public Customer findById(String id){
      return this.customersRepository.findById(id);
    }

    public List<Customer> list(){
      return this.customersRepository.list();
    }

    public Customer update(Customer customer){
        return this.customersRepository.update(customer);
    }
    
    
    private void isValidCPF(String cpf) throws Exception{
        if (cpf.length() != 11){
            throw new Exception("CPF Inválido");
        }
    }
    
}
