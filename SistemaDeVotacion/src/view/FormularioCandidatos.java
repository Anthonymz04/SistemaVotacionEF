package view;

import controller.ControladorCandidatos;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import model.Candidato;

public class FormularioCandidatos extends JInternalFrame {
    private JTextField campoId, campoNombre, campoFoto, campoPartido;
    private JButton botonAgregar;
    private JTable tablaCandidatos;
    private DefaultTableModel modeloTabla;
    private ControladorCandidatos controladorCandidatos;

    public FormularioCandidatos(ControladorCandidatos controladorCandidatos) {
        super("Administrar Candidatos", true, true, true, true);
        setSize(600, 400);
        setLayout(new BorderLayout());

        this.controladorCandidatos = controladorCandidatos;

        JPanel panelFormulario = new JPanel(new GridLayout(4, 2));
        campoId = new JTextField();
        campoNombre = new JTextField();
        campoFoto = new JTextField();
        campoPartido = new JTextField();
        botonAgregar = new JButton("Agregar");

        panelFormulario.add(new JLabel("ID:"));
        panelFormulario.add(campoId);
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(campoNombre);
        panelFormulario.add(new JLabel("Foto:"));
        panelFormulario.add(campoFoto);
        panelFormulario.add(new JLabel("Nombre Partido:"));
        panelFormulario.add(campoPartido);

        add(panelFormulario, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.add(botonAgregar);
        add(panelBotones, BorderLayout.SOUTH);

        botonAgregar.addActionListener(e -> agregarCandidato());

        modeloTabla = new DefaultTableModel(new String[] {"ID", "Nombre", "Foto", "Partido"}, 0);
        tablaCandidatos = new JTable(modeloTabla);
        add(new JScrollPane(tablaCandidatos), BorderLayout.CENTER);

        actualizarTabla();
    }

    private void agregarCandidato() {
        try {
            Long id = Long.parseLong(campoId.getText());
            String nombre = campoNombre.getText();
            String foto = campoFoto.getText();
            String partido = campoPartido.getText();

            Candidato candidato = new Candidato(id, nombre, foto, partido);
            controladorCandidatos.agregarCandidato(candidato);
            actualizarTabla();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos ingresados");
        }
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        for (Candidato candidato : controladorCandidatos.obtenerCandidatos()) {
            modeloTabla.addRow(new Object[] {
                    candidato.getId(),
                    candidato.getNombre(),
                    candidato.getFoto(),
                    candidato.getNombrePartido()
            });
        }
    }
}
