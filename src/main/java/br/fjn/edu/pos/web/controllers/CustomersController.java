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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



/**
 *
 * @author leonardo
 *
 * Criar -> POST /customers Atualizar -> PUT /customers Recuperar -> GET
 * /customers Deletar -> DELETE /customers
 */
@Controller
@Path("/customers")
public class CustomersController {

  
    @Post
    public void create(){
        
    }
    
    @Get("")
    public void getCustomers(){
        System.out.println("Recebendo requisições GET");
    }
    
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//        String operation = req.getParameter("operation");
//        String name = req.getParameter("name");
//        String cpf = req.getParameter("cpf");
//        Integer age = Integer.parseInt(req.getParameter("age"));
//        String street = req.getParameter("street");
//        String number = req.getParameter("number");
//
//        Address address = new Address(street, number);
//
//        Customer customer = new Customer(name, cpf, age);
//        customer.setAddress(address);
//
//        ServletContext context = getServletContext();
//
//        List<Customer> customerList;
//
//        if (context.getAttribute("customerList") == null) {
//            customerList = new LinkedList<>();
//        } else {
//            customerList = (List<Customer>) context.getAttribute("customerList");
//        }
//
//        if (operation == null) {
//            //Fluxo de cadastro
//            customerList.add(customer);
//            context.setAttribute("customer", customer);
//        }
//
//        if (operation != null && operation.equalsIgnoreCase("PUT")) {
//            //Fluxo de atualização do customer
//            String id = req.getParameter("id");
//            for (Customer customerFromList : customerList) {
//                if (customerFromList.getId().equalsIgnoreCase(id)) {
//                    customerFromList.setAddress(customer.getAddress());
//                    customerFromList.setName(customer.getName());
//                    customerFromList.setAge(customer.getAge());
//                    customerFromList.setCpf(customer.getCpf());
//                    break;
//                }
//
//            }
//        }   
//        
//        context.setAttribute("customerList", customerList);
//        resp.sendRedirect("customer/customers.jsp");
//
//    }

  
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String customerId = req.getParameter("customerId");
//
////        ServletContext context = getServletContext();
////        List<Customer> customerList = (List<Customer>) context.getAttribute("customerList");
//        List<Customer> customerList = (List<Customer>) getServletContext()
//                .getAttribute("customerList");
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("customer/update.jsp");
//
//        for (Customer customer : customerList) {
//            if (customer.getId().equalsIgnoreCase(customerId)) {
//                req.setAttribute("customerToUpdate", customer);
//                break;
//            }
//        }
//        
//        requestDispatcher.forward(req, resp);
//
//    }

}
