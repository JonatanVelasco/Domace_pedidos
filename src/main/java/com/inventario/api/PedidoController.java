package com.inventario.api;

import com.inventario.entities.pedidoEntity;
import com.inventario.exceptions.ApiErrorResponse;
import com.inventario.services.IpedidoService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador orquestador de las peticiones
 * @author jonatan.velasco
 */
@RestController
@RequiredArgsConstructor
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = ApiErrorResponse[].class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ApiErrorResponse[].class)
})

@RequestMapping("pedido")
@Slf4j
public class PedidoController {

    private final IpedidoService ipedidoService;

    @GetMapping("listAll")
    public ResponseEntity<?> allPedido() {
        return new ResponseEntity(ipedidoService.findAllPedido(), HttpStatus.OK);
    }

    @GetMapping("byId/{id}")
    public ResponseEntity<?> getpedidoById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(ipedidoService.findByIdPedido(id), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<?> insertPedido(@RequestBody pedidoEntity pedidoEntity) {
        return new ResponseEntity<>(ipedidoService.insertPedido(pedidoEntity), HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<?> updateInfoPedido(@RequestBody pedidoEntity pedidoEntity) {
        return new ResponseEntity<>(ipedidoService.updatePedido(pedidoEntity), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteInfoPedido(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(ipedidoService.findByIdDeletePedido(id), HttpStatus.OK);
    }


}

