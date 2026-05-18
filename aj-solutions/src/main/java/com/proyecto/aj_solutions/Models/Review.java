package com.proyecto.aj_solutions.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotBlank
    private String titulo;

    @NotNull
    @NotBlank
    private String descripcion;

    @NotNull
    @Min(value = 1, message = "Valoración mínima: 1")
    @Max(value = 5, message = "Valoración máxima: 5")
    private int valoracion;

    @ManyToOne
    private User cliente;

    public Review() {}

    public Review(String descripcion, String titulo, int valoracion, User cliente) {
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.valoracion = valoracion;
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public User getCliente() {
        return cliente;
    }

    public void setCliente(User cliente) {
        this.cliente = cliente;
    }
}
