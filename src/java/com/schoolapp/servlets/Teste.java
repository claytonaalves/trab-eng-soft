package com.schoolapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.schoolapp.jdbc.ConnectionManager;

/**
 *
 * @author clayton
 */
@WebServlet(name = "Teste", urlPatterns = {"/teste"})
public class Teste extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Connection connection = ConnectionManager.getConnection();
        PrintWriter out = response.getWriter();
        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery("select * from pessoas");

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Teste</title>");            
            out.println("</head>");
            out.println("<body>");
            while(rs.next())
              {
                // read the result set
                out.println("id = " + rs.getInt("id"));
                out.println("nome = " + rs.getString("nome"));
              }
            out.println("</body>");
            out.println("</html>");
           
        } catch (SQLException e) {
                out.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
          
    }

}
