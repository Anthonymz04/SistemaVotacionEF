// src/view/VentanaPrincipal.java
package view;

import controller.ControladorCandidatos;
import controller.ControladorCursos;
import controller.ControladorEstudiantes;
import controller.ControladorMesas;
import controller.ControladorVotos;
import javax.swing.*;
import java.awt.BorderLayout;

public class VentanaPrincipal extends JFrame {
    private JDesktopPane escritorio;
    private ControladorEstudiantes controladorEstudiantes;
    private ControladorCandidatos controladorCandidatos;
    private ControladorVotos controladorVotos;
    private ControladorCursos controladorCursos;
    private ControladorMesas controladorMesas;

    public VentanaPrincipal() {
        setTitle("Sistema Electoral");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        escritorio = new JDesktopPane();
        add(escritorio, BorderLayout.CENTER);

        controladorEstudiantes = new ControladorEstudiantes();
        controladorCandidatos = new ControladorCandidatos();
        controladorVotos = new ControladorVotos(controladorEstudiantes.getEstudiantes());
        controladorCursos = new ControladorCursos();
        controladorMesas = new ControladorMesas();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuArchivo = new JMenu("Archivo");
        JMenu menuAdministracion = new JMenu("Administración");
        JMenu menuProceso = new JMenu("Proceso");
        JMenu menuReportes = new JMenu("Reportes");

        menuBar.add(menuArchivo);
        menuBar.add(menuAdministracion);
        menuBar.add(menuProceso);
        menuBar.add(menuReportes);

        JMenuItem itemSalir = new JMenuItem("Salir");
        JMenuItem itemAgregarEstudiante = new JMenuItem("Agregar Estudiante");
        JMenuItem itemAgregarCandidato = new JMenuItem("Agregar Candidato");
        JMenuItem itemAgregarCurso = new JMenuItem("Agregar Curso");
        JMenuItem itemAgregarMesa = new JMenuItem("Agregar Mesa");
        JMenuItem itemSufragar = new JMenuItem("Sufragar");
        JMenuItem itemReportePadron = new JMenuItem("Reporte Padrón Electoral");
        JMenuItem itemReporteGrafico = new JMenuItem("Reporte Gráfico");

        menuArchivo.add(itemSalir);
        menuAdministracion.add(itemAgregarEstudiante);
        menuAdministracion.add(itemAgregarCandidato);
        menuAdministracion.add(itemAgregarCurso);
        menuAdministracion.add(itemAgregarMesa);
        menuProceso.add(itemSufragar);
        menuReportes.add(itemReportePadron);
        menuReportes.add(itemReporteGrafico);

        itemSalir.addActionListener(e -> System.exit(0));

        itemAgregarEstudiante.addActionListener(e -> abrirFormulario(new FormularioEstudiantes(controladorEstudiantes, controladorCursos)));
        itemAgregarCandidato.addActionListener(e -> abrirFormulario(new FormularioCandidatos(controladorCandidatos)));
        itemAgregarCurso.addActionListener(e -> abrirFormulario(new FormularioCursos(controladorCursos, controladorMesas)));
        itemAgregarMesa.addActionListener(e -> abrirFormulario(new FormularioMesas(controladorMesas)));
        itemSufragar.addActionListener(e -> abrirFormulario(new FormularioSufragio(controladorEstudiantes, controladorCandidatos, controladorVotos)));
        itemReportePadron.addActionListener(e -> abrirFormulario(new FormularioPadron(controladorEstudiantes)));
        itemReporteGrafico.addActionListener(e -> abrirFormulario(new FormularioReportes(controladorVotos, controladorCandidatos)));

        setVisible(true);
    }

    private void abrirFormulario(JInternalFrame formulario) {
        escritorio.add(formulario);
        formulario.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VentanaPrincipal::new);
    }
}
