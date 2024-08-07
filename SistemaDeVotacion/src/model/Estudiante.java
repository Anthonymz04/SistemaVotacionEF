// src/model/Estudiante.java
package model;

public class Estudiante extends Persona {
    private String cedula;
    private Boolean estado;
    private Curso curso;

    
    public Estudiante(Long id, String nombre, String cedula, Boolean estado, Curso curso) {
        super(id, nombre);
        this.cedula = cedula;
        this.estado = false;
        this.curso = curso;
    }
public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public String getCedula() { return cedula; }
    
    public Curso getCurso() { return curso; }

    public void setCedula(String cedula) { this.cedula = cedula; }
    
    public void setCurso(Curso curso) { this.curso = curso; }
}
