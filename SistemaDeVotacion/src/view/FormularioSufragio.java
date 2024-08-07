// src/view/FormularioSufragio.java
package view;

import controller.ControladorCandidatos;
import controller.ControladorEstudiantes;
import controller.ControladorVotos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Estudiante;
import model.Candidato;

public class FormularioSufragio extends JInternalFrame {
    private ControladorEstudiantes controladorEstudiantes;
    private ControladorCandidatos controladorCandidatos;
    private ControladorVotos controladorVotos;
    private JComboBox<Estudiante> comboEstudiantes;
    private JComboBox<Candidato> comboCandidatos;

    public FormularioSufragio(ControladorEstudiantes controladorEstudiantes, ControladorCandidatos controladorCandidatos, ControladorVotos controladorVotos) {
        super("Sufragio", true, true, true, true);
        setSize(400, 300);
        setLayout(new GridLayout(4, 2));

        this.controladorEstudiantes = controladorEstudiantes;
        this.controladorCandidatos = controladorCandidatos;
        this.controladorVotos = controladorVotos;

        JLabel labelEstudiante = new JLabel("Seleccionar Estudiante:");
        comboEstudiantes = new JComboBox<>(controladorEstudiantes.obtenerEstudiantes().toArray(new Estudiante[0]));
        JLabel labelCandidato = new JLabel("Seleccionar Candidato:");
        comboCandidatos = new JComboBox<>(controladorCandidatos.obtenerCandidatos().toArray(new Candidato[0]));
        JButton botonVotar = new JButton("Votar");

        botonVotar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Estudiante estudianteSeleccionado = (Estudiante) comboEstudiantes.getSelectedItem();
                Candidato candidatoSeleccionado = (Candidato) comboCandidatos.getSelectedItem();

                if (estudianteSeleccionado == null || candidatoSeleccionado == null) {
                    JOptionPane.showMessageDialog(FormularioSufragio.this, "Debe seleccionar un estudiante y un candidato.");
                    return;
                }

                controladorVotos.registrarVoto(estudianteSeleccionado, candidatoSeleccionado);
                JOptionPane.showMessageDialog(FormularioSufragio.this, "Voto registrado con éxito.");
            }
        });

        add(labelEstudiante);
        add(comboEstudiantes);
        add(labelCandidato);
        add(comboCandidatos);
        add(new JLabel()); // Espacio vacío
        add(botonVotar);
    }
}
