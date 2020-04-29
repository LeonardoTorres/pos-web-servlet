/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fjn.edu.pos.web.controllers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.fjn.edu.pos.web.components.AuthSession;
import br.fjn.edu.pos.web.domain.Credentials;
import javax.inject.Inject;

/**
 *
 * @author leonardo
 */
@Controller
public class AuthController {
    
    @Inject
    private AuthSession authSession;

    @Inject
    private Result result;
    
    @Get("signin")
    public void login(){
        
    }
    
    @Post("auth")
    public void authenticate(Credentials credentials){
      
        if (credentials.getUserName().equalsIgnoreCase("joao") && 
                credentials.getPassword().equals("123")){
            authSession.setUserName(credentials.getUserName());
            authSession.setIsLogged(true);
            result.redirectTo(CustomersController.class).getCustomers();
        }else{
            result.include("loginErrorMsg", "Login inválido!");
            result.redirectTo(this).login();
        }   
    }
    
    @Get("signout")
    public void signout(){
       authSession.signout();
       result.redirectTo(this).login();
    }

}
