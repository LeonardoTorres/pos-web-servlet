/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fjn.edu.pos.web.controllers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import javax.inject.Inject;

/**
 *
 * @author leonardo
 */
@Controller
public class IndexController {
    
    @Inject
    private Result result;
    
    @Get("/")
    public void index(){
        result.redirectTo(CustomersController.class).getCustomers();
    }
}
