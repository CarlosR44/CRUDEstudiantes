<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión de Matrículas</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>

<body class="container mt-4">

    <h2 class="mb-4">Matrículas del Estudiante ID: ${idEstudiante}</h2>

    <div class="row">

        <div class="col-md-6">
            <div class="card shadow-sm mb-4">
                <div class="card-header bg-primary text-white">
                    <h5 class="mb-0">Materias matriculadas</h5>
                </div>
                <div class="card-body">

                    <table class="table table-bordered table-striped">
                        <thead class="table-dark">
                            <tr>
                                <th>Materia</th>
                                <th>Acción</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="m" items="${matriculadas}">
                            <tr>
                                <td>${m.nombre}</td>
                                <td>
                                    <a href="ControladorMatricula?accion=desmatricular&idEstudiante=${idEstudiante}&idMateria=${m.id}"
                                       class="btn btn-danger btn-sm">
                                       Quitar
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>

                        <c:if test="${empty matriculadas}">
                            <tr><td colspan="2" class="text-center text-muted">No tiene materias matriculadas</td></tr>
                        </c:if>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>

        <div class="col-md-6">
            <div class="card shadow-sm mb-4">
                <div class="card-header bg-success text-white">
                    <h5 class="mb-0">Materias disponibles</h5>
                </div>

                <div class="card-body">

                    <table class="table table-bordered table-striped">
                        <thead class="table-dark">
                            <tr>
                                <th>Materia</th>
                                <th>Acción</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="m" items="${noMatriculadas}">
                            <tr>
                                <td>${m.nombre}</td>
                                <td>
                                    <a href="ControladorMatricula?accion=matricular&idEstudiante=${idEstudiante}&idMateria=${m.id}"
                                       class="btn btn-success btn-sm">
                                       Matricular
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>

                        <c:if test="${empty noMatriculadas}">
                            <tr><td colspan="2" class="text-center text-muted">No hay materias disponibles</td></tr>
                        </c:if>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>

    </div>

    <a href="Controlador?accion=listar" class="btn btn-secondary mt-3">Volver</a>

</body>
</html>


