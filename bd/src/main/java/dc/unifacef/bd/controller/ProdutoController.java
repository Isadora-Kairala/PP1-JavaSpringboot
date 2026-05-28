package dc.unifacef.bd.controller;


import dc.unifacef.bd.model.Produto;
import dc.unifacef.bd.service.ProdutoService;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Produtos")
public class ProdutoController {

    private ProdutoService service;

    public ProdutoController(ProdutoService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar(){
        return ResponseEntity.ok(service.listar()); //statusCode: 200
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> buscarPorId(@PathVariable Long id){
        Optional<Produto> prod = service.buscarPorId(id);
        if (prod.isEmpty()){
            return ResponseEntity.notFound().build();//status 404 prod n existe
        }
        return ResponseEntity.ok(prod); //statuscode - 200 retora prod encontrado
    }

    @PostMapping
    public ResponseEntity<Produto> salva(@RequestBody Produto produto){
        Produto novo = service.salva(produto);
        if(novo != null){
            //montar URI Uniform Resource identifier
            URI uri = URI.create("/produtos" + novo.getId());
            return ResponseEntity.created(uri).body(novo); // 201
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id")
    public ResponseEntity<Void> remove(@PathVariable Long id){
        if(service.remove(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


    @PatchMapping("/{id")
    public ResponseEntity<Produto> atualiza(@PathVariable Long id, @RequestBody Produto alterado){
        Produto resposta = service.atualiza(id, alterado);
        if (resposta != null){
            return ResponseEntity.ok(resposta);
        }
        return ResponseEntity.notFound().build();
    }


}
