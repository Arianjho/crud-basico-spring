package com.sergiecode.apirest.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sergiecode.apirest.apirest.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
