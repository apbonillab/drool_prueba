package co.com.prueba.demo;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PruebaService {


    @Autowired
    private KieContainer kieContainer;

    public ResponseEntity<String>getEstado(Validacion valor,ClienteDto cliente){
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("cliente", cliente);
        kieSession.insert(valor);
        kieSession.fireAllRules();
        kieSession.dispose();
        return new ResponseEntity<>(cliente.getNombre(), HttpStatus.OK);
    }
}
