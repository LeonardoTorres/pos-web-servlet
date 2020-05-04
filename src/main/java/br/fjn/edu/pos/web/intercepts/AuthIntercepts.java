/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fjn.edu.pos.web.intercepts;

import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.fjn.edu.pos.web.annotations.Auth;
import br.fjn.edu.pos.web.components.AuthSession;
import br.fjn.edu.pos.web.controllers.AuthController;
import javax.inject.Inject;

/**
 *
 * @author leonardo
 */
@Intercepts
public class AuthIntercepts implements Interceptor{

    @Inject
    private AuthSession authSession;
    
    @Inject
    private Result result;
    
    @Override
    public void intercept(InterceptorStack is, ControllerMethod cm, Object o) {
        System.out.println("authSession" + authSession.isLogged());
        if (authSession.isLogged()){
            is.next(cm, o);
        }else{
            authSession.signout();
            result.redirectTo(AuthController.class).login();
        }
    }

    @Override
    public boolean accepts(ControllerMethod cm) {
         boolean canGo =  cm.containsAnnotation(Auth.class) || cm.getController().getType().isAnnotationPresent(Auth.class);
         System.out.println("Can go " + canGo);
         return canGo;
    }
    
    
}
