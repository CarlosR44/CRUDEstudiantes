<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Materias por Estudiante</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body class="container mt-4">
        <h2 class="mb-4">Listado de Materias por Estudiante (WS)</h2>
        <form action="${pageContext.request.contextPath}/ControladorMateria" method="get" 
              class="mb-3 d-flex align-items-center gap-2" 
              style="max-width: 450px;">
            <input type="hidden" name="accion" value="listarPorEstudianteWS">
            <input type="text" 
                   name="texto" 
                   class="form-control form-control-sm" 
                   placeholder="Buscar por ID de estudiante"
                   style="width: 200px;">
            <button class="btn btn-primary btn-sm">Buscar</button>
            <a href="${pageContext.request.contextPath}/ControladorMateria?accion=listar" 
               class="btn btn-secondary btn-sm">Ver todos</a>
        </form>

        <c:if test="${not empty mensajeError}">
            <div class="alert alert-danger" role="alert">
                <strong>Error de Búsqueda:</strong> ${mensajeError}
            </div>
        </c:if>

        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="m" items="${materias}">
                    <tr>
                        <td>${m.id}</td>
                        <td>${m.codigo}</td>
                        <td>${m.nombre}</td>
                        <td>${m.descripcion}</td>
                    </tr>
                </c:forEach>

                <c:if test="${empty materias}">
                    <tr>
                        <td colspan="4" class="text-center">
                            <c:choose>
                                <c:when test="${not empty idEstudianteBuscado and empty mensajeError}">
                                    No se encontraron materias matriculadas para el estudiante ${idEstudianteBuscado}.
                                </c:when>
                                <c:otherwise>
                                    No hay registros o no se ha realizado la búsqueda.
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:if>
            </tbody>
        </table>

        <div class="mt-3">
            <a href="${pageContext.request.contextPath}/ControladorMateria?accion=listar" 
               class="btn btn-secondary mb-3">Gestionar Materias</a>
            <a href="${pageContext.request.contextPath}/Controlador?accion=listar" 
               class="btn btn-primary mb-3">Gestionar Estudiantes</a>
        </div>

    </body>
</html>