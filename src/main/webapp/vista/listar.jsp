<%-- 
    Document   : listar
    Created on : 27/11/2025, 8:16:56 p. m.
    Author     : cbeff
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Listado de Estudiantes</title>
    <a href="Controlador?accion=listar" class="btn btn-primary">Estudiantes</a>
    <a href="ControladorMateria?accion=listar" class="btn btn-secondary">Materias</a>
    <br><br>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>

<body class="container mt-4">

    <h2 class="mb-4">Listado de Estudiantes</h2>

    <form action="Controlador" method="get" 
          class="mb-3 d-flex align-items-center gap-2" 
          style="max-width: 450px;">

        <input type="hidden" name="accion" value="buscar">

        <input type="text" 
               name="texto" 
               class="form-control form-control-sm" 
               placeholder="Buscar por ID o nombre..."
               style="width: 200px;">

        <button class="btn btn-primary btn-sm">Buscar</button>

        <%
            String accion = request.getParameter("accion");
            if ("buscar".equals(accion)) {
        %>
        <a href="Controlador?accion=listar" class="btn btn-secondary btn-sm">Ver todos</a>
        <%
            }
        %>
    </form>



    <table class="table table-bordered table-striped">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Pais</th>
                <th>Correo</th>
                <th>Acciones</th>
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

                    <td class="d-flex gap-2">

                        <a href="Controlador?accion=editar&id=${e.id}" 
                           class="btn btn-warning btn-sm">
                            Editar
                        </a>

                        <a href="Controlador?accion=eliminar&id=${e.id}" 
                           class="btn btn-danger btn-sm"
                           onclick="return confirm('¿Desea eliminar este estudiante?');">
                            Eliminar
                        </a>

                        <a href="ControladorMatricula?accion=ver&id=${e.id}"
                           class="btn btn-info btn-sm text-white">
                            Matricular Materias
                        </a>

                    </td>
                </tr>
            </c:forEach>

            <c:if test="${empty estudiantes}">
                <tr><td colspan="6" class="text-center">No hay registros</td></tr>
            </c:if>
        </tbody>
    </table>
    <div class="mt-3">
        <a href="Controlador?accion=add" class="btn btn-primary">Agregar Estudiante</a>
    </div>
</body>
</html>
