package proj_SistemaPasaporte;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class RegistrosTest {
    private Cita[] citaTest;
    public Date hoy = new Date();

    void setup(){
        citaTest[0] = new Cita("Lucio", "Ruiz", "Sepulveda", "2004-09-17", "RUSL040917HMCZPCA4", "H3224733", "2015-09-07", "2016-09-07", "Puebla", "Cholula", "2025-03-18", "10:40 AM", "Renovación", 0);
        citaTest[1] = new Cita("Elena", "Vargas", "Jiménez", "1999-12-08", "VAJE991208FMCZPCA6", "V7890123", "2021-09-28", "2026-09-28", "Querétaro", "Santiago de Querétaro", "2025-04-18", "13:00 PM", "Primera vez", 1);
        citaTest[2] = new Cita("Ana", "García", "López", "1995-03-22", "GALN950322MMCZPCA7", "G1234567", "2020-01-15", "2025-01-15", "Ciudad de México", "Coyoacán", "2025-04-02", "09:00 AM", "Primera vez", 2); 
        citaTest[3] = new Cita("Carlos", "Pérez", "Martínez", "1988-11-10", "PEMC881110HMCZPCA1", "P9876543", "2018-07-20", "2023-07-20", "Jalisco", "Guadalajara", "2025-03-25", "14:30 PM", "Renovación", 3);
        citaTest[4] = new Cita("Sofía", "Hernández", "González", "2001-07-05", "HEGS010705FMCZPCA9", "H5678901", "2022-05-10", "2027-05-10", "Nuevo León", "Monterrey", "2025-04-10", "11:15 AM", "Primera vez", 4);  
    }

    void after(){
        Registros.limpiarHistorialCitas(citaTest);
    }
    
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setStreams() {
        System.setOut(new PrintStream(output));
    }

    @After
    public void restoreInitialStreams() {
        System.setOut(originalOut);
    }
    
    // PL01 - Hacer cita de una fecha que ya pas'o
    @Test
    public void correctDate(){
        InputStream originalIn = System.in;

        String input = String.join("\n",
            "1", "Lucio", "Ruiz", "Sepulveda", "2004-09-17", "RUSL040917HMCZPCA4", 
            "", "H3224733", "2015-09-07", "2016-09-07", 
            "Puebla", "Cuetzalan", "2025-03-08"  // Fecha de la cita
        );
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

            
        assertEquals("Hora de tu cita: ", output.toString());

    }
}
