/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fjn.edu.pos.web.servlets;

import br.fjn.edu.pos.web.domain.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author leonardo
 */
@WebServlet(urlPatterns = {"/auth", "/logout"})
//@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        User user = new User(userName, password);

        ServletContext context = getServletContext();

        String messageResponse = null;
        if (user.getName().equalsIgnoreCase("joao") && user.getPassword().equals("123")) {
            HttpSession session = request.getSession();
            session.setAttribute("userLogged", user);
            response.sendRedirect("home.jsp");
        } else {
            request.setAttribute("loginErrorMsg", "Login Inválido!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("login.jsp");
    }

}
