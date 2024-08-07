// src/model/Candidato.java
package model;

// Candidato.java
public class Candidato extends Persona {
    private String foto;
    private String nombrePartido;

    // Constructor, getters y setters
    public Candidato(Long id, String nombre, String foto, String nombrePartido) {
        super(id, nombre);
        this.foto = foto;
        this.nombrePartido = nombrePartido;
    }

    public String getFoto() { return foto; }
    public String getNombrePartido() { return nombrePartido; }

    public void setFoto(String foto) { this.foto = foto; }
    public void setNombrePartido(String nombrePartido) { this.nombrePartido = nombrePartido; }
    
    
}
