// src/model/Mesa.java
package model;

// Mesa.java
public class Mesa {
    private Long id;
    private String nombre;
    private String presidente;
    private String secretario;

    // Constructor, getters y setters
    public Mesa(Long id, String nombre, String presidente, String secretario) {
        this.id = id;
        this.nombre = nombre;
        this.presidente = presidente;
        this.secretario = secretario;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getPresidente() { return presidente; }
    public String getSecretario() { return secretario; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPresidente(String presidente) { this.presidente = presidente; }
    public void setSecretario(String secretario) { this.secretario = secretario; }
}

