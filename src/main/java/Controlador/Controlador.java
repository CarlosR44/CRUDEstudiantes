package Controlador;

import Modelo.Estudiante;
import Modelo.EstudianteDAO;
import Modelo.PaisesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import wscliente.ServicioMatriculas;
import wscliente.ServicioMatriculas_Service;

public class Controlador extends HttpServlet {

    private EstudianteDAO estDao = new EstudianteDAO();
    PaisesDAO paisDao = new PaisesDAO();
    private final String pagListar = "/vista/listar.jsp";
    private final String pagAdd = "/vista/add.jsp";
    private final String pagEdit = "/vista/editar.jsp";
    private final String pagEstMat = "/vista/estudiantesPorMateria.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        if (accion == null) {
            accion = "listar";
        }

        switch (accion) {

            case "listar":
                listar(request, response);
                break;

            case "add":
                mostrarAdd(request, response);
                break;

            case "guardar":
                guardar(request, response);
                break;

            case "editar":
                mostrarEditar(request, response);
                break;

            case "actualizar":
                actualizar(request, response);
                break;

            case "eliminar":
                eliminar(request, response);
                break;

            case "buscar":
                String texto = request.getParameter("texto");
                System.out.println(">> BUSCANDO: " + texto);
                var resultado = estDao.buscar(texto);
                System.out.println(">> ENCONTRADOS: " + resultado.size());
                request.setAttribute("estudiantes", resultado);
                request.getRequestDispatcher("vista/listar.jsp").forward(request, response);
                return;

            case "listarPorMateria":
                String idmateria = request.getParameter("texto");
                System.out.println(idmateria);
                if (idmateria == null || idmateria.equals("")) {
                    idmateria = "0";
                }
                System.out.println(idmateria);
                ServicioMatriculas_Service servicio = new ServicioMatriculas_Service();
                ServicioMatriculas port = servicio.getServicioMatriculasPort();
                
                wscliente.Materia matWs = port.getMateria(Integer.parseInt(idmateria));
                
                if (matWs != null){
                    request.setAttribute("nombreMateria", matWs.getNombre());
                } else {
                    request.setAttribute("nombreMateria", "Materia no encontrada");
                }
                

                List<Estudiante> lista = new ArrayList<>();
                for (wscliente.Estudiante e : port.getEstudiantePorMateria(Integer.parseInt(idmateria))) {
                    Estudiante estudiante = new Estudiante();
                    estudiante.setId(e.getId());
                    estudiante.setNombre(e.getNombre());
                    estudiante.setApellido(e.getApellido());
                    estudiante.setPais_codigo(e.getPaisCodigo());
                    estudiante.setCorreo(e.getCorreo());
                    lista.add(estudiante);
                }
                request.setAttribute("estudiantes", lista);
                request.getRequestDispatcher(pagEstMat).forward(request, response);

            default:
                listar(request, response);
                break;

        }
    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("estudiantes", estDao.ListarTodos());
        request.getRequestDispatcher(pagListar).forward(request, response);

    }

    protected void mostrarAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("paises", paisDao.listar());
        request.getRequestDispatcher(pagAdd).forward(request, response);

    }

    protected void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre").toUpperCase();
        String apellido = request.getParameter("apellido").toUpperCase();
        String pais = request.getParameter("pais_codigo");

        Estudiante e = new Estudiante();

        e.setNombre(nombre);
        e.setApellido(apellido);
        e.setPais_codigo(pais);
        try {
            String correo = estDao.generarCorreo(nombre, apellido, pais);
            e.setCorreo(correo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        estDao.insertar(e);
        response.sendRedirect("Controlador?accion=listar");

    }

    protected void mostrarEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Estudiante est = estDao.obtenerId(id);

        request.setAttribute("est", est);
        request.setAttribute("paises", paisDao.listar());
        request.getRequestDispatcher(pagEdit).forward(request, response);
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String pais = request.getParameter("pais_codigo");

        Estudiante e = new Estudiante();
        e.setId(id);
        e.setNombre(nombre);
        e.setApellido(apellido);
        e.setPais_codigo(pais);

        Estudiante temp = estDao.obtenerId(id);
        e.setCorreo(temp.getCorreo());

        estDao.actualizar(e);
        response.sendRedirect("Controlador?accion=listar");
    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        estDao.eliminar(id);

        response.sendRedirect("Controlador?accion=listar");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
