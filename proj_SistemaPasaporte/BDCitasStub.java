package proj_SistemaPasaporte;

import java.util.Map;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;

public class BDCitasStub implements FuenteDatosCitas {
    private Map<String, Cita> citas = new HashMap<>();

    @Override
    public void crearCita(Cita cita) {
        citas.put(cita.getCurp(), cita);
    }

    @Override
    public Cita buscarCita(String curp) {
        if(citas.containsKey(curp)){
            Cita cita = citas.get(curp);
            return cita;
        }
        return null;
    }

    @Override
    public boolean eliminarCita(String curp) {
        if (citas.containsKey(curp)) {
            citas.remove(curp);
            return true;
        }
        return false;
    }

    @Override
    public void modificarCita(String curp, int opc) {
        if (citas.containsKey(curp)) {
            Cita cita = citas.get(curp);
            switch (opc) {
                case 1:     // cambiar locación.
                    cita.setEstadoSRE("Jalisco");
                    cita.setCiudadSRE("Guadalajara");
                    break;
                case 2:     // cambiar fecha y hora.
                    cita.setFechaCita("2025-09-17");
                    cita.setHoraCita("15:45");
                    break;
                case 3:     // cambiar motivo.
                    cita.setMotivoCita("Pasaporte extraviado");
                    break;
                case 4:     // cambiar estado.
                    cita.setEstadoCitaActivo(true);
                    break;
                default:
                    break;
            }
        }
    }
    
    @Override
    public boolean estadoCita(String curp) {
        if(citas.containsKey(curp)){
            validarFechaCita(curp);
            Cita cita = citas.get(curp);
            String estado = cita.getEstadoCita();
            if(estado == "Activa"){
                return true;
            }
            return false;
        }
        return false;
    }
    
    @Override
    public void validarFechaCita(String curp) {
        if(citas.containsKey(curp)){
            Cita cita = citas.get(curp);
            String fechaCita = cita.getFechaCita();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
            LocalDate inputdaDate = LocalDate.parse(fechaCita);
            LocalDate currDate = LocalDate.now();
            if (!currDate.isBefore(inputdaDate)) {
                cita.setEstadoCitaActivo(false);
            }
            cita.setEstadoCitaActivo(true);
        }
    }
}
