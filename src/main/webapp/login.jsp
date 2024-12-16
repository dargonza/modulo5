<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<jsp:include page="header.jsp"/>
<div class="container d-flex justify-content-center align-items-center min-vh-100">
    <div class="card shadow-lg" style="width: 100%; max-width: 400px;">
        <div class="card-header text-center">
            <h4 class="mb-0">Iniciar sesión</h4>
        </div>
        <div class="card-body">
            <!-- Formulario de login -->
            <form action="login" method="POST">
                <!-- Campo de Usuario -->
                <div class="mb-3">
                    <label for="username" class="form-label">Usuario</label>
                    <input type="text" class="form-control" id="username" name="username" required>
                </div>

                <!-- Campo de Contraseña -->
                <div class="mb-3">
                    <label for="password" class="form-label">Contraseña</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>

                <!-- Mensaje de cierre de sesión -->
                <% if (request.getParameter("logout") != null && request.getParameter("logout").equals("success")) { %>
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    Has cerrado sesión exitosamente.
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
                <script>
                    setTimeout(function () {
                        document.querySelector('.alert').remove();
                    }, 2000);
                </script>
                <% } %>

                <!-- Mostrar errores -->
                <% if (request.getParameter("error") != null && request.getParameter("error").equals("success")) { %>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <%= request.getAttribute("error") %>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
                <script>
                    setTimeout(function () {
                        document.querySelector('.alert-danger').remove();
                    }, 2000);
                </script>
                <% } %>

                <!-- Botón de Enviar -->
                <button type="submit" class="btn btn-info text-light w-100">Iniciar sesión</button>
            </form>
        </div>
        <div class="card-footer text-center">
            <small>¿No tienes cuenta? <a href="register">Regístrate</a></small>
        </div>
    </div>
</div>

<!-- Bootstrap JS (opcional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>