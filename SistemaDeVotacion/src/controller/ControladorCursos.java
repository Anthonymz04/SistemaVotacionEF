// src/controller/CursoController.java
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Curso;

public class ControladorCursos {
    private List<Curso> cursos;

    public ControladorCursos() {
        cursos = new ArrayList<>();
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public List<Curso> obtenerCursos() {
        return cursos;
    }

    public Curso obtenerCursoPorId(Long id) {
        for (Curso curso : cursos) {
            if (curso.getId().equals(id)) {
                return curso;
            }
        }
        return null;
    }
}
