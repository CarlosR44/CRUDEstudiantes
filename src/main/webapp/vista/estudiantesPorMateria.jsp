<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Listado de Estudiantes por Materia</title>
    <a href="Controlador?accion=listar" class="btn btn-primary">Estudiantes</a>
    <a href="ControladorMateria?accion=listar" class="btn btn-secondary">Materias</a>
    <br><br>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>

<body class="container mt-4">

    <h2 class="mb-4">Listado de Estudiantes por Materia</h2>

    <form action="Controlador" method="get" 
          class="mb-3 d-flex align-items-center gap-2" 
          style="max-width: 450px;">

        <input type="hidden" name="accion" value="listarPorMateria">

        <input type="text" 
               name="texto" 
               class="form-control form-control-sm" 
               placeholder="Buscar por ID"
               style="width: 200px;">

        <button class="btn btn-primary btn-sm">Buscar</button>

    </form>

    <c:if test="${not empty nombreMateria}">
        <h4>Estudiantes matriculados en la materia: <strong>${nombreMateria}</strong></h4>
    </c:if>

    <table class="table table-bordered table-striped">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Pais</th>
                <th>Correo</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="e" items="${estudiantes}">
                <tr>
                    <td>${e.id}</td>
                    <td>${e.nombre}</td>
                    <td>${e.apellido}</td>
                    <td>${e.pais_codigo}</td>
                    <td>${e.correo}</td>
                </tr>
            </c:forEach>

            <c:if test="${empty estudiantes}">
                <tr><td colspan="6" class="text-center">No hay registros</td></tr>
            </c:if>
        </tbody>
    </table>
</body>
</html>
