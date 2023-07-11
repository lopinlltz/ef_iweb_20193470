package com.example.webapphr3.Filters;

import com.example.webapphr3.Beans.Employee;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "FiltroEmployee", servletNames = "EmployeeServlet")
public class FiltroEmployee implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        Employee e = (Employee) session.getAttribute("employee");
        if (e.getJob().getJobId() == "AD_PRES" || e.getJob().getJobId() == "AD_VP" || e.getJob().getJobId() == "FI_MGR") {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect(request.getContextPath());
        }
    }
}
