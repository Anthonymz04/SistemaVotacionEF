package view;

import controller.ControladorMesas;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import model.Mesa;

public class FormularioMesas extends JInternalFrame {
    private JTextField campoId, campoNombre, campoPresidente, campoSecretario;
    private JButton botonAgregar;
    private JTable tablaMesas;
    private DefaultTableModel modeloTabla;
    private ControladorMesas controladorMesas;

    public FormularioMesas(ControladorMesas controladorMesas) {
        super("Administrar Mesas", true, true, true, true);
        setSize(600, 400);
        setLayout(new BorderLayout());

        this.controladorMesas = controladorMesas;

        JPanel panelFormulario = new JPanel(new GridLayout(4, 2));
        campoId = new JTextField();
        campoNombre = new JTextField();
        campoPresidente = new JTextField();
        campoSecretario = new JTextField();
        botonAgregar = new JButton("Agregar");

        panelFormulario.add(new JLabel("ID:"));
        panelFormulario.add(campoId);
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(campoNombre);
        panelFormulario.add(new JLabel("Presidente:"));
        panelFormulario.add(campoPresidente);
        panelFormulario.add(new JLabel("Secretario:"));
        panelFormulario.add(campoSecretario);

        add(panelFormulario, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.add(botonAgregar);
        add(panelBotones, BorderLayout.SOUTH);

        botonAgregar.addActionListener(e -> agregarMesa());

        modeloTabla = new DefaultTableModel(new String[] {"ID", "Nombre", "Presidente", "Secretario"}, 0);
        tablaMesas = new JTable(modeloTabla);
        add(new JScrollPane(tablaMesas), BorderLayout.CENTER);

        actualizarTabla();
    }

    private void agregarMesa() {
        try {
            Long id = Long.parseLong(campoId.getText());
            String nombre = campoNombre.getText();
            String presidente = campoPresidente.getText();
            String secretario = campoSecretario.getText();

            Mesa mesa = new Mesa(id, nombre, presidente, secretario);
            controladorMesas.agregarMesa(mesa);
            actualizarTabla();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos ingresados");
        }
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        for (Mesa mesa : controladorMesas.obtenerMesas()) {
            modeloTabla.addRow(new Object[] {
                    mesa.getId(),
                    mesa.getNombre(),
                    mesa.getPresidente(),
                    mesa.getSecretario()
            });
        }
    }
}
