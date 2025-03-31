package proj_SistemaPasaporte;

public interface FuenteDatosCitas {
    void crearCita(Cita cita);

    Cita buscarCita(String curp);

    boolean eliminarCita(String curp);

    void modificarCita(String curp, int opc);

    void validarFechaCita(String curp);

    boolean estadoCita(String curp);
    
}