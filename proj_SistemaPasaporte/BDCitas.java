package proj_SistemaPasaporte;
import java.sql.*;

public class BDCitas implements FuenteDatosCitas {

    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/proy_pasaporte";
    private String usuario = "root";
    private String contrasena = "Doge4ever!";

    private Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, usuario, contrasena);
            } catch (ClassNotFoundException e) {
                System.err.println("Error al cargar el driver JDBC: " + e.getMessage());
                throw new SQLException("Driver no encontrado", e);
            } catch (SQLException e) {
                System.err.println("Error al conectar a la base de datos: " + e.getMessage());
                throw e;
            }
        }
        return connection;
    }

    @Override
    public void crearCita(Cita cita) {
        String sql = "INSERT INTO citas  VALUES (null, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, null)";
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, cita.getNombres());

                pstmt.executeUpdate(); // executeUpdate para INSERT, UPDATE and DELETE
        } catch (SQLException e) {
            System.err.println("Error al crear una cita en BD: " + e.getMessage());
        }
    }

    @Override
    public Cita buscarCita(String curp) {
        String sql = "SELECT * FROM citas WHERE Curp = ?";
        Cita cita = null;
        try (Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, curp);
            ResultSet rs = pstmt.executeQuery(); // executeQuery es para Select (regresan datos)

            if (rs.next()) {
                 // Crear objeto Cita a partir de los datos del ResultSet
                 cita = new Cita(
                    rs.getString("Nombre"),
                    rs.getString("apellido_paterno"),
                    rs.getString("apellido_materno"),
                    rs.getString("fecha_nacimiento"),
                    rs.getString("Curp"),
                    rs.getString("num_pasaporte"),
                    rs.getString("fecha_expedicion"),
                    rs.getString("fecha_vencimiento"),
                    rs.getString("estatus"),
                    rs.getString("ciudad"),
                    rs.getString("fecha_cita"),
                    rs.getString("fecha_cita"),
                    rs.getString("motivo"),
                    rs.getInt("idCita")
                 );
            }
            rs.close();
        } catch (SQLException e) {
             System.err.println("Error al buscar la cita en la BD: " + e.getMessage());
        }
        return cita;
    }

    @Override
    public boolean eliminarCita(String curp) {
        String sql = "DELETE FROM citas WHERE Curp = ?";
        Cita cita = null;
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, curp);
                ResultSet rs = pstmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error al borrar la cita en la BD: " + e.getMessage());
        }
        return true;
    }

    @Override
    public void modificarCita(String curp, int opc) {
        String sql = "DELETE FROM citas WHERE Curp = ?";
        Cita cita = null;
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, curp);
                ResultSet rs = pstmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error al borrar la cita en la BD: " + e.getMessage());
        }
        return true;
        
    }

    @Override
    public void validarFechaCita(String curp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validarFechaCita'");
    }

    @Override
    public boolean estadoCita(String curp) {
        // TODO Auto-generated method stub
        return true;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión a la BD cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión a la BD: " + e.getMessage());
        }
    }
    
}
