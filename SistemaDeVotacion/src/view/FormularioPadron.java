// src/view/FormularioPadron.java
package view;

import controller.ControladorEstudiantes;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import model.Estudiante;

public class FormularioPadron extends JInternalFrame {
    private JTable tablaPadron;
    private DefaultTableModel modeloTabla;
    private ControladorEstudiantes controladorEstudiantes;

    public FormularioPadron(ControladorEstudiantes controladorEstudiantes) {
        super("Padrón Electoral", true, true, true, true);
        setSize(800, 600);
        setLayout(new BorderLayout());

        this.controladorEstudiantes = controladorEstudiantes;

        modeloTabla = new DefaultTableModel(new String[] {"ID", "Nombre", "Cédula", "Estado", "Curso", "Votó"}, 0);
        tablaPadron = new JTable(modeloTabla);
        add(new JScrollPane(tablaPadron), BorderLayout.CENTER);

        actualizarTabla();
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        for (Estudiante estudiante : controladorEstudiantes.obtenerEstudiantes()) {
            modeloTabla.addRow(new Object[] {
                estudiante.getId(),
                estudiante.getNombre(),
                estudiante.getCedula(),
                estudiante.getEstado() ? "Ha votado" : "No ha votado",
                estudiante.getCurso().getNombre(),
                estudiante.getEstado() ? "Sí" : "No"
            });
        }
    }
}
