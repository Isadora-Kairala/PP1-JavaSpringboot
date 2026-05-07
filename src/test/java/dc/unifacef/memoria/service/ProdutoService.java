package dc.unifacef.memoria.service;

import dc.unifacef.memoria.model.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProdutoService {



    //cria o arrayList
    List<Produto> produtos = new ArrayList<Produto>();

    //consulta os produtos na lista
    public List<Produto> consulta(){
        return this.produtos;
    }

    // insere produto na lista
    public Produto cria(Produto produto){
        produto.setId();
    }


}
