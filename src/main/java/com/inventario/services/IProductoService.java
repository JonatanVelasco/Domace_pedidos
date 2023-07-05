    package com.inventario.services;

import com.inventario.entities.pedidoEntity;

import java.util.List;

public interface IpedidoService {

    public List<pedidoEntity> findAllPedido();

    public pedidoEntity findByIdPedido(Integer id);

    public pedidoEntity insertPedido(pedidoEntity pedidoEntity);

    public pedidoEntity updatePedido(pedidoEntity pedidoEntity);

    public boolean findByIdDeletePedido(Integer id);
}
