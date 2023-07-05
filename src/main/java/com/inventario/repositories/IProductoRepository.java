package com.inventario.repositories;

import com.inventario.entities.pedidoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpedidoRepository extends CrudRepository<pedidoEntity, Integer> {



}
