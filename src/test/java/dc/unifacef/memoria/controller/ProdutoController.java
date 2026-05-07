package dc.unifacef.memoria.controller;


import dc.unifacef.memoria.model.Produto;
import dc.unifacef.memoria.service.ProdutoService;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController// cotrolador de requisições REST (api)
@RequestMapping( "/produto") //mapeamento de requisição


public class ProdutoController {
    //injeção de dependencia
    //chamar metodos de um objeto sem instanciá-lo
    @Autowired
    ProdutoService service;


    @GetMapping

    public String consulta(){
        return service.consulta();

    }


    public String mensagem(){
        return "Boa Noite a todos";
    }

    public ResponseEntity<List<Produto>> consulta(){
        return ResponseEntity.ok(service.consulta());
    }

    @PostMapping
    public void cria(@RequestBody Produto produto){

    }


}
