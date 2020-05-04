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
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.fjn.edu.pos.web.annotations.Auth;
import br.fjn.edu.pos.web.domain.Customer;
import br.fjn.edu.pos.web.domain.CustomersService;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private CustomersService customersService;
    
   
    @Get("new")
    public void create(){
        
    }
    
    @Post("")
    @IncludeParameters
    public void store(Customer customer) {          
        try {
            customersService.create(customer);
            result.redirectTo(this).getCustomers();
        } catch (Exception ex) {
            result.include("cpfError", ex.getMessage());
            result.redirectTo(this).create();
        }    
    }

    @Post("update")
    public void update(Customer customer) {
        customersService.update(customer);
        result.redirectTo(this).getCustomers();
    }

    @Get("id/{id}")
    public void getCustomersById(String id){
        Customer customer = customersService.findById(id);    
        result.include("customerToUpdate", customer);
        result.of(this).update(null);
    }    
    
    @Get("")
    public void getCustomers() {
       result.include("customerList", customersService.list());
    }
    
    @Post("remove")
    public void remove(String id){
        customersService.delete(id);
        result.redirectTo(this).getCustomers();          
    }
}
