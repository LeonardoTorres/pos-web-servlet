/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fjn.edu.pos.web.servlets;

import br.fjn.edu.pos.web.domain.Address;
import br.fjn.edu.pos.web.domain.Customer;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.json.Json;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leonardo
 */
@WebServlet("/customers")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        String name = req.getParameter("name");
        String cpf = req.getParameter("cpf");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String street = req.getParameter("street");
        String number = req.getParameter("number");
        
        Address address = new Address(street, number);
        
        Customer customer = new Customer(name, cpf, age);
        customer.setAddress(address);
        
        ServletContext context = getServletContext();
        
        List<Customer> customerList;
        
        if (context.getAttribute("customerList") ==  null){
            customerList = new LinkedList<>();
        }else{
            customerList = (List<Customer>) 
                    context.getAttribute("customerList");
        }
 
        customerList.add(customer);
        context.setAttribute("customer", customer);
        context.setAttribute("customerList", customerList);
        resp.sendRedirect("customer/customers.jsp");
        
    }
    
    
}
