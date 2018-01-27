package com.schoolapp.servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class FiltroLogin implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String url = httpRequest.getRequestURI();
        HttpSession session = httpRequest.getSession();
        // se o usuário já estiver autenticado, continua processamento de filtros.
        if (session.getAttribute("usuario") != null || 
                url.lastIndexOf("login.jsp") > -1 || 
                url.lastIndexOf("login") > -1) 
        {
            chain.doFilter(request, response);
        } 
        // Senão, redireciona ele para a página de login.
        else {
            ((HttpServletResponse) response).sendRedirect("login.jsp");
        }
    }

    @Override
    public void destroy() {
        
    }
    
}
