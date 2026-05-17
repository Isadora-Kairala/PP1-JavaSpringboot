package dc.unifacef.dcfacef.controller;


import dc.unifacef.dcfacef.model.Cliente;
import dc.unifacef.dcfacef.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.CommandLinePropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;



@RestController
@RequestMapping("/cliente") //mapeamento requisição
public class ClienteController {
    //chamar metodos de um obj sem instanciaar
    @Autowired
    ClienteService service;


    /*
    GET: Para listar todos os clientes.

    POST: Para receber um JSON de cliente no corpo da requisição e retornar 201 Created.

    DELETE: Para remover um cliente passando o ID na URL (/clientes/{id}).

    PUT: Para atualizar um cliente passando o ID na URL e o novo JSON no corpo.
     */

    @GetMapping
    public ResponseEntity<List<Cliente>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<Cliente> cria(@RequestBody Cliente cliente){
        Cliente novo = service.cria(cliente);
        // URI Uniform Resource Identifier
        URI uri = URI.create("/cliente/" + novo.getId());
        return ResponseEntity.created(uri).body(novo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id){
        if (service.remover(id)){
            return ResponseEntity.noContent().build(); // sucesso - 204
        }
        else {
            return ResponseEntity.notFound().build(); // erro cliente - 404
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualiza(@PathVariable Long id,
                                            @RequestBody Cliente novo){
        Cliente resposta = service.atualizar(id, novo);
        if (resposta != null){
            // atualizou e retornou produto atualizado
            return ResponseEntity.ok(resposta); // 200 ok
        }
        else {
            // não atualizou
            return ResponseEntity.notFound().build(); // 404 notFound
        }
    }

}
