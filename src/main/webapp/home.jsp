<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bootcamp.modulo5.dto.UserResponseDTO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex align-items-center justify-content-center vh-100">
    <div class="container">
        <div class="card">
            <div class="card-header text-center">
                <h1 class="mb-4">¿Qué desea hacer <%= ((UserResponseDTO)session.getAttribute("loggedUser")).getName() %>?</h1>
            </div>
            <div class="card-body text-center">
                <div class="d-flex justify-content-center gap-3 flex-wrap">
                    <a href="profile" class="btn btn-info text-light">Conocer tu animal</a>
                    <a href="users" class="btn btn-info text-light">Listar usuarios</a>
                    <a href="account" class="btn btn-info text-light">Cuenta</a>

                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
