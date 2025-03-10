package proj_SistemaPasaporte;
import java.io.BufferedInputStream;
import java.io.Console;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.lang.Thread;
import java.util.Scanner;

import javax.swing.*;

public class Registros {
    // funciones: agendar, visualizar, cancelar, modificar cita.
    // registro renovación: valida que sus datos estén en una base de datos.
    // registro nuevo: no hay validaciones extra

    // Para leer:
    private FileInputStream yourFile;       // variable para leer byte por byte. (LOGICAL)
    private BufferedInputStream inputStream;       // variable de buffer leer byte por byte. (LOGICAL)
    
    // // INTERFAZ
    // // Botones:
    // private JButton btnAgendar, btnConsultar, btnModificar, btnCancelar;
    // // Labels:
    // private JLabel 
    // // Paneles:
    // private JPanel pnlMain;


    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    private static Scanner scanner = new Scanner(System.in);

    public static char getch() {
        char ch = '\0'; // Inicializamos con un valor por defecto
        if (scanner.hasNext()) {
            ch = scanner.next().charAt(0);
        }
        return ch;
    }
    

    public static void limpiarHistorialCitas(Cita[] historialCitas) {
        historialCitas = new Cita[100];
    }

    
    public static void main(String[] args) {
        Cita[] arr;
        Cita[] historialCitas;
        arr = new Cita[100];
        historialCitas = new Cita[100];
        int arrIndex = 0;
        // Cita nCita = new Cita();
    
        // **************************   El código abajo es para que corra en consola, no con GUI
        Scanner myInput = new Scanner(System.in);
        boolean running = true;
        int opc;    // 1: crear cita    2: Ver mis citas   
         
        String nameString, apePString, apeMString, fechaString, curpString; // variables para insertar datos personales en caso "crear cita"
        String numPassString, fechaExpString, fechaVencString; // variables para insertar datos de pasaporte en caso "crear cita"
        String ciudadString, estadoString, fechaCitaString, horaCitaString, motivoString; // variables para insertar datos de la cita en caso "crear cita"
        int idCita = 0;     // el id será el número que ocupa en el arreglo

        //inicializar para testing
        // arr[0] = new Cita("Lucio", "Ruiz", "Sepulveda", "2004-09-17", "RUSL040917HMCZPCA4", "H3224733", "2015-09-07", "2016-09-07", "Puebla", "Cholula", "2025-03-18", "10:40 AM", "Renovación", idCita);   idCita+=1;
        // arr[1] = new Cita("Elena", "Vargas", "Jiménez", "1999-12-08", "VAJE991208FMCZPCA6", "V7890123", "2021-09-28", "2026-09-28", "Querétaro", "Santiago de Querétaro", "2025-04-18", "13:00 PM", "Primera vez", idCita); idCita+=1;
        // arr[2] = new Cita("Ana", "García", "López", "1995-03-22", "GALN950322MMCZPCA7", "G1234567", "2020-01-15", "2025-01-15", "Ciudad de México", "Coyoacán", "2025-04-02", "09:00 AM", "Primera vez", idCita);   idCita+=1;
        // arr[3] = new Cita("Carlos", "Pérez", "Martínez", "1988-11-10", "PEMC881110HMCZPCA1", "P9876543", "2018-07-20", "2023-07-20", "Jalisco", "Guadalajara", "2025-03-25", "14:30 PM", "Renovación", idCita); idCita+=1;
        // arr[4] = new Cita("Sofía", "Hernández", "González", "2001-07-05", "HEGS010705FMCZPCA9", "H5678901", "2022-05-10", "2027-05-10", "Nuevo León", "Monterrey", "2025-04-10", "11:15 AM", "Primera vez", idCita);    idCita+=1;
        // arr[5] = new Cita("Lucio", "Ruiz", "Sepulveda", "2004-09-17", "RUSL040917HMCZPCA4", "H3224733", "2015-09-07", "2016-09-07", "Puebla", "Cholula", "2025-05-10", "14:30 PM", "Renovación", idCita);   idCita+=1;
        // arr[0].setEstadoCitaActivo(false); // cambio el primer registro a Inactivo
        
        // arrIndex = 6;
        
        do {
            clearScreen();
            System.out.println("**************************************************\n");
            System.out.println("            Sistema de citas SRE");
            System.out.println("[1] Agendar Cita   [2] Consultar Citas  [3] Salir");
            System.out.print("\n             Escriba su elección: ");
            opc = Integer.parseInt(myInput.nextLine());
            clearScreen();
            
            idCita = arrIndex;

            switch (opc) {
                case 1: // crear cita
                    System.out.println("[CREAR CITA pag. 1/3]");
                    System.out.println("..--DATOS PERSONALES--..");
                    System.out.println(" Instrucción: Rellena con tus datos");
                    System.out.print("Nombre/s: ");
                    nameString = myInput.nextLine();
                    System.out.print("Apellido Paterno: ");
                    apePString = myInput.nextLine();
                    System.out.print("Apellido Materno: ");
                    apeMString = myInput.nextLine();
                    System.out.print("Fecha nacimiento (AA-MM-DD):  ");
                    fechaString = myInput.nextLine();
                    System.out.print("CURP: ");
                    curpString = myInput.nextLine();
                    
                    arr[arrIndex] = new Cita(nameString, apePString, apeMString, fechaString, curpString, idCita);  //GUARDA en el arreglo de objetos
                    System.out.println("    Autenticado");  // se hizo un nuevo registro
                    System.out.print("    Presiona [ENTER] para continuar ");
                    getch();
                    clearScreen();
                    
                    System.out.println("[CREAR CITA pag. 2/3]");
                    System.out.println("..--DATOS PASAPORTE--..");
                    System.out.println(" Instrucción: Rellena con los datos de tu último pasaporte");
                    System.out.println("              expedido en Territorio nacional");
                    
                    System.out.print("Número de pasaporte:  ");
                    numPassString = myInput.nextLine();
                    arr[arrIndex].setNumero_Pasaporte(numPassString);
                    
                    System.out.print("Fecha de Expedición:  ");
                    fechaExpString = myInput.nextLine();
                    arr[arrIndex].setFecha_Expedicion(fechaExpString);

                    System.out.print("Fecha de Vencimiento: ");
                    fechaVencString = myInput.nextLine();
                    arr[arrIndex].setFecha_Vencimiento(fechaVencString);
                    
                    System.out.println("    Datos de pasaporte registrados");  // se hizo un nuevo registro
                    System.out.print("    Presiona [ENTER] para continuar ");
                    getch();
                    clearScreen();
                    
                    System.out.println("[CREAR CITA pag. 3/3]");
                    System.out.println("..--AGENDAR TU CITA--..");
                    System.out.println(" Instrucción: Rellena los siguientes campos");
                    
                    System.out.print("Estado donde deseas tomar tu cita: ");
                    estadoString = myInput.nextLine();
                    arr[arrIndex].setEstadoSRE(estadoString);
                    
                    System.out.print("Ciudad donde deseas tomar tu cita: ");
                    ciudadString = myInput.nextLine();
                    arr[arrIndex].setCiudadSRE(ciudadString);

                    System.out.print("Fecha de tu cita: ");
                    fechaCitaString = myInput.nextLine();
                    arr[arrIndex].setFechaCita(fechaCitaString);

                    System.out.print("Hora de tu cita: ");
                    horaCitaString = myInput.nextLine();
                    arr[arrIndex].setHoraCita(horaCitaString);

                    System.out.print("Motivo de tu cita: ");
                    motivoString = myInput.nextLine();
                    arr[arrIndex].setMotivoCita(motivoString);
                    
                    arr[arrIndex].setIdCita(idCita);
                    
                    System.out.println("    Tu cita ha sido agendada correctamente");  // se hizo un nuevo registro
                    System.out.print("    Presiona [ENTER] para continuar ");
                    getch();
                    clearScreen();


                    arrIndex += 1;
                    idCita += 1;
                    getch();
                    break;
                case 2: // ver citas
                    int historyIndex = 0;
                    System.out.println("Busca por CURP");
                    System.out.print("CURP: ");
                    curpString = myInput.nextLine();
                    
                    int contadorCitas = 0;
                    System.out.println("No. ||   Motivo    ||  Lugar (estado, ciudad) ||    fecha    ||    hora    ||  estado de la cita  ");
                    System.out.println("-------------------------------------------------------------------------------------------------");
                    for (Cita cita : arr) {
                        if (cita != null) {
                            if(curpString.equals(cita.getCurp())){
                                // clearScreen();
                                // historialCitas[historyIndex] = new Cita(cita.getNombres(), cita.getApellido_Paterno(), cita.getApellido_Materno(), cita.getFecha_Nacimiento(), cita.getCurp(), cita.getNumero_Pasaporte(), cita.getFecha_Expedicion(), cita.getFecha_Vencimiento(), cita.getEstadoSRE(), cita.getCiudadSRE(), cita.getFechaCita(), cita.getHoraCita(), cita.getMotivoCita());
                                System.out.println("[" + cita.getIdCita() + "] ||" + cita.getMotivoCita() + "   ||     " + cita.getEstadoSRE() + ", " + cita.getCiudadSRE() + "     || " + cita.getFechaCita() + "  ||  " + cita.getHoraCita() + "  || " + cita.getEstadoCita());
                                contadorCitas+=1;
                                historyIndex += 1;
                            }
                        }
                    }
                    System.out.print("¿Deseas modificar/cancelar alguna cita? (Si/No): ");
                    String choice = myInput.nextLine();
                    int intChoice;
                    if (choice.equalsIgnoreCase("Si")) {
                        clearScreen();
                        System.out.println("ID ||   Motivo    ||  Lugar (estado, ciudad) ||    fecha    ||    hora    ||  estado de la cita  ");
                        System.out.println("-------------------------------------------------------------------------------------------------");        
                        contadorCitas = 0;
                        for (Cita cita : arr) {
                            if (cita != null) {
                                if(curpString.equals(cita.getCurp())){
                                    System.out.println("[" + cita.getIdCita() + "] ||" + cita.getMotivoCita() + "   ||     " + cita.getEstadoSRE() + ", " + cita.getCiudadSRE() + "     || " + cita.getFechaCita() + "  ||  " + cita.getHoraCita() + "  || " + cita.getEstadoCita());
                                    contadorCitas+=1;
                                    historyIndex += 1;
                                }
                            }
                        }
                        System.out.print("Elige el registro a modificar: ");
                        intChoice = myInput.nextInt();
                        myInput.nextLine();
                        idCita = intChoice;
                        boolean running2 = true;
                        do{
                            clearScreen();
                            System.out.println("REGISTRO SELECCIONADO:");
                            System.out.println("ID ||   Motivo    ||  Lugar (estado, ciudad) ||    fecha    ||    hora    ||  estado de la cita  ");
                            System.out.println("-------------------------------------------------------------------------------------------------");        
                            // cita seleccionada a modificar
                            System.out.println("[" + arr[idCita].getIdCita() + "] ||" + arr[idCita].getMotivoCita() + "   ||     " + arr[idCita].getEstadoSRE() + ", " + arr[idCita].getCiudadSRE() + "     || " + arr[idCita].getFechaCita() + "  ||  " + arr[idCita].getHoraCita() + "  || " + arr[idCita].getEstadoCita());

    
                            System.out.println("    Elija una modificación: ");
                            System.out.println("        [1] Lugar");
                            System.out.println("        [2] Fecha y hora");
                            System.out.println("        [3] Cancelar cita");
                            System.out.print("    Su elección: ");
                            intChoice = myInput.nextInt();
                            myInput.nextLine(); // resetea el scanner
                            switch (intChoice) {
                                case 1:
                                    System.out.print("Estado donde deseas tomar tu cita: ");
                                    estadoString = myInput.nextLine();
                                    arr[idCita].setEstadoSRE(estadoString);
                                    
                                    System.out.print("Ciudad donde deseas tomar tu cita: ");
                                    ciudadString = myInput.nextLine();
                                    arr[idCita].setCiudadSRE(ciudadString);
                                    
                                    break;
                                case 2:
                                    System.out.print("Fecha de tu cita: ");
                                    fechaCitaString = myInput.nextLine();
                                    arr[idCita].setFechaCita(fechaCitaString);
                
                                    System.out.print("Hora de tu cita: ");
                                    horaCitaString = myInput.nextLine();
                                    arr[idCita].setHoraCita(horaCitaString);
                                    
                                    break;
                                case 3:   
                                    System.out.print("¿Deseas cancelar tu cita? (Si/No): ");
                                    choice = myInput.nextLine();
                                    if (choice.equalsIgnoreCase("Si")) {
                                        try {
                                            arr[idCita].setEstadoCitaActivo(false);
                                            clearScreen();
                                            Thread.sleep(700);
                                            System.out.print("Tu cita ha sido cancelada correctamente");
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    } else {
                                        System.out.print("Tu cita no ha sido modificada");
                                    }
                                    break;
                            }
                            clearScreen();
                            try {
                                System.out.println("Tu cita ha sido modificada correctamente");
                                Thread.sleep(500);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            System.out.print("¿Desea modificar otro aspecto de su cita? (Si/No): ");
                            choice = myInput.nextLine();
                            if (choice.equalsIgnoreCase("No")) {
                                running2 = false;
                            }
                        } while(running2);
                    }
                    idCita = arrIndex;
                    System.out.print("    Presiona [ENTER] para continuar ");
                    getch();
                    break;
                case 3:
                    System.out.print("Saliendo ");
                    try {
                        Thread.sleep(300);
                        System.out.print(".");
                        Thread.sleep(300);
                        System.out.print(".");
                        Thread.sleep(300);
                        System.out.print(".");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    running = false;
                    break;
                default:
                    System.out.println("Error: input inválido");
                    break;
            }    
        } while (running);
        myInput.close();
        scanner.close();
        System.out.println("El programa terminó exitosamente");
    }
}