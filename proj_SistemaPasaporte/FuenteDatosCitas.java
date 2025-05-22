package proj_SistemaPasaporte;

public interface FuenteDatosCitas {
    void crearCita(Cita cita);

    Cita buscarCita(String curp);

    boolean eliminarCita(String curp);

    void modificarCita(String curp, int opc, String cambio);

    boolean validarFechaCita(String curp);

    void estadoCita(String curp);
    
}