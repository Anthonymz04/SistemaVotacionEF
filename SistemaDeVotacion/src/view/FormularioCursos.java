
package view;

import controller.ControladorCursos;
import controller.ControladorMesas;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import model.Curso;
import model.Mesa;

public class FormularioCursos extends JInternalFrame {
    private JTextField campoId, campoNombre, campoMesa;
    private JButton botonAgregar;
    private JTable tablaCursos;
    private DefaultTableModel modeloTabla;
    private ControladorCursos controladorCursos;
    private ControladorMesas controladorMesas;

    public FormularioCursos(ControladorCursos controladorCursos, ControladorMesas controladorMesas) {
        super("Administrar Cursos", true, true, true, true);
        setSize(600, 400);
        setLayout(new BorderLayout());

        this.controladorCursos = controladorCursos;
        this.controladorMesas = controladorMesas;

        JPanel panelFormulario = new JPanel(new GridLayout(3, 2));
        campoId = new JTextField();
        campoNombre = new JTextField();
        campoMesa = new JTextField();
        botonAgregar = new JButton("Agregar");

        panelFormulario.add(new JLabel("ID:"));
        panelFormulario.add(campoId);
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(campoNombre);
        panelFormulario.add(new JLabel("Mesa ID:"));
        panelFormulario.add(campoMesa);

        add(panelFormulario, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.add(botonAgregar);
        add(panelBotones, BorderLayout.SOUTH);

        botonAgregar.addActionListener(e -> agregarCurso());

        modeloTabla = new DefaultTableModel(new String[] {"ID", "Nombre", "Mesa"}, 0);
        tablaCursos = new JTable(modeloTabla);
        add(new JScrollPane(tablaCursos), BorderLayout.CENTER);

        actualizarTabla();
    }

    private void agregarCurso() {
        try {
            Long id = Long.parseLong(campoId.getText());
            String nombre = campoNombre.getText();
            Long idMesa = Long.parseLong(campoMesa.getText());

            Mesa mesa = controladorMesas.obtenerMesaPorId(idMesa);
            if (mesa != null) {
                Curso curso = new Curso(id, nombre, mesa);
                controladorCursos.agregarCurso(curso);
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Mesa no encontrada");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos ingresados");
        }
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        for (Curso curso : controladorCursos.obtenerCursos()) {
            modeloTabla.addRow(new Object[] {
                    curso.getId(),
                    curso.getNombre(),
                    curso.getMesa().getNombre()
            });
        }
    }
}
