
package Controlador;

import Modelo.MatriculaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ControladorMatricula extends HttpServlet {
    
    MatriculaDAO dao = new MatriculaDAO();
    private final String pagVer = "/vista/matricula.jsp";
    
    @Override
    protected  void doGet(HttpServletRequest req, HttpServletResponse resp ) 
            throws ServletException, IOException {
        
        String accion = req.getParameter("accion");
        if (accion==null) accion = "ver";
        
        switch (accion){
            
            case "ver":{
                int idEst = Integer.parseInt(req.getParameter("id"));
                
                req.setAttribute("idEstudiante", idEst);
                req.setAttribute("matriculadas", dao.listarMatriculas(idEst));
                req.setAttribute("noMatriculadas", dao.ListaNoMatriculadas(idEst));
                
                req.getRequestDispatcher(pagVer).forward(req, resp);
                break;
                
            }
            
            case "matricular":{
                
                int idEst = Integer.parseInt(req.getParameter("idEstudiante"));
                int idMat = Integer.parseInt(req.getParameter("idMateria"));
                
                dao.matricular(idEst, idMat);
                resp.sendRedirect("ControladorMatricula?accion=ver&id=" + idEst);
                break;
            }
            
            case "desmatricular":{
                
                int idEst = Integer.parseInt(req.getParameter("idEstudiante"));
                int idMat = Integer.parseInt(req.getParameter("idMateria"));
                
                dao.desmatricular(idEst, idMat);
                resp.sendRedirect("ControladorMatricula?accion=ver&id=" + idEst);
                break;
            }
        }
        
        
        
    }
    
    
    
}
