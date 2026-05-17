package dc.unifacef.dcfacef.service;


import java.util.ArrayList;
import java.util.List;

import dc.unifacef.dcfacef.model.Cliente; //ArrayList
import org.springframework.stereotype.Service; // @Service

@Service
public class ClienteService {
    private List<Cliente> clientes = new ArrayList<Cliente>(); // simular bd
    private static Long nextId = 1l;


    //criar(Cliente c): gera o ID, adiciona na lista e retorna o cliente.
    //metodo nextId
    public Cliente cria(Cliente cliente){
        cliente.setId(nextId);
        nextId++;
        this.clientes.add(cliente);
        return cliente;
    }


    //listar(): retorna todos os clientes.
    public List<Cliente> listar(){
        return this.clientes;
    }

    // buscarPorId( Long id): retorna o cliente ou null.
    public Cliente buscaPorId(Long id){
        for(int i = 0; i < clientes.size(); i++){
            if(this.clientes.get(i).getId().equals(id)) {
                return clientes.get(i);
            }
        }
        return null;
    }

    //remover(Long id): remove o cliente e retorna um booleano de sucesso.
    public boolean remover(Long id){
        //removeif faz o for
        return this.clientes.removeIf( c -> c.getId().equals(id));
    }

    // atualizar(Long id, Cliente novo): localiza pelo ID e substitui os dados
    public Cliente atualizar(Long id, Cliente novo){
        novo.setId(id);
        for(int i = 0; i < clientes.size(); i++){
            if (this.clientes.get(i).getId().equals(id)){
                this.clientes.set(i, novo);
                return novo;

            }
        }
        return null;

    }




}
