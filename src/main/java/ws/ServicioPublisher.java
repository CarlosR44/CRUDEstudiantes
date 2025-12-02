package ws;


//import jakarta.xml.ws.Endpoint;
import java.util.List;
import wscliente.Estudiante;
import wscliente.ServicioMatriculas_Service;
import wscliente.ServicioMatriculas;

public class ServicioPublisher {
    public static void main(String[] args) {

        ServicioMatriculas_Service servicio = new ServicioMatriculas_Service();
        ServicioMatriculas port = servicio.getServicioMatriculasPort();
        List<Estudiante> estudiantes = port.getEstudiantePorMateria(2);
        for (Estudiante e: estudiantes){
            System.out.println(e.getNombre());
        
       
    }
}
}