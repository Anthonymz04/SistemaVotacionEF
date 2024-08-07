// src/controller/CandidatoController.java
package controller;
import java.util.ArrayList;
import java.util.List;
import model.Candidato;

public class ControladorCandidatos {
    private List<Candidato> candidatos;

    public ControladorCandidatos() {
        candidatos = new ArrayList<>();
    }

    public void agregarCandidato(Candidato candidato) {
        candidatos.add(candidato);
    }

    public List<Candidato> obtenerCandidatos() {
        return candidatos;
    }
}
