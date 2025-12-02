package Controlador;

import Modelo.Materia;
import Modelo.MateriaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import wscliente.ServicioMatriculas;
import wscliente.ServicioMatriculas_Service;


@WebServlet(name = "ControladorMateria", urlPatterns = {"/ControladorMateria"})
public class ControladorMateria extends HttpServlet {

    private MateriaDAO dao = new MateriaDAO();

    private final String pagListar = "/vista/listarMateria.jsp";
    private final String pagAdd = "/vista/addMateria.jsp";
    private final String pagEdit = "/vista/editMateria.jsp";
    private final String pagMateriasPorEst = "/vista/materiasPorEstudiante.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion == null) {
            accion = "listar";
        }

        switch (accion) {

            case "listar":
                
                request.setAttribute("materias", dao.ListarTodos());
                request.getRequestDispatcher(pagListar).forward(request, response);
                break;

            case "add":
                request.getRequestDispatcher(pagAdd).forward(request, response);
                break;

            case "edit":
                int idEdit = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("materia", dao.obtenerId(idEdit));
                request.getRequestDispatcher(pagEdit).forward(request, response);
                break;

            case "buscar":
                String texto = request.getParameter("texto");
                var resultado = dao.buscar(texto);
                request.setAttribute("materias", resultado);
                request.getRequestDispatcher(pagListar).forward(request, response);
                break;

            case "delete":
                int idDelete = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(idDelete);
                response.sendRedirect("ControladorMateria?accion=listar");
                break;

           
            case "listarPorEstudianteWS":
                String idEst = request.getParameter("texto");
                List<Modelo.Materia> listaMaterias = new ArrayList<>();
                int estudianteId = -1; // Usamos un ID por defecto

                if (idEst != null && !idEst.isEmpty()) {
                    try {
                        estudianteId = Integer.parseInt(idEst);
                        
                    
                        ServicioMatriculas_Service servicio = new ServicioMatriculas_Service();
                        ServicioMatriculas port = servicio.getServicioMatriculasPort();

                      
                        List<wscliente.Materia> materiasWS = port.getMateriasPorEstudiante(estudianteId);

                       
                        for (wscliente.Materia mWS : materiasWS) {
                            Modelo.Materia m = new Modelo.Materia();
                            m.setId(mWS.getId());
                            m.setCodigo(mWS.getCodigo());
                            m.setNombre(mWS.getNombre());
                            m.setDescripcion(mWS.getDescripcion());
                            listaMaterias.add(m);
                        }
                    
                     
                    } catch (NumberFormatException e) {
                        System.err.println("ID de estudiante no es un número válido: " + idEst);
                        request.setAttribute("mensajeError", "El ID de estudiante debe ser un número.");
                    } catch (Exception e) {
                        System.err.println("Error al consumir el Web Service: " + e.getMessage());
                        e.printStackTrace();
                        request.setAttribute("mensajeError", "Error al conectar o consultar el servicio de matrícula. Asegúrese de que el WS está corriendo en el puerto correcto.");
                        listaMaterias = new ArrayList<>();
                    }
                }
                
                request.setAttribute("idEstudianteBuscado", idEst); 
                request.setAttribute("materias", listaMaterias);
                request.getRequestDispatcher(pagMateriasPorEst).forward(request, response);
                return;

            default:
                request.setAttribute("materias", dao.ListarTodos());
                request.getRequestDispatcher(pagListar).forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {

            case "addGuardar":
                Materia m1 = new Materia();
                m1.setCodigo(request.getParameter("codigo"));
                m1.setNombre(request.getParameter("nombre").toUpperCase());
                m1.setDescripcion(request.getParameter("descripcion"));
                dao.agregar(m1);
                response.sendRedirect("ControladorMateria?accion=listar");
                break;

            case "editGuardar":
                Materia m2 = new Materia();
                m2.setId(Integer.parseInt(request.getParameter("id")));
                m2.setCodigo(request.getParameter("codigo"));
                m2.setNombre(request.getParameter("nombre").toUpperCase());
                m2.setDescripcion(request.getParameter("descripcion"));
                dao.actualizar(m2);
                response.sendRedirect("ControladorMateria?accion=listar");
                break;

            default:
                response.sendRedirect("ControladorMateria?accion=listar");
                break;
        }
    }
}