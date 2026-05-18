package com.proyecto.aj_solutions.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Servicios")
public class Servicio {

    // Atributos de la clase

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Este campo no puede estar en blanco")
    private String nombre;

    @NotNull
    @Digits(integer = 3, fraction = 2)
    private BigDecimal precio;

    @NotNull
    private int duracion;

    @NotNull
    private String descripcion;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "empleado_servicio",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private List<User> empleado = new ArrayList<>();

    // Constructores

    public Servicio() {}

    public Servicio(BigDecimal precio, String nombre, int duracion, String descripcion, List<User> empleado) {
        this.precio = precio;
        this.nombre = nombre;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.empleado = empleado;
    }

    // Getters y Setters


    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<User> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(List<User> empleado) {
        this.empleado = empleado;
    }
}
