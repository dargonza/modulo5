<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cuenta de Usuario</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-light">
<jsp:include page="header.jsp"/>
<div class="container mt-5">
    <h2 class="text-center mb-4">Cuenta</h2>


    <div class="row justify-content-center align-items-center">

        <div class="col-md-6">
            <% if (request.getParameter("success") != null && request.getParameter("success").equals("update-success")) { %>
            <div class="alert alert-success alert-dismissible fade show" role="alert" id="successAlert">
                ¡Perfil actualizado exitosamente!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <% } %>

            <% if (request.getParameter("error") != null && request.getParameter("error").equals("update-failed")) { %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert" id="errorAlert">
                Hubo un error al actualizar el perfil. Por favor, intente nuevamente.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <% } %>
            <div class="card">
                <div class="card-header text-center">
                    <h4 class="mb-0">Actualizar Perfil</h4>
                </div>
                <div class="card-body">
                    <form action="/account/update-profile" method="POST">
                        <div class="form-group">
                            <label for="name">Nombre:</label>
                            <input type="text" class="form-control" id="name" name="name" value="${loggedUser.name}"
                                   required>
                        </div>
                        <div class="form-group">
                            <label for="username">Username:</label>
                            <input type="text" class="form-control" id="username" name="username"
                                   value="${loggedUser.username}"
                                   required>
                        </div>
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="email" class="form-control" id="email" name="email" value="${loggedUser.email}"
                                   required>
                        </div>
                        <div class="form-group">
                            <label for="birth_date">Fecha de Cumpleaños:</label>
                            <input type="date" class="form-control" id="birth_date" name="birth_date"
                                   value="${loggedUser.birthDate}" required>
                        </div>
                        <div class="form-group">
                            <label for="password">Nueva Contraseña:</label>
                            <input type="password" class="form-control" id="password" name="password">
                            <small class="form-text text-muted">Dejar en blanco si no desea cambiar la
                                contraseña</small>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Guardar Cambios</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-6">

            <% if (request.getParameter("error") != null &&
                    (request.getParameter("error").equals("not-logged") || request.getParameter("error").equals("delete-failed"))) { %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert" id="notLoggedAlert">
                Hubo un error al eliminar la cuenta. Por favor, intente nuevamente.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <% } %>


            <div class="card border-danger p-4">
                <h4 class="text-center text-danger mb-3">Eliminar Cuenta</h4>
                <div class="card-body">
                    <p class="card-text text-center">Esta acción no se puede deshacer. Se eliminarán todos sus datos
                        permanentemente.</p>
                    <div class="text-center">
                        <button type="button" class="btn btn-danger btn-lg" data-toggle="modal"
                                data-target="#deleteAccountModal">
                            Eliminar mi cuenta
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal de confirmación para eliminar cuenta -->
<div class="modal fade" id="deleteAccountModal" tabindex="-1" role="dialog" aria-labelledby="deleteAccountModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteAccountModalLabel">Confirmar eliminación</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                ¿Está seguro que desea eliminar su cuenta? Esta acción no se puede deshacer.
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <form action="/account/delete-account" method="POST" style="display: inline;">
                    <button type="submit" class="btn btn-danger">Sí, eliminar mi cuenta</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
        setTimeout(function () {
            $("#successAlert").alert('close');
            $("#errorAlert").alert('close');
            $("#notLoggedAlert").alert('close');
        }, 2000);
    });
</script>
</body>
</html>