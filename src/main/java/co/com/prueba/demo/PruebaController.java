package co.com.prueba.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebaController {

    @Autowired
    PruebaService service;
    @PostMapping("pruebas")
    public ResponseEntity<String> prueba(@RequestBody Validacion cliente){
            return service.getEstado(cliente,new ClienteDto());
    }
}
