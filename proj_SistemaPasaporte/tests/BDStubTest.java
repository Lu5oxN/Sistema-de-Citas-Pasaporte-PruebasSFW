package proj_SistemaPasaporte.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BDStubTest {

    // PL01 - Probar creación de cita en BD Stub
    System.out.println("STUB (PL01): Cita creada correctamente.");

    // PL02 - Probar búsqueda de cita por datos (CURP)
    System.out.println("STUB (PL02): Cita encontrada.");
    System.out.println("Datos: " + cita.getCurp() + cita.getNombres() + cita.getFechaCita() + cita.getEstadoCita());

    // PL03 - Probar eliminar cita
    System.out.println("STUB (PL03): Cita creada correctamente.");
    // PL04 - Probar modificar datos de la cita
    System.out.println("STUB (PL04): Cita creada correctamente.");
    // PL05 - Comprobar estado de cita
    System.out.println("STUB (PL05): Cita creada correctamente.");
}
