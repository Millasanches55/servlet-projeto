/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/greeting.html"})
public class GreetingServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Pegando a hora atual
        LocalTime now = LocalTime.now();
        String greeting = "";

        // Definindo a saudação com base na hora
        if (now.isBefore(LocalTime.NOON)) {
            greeting = "Bom dia!";
        } else if (now.isBefore(LocalTime.of(18, 0))) {
            greeting = "Boa tarde!";
        } else if (now.isBefore(LocalTime.of(22, 0))) {
            greeting = "Boa noite!";
        } else {
            greeting = "Vá dormir!";
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Greeting Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + greeting + "</h1>");
            out.println("<p>Hora atual: " + now + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Greeting Servlet";
    }
}
