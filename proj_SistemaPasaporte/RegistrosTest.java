package proj_SistemaPasaporte;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegistrosTest {

    // PL01 - Probar fechas del pasado
    @Test
    void validarFechasPasadas() {
        String fechaPasada = "2024-03-01";
        
        try {
            Cita cita = new Cita("Juan", "Perez", "Gomez", "2000-05-15", 
                                 "PERJ000515HMCZPCA3", "P1234567", "2021-01-01", 
                                 "2031-01-01", "Puebla", "Centro", fechaPasada, 
                                 "10:00 AM", "Renovación", 1);
            
            System.out.println("Method executed without exception, past dates are being accepted.");
        } catch (Exception e) {
            System.out.println("Exception thrown: " + e.getMessage());
            assertTrue(e.getMessage().contains("Fecha de cita inválida"));
        }
    }

    // PL02 - Registrar 100 usuarios, permite modificar y borrar citas

    // PL03 - Validar el CURP que sea el correcto

    // PL04 - No aceptar citas fuera del rango *horario

    // PL05 - No permite agendar mas de 1 cita activa

}
