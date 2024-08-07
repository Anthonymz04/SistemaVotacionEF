// src/view/FormularioReportes.java
package view;

import controller.ControladorCandidatos;
import controller.ControladorVotos;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Candidato;
import model.Voto;

public class FormularioReportes extends JInternalFrame {
    private ControladorVotos controladorVotos;
    private ControladorCandidatos controladorCandidatos;

    public FormularioReportes(ControladorVotos controladorVotos, ControladorCandidatos controladorCandidatos) {
        super("Reportes", true, true, true, true);
        setSize(800, 600);
        setLayout(new BorderLayout());

        this.controladorVotos = controladorVotos;
        this.controladorCandidatos = controladorCandidatos;

        JButton botonMostrarReporte = new JButton("Mostrar Reporte de Votos");
        botonMostrarReporte.addActionListener(e -> mostrarReporte());

        add(botonMostrarReporte, BorderLayout.NORTH);
    }

    private void mostrarReporte() {
        CategoryDataset dataset = crearDataset();
        JFreeChart chart = ChartFactory.createBarChart(
                "Resultados de Votos",
                "Candidatos",
                "Número de Votos",
                dataset
        );
        ChartPanel panelGrafico = new ChartPanel(chart);
        panelGrafico.setPreferredSize(new Dimension(600, 400));
        getContentPane().add(panelGrafico, BorderLayout.CENTER);
        revalidate();
    }

    private CategoryDataset crearDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map<Candidato, Integer> votosPorCandidato = new HashMap<>();

        for (Voto voto : controladorVotos.obtenerVotos()) {
            votosPorCandidato.merge(voto.getCandidato(), 1, Integer::sum);
        }

        for (Candidato candidato : controladorCandidatos.obtenerCandidatos()) {
            dataset.addValue(votosPorCandidato.getOrDefault(candidato, 0), "Votos", candidato.getNombre());
        }

        return dataset;
    }
}
