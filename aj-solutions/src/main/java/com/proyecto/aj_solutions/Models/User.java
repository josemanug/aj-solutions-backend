package com.proyecto.aj_solutions.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
public class User {

    // Atributos de la clase usuario

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Email
    private String email;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String fullName;

    @NotBlank
    @Length(min = 9, max = 9, message = "Este campo debe contener 9 dígitos.")
    private String phone;

    /*
    * RELACIONES CON OTRAS ENTIDADES
    */

    // Muchos a muchos con Roles
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<Role> roles = new ArrayList<>();

    // Muchos a muchos con Servicio
    @ManyToMany(mappedBy = "empleado" )
    private List<Servicio> servicios = new ArrayList<>();


    // Uno a muchos con Review
    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Review> reviews = new ArrayList<>();

    // Constructores

    public User() {
    }

    public User(String email, String username, String password, String fullName, String phone, List<Role> roles) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.phone = phone;
        this.roles = roles;
        this.username = username;
    }

    public User(String email, String username, String password, String fullName, String phone, List<Role> roles, List<Review> reviews, List<Servicio> servicios) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.phone = phone;
        this.roles = roles;
        this.username = username;
        this.servicios = servicios;
        this.reviews = reviews;

    }

    // Getters y Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
}
