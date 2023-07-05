package com.inventario.services.imple;

import com.inventario.entities.pedidoEntity;
import com.inventario.repositories.IpedidoRepository;
import com.inventario.services.IpedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServicesImple implements IpedidoService {

    @Autowired
    IpedidoRepository pedidoRepository;

    @Override
    public List<pedidoEntity> findAllPedido() {
        return (List<pedidoEntity>) pedidoRepository.findAll();
    }

    @Override
    public pedidoEntity findByIdPedido(Integer id) {
        pedidoEntity obj = pedidoRepository.findById(id).orElseGet(null);
        return obj;
    }

    @Override
    public pedidoEntity insertPedido(pedidoEntity pedidoEntity) {
        if (pedidoEntity.getId() == null){
            return pedidoRepository.save(pedidoEntity);
        }else {
            return null;
        }
    }

    @Override
    public pedidoEntity updatePedido(pedidoEntity pedidoEntity) {
        pedidoEntity obj = pedidoRepository.findById(pedidoEntity.getId()).orElseGet(null);
        if (obj == null){
            return null;
        }else {
            pedidoRepository.save(obj);
        }
        return obj;
    }

    @Override
    public boolean findByIdDeletePedido(Integer id) {
        pedidoEntity obj = pedidoRepository.findById(id).orElseGet(null);
        if (obj == null){
            return false;
        }else {
            pedidoRepository.save(obj);
            return true;
        }
    }
}
