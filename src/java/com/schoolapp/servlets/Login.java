package com.schoolapp.servlets;

import com.schoolapp.bean.Usuario;
import com.schoolapp.jdbc.ConnectionManager;
import com.schoolapp.model.dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author clayton
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    Connection connection = ConnectionManager.getConnection();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        Usuario usuario = new Usuario();
        usuario.setEmail(login);
        usuario.setSenha(senha);
        
        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
        
        boolean usuarioAutenticado = usuarioDAO.autentica(usuario);
        
        if (usuarioAutenticado) {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10000); // 10 min
            session.setAttribute("usuario", usuario);
//            request.getRequestDispatcher("home.jsp").forward(request, response);
            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("loginIncorreto.jsp");
        }
        
    }

}
