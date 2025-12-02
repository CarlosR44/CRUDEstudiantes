<%-- 
    Document   : editar
    Created on : 28/11/2025, 8:23:08 p. m.
    Author     : cbeff
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Estudiante</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>

<body class="container mt-4">

    <h2 class="mb-4">Editar Estudiante</h2>

    <form action="Controlador?accion=actualizar" method="post">

        <input type="hidden" name="id" value="${est.id}">

        <div class="mb-3">
            <label>Nombre</label>
            <input type="text" name="nombre" class="form-control"
                   value="${est.nombre}" required maxlength="50">
        </div>

        <div class="mb-3">
            <label>Apellido</label>
            <input type="text" name="apellido" class="form-control"
                   value="${est.apellido}" required maxlength="50">
        </div>

        <div class="mb-3">
            <label>País</label>
            <select name="pais_codigo" class="form-select" required>

                <c:forEach var="p" items="${paises}">
                    <option value="${p.codigo}"
                            ${p.codigo == est.pais_codigo ? 'selected' : ''}>
                        ${p.nombre}
                    </option>
                </c:forEach>

            </select>
        </div>

        <button type="submit" class="btn btn-primary">Actualizar</button>
        <a href="Controlador?accion=listar" class="btn btn-secondary">Cancelar</a>

    </form>

</body>
</html>
