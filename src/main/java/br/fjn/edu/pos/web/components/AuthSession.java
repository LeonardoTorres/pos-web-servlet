/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fjn.edu.pos.web.components;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author leonardo
 */
@SessionScoped
public class AuthSession implements Serializable{
    
    private Boolean isLogged;
    private String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public Boolean isLogged(){
        return isLogged;
    }

    public String getUserName() {
        return userName;
    }

    public void setIsLogged(Boolean isLogged) {
        this.isLogged = isLogged;
    }
    
    public void signout(){
        this.isLogged = false;
        this.userName = null;
    }
    
    
    
    
}
