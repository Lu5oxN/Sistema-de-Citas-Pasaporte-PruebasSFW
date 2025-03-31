package proj_SistemaPasaporte;

public class Cita {
    // datos persona
    private String nombres, apellido_Paterno, apellido_Materno;
    private String curp;
    private String fecha_Nacimiento;
    // pasaporte
    private String numero_Pasaporte;
    private String fecha_Expedicion, fecha_Vencimiento;
    // Lugar de Oficina de Secretaría de Exteriores, fecha Cita
    private String ciudadSRE, estadoSRE;
    private String fechaCita, horaCita;
    private String motivoCita;

    private String estadoCita; //activa, cancelada.
    private int idCita;
    
    
    // CONSTRUCTOR
    public Cita(){
        this.estadoCita = "activa";
    }
    // inicializar una cita con datos más básicos
    public Cita(String nombres, String apellido_Paterno, String apellido_Materno, String fecha_Nacimiento, String curp, int idCita){
        this.nombres = nombres;
        this.apellido_Paterno = apellido_Paterno;
        this.apellido_Materno = apellido_Materno;
        this.fecha_Nacimiento = fecha_Nacimiento;
        this.curp = curp;
        this.estadoCita = "Activa";
    }
    // inicializar una cita con todos sus datos (solo para en las pruebas tener ya casos registrados, en las otras se van registrando poco a poco)
    public Cita(String nombres, String apellido_Paterno, String apellido_Materno, String fecha_Nacimiento, String curp, String numero_Pasaporte, String fecha_Expedicion, String fecha_Vencimiento, String estadoSRE, String ciudadSRE, String fechaCita, String horaCita, String motivoCita, int idCita){
        this.nombres = nombres;
        this.apellido_Paterno = apellido_Paterno;
        this.apellido_Materno = apellido_Materno;
        this.fecha_Nacimiento = fecha_Nacimiento;
        this.curp = curp;
        
        this.numero_Pasaporte = numero_Pasaporte;
        this.fecha_Expedicion = fecha_Expedicion;
        this.fecha_Vencimiento = fecha_Vencimiento;
        
        this.estadoSRE = estadoSRE;
        this.ciudadSRE = ciudadSRE;
        
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.motivoCita = motivoCita;
        this.estadoCita = "Activa";
        this.idCita = idCita;
    }


    /************.SETTERS.**************/
    // Registrar información personal
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public void setApellido_Paterno(String apellido_Paterno) {
        this.apellido_Paterno = apellido_Paterno;
    }
    public void setApellido_Materno(String apellido_Materno) {
        this.apellido_Materno = apellido_Materno;
    }
    public void setFecha_Nacimiento(String fecha_Nacimiento) {
        this.fecha_Nacimiento = fecha_Nacimiento;
    }
    public void setCurp(String curp) {
        this.curp = curp;
    }    

    // Registrar información pasaporte
    public void setNumero_Pasaporte(String numero_Pasaporte) {
        this.numero_Pasaporte = numero_Pasaporte;
    }
    public void setFecha_Expedicion(String fecha_Expedicion) {
        this.fecha_Expedicion = fecha_Expedicion;
    }
    public void setFecha_Vencimiento(String fecha_Vencimiento) {
        this.fecha_Vencimiento = fecha_Vencimiento;
    }
    
    // Registrar información de la cita (ciudad, estado, fecha, hora y motivo)
    public void setCiudadSRE(String ciudadSRE) {
        this.ciudadSRE = ciudadSRE;
    }
    public void setEstadoSRE(String estadoSRE) {
        this.estadoSRE = estadoSRE;
    }
    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }
    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }
    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    // Estado de la cita
    public void setEstadoCitaActivo(boolean opc) {
        if (opc) {
            this.estadoCita = "Activa";
        } else {
            this.estadoCita = "Inactiva";
        }
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    /************.GET.**************/
    // Registrar información personal
    public String getNombres() {
        return nombres;
    }
    public String getApellido_Paterno() {
        return apellido_Paterno;
    }
    public String getApellido_Materno() {
        return apellido_Materno;
    }
    public String getFecha_Nacimiento() {
        return fecha_Nacimiento;
    }
    public String getCurp() {
        return curp;
    }
    // Obtener información del pasaporte (número, expedición y vencimiento)
    public String getNumero_Pasaporte() {
        return numero_Pasaporte;
    }
    public String getFecha_Expedicion() {
        return fecha_Expedicion;
    }
    public String getFecha_Vencimiento() {
        return fecha_Vencimiento;
    }
    // Recuperar información de la cita (ciudad, estado, fecha, hora y motivo)
    public String getEstadoSRE() {
        return estadoSRE;
    }
    public String getCiudadSRE() {
        return ciudadSRE;
    }
    public String getFechaCita() {
        return fechaCita;
    }
    public String getHoraCita() {
        return horaCita;
    }
    public String getMotivoCita() {
        return motivoCita;
    }
    public String getEstadoCita() {
        return estadoCita;
    }
    public int getIdCita() {
        return idCita;
    }
    
    /************.CLASS METHODS.**************/
    // 
    
    
}