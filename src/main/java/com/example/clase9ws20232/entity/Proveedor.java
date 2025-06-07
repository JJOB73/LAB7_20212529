package com.example.clase9ws20232.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "poveedores")
@Getter
@Setter
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "razonSocial", length = 100)
    private String razonSocial;

    @Column(name = "nombreComercial", length = 100)
    private String nombreComercial;

    @Column(name = "RUC", nullable = false, length = 11)
    private String RUC;

    @Column(name = "telefono", length = 9)
    private String telefono;

    @Column(name = "correoElectronico", length = 100)
    private String correoElectronico;

    @Column(name = "sitioWeb", length = 100)
    private String sitioWeb;

    @Column(name = "direccionFisica", length = 15)
    private String direccionFisica;

    @Column(name = "pais", length = 45)
    private String pais;

    @Column(name = "representateLegal", length = 45)
    private String representateLegal;

    @Column(name = "DNI", length = 9)
    private String DNI;

    @Column(name = "tipoDeProveedor", length = 24)
    private String tipoDeProveedor;

    @Column(name = "categoria", length = 24)
    private String categoria;

    @Column(name = "facturacionAnualDolares", length = 24)
    private String facturacionAnualDolares;

    @Column(name = "fechaRegistro")
    private String fechaRegistro;

    @Column(name = "ultimaActualizacion")
    private String ultimaActualizacion;

    @Column(name = "estado")
    private String estado;


}