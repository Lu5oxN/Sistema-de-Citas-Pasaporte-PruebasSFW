package proj_SistemaPasaporte;
import java.io.BufferedInputStream;
import java.io.Console;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.lang.Thread;
import java.util.Scanner;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroCitasUI extends JFrame{
    private JLabel inicioLabel, nombreLabel;
    private JButton crearCuentaButton, iniciarSesionButton;
    private JPanel mainPanel, inicioPanel, crearPanel;
    private CardLayout cardLayout;

    public RegistroCitasUI() {
        super("Registro de citas para pasaporte");

        // Botones
        crearCuentaButton = new JButton("Crear cuenta");
        iniciarSesionButton = new JButton("Iniciar sesión");

        // Labels
        inicioLabel = new JLabel("Citas SRE");
        nombreLabel = new JLabel("Nombre:");

        // Panels
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        // Panel inicio
        inicioPanel = new JPanel();
        inicioPanel.add(inicioLabel);
        inicioPanel.add(crearCuentaButton);
        inicioPanel.add(iniciarSesionButton);

        // Crear cuenta panel
        crearPanel = new JPanel();
        crearPanel.add(nombreLabel);

        mainPanel.add(inicioPanel, "Inicio");
        mainPanel.add(crearPanel, "CrearCuenta");

        crearCuentaButton.addActionListener((e) -> {
            cardLayout.show(mainPanel, "CrearCuenta");
        });

        add(mainPanel);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        RegistroCitasUI ui = new RegistroCitasUI();
    }
}