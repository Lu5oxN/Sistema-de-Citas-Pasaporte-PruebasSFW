package proj_SistemaPasaporte.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import proj_SistemaPasaporte.Cita;
import proj_SistemaPasaporte.FuenteDatosCitas;
import proj_SistemaPasaporte.BDCitas;

public class BDInegracionTest {
    private FuenteDatosCitas fuenteDeDatos;
    
    @BeforeEach
    void setUp() {
        // Instanciar la implementación JDBC
        this.fuenteDeDatos = new BDCitas();
        System.out.println("FuenteDeDatos inicializada: " + this.fuenteDeDatos);
    }

    // IT01 - Probar creación de cita en BD Stub
    @Test
    public void crearCita() {
        try {
            Cita insert = new Cita("Lucio", "Ruiz", "Sepulveda", "2004-09-17", "RUSL040917HMCZPCA4", "H3224733", "2015-09-07", 
            "2016-09-07", "Puebla", "Cholula", "2025-03-18", "10:40", "Renovación", 1);
    
            this.fuenteDeDatos.crearCita(insert);
            System.out.println("Prueba (IT01): Cita creada correctamente.");
            
        } catch (Exception e) {
            fail("No se logró registrar la cita.");
        }
    }

    // IT02 - Probar búsqueda de cita por datos (CURP)
    @Test
    public void buscarCita(){
        assertNotNull(this.fuenteDeDatos, "fuenteDeDatos no debería ser null aquí");
        Cita citaEncontrada = this.fuenteDeDatos.buscarCita("PERJ000515HMCZPCA3");
        assertNotNull(citaEncontrada, "La cita no se encontró.");
        System.out.println("Prueba (IT02): Cita encontrada.");
        System.out.println("Datos: " + citaEncontrada.getCurp() +
                        " " +citaEncontrada.getNombres() + " " +
                        citaEncontrada.getFechaCita() + " " + citaEncontrada.getEstadoCita());
    }

    // IT03 - Probar eliminar cita
    @Test
    public void eliminarCita(){
        Cita cita = null;
        try {
            Cita insert2 = new Cita("Elena", "Vargas", "Jiménez", "1999-12-08",
            "VAJE991208FMCZPCA6", "V7890123", "2021-09-28", "2026-09-28", "Querétaro",
            "Santiago de Querétaro", "2025-04-18", "13:00", "Primera vez", 2);
            this.fuenteDeDatos.crearCita(insert2);

            cita = this.fuenteDeDatos.buscarCita(insert2.getCurp());
            System.out.println("Datos: " + cita.getCurp() +
                        " " +cita.getNombres() + " " +
                        cita.getFechaCita() + " " + cita.getEstadoCita());

            boolean deletedFlag = false;
            deletedFlag = this.fuenteDeDatos.eliminarCita(cita.getCurp());

            assertTrue(deletedFlag, "La cita no fue eliminada.");

            assertNull(this.fuenteDeDatos.buscarCita(insert2.getCurp()));
            System.out.println("La cita fue eliminada correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            fail("No fue posible eliminar la cita: " + e.getMessage());
        }
    }

    // IT04 - Probar modificar datos de la cita
    @Test
    public void modificarCita() {
        Cita citaEncontrada = null;
        Cita citaSinMod = null;
        String curp = "PERJ000515HMCZPCA3";
        // busca e imprime la cita
        try {
            citaEncontrada = this.fuenteDeDatos.buscarCita(curp);
            citaSinMod = citaEncontrada;
            System.out.println("Datos: " + citaEncontrada.getCurp() +
                        " " +citaEncontrada.getNombres() + " " +
                        citaEncontrada.getFechaCita() + " " + citaEncontrada.getCiudadSRE());
            System.out.println("");
            // modificar cita
            this.fuenteDeDatos.modificarCita(curp, 3, "Uruapan");
            // mostrar de nuevo
            citaEncontrada = this.fuenteDeDatos.buscarCita(curp);
            System.out.println("Datos: " + citaEncontrada.getCurp() +
                        " " +citaEncontrada.getNombres() + " " +
                        citaEncontrada.getFechaCita() + " " + citaEncontrada.getCiudadSRE());
            System.out.println("");
            // comoprobar que se hizo el cambio
            assertNotEquals(citaEncontrada, citaSinMod);

            assertNotEquals(citaSinMod.getCiudadSRE(), citaEncontrada.getCiudadSRE(),
                    "La ciudad debería haber cambiado de '" + citaSinMod.getCiudadSRE() + "' a 'Cuernavaca'.");
        } catch (Exception e) {
            fail("No es posible modificar la cita");
        }
    }

    // IT05 - Comprobar estado de cita
    @Test
    public void compEstadoCita() {
        Cita cita = new Cita("Jorge", "Mainez", "Gomez", "2000-05-15", 
            "MJRJ000515HMCZPCA8", "P1234567", "2021-01-01", 
            "2031-01-01", "Puebla", "Centro", "2024-10-10", 
            "14:00", "Renovación", 1);
            
        this.fuenteDeDatos.crearCita(cita);

        this.fuenteDeDatos.estadoCita(cita.getCurp());
        Cita changedCita = this.fuenteDeDatos.buscarCita(cita.getCurp());
        assertNotEquals(cita.getEstadoSRE(), changedCita.getEstadoSRE());
        System.out.println("El estado cambió a: " + changedCita.getEstadoCita());
    }
}
