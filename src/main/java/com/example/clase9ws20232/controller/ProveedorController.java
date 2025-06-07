package com.example.clase9ws20232.controller;


import com.example.clase9ws20232.entity.Proveedor;
import com.example.clase9ws20232.repository.ProveedorRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    final ProveedorRepository proveedorRepository;

    public ProveedorController(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    //LISTAR
    @GetMapping(value = {"/list", ""})
    public List<Proveedor> listaProveedor() {
        return proveedorRepository.findAll();
    }

    // REGISTRO
    @PostMapping(value = {"", "/"})
    public ResponseEntity<HashMap<String, Object>> guardarProveedor(
            @RequestBody Proveedor proveedor,
            @RequestParam(value = "fetchId", required = false) boolean fetchId) {

        HashMap<String, Object> responseJson = new HashMap<>();

        proveedorRepository.save(proveedor);
        if (fetchId) {
            responseJson.put("id", proveedor.getId());
        }
        responseJson.put("estado", "creado");
        return ResponseEntity.status(HttpStatus.CREATED).body(responseJson);
    }





}