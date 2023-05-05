<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    
    if (username != null && password != null && username.equals(password)) {
        response.sendRedirect("login.html?message=Login%20Successfully");
    } else {
        response.sendRedirect("error.html?message=Login%20Failed");
    }
%>

