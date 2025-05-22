package proj_SistemaPasaporte;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        /*
            create table Citas (
            idCita INT auto_increment primary key,
            nombre varchar(20) not null,
            apellido_paterno varchar(20) not null,
            apellido_materno varchar(20) not null,
            fecha_nacimiento date not null,
            curp varchar(18) not null,
            
            num_pasaporte varchar(10) not null,
            fecha_expedicion date not null,
            fecha_vencimiento date not null,
            
            ciudad varchar(30) not null,
            motivo varchar(30) not null,
            
            fecha_cita datetime,
            estatus varchar(10) default 'Activo'
            );
         */
        String sql = "INSERT INTO citas  VALUES (null, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, null)";
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, cita.getNombres());
                pstmt.setString(2, cita.getApellido_Paterno());
                pstmt.setString(3, cita.getApellido_Materno());
                pstmt.setString(4, cita.getFecha_Nacimiento());
                pstmt.setString(5, cita.getCurp());

                pstmt.setString(6, cita.getNumero_Pasaporte());
                pstmt.setString(7, cita.getFecha_Expedicion());
                pstmt.setString(8, cita.getFecha_Vencimiento());

                pstmt.setString(9, cita.getCiudadSRE());
                pstmt.setString(10, cita.getMotivoCita());
                pstmt.setString(10, cita.getMotivoCita());

                String date = cita.getFechaCita() + " " + cita.getHoraCita();
                pstmt.setString(11, date);

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
                pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al borrar la cita en la BD: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void modificarCita(String curp, int opc, String cambio) {
        String colString;
        Cita cita = null;
        switch (opc) {
            case 1:
            colString = "Curp";
            break;
            case 2:
            colString = "num_pasaporte";
            break;
            case 3:
            colString = "ciudad";
            break;
            case 4:
            colString = "estatus";
            break;
            default:
            colString = "ciudad";
            break;
        }
        
        String sql = "UPDATE citas SET " + colString + " = ? WHERE Curp = ?";
        try (Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cambio);
            pstmt.setString(2, curp);
            pstmt.executeUpdate(); // executeQuery es para Select (regresan datos)
        } catch (SQLException e) {
             System.err.println("Error al buscar la cita en la BD: " + e.getMessage());
        }
    }

    @Override
    public boolean validarFechaCita(String fechaCita) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime inputDateTime = LocalDateTime.parse(fechaCita, formatter);
        LocalDate inputDate = inputDateTime.toLocalDate();
        LocalDate currDate = LocalDate.now();
        return inputDate.isAfter(currDate);
    }

    @Override
    public void estadoCita(String curp) {
        Cita cita = buscarCita(curp);
        if (cita.getEstadoCita() != "Inactiva") {
            boolean active = validarFechaCita(cita.getFechaCita());
            if(!active) modificarCita(curp, 4, "Inactiva"); 
        }
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
