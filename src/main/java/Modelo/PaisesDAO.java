package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaisesDAO {

    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<Paises> listar() {
        List<Paises> lista = new ArrayList<>();

        try {
            cn = Conexion.getConnection();
            String sql = "SELECT codigo, nombre FROM paises ORDER BY nombre";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Paises p = new Paises();
                p.setCodigo(rs.getString("codigo"));
                p.setNombre(rs.getString("nombre"));
                lista.add(p);

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

}
