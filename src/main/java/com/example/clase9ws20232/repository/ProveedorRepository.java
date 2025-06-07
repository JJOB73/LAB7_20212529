package com.example.clase9ws20232.repository;

import com.example.clase9ws20232.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor,Integer> {
}