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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leonardo
 *
 * Criar -> POST /customers Atualizar -> PUT /customers Recuperar -> GET
 * /customers Deletar -> DELETE /customers
 */
@WebServlet("/customers")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String operation = req.getParameter("operation");
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

        if (context.getAttribute("customerList") == null) {
            customerList = new LinkedList<>();
        } else {
            customerList = (List<Customer>) context.getAttribute("customerList");
        }

        if (operation == null) {
            customerList.add(customer);
            context.setAttribute("customer", customer);
        }

        if (operation != null && operation.equalsIgnoreCase("PUT")) {
            String id = req.getParameter("id");
            for (Customer customerFromList : customerList) {
                if (customerFromList.getId().equalsIgnoreCase(id)) {
                    customerFromList.setAddress(customer.getAddress());
                    customerFromList.setName(customer.getName());
                    customerFromList.setAge(customer.getAge());
                    customerFromList.setCpf(customer.getCpf());
                    break;
                }

            }
        }   
        
        context.setAttribute("customerList", customerList);
        resp.sendRedirect("customer/customers.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerId = req.getParameter("customerId");

//        ServletContext context = getServletContext();
//        List<Customer> customerList = (List<Customer>) context.getAttribute("customerList");
        List<Customer> customerList = (List<Customer>) getServletContext()
                .getAttribute("customerList");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("customer/update.jsp");

        for (Customer customer : customerList) {
            if (customer.getId().equalsIgnoreCase(customerId)) {
                req.setAttribute("customerToUpdate", customer);
                break;
            }
        }
        
        requestDispatcher.forward(req, resp);

    }

}
