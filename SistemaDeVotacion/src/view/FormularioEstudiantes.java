package view;

import controller.ControladorCursos;
import controller.ControladorEstudiantes;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import model.Curso;
import model.Estudiante;

public class FormularioEstudiantes extends JInternalFrame {
    private JTextField campoId, campoNombre, campoCedula, campoEstado, campoCurso;
    private JButton botonAgregar;
    private JTable tablaEstudiantes;
    private DefaultTableModel modeloTabla;
    private ControladorEstudiantes controladorEstudiantes;
    private ControladorCursos controladorCursos;

    public FormularioEstudiantes(ControladorEstudiantes controladorEstudiantes, ControladorCursos controladorCursos) {
        super("Administrar Estudiantes", true, true, true, true);
        setSize(600, 400);
        setLayout(new BorderLayout());

        this.controladorEstudiantes = controladorEstudiantes;
        this.controladorCursos = controladorCursos;

        JPanel panelFormulario = new JPanel(new GridLayout(5, 2));
        campoId = new JTextField();
        campoNombre = new JTextField();
        campoCedula = new JTextField();
        campoEstado = new JTextField();
        campoCurso = new JTextField();
        botonAgregar = new JButton("Agregar");

        panelFormulario.add(new JLabel("ID:"));
        panelFormulario.add(campoId);
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(campoNombre);
        panelFormulario.add(new JLabel("Cédula:"));
        panelFormulario.add(campoCedula);
        panelFormulario.add(new JLabel("Estado (true/false):"));
        panelFormulario.add(campoEstado);
        panelFormulario.add(new JLabel("ID Curso:"));
        panelFormulario.add(campoCurso);

        add(panelFormulario, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.add(botonAgregar);
        add(panelBotones, BorderLayout.SOUTH);

        botonAgregar.addActionListener(e -> agregarEstudiante());

        modeloTabla = new DefaultTableModel(new String[] {"ID", "Nombre", "Cédula", "Estado", "Curso"}, 0);
        tablaEstudiantes = new JTable(modeloTabla);
        add(new JScrollPane(tablaEstudiantes), BorderLayout.CENTER);

        actualizarTabla();
    }

    private void agregarEstudiante() {
        try {
            Long id = Long.parseLong(campoId.getText());
            String nombre = campoNombre.getText();
            String cedula = campoCedula.getText();
            Boolean estado = Boolean.parseBoolean(campoEstado.getText());
            Long idCurso = Long.parseLong(campoCurso.getText());

            Curso curso = controladorCursos.obtenerCursoPorId(idCurso);
            if (curso != null) {
                Estudiante estudiante = new Estudiante(id, nombre, cedula, estado, curso);
                controladorEstudiantes.agregarEstudiante(estudiante);
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Curso no encontrado");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos ingresados");
        }
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        for (Estudiante estudiante : controladorEstudiantes.obtenerEstudiantes()) {
            modeloTabla.addRow(new Object[] {
                    estudiante.getId(),
                    estudiante.getNombre(),
                    estudiante.getCedula(),
                    estudiante.getEstado(),
                    estudiante.getCurso().getNombre()
            });
        }
    }
}
