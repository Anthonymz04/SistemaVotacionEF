// src/model/Voto.java
package model;
public class Voto {
    private Long id;
    private Estudiante estudiante;
    private Candidato candidato;

    // Constructor, getters y setters
    public Voto(Estudiante estudiante, Candidato candidato) {
        this.id = id;
        this.estudiante = estudiante;
        this.candidato = candidato;
    }

    public Long getId() { return id; }
    public Estudiante getEstudiante() { return estudiante; }
    public Candidato getCandidato() { return candidato; }

    public void setId(Long id) { this.id = id; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }
    public void setCandidato(Candidato candidato) { this.candidato = candidato; }
}
