<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="bootcamp.modulo5.dto.UserResponseDTO" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Usuarios</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<jsp:include page="header.jsp" />
<div class="container mt-5">
    <h2>Lista de Usuarios</h2>

    <div class="row mb-3">
        <div class="col-md-4">
            <input type="text" id="nameFilter" class="form-control" placeholder="Filtrar por nombre">
        </div>
        <div class="col-md-4">
            <input type="text" id="usernameFilter" class="form-control" placeholder="Filtrar por username">
        </div>
        <div class="col-md-4">
            <input type="text" id="animalFilter" class="form-control" placeholder="Filtrar por animal">
        </div>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Username</th>
            <th>Animal Horocopo</th>
        </tr>
        </thead>
        <tbody id="userTableBody">
        <%
            List<UserResponseDTO> users = (List<UserResponseDTO>) request.getAttribute("users");
            if (users != null) {
                for (UserResponseDTO user : users) {
        %>
        <tr>
            <td><%= user.getName() %></td>
            <td><%= user.getUsername() %></td>
            <td><%= user.getAnimal() %></td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>
<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
document.addEventListener('DOMContentLoaded', function() {
    const nameFilter = document.getElementById('nameFilter');
    const usernameFilter = document.getElementById('usernameFilter');
    const animalFilter = document.getElementById('animalFilter');
    const tbody = document.getElementById('userTableBody');
    const rows = tbody.getElementsByTagName('tr');

    function filterTable() {
        const nameValue = nameFilter.value.toLowerCase();
        const usernameValue = usernameFilter.value.toLowerCase();
        const animalValue = animalFilter.value.toLowerCase();

        for (let row of rows) {
            const name = row.cells[0].textContent.toLowerCase();
            const username = row.cells[1].textContent.toLowerCase();
            const animal = row.cells[2].textContent.toLowerCase();

            const nameMatch = name.includes(nameValue);
            const usernameMatch = username.includes(usernameValue);
            const animalMatch = animal.includes(animalValue);

            if (nameMatch && usernameMatch && animalMatch) {
                row.style.display = '';
            } else {
                row.style.display = 'none';
            }
        }
    }

    nameFilter.addEventListener('input', filterTable);
    usernameFilter.addEventListener('input', filterTable);
    animalFilter.addEventListener('input', filterTable);
});
</script>
</body>
</html></body></html></html></html></body></html>