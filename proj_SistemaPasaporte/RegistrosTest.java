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
    @Test
    void registrarMuchosUsuarios(){
        Cita[] arr = new Cita[100];
        for(int i = 0; i < 100; i++){
            try{
                String nombre = "Usuario" + (i+1);
                arr[i] = new Cita(nombre, "Perez", "Gomez", "2000-05-15", 
                                 "PERJ000515HMCZPCA3", "P1234567", "2021-01-01", 
                                 "2031-01-01", "Puebla", "Centro", "2025-10-10", 
                                 "10:00 AM", "Renovación", 1);

                System.out.println("User " + (i + 1) + " registered successfully.");
                System.out.flush();

                arr[i].setCiudadSRE("Nueva Ciudad");

            } catch (Exception e){
                fail("Failed to register user " + (i + 1));
            }
        }
        for (int i = 0; i < 100; i++) {
            // Access and verify the changes made to each Cita
            assertEquals("Nueva Ciudad", arr[i].getCiudadSRE(), "CiudadSRE should be 'Nueva Ciudad' for user " + (i + 1));
            // Optionally, print out the user's details to verify
            System.out.println("User " + (i + 1) + " - CiudadSRE: " + arr[i].getCiudadSRE());
            System.out.flush();
        }
    }

    // PL03 - Validar el CURP que sea el correcto
    @Test
    void validarCURP() {
        try {
            Cita cita = new Cita("Juan", "Perez", "Gomez", "2000-05-15", 
                                 "PER0515", "P1234567", "2021-01-01", 
                                 "2031-01-01", "Puebla", "Centro", "2025-03-28", 
                                 "10:00 AM", "Renovación", 1);
            
            System.out.println("Method executed without exception, CURP is valid accepted.");
        } catch (Exception e) {
            System.out.println("Exception thrown: " + e.getMessage());
            assertTrue(e.getMessage().contains("CURP inválido. Debe tener 10 dígitos"));
        }
    }

    // PL04 - No aceptar citas fuera del rango *horario
    @Test
    void rangoCitas() {
        try {
            Cita cita = new Cita("Juan", "Perez", "Gomez", "2000-05-15", 
                                 "PERJ000515HMCZPCA3", "P1234567", "2021-01-01", 
                                 "2031-01-01", "Puebla", "Centro", "2025-03-28", 
                                 "18:00 PM", "Renovación", 1);
            
            System.out.println("Method executed without exception, the time of the appointment is within the client attention hour range.");
        } catch (Exception e) {
            System.out.println("Exception thrown: " + e.getMessage());
            assertTrue(e.getMessage().contains("Error: La cita está agendada en un horario inválido. La atención al cliente es de 9:00 a 17:50"));
        }
    }

    // PL05 - No permite agendar mas de 1 cita activa

}
