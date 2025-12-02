package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MateriaDAO {

    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<Materia> ListarTodos() {
        ArrayList<Materia> lista = new ArrayList<>();

        try {
            cn = Conexion.getConnection();
            String sql = "select * from materia";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Materia m = new Materia();
                m.setId(rs.getInt("id"));
                m.setNombre(rs.getString("nombre"));
                m.setCodigo(rs.getString("codigo"));
                m.setDescripcion(rs.getString("descripcion"));
                lista.add(m);
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

    public Materia obtenerId(int id) {

        Materia m = null;
        try {
            cn = Conexion.getConnection();
            String sql = "SELECT * FROM materia WHERE id=?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                m = new Materia();
                m.setId(rs.getInt("id"));
                m.setCodigo(rs.getString("codigo"));
                m.setNombre(rs.getString("nombre"));
                m.setDescripcion(rs.getString("descripcion"));
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
        return m;
    }

    public boolean agregar(Materia m) {
//        boolean inicio = false;

        try {
            cn = Conexion.getConnection();
            String sql = "INSERT INTO materia (codigo, nombre, descripcion) VALUES (?,?,?)";
            ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, m.getCodigo());
            ps.setString(2, m.getNombre());
            ps.setString(3, m.getDescripcion());
            int r = ps.executeUpdate();
            return r > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public boolean actualizar(Materia m) {
        boolean ok = false;
        try {
            cn = Conexion.getConnection();
            String sql = "UPDATE materia SET codigo=?, nombre=?, descripcion=? WHERE id=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, m.getCodigo());
            ps.setString(2, m.getNombre());
            ps.setString(3, m.getDescripcion());
            ps.setInt(4, m.getId());
            ok = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }

    public boolean eliminar(int id) {
        boolean ok = false;
        try {
            cn = Conexion.getConnection();
            String sql = "DELETE FROM materia WHERE id=?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ok = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok;
    }

    public List<Materia> buscar(String texto) {
        List<Materia> lista = new ArrayList<>();

        try {
            cn = Conexion.getConnection();
            String sql = "SELECT * FROM materia WHERE codigo LIKE ? OR nombre LIKE ? OR id LIKE ? ";
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

                Materia m = new Materia();
                m.setId(rs.getInt("id"));
                m.setCodigo(rs.getString("codigo"));
                m.setNombre(rs.getString("nombre"));
                m.setDescripcion(rs.getString("descripcion"));
                lista.add(m);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
