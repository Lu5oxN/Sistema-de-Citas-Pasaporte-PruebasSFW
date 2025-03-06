package proj_SistemaPasaporte;

public class Cita {
    // datos persona
    private String nombres, apellido_Paterno, apellido_Materno;
    private String curp;
    private String fecha_Nacimiento;
    // pasaporte
    private String numero_Pasaporte;
    private String fecha_Expedicion, fecha_Vencimiento;
    // Lugar de Oficina de Secretaría de Exteriores
    private String ciudadSRE, estadoSRE;
    
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
    
    // Registrar información oficina
    public void setCiudadSRE(String ciudadSRE) {
        this.ciudadSRE = ciudadSRE;
    }
    public void setEstadoSRE(String estadoSRE) {
        this.estadoSRE = estadoSRE;
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
    // Registrar información pasaporte
    public String getNumero_Pasaporte() {
        return numero_Pasaporte;
    }
    public String getFecha_Expedicion() {
        return fecha_Expedicion;
    }
    public String getFecha_Vencimiento() {
        return fecha_Vencimiento;
    }
    // Registrar información oficina
    public String getCiudadSRE() {
        return ciudadSRE;
    }
    public String getEstadoSRE() {
        return estadoSRE;
    }
    /************.CLASS METHODS.**************/
    // 


    
}