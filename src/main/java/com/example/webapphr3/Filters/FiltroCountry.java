package com.example.webapphr3.Filters;

import com.example.webapphr3.Beans.Employee;
import com.example.webapphr3.Daos.EmployeeDao;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "FiltroCountry", servletNames = "CountryServlet")
public class FiltroCountry implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        Employee e = (Employee) session.getAttribute("employee");
        //EmployeeDao employeeDao = new EmployeeDao();
        if (e.getDepartment().getLocation().getCountry().getRegionId().equals(1) || e.getDepartment().getLocation().getCountry().getRegionId().equals(2)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect(request.getContextPath());
        }
    }
}
