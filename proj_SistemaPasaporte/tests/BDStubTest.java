 package proj_SistemaPasaporte.tests;

import org.junit.jupiter.api.Test;

import proj_SistemaPasaporte.BDCitasStub;
import proj_SistemaPasaporte.Cita;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;

public class BDStubTest {

    private BDCitasStub stubBD;

    @BeforeEach
    void setup(){
        stubBD = new BDCitasStub();
    }

    // ST01 - Probar creación de cita en BD Stub
    @Test
    void creacionCita(){
        try {
            Cita cita = new Cita("Juan", "Perez", "Gomez", "2000-05-15", 
            "PERJ000515HMCZPCA3", "P1234567", "2021-01-01", 
            "2031-01-01", "Puebla", "Centro", "2025-10-10", 
            "10:00 AM", "Renovación", 1);
    
            stubBD.crearCita(cita);
            System.out.println("STUB (ST01): Cita creada correctamente.");
            
        } catch (Exception e) {
            fail("No se logró registrar la cita.");
        }
    }

    // ST02 - Probar búsqueda de cita por datos (CURP)
    @Test
    void buscarCita(){
        try {
            Cita insert = new Cita("Lucio", "Ruiz", "Sepulveda", "2004-09-17", "RUSL040917HMCZPCA4", "H3224733", "2015-09-07", "2016-09-07", "Puebla", "Cholula", "2025-03-18", "10:40 AM", "Renovación", 0);
            Cita insert2 = new Cita("Elena", "Vargas", "Jiménez", "1999-12-08", "VAJE991208FMCZPCA6", "V7890123", "2021-09-28", "2026-09-28", "Querétaro", "Santiago de Querétaro", "2025-04-18", "13:00 PM", "Primera vez", 2);
            Cita insert3 = new Cita("Ana", "García", "López", "1995-03-22", "GALN950322MMCZPCA7", "G1234567", "2020-01-15", "2025-01-15", "Ciudad de México", "Coyoacán", "2025-04-02", "09:00 AM", "Primera vez", 3);
    
            stubBD.crearCita(insert);
            stubBD.crearCita(insert2);
            stubBD.crearCita(insert3);

            Cita cita = stubBD.buscarCita("RUSL040917HMCZPCA4");
            assertNotNull(cita, "La cita encontrada no debe ser null");

            System.out.println("STUB (ST02): Cita encontrada.");
            System.out.println("Datos: " + cita.getCurp() + cita.getNombres() + cita.getFechaCita() + cita.getEstadoCita());
            
        } catch (Exception e) {
            fail("No se logró encontrar la cita.");
        }
    }

    // // ST03 - Probar eliminar cita
    @Test
    void eliminarCita(){
        try {
            Cita insert = new Cita("Lucio", "Ruiz", "Sepulveda", "2004-09-17", "RUSL040917HMCZPCA4", "H3224733", "2015-09-07", "2016-09-07", "Puebla", "Cholula", "2025-03-18", "10:40 AM", "Renovación", 0);
            Cita insert2 = new Cita("Elena", "Vargas", "Jiménez", "1999-12-08", "VAJE991208FMCZPCA6", "V7890123", "2021-09-28", "2026-09-28", "Querétaro", "Santiago de Querétaro", "2025-04-18", "13:00 PM", "Primera vez", 2);
            Cita insert3 = new Cita("Ana", "García", "López", "1995-03-22", "GALN950322MMCZPCA7", "G1234567", "2020-01-15", "2025-01-15", "Ciudad de México", "Coyoacán", "2025-04-02", "09:00 AM", "Primera vez", 3);
           
            stubBD.crearCita(insert);
            stubBD.crearCita(insert2);
            stubBD.crearCita(insert3);
            
            // buscar 
            Cita cita = stubBD.buscarCita("RUSL040917HMCZPCA4");

            System.out.println("Datos: " + cita.getCurp() + cita.getNombres() + cita.getFechaCita() + cita.getEstadoCita());
            
            boolean deletedFlag = false;
            deletedFlag = stubBD.eliminarCita("RUSL040917HMCZPCA4");
            Cita afterDel = stubBD.buscarCita("RUSL040917HMCZPCA4");
            if (deletedFlag) {
                System.out.println("STUB (ST03): Cita eliminada correctamente.");
                assertNull(afterDel);
            } else {
                System.out.println("STUB (ST03): No se logró eliminar la cita.");
                assertNotNull(afterDel);
            }
        } catch (Exception e) {
            fail("No fue posible eliminar la cita");
        }
    }

    // // ST04 - Probar modificar datos de la cita
    @Test
    void modificarCita(){
        Cita cita = new Cita("Juan", "Perez", "Gomez", "2000-05-15", 
            "PERJ000515HMCZPCA3", "P1234567", "2021-01-01", 
            "2031-01-01", "Puebla", "Centro", "2025-10-10", 
            "10:00 AM", "Renovación", 1);

        stubBD.crearCita(cita);

        stubBD.modificarCita("PERJ000515HMCZPCA3", 1);
        stubBD.modificarCita("PERJ000515HMCZPCA3", 2);
        stubBD.modificarCita("PERJ000515HMCZPCA3", 3);
        stubBD.modificarCita("PERJ000515HMCZPCA3", 4);

        System.out.println("Datos: " + cita.getCurp() + cita.getNombres() + cita.getFechaCita() + cita.getEstadoCita());
        assertNotEquals("2025-10-10", cita.getFechaCita());
        assertNotEquals("Puebla", cita.getEstadoCita());
        System.out.println("STUB (ST04): Cita modificada correctamente.");
    }
    // // ST05 - Comprobar estado de cita
    // System.out.println("STUB (ST05): Cita creada correctamente.");
}
