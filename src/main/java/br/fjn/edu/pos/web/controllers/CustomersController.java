/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fjn.edu.pos.web.controllers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.fjn.edu.pos.web.annotations.Auth;
import br.fjn.edu.pos.web.components.CustomersRepository;
import br.fjn.edu.pos.web.domain.Customer;
import javax.inject.Inject;

/**
 *
 * @author leonardo
 *
 * Criar -> POST /customers/create Atualizar -> PUT /customers/update Recuperar
 * -> GET /customers Deletar -> DELETE /customers
 * 
 *                                                    PASTA                 página.jsp
 * path das views (páginas) - GET / - WEB-INF/jsp/{controlador - customers}/{nomeDoMétodo - getCustomers}
 * path by Id - GET /customers/id/{sdfasdgasg} - PathParams
 * path by Id - GET /customers?id={id} - QueryParams
 */
@Auth
@Controller
@Path("/customers")
public class CustomersController {

    
    @Inject
    private Result result;
    
    @Inject
    private CustomersRepository customersRepository;
    
   
    @Get("new")
    public void create(){
        
    }
    
    @Post("")
    public void store(Customer customer) {
        customersRepository.create(customer);
        result.redirectTo(this).getCustomers();
    }

    @Post("update")
    public void update(Customer customer) {
        customersRepository.update(customer);
        result.redirectTo(this).getCustomers();
    }

    @Get("id/{id}")
    public void getCustomersById(String id){
        Customer customer = customersRepository.findById(id);
        System.out.println("customer" + customer);
        result.include("customerToUpdate", customer);
        result.of(this).update(null);
    }    
    
    @Get("")
    public void getCustomers() {
       result.include("customerList", customersRepository.list());
    }
    
    @Post("remove")
    public void remove(String id){
        customersRepository.delete(id);
        result.redirectTo(this).getCustomers();
              
    }
}
