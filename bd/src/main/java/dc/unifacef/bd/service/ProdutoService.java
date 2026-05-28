package dc.unifacef.bd.service;


import dc.unifacef.bd.model.Produto;
import dc.unifacef.bd.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private ProdutoRepository repo;  //service usa a classe de baixo na camada que usa o repository


    //inicializou pelo construtor injecao de independencia pelo construtor
    public ProdutoService(ProdutoRepository repo){
        this.repo = repo;
    }

    public List<Produto> listar(){
        return repo.findAll();
    }

    public Optional<Produto> buscarPorId(Long id){
        return repo.findById(id);
    }

    public boolean remove(Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }


    public Produto atualiza(Long id, Produto alterado){
        if (repo.existsById(id)){

            alterado.setId(id);
            return repo.save(alterado);
        }
        return  null;
    }


    public Produto salva(Produto produto){
        return repo.save(produto);
    }

}
