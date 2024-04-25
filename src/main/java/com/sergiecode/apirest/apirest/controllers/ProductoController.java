package com.sergiecode.apirest.apirest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergiecode.apirest.apirest.entities.Producto;
import com.sergiecode.apirest.apirest.repositories.ProductoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto findOne(@PathVariable Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID: " + id));
    }

    @PostMapping()
    public Producto create(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto update(@PathVariable Long id, @RequestBody Producto payloadProducto) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID: " + id));
        producto.setNombre(payloadProducto.getNombre());
        producto.setPrecio(payloadProducto.getPrecio());

        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID: " + id));

        productoRepository.delete(producto);
        return "Producto con el ID: " + id + " ha sido eliminado.";
    }

}
