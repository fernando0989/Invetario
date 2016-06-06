package proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Procesos {

    ConexionBD conexion = new ConexionBD();
    Connection cnn = null;

    public Procesos() {
         cnn = conexion.getConnection();
    }

    public void Agregar(Empleados e1) {
        ConexionBD a1 = new ConexionBD();
        try {
            Statement consulta = a1.getConnection().createStatement();
            String sql = "INSERT INTO empleados VALUES( '" + e1.getUsuarioE() + "','" + e1.getNombreE() + "', '" + e1.getApellidosE() + "', '" + e1.getSexoE() + "', '" + e1.getContraE() + "')";
            consulta.executeUpdate(sql);
            System.out.println("Empleado Registrado");
            consulta.cancel();
            a1.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error en el programa" + ex.getMessage());
        }
    }
    
    public int eliminar(Empleados empleado) throws Exception {
        String query = "DELETE FROM empleados WHERE codigo = ?";
        int row = 0;
        PreparedStatement ps = null;
        ps = cnn.prepareStatement(query);
        ps.setString(1, empleado.getUsuarioE());
        row = ps.executeUpdate();
        ps.close();
        return row;
    }
    

    public ArrayList<Empleados> obtenerEmpelado() {
        ArrayList<Empleados> e2 = new ArrayList<>();
        ConexionBD conn = new ConexionBD();
        String sql = "SELECT * FROM empleados";

        PreparedStatement st;
        try {
            st = conn.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Empleados E1 = new Empleados(rs.getString("usuario"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("sexo"), rs.getString("contraseña"));
                e2.add(E1);
            }
            rs.close();
            st.close();
            conn.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());

        }
        return e2;
    }
        public int editar(Empleados empleado) throws Exception {
        String query = "UPDATE empleados SET "
                + "Usuario = ?, "
                + "nombre = ?, "
                + "apellido = ? "
                + "sexo = ?"
                + "contraseña"
                + "WHERE Usuario = ?";

        int row = 0;

        PreparedStatement ps = null;

        try {
            ps = cnn.prepareStatement(query);
            ps.setString(1, empleado.getUsuarioE());
            ps.setString(2, empleado.getNombreE());
            ps.setString(3, empleado.getApellidosE());
            ps.setString(4, empleado.getSexoE());
            ps.setString(5, empleado.getContraE());
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
