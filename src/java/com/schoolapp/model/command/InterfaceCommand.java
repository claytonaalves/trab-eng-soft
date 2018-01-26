package com.schoolapp.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author clayton
 */
public interface InterfaceCommand {
    
    public String execute(HttpServletRequest request,
            HttpServletResponse response);

}
