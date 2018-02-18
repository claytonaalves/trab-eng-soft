package com.schoolapp.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author clayton
 */
public class ListarMenuPrincipal implements InterfaceCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "menuPrincipal.jsp";
    }
    
}
