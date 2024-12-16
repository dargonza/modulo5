<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<jsp:include page="header.jsp"/>
<div class="container min-vh-100 d-flex justify-content-center align-items-center">
    <div class="row w-100 justify-content-center">
        <div class="col-md-6">
            <div class="card shadow-lg">
                <div class="card-header text-center">
                    <h4 class="mb-0">Registrar Nuevo Usuario</h4>
                </div>
                <div class="card-body">
                    <div id="alertSuccess" class="alert alert-success alert-dismissible fade d-none" role="alert">
                        ¡Usuario registrado exitosamente!
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>

                    <div id="alertError" class="alert alert-danger alert-dismissible fade d-none" role="alert">
                        Error al registrar usuario. Por favor intente nuevamente.
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>

                    <form id="registerForm" action="register" method="post">
                        <div class="mb-3">
                            <label for="name" class="form-label">Nombre Completo</label>
                            <input type="text" class="form-control" id="name" name="name" required>
                        </div>

                        <div class="mb-3">
                            <label for="username" class="form-label">Nombre de Usuario</label>
                            <input type="text" class="form-control" id="username" name="username" required>
                        </div>

                        <div class="mb-3">
                            <label for="email" class="form-label">Correo Electrónico</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>

                        <div class="mb-3">
                            <label for="password" class="form-label">Contraseña</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>

                        <div class="mb-3">
                            <label for="birthDate" class="form-label">Fecha de Nacimiento</label>
                            <input type="date" class="form-control" id="birthDate" name="birthDate" required>
                        </div>

                        <div class="d-grid">
                            <button type="submit" class="btn btn-info text-light">Registrar</button>
                        </div>
                    </form>
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
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function showAlert(type) {
        const alert = document.getElementById('alert' + type);
        alert.classList.remove('d-none');
        alert.classList.add('show');

        setTimeout(() => {
            alert.classList.remove('show');
            alert.classList.add('d-none');
        }, 2000);
    }
</script>
</body>
</html></html>