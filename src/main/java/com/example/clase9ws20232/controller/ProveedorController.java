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

    // EDITAR
    @PutMapping(value = {"", "/"}, consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<HashMap<String, Object>> actualizar(Proveedor proveedorRecibido) {

        HashMap<String, Object> rpta = new HashMap<>();

        if (proveedorRecibido.getId() != null && proveedorRecibido.getId() > 0) {

            Optional<Proveedor> byId = proveedorRepository.findById(proveedorRecibido.getId());
            if (byId.isPresent()) {
                Proveedor proveedorFromDb = byId.get();

                if (proveedorRecibido.getRazonSocial() != null)
                    proveedorFromDb.setRazonSocial(proveedorRecibido.getRazonSocial());

                if (proveedorRecibido.getNombreComercial() != null)
                    proveedorFromDb.setNombreComercial(proveedorRecibido.getNombreComercial());

                if (proveedorRecibido.getRUC() != null)
                    proveedorFromDb.setRUC(proveedorRecibido.getRUC());

                if (proveedorRecibido.getTelefono() != null)
                    proveedorFromDb.setTelefono(proveedorRecibido.getTelefono());

                if (proveedorRecibido.getCorreoElectronico() != null)
                    proveedorFromDb.setCorreoElectronico(proveedorRecibido.getCorreoElectronico());

                if (proveedorRecibido.getSitioWeb() != null)
                    proveedorFromDb.setSitioWeb(proveedorRecibido.getSitioWeb());

                if (proveedorRecibido.getDireccionFisica() != null)
                    proveedorFromDb.setDireccionFisica(proveedorRecibido.getDireccionFisica());

                if (proveedorRecibido.getPais() != null)
                    proveedorFromDb.setPais(proveedorRecibido.getPais());

                if (proveedorRecibido.getRepresentateLegal() != null)
                    proveedorFromDb.setRepresentateLegal(proveedorRecibido.getRepresentateLegal());

                if (proveedorRecibido.getDNI() != null)
                    proveedorFromDb.setDNI(proveedorRecibido.getDNI());

                if (proveedorRecibido.getTipoDeProveedor() != null)
                    proveedorFromDb.setTipoDeProveedor(proveedorRecibido.getTipoDeProveedor());

                if (proveedorRecibido.getCategoria() != null)
                    proveedorFromDb.setCategoria(proveedorRecibido.getCategoria());

                if (proveedorRecibido.getFacturacionAnualDolares() != null)
                    proveedorFromDb.setFacturacionAnualDolares(proveedorRecibido.getFacturacionAnualDolares());

                if (proveedorRecibido.getFechaRegistro() != null)
                    proveedorFromDb.setFechaRegistro(proveedorRecibido.getFechaRegistro());
                if (proveedorRecibido.getUltimaActualizacion() != null)
                    proveedorFromDb.setUltimaActualizacion(proveedorRecibido.getUltimaActualizacion());
                if (proveedorRecibido.getEstado() != null) {
                    proveedorFromDb.setEstado(proveedorRecibido.getEstado());
                }

                proveedorRepository.save(proveedorFromDb);
                rpta.put("result", "ok");
                return ResponseEntity.ok(rpta);
            } else {
                rpta.put("result", "error");
                rpta.put("msg", "El ID del proveedor enviado no existe");
                return ResponseEntity.badRequest().body(rpta);
            }
        } else {
            rpta.put("result", "error");
            rpta.put("msg", "debe enviar un proveedor con ID");
            return ResponseEntity.badRequest().body(rpta);
        }
    }





}