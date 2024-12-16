<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Horóscopo Chino</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<nav class="navbar navbar-expand-lg">
    <div class="container-fluid">
        <a class="navbar-brand" href="home">Horóscopo Chino</a>
        <% if(session.getAttribute("loggedUser") != null) { %>
            <div class="navbar-nav mx-auto">
                <a class="nav-link" href="home">Inicio</a>
                <a class="nav-link" href="profile">Conoce tu animal</a>
                <a class="nav-link" href="users">Listado de Usuarios</a>
                <a class="nav-link" href="account">Cuenta</a>

            </div>
        <% } %>
        <div class="d-flex">
            <% if(session.getAttribute("loggedUser") != null) { %>
                <a href="logout" class="btn btn-outline-danger">Cerrar Sesión</a>
            <% } else { %>
                <a href="login" class="btn btn-outline-primary">Iniciar Sesión</a>
            <% } %>
        </div>
    </div>
</nav>