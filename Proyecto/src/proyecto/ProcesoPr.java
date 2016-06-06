package proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProcesoPr {

    ConexionBD conexion = new ConexionBD();
    Connection cnn = null;

    public ProcesoPr() {
        cnn = conexion.getConnection();

    }

    public void Agregar(Producto p1) {

        try {
            Statement consulta = conexion.getConnection().createStatement();
            String sql = "INSERT INTO tablaprodutos VALUES( '" + p1.getCodigo() + "','" + p1.getNombre() + "', '" + p1.getPrecio() + "','" + p1.getExistencia() + "')";
            consulta.executeUpdate(sql);
            System.out.println("Producto Registrado");
            consulta.cancel();
            conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error en el programa" + ex.getMessage());
        }
    }

    public int eliminar(Producto pr) throws Exception {
        String query = "DELETE FROM tablaprodutos WHERE codigo = ?";
        int row = 0;
        PreparedStatement ps = null;
        ps = cnn.prepareStatement(query);
        ps.setString(1, pr.getCodigo());
        row = ps.executeUpdate();
        ps.close();
        return row;
    }

    public ArrayList<Producto> obtenerProducto() {
        ArrayList<Producto> p2 = new ArrayList<>();
        //ConexionBD conn = new ConexionBD();
        String sql = "SELECT * FROM tablaprodutos";

        PreparedStatement st;
        try {
            st = conexion.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Producto Pr1 = new Producto(rs.getString("Nombre"), rs.getString("Codigo"), rs.getInt("precio"), rs.getInt("existencia"));
                p2.add(Pr1);
            }
            rs.close();
            st.close();
            conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());

        }
        return p2;
    }

    public int editar(Producto p1) throws Exception {
        String query = "UPDATE tablaprodutos SET "
                + "codigo = ?, "
                + "nombre = ?,"
                + "precio=?"
                + "existencia = ?"
                + "WHERE usuario = ?";

        int row = 0;

        PreparedStatement ps = null;

        try {
            ps = cnn.prepareStatement(query);
            ps.setString(1, p1.getCodigo());
            ps.setString(2, p1.getNombre());
            ps.setFloat(3,p1.getPrecio());
            ps.setInt(4,p1.getExistencia());
            row = ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return row;
    }
}
