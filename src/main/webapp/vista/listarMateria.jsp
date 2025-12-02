<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Materias</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css">
    </head>
    <body>

        <div class="container mt-4">

            <h2>Listado de Materias</h2>

            <form action="ControladorMateria" method="get" 
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
                <a href="ControladorMateria?accion=listar" class="btn btn-secondary btn-sm">Ver todos</a>
                <%
                    }
                %>
            </form>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Opciones</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${materias}" var="m">
                        <tr>
                            <td>${m.id}</td>
                            <td>${m.codigo}</td>
                            <td>${m.nombre}</td>
                            <td>${m.descripcion}</td>
                            <td>
                                <a href="ControladorMateria?accion=edit&id=${m.id}" class="btn btn-warning btn-sm">Editar</a>
                                <a href="ControladorMateria?accion=delete&id=${m.id}" class="btn btn-danger btn-sm">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="mt-3">
                <a href="ControladorMateria?accion=add" class="btn btn-primary mb-3">Nueva Materia</a>
                <a href="Controlador?accion=listar" class="btn btn-secondary mb-3">Ir a Estudiantes</a>
            </div>

        </div>
    </body>
</html>

