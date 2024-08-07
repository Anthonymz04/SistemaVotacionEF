package controller;

import java.util.ArrayList;
import java.util.List;
import model.Estudiante;
import model.Voto;

public class ControladorEstudiantes {
    private List<Estudiante> estudiantes;

    public ControladorEstudiantes() {
        estudiantes = new ArrayList<>();
    }

    // Agrega un estudiante a la lista
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    // Obtiene la lista de estudiantes
    public List<Estudiante> obtenerEstudiantes() {
        return estudiantes;
    }

    // Obtiene un estudiante por su cédula
    public Estudiante obtenerEstudiantePorCedula(String cedula) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                return estudiante;
            }
        }
        return null;
    }

    // Verifica si un estudiante ha votado
    public boolean estudianteHaVotado(String cedula, ControladorVotos controladorVotos) {
        Estudiante estudiante = obtenerEstudiantePorCedula(cedula);
        if (estudiante != null) {
            for (Voto voto : controladorVotos.obtenerVotos()) {
                if (voto.getEstudiante().equals(estudiante)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Retorna la lista de estudiantes
    public List<Estudiante> getEstudiantes() {
        return estudiantes; // Corregido para devolver la lista de estudiantes
    }
}
