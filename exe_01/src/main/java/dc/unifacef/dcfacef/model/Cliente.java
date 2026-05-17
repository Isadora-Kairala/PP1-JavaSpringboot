package dc.unifacef.dcfacef.model;

//1. Camada Model
//Crie a classe Cliente com os seguintes atributos:
//Long id
//String nome
//String email
//int idade
//Implemente o construtor padrão, o construtor com parâmetros e os métodos Getters e Setters.

public class Cliente {
    private Long id;
    private String nome;
    private String email;
    private int idade;



    public Cliente(){

    }

    public Cliente(Long id, String nome, String email, int idade){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;

    }

    public Long getId() {
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public int getIdade(){
        return idade;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }


}
