package com.inventario.api;

import com.inventario.exceptions.ApiErrorResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador que retorna la version de la aplicacion
 *
 * @author jonatan.velasco
 */
@RestController
@ApiResponses( value = {
    @ApiResponse( code = 200, message = "OK", response = String.class ),
    @ApiResponse( code = 401, message = "Unauthorized", response = ApiErrorResponse[].class ),
    @ApiResponse( code = 500, message = "Internal Server Error", response = ApiErrorResponse[].class )
} )
@Api( value = "Version ApiController", tags = { "", "" } )
@RequestMapping( "" )
public class ApiController {

    @Value( "${spring.application.version}" )
    private String version;

    @Value( "${spring.application.name}" )
    private String name;

    @ApiOperation( value = "Retorna la version de la aplicacion",
                   notes = "Encuestas de Satisfacción y Reportes Gerencia Service al Cliente" )
    @GetMapping( path = "version" )
    public ResponseEntity<Object> index() {

        return ResponseEntity.ok( "Name: " + name + " Version: " + version );
    }

}
