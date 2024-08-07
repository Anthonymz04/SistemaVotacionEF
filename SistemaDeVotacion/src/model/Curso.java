// src/model/Curso.java
package model;

public class Curso {
    private Long id;
    private String nombre;
    private Mesa mesa;

    // Constructor, getters y setters
    public Curso(Long id, String nombre, Mesa mesa) {
        this.id = id;
        this.nombre = nombre;
        this.mesa = mesa;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public Mesa getMesa() { return mesa; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setMesa(Mesa mesa) { this.mesa = mesa; }
}
