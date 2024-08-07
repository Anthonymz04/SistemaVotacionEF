// src/controller/ControladorVotos.java
package controller;

import model.Estudiante;
import model.Voto;
import java.util.ArrayList;
import java.util.List;
import model.Candidato;

public class ControladorVotos {
    private List<Voto> votos;
    private List<Estudiante> estudiantes;

    public ControladorVotos(List<Estudiante> estudiantes) {
        this.votos = new ArrayList<>();
        this.estudiantes = estudiantes;
    }

    public void registrarVoto(Estudiante estudiante, Candidato candidato) {
        if (estudiante.getEstado()) {
            System.out.println("El estudiante ya ha votado.");
            return;
        }
        estudiante.setEstado(true);
        votos.add(new Voto(estudiante, candidato));
    }

    public List<Voto> obtenerVotos() {
        return votos;
    }
}
