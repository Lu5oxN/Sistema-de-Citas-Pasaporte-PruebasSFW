package proj_SistemaPasaporte.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        // Instanciar la implementación JDBC en lugar del Stub
        this.fuenteDeDatos = new BDCitas();
        System.out.println("FuenteDeDatos inicializada: " + this.fuenteDeDatos);
    }

    @Test
    public void buscarCita(){
        assertNotNull(this.fuenteDeDatos, "fuenteDeDatos no debería ser null aquí");
        Cita citaEncontrada = this.fuenteDeDatos.buscarCita("PERJ000515HMCZPCA3");
        System.err.println(citaEncontrada.getCurp());
        assertNotNull(citaEncontrada, "La cita debería encontrarse en la BD");
    }
}
