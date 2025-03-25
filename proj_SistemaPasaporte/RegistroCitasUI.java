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
    private CardLayout cardLayout;
    private JLabel inicioLabel, nombreLabel, correoLabel, contraLabel;
    private JTextField correoField, contraField;
    private JButton crearCuentaButton, iniciarSesionButton;
    private JPanel mainPanel, inicioPanel, crearPanel;

    public RegistroCitasUI() {
        super("Registro de citas para pasaporte");

        // Botones
        crearCuentaButton = new JButton("Crear cuenta");
        iniciarSesionButton = new JButton("Iniciar sesión");

        // Labels
        inicioLabel = new JLabel("Citas SRE");
        nombreLabel = new JLabel("Nombre:");
        correoLabel = new JLabel("Correo:");
        contraLabel = new JLabel("Contraseña:");

        // Panels
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // TextFields
        correoField = new JTextField("", 6);
        contraField = new JTextField("", 6);
        
        // Panel inicio
        inicioPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        inicioPanel.add(inicioLabel, gbc);
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        inicioPanel.add(correoLabel, gbc);
        gbc.gridy = 2;
        gbc.gridx = 0;
        inicioPanel.add(correoField, gbc);
        gbc.gridy = 3;
        gbc.gridx = 0;
        inicioPanel.add(contraLabel, gbc);
        gbc.gridy = 4;
        gbc.gridx = 0;
        inicioPanel.add(contraField, gbc);
        gbc.gridy = 5;
        gbc.gridx = 0;
        inicioPanel.add(iniciarSesionButton, gbc);
        gbc.gridheight = 5;
        gbc.gridy = 1;
        gbc.gridx = 1;
        inicioPanel.add(crearCuentaButton,gbc);

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