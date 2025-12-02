<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inicio - Universidad Fasttrack</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">

    <h1 class="text-center mb-4">Universidad Fasttrack</h1>
    <h3 class="text-center mb-4">Seleccione un módulo</h3>

    <div class="d-grid gap-3 col-6 mx-auto">

        <!-- Módulos existentes -->
        <a class="btn btn-primary btn-lg" 
           href="Controlador?accion=listar">
           Gestionar Estudiantes
        </a>

        <a class="btn btn-success btn-lg"
           href="ControladorMateria?accion=listar">
           Gestionar Materias
        </a>

        <a class="btn btn-info btn-lg"
           href="Controlador?accion=listarPorMateria">
           Ver Estudiantes por Materia (WS)
        </a>

        <a class="btn btn-warning btn-lg"
           href="vista/materiasPorEstudiante.jsp">
           Ver Materias por Estudiante (WS)
        </a>

    </div>

</div>

</body>
</html>
