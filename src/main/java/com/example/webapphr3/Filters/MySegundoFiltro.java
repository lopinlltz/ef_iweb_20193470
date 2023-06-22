package com.example.webapphr3.Filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(filterName = "miFiltroPe", servletNames = "EmployeeServlet")
public class MySegundoFiltro implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("soy miFiltroPe :D");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
