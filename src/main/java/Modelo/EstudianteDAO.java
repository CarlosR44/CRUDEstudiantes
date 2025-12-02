package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EstudianteDAO {

    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<Estudiante> ListarTodos() {
        ArrayList<Estudiante> lista = new ArrayList<>();

        try {
            cn = Conexion.getConnection();
            String sql = "select * from estudiantes";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Estudiante obj = new Estudiante();
                obj.setId(rs.getInt("id"));
                obj.setNombre(rs.getString("Nombre"));
                obj.setApellido(rs.getString("Apellido"));
                obj.setPais_codigo(rs.getString("Pais_codigo"));
                obj.setCorreo(rs.getString("Correo"));
                lista.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {

            }
        }

        return lista;
    }

    public Estudiante obtenerId(int id) {
        Estudiante obj = null;
        try {
            cn = Conexion.getConnection();
            String sql = "select * from estudiantes where id = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                obj = new Estudiante();
                obj.setId(rs.getInt("id"));
                obj.setNombre(rs.getString("Nombre"));
                obj.setApellido(rs.getString("Apellido"));
                obj.setPais_codigo(rs.getString("Pais_codigo"));
                obj.setCorreo(rs.getString("Correo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public boolean insertar(Estudiante e) {
        try {
            cn = Conexion.getConnection();
            String sql = "INSERT INTO estudiantes (Nombre, Apellido, Pais_codigo,Correo) VALUES(?,?,?,?)";
            ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setString(3, e.getPais_codigo());
            ps.setString(4, e.getCorreo());
            int r = ps.executeUpdate();
            return r > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean actualizar(Estudiante e) {
        try {
            cn = Conexion.getConnection();
            String sql = "UPDATE estudiantes set Nombre=?, Apellido=?, Pais_codigo=?, Correo=? WHERE id=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setString(3, e.getPais_codigo());
            ps.setString(4, e.getCorreo());
            ps.setInt(5, e.getId());
            int r = ps.executeUpdate();
            return r > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id) {

        try {
            cn = Conexion.getConnection();
            String sql = "DELETE FROM estudiantes WHERE id=?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            int r = ps.executeUpdate();
            return r > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean correoExiste(String correo) {
        boolean existe = false;

        try {
            cn = Conexion.getConnection();
            String sql = "SELECT 1 FROM estudiantes WHERE Correo = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, correo);
            rs = ps.executeQuery();
            existe = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return existe;

    }

    private String normalizar(String s) {
        String normalizado = Normalizer.normalize(s, Normalizer.Form.NFC);
        normalizado = normalizado.replaceAll("\\p{M}", "");
        normalizado = normalizado.replaceAll("[^a-z0-9]", "");
        return normalizado;
    }

    public String generarCorreo(String nombre, String apellido, String paisCodigo) throws Exception {

        String primero = nombre.toLowerCase();
        String segundo = apellido.toLowerCase();

        primero = normalizar(primero);
        segundo = normalizar(segundo);

        String dominio = "fasttrack.com";
        String pais = paisCodigo.toLowerCase();

        String base = segundo + "." + primero;
        String correo = base + "@" + dominio + "." + pais;

        int maxLen = 100;
        int contador = 0;

        while (true) {
            if (correo.length() > maxLen) {
                int reservado = ("@" + dominio + "." + pais).length();
                if (contador > 0) {
                    reservado += ("." + contador).length();
                }
                int maxBase = maxLen - reservado;
                if (maxBase <= 0) {
                    throw new Exception("Correo demasiado largo");
                }
                if (base.length() > maxBase) {
                    base = base.substring(0, maxBase);
                }
                correo = base + (contador > 0 ? ("." + contador) : "") + "@" + dominio + "." + pais;
            }

            if (!correoExiste(correo)) {
                return correo;
            }
            contador++;
            correo = base + "." + contador + "@" + dominio + "." + pais;
            return correo;

        }
    }

    public List<Estudiante> buscar(String texto) {
        List<Estudiante> lista = new ArrayList<>();

        try {
            cn = Conexion.getConnection();
            String sql = "SELECT * FROM estudiantes "
                + "WHERE nombre LIKE ? OR apellido LIKE ? OR id = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, "%" + texto + "%");
            ps.setString(2, "%" + texto + "%");

            try {
                ps.setInt(3, Integer.parseInt(texto));
            } catch (NumberFormatException e) {
                ps.setInt(3, -1);
            }

            rs = ps.executeQuery();
            while (rs.next()) {

                Estudiante e = new Estudiante();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                e.setPais_codigo(rs.getString("pais_codigo"));
                e.setCorreo(rs.getString("correo"));

                lista.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("RESULTADOS ENCONTRADOS: " + lista.size());
        return lista;
    }
    
    public List<Estudiante> obternerListaPorId(List<Integer> ids){
        
        List<Estudiante> lista = new ArrayList<>();
        
        if(ids.isEmpty()){
            return lista;
        }
        
        try {
            cn = Conexion.getConnection();
            String sql = "SELECT * FROM estudiantes WHERE id IN (" + ids.stream().map(x -> "?").collect(Collectors.joining(",")) + ")";
            ps = cn.prepareStatement(sql);
            
            for (int i=0; i < ids.size(); i++){
                ps.setInt(i+1, ids.get(i));
            }
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Estudiante e = new Estudiante();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                e.setPais_codigo(rs.getString("pais_codigo"));
                e.setCorreo(rs.getString("correo"));
                lista.add(e);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return lista;
    }

}
