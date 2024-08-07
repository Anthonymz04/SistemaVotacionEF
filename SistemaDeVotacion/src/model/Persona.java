// src/model/Persona.java
package model;
public class Persona {
    private Long id;
    private String nombre;

    // Constructor, getters y setters
    public Persona(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    @Override
    public String toString() {
        return nombre;
    }
}
