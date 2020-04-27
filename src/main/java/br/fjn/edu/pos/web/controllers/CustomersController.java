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
import br.fjn.edu.pos.web.components.CustomersRepository;
import br.fjn.edu.pos.web.domain.Customer;
import javax.inject.Inject;
import javax.servlet.ServletContext;

/**
 *
 * @author leonardo
 *
 * Criar -> POST /customers/create Atualizar -> PUT /customers/update Recuperar
 * -> GET /customers Deletar -> DELETE /customers
 * 
 *                                                    PASTA                 página.jsp
 * path das views (páginas) - GET / - WEB-INF/jsp/{controlador - customers}/{nomeDoMétodo - getCustomers}
 */
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
    public void update() {

    }

    @Get("")
    public void getCustomers() {
       result.include("customerList", customersRepository.list());
    }
}
