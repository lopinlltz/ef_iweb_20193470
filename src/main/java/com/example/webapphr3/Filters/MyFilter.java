package com.example.webapphr3.Filters;

import com.example.webapphr3.Beans.Employee;
import com.example.webapphr3.Controllers.CountryServlet;
import com.example.webapphr3.Daos.EmployeeDao;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.Timestamp;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.

@WebFilter(filterName = "miFiltro", servletNames = {"EmployeeServlet", "CountryServlet", "JobServlet","LocationServlet", "DepartmentServlet"})
public class MyFilter implements Filter {
    static Logger logger = Logger.getLogger("intentos.log");

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Soy miFiltro :O");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        //String fecha_hora = Timestamp(request);
        //String url = request.getPathInfo();
        String metodohttp = new String();
        StringBuffer url = request.getRequestURL();

        Employee em = (Employee) session.getAttribute("employee");
        if (em == null) {
            //logger;
            logger.info("fecha-hora"+"-"+metodohttp+"-"+url);
            response.sendRedirect(request.getContextPath());
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

}
