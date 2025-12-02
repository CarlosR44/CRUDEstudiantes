<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Agregar Materia</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-4">

    <h2>Nueva Materia</h2>

    <form action="ControladorMateria" method="post">
        <input type="hidden" name="accion" value="addGuardar">

        <div class="mb-3">
            <label>Código:</label>
            <input type="text" name="codigo" class="form-control" required>
        </div>

        <div class="mb-3">
            <label>Nombre:</label>
            <input type="text" name="nombre" class="form-control" required>
        </div>

        <div class="mb-3">
            <label>Descripción:</label>
            <textarea name="descripcion" class="form-control"></textarea>
        </div>

        <button class="btn btn-success">Guardar</button>
        <a href="ControladorMateria?accion=listar" class="btn btn-secondary">Cancelar</a>

    </form>

</div>
</body>
</html>
