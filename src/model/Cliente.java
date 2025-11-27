package model;

/*
  Representa um cliente da aplicação.
  Contém os dados básicos utilizados no cadastro.*/
 

public class Cliente {

    private int id;
    private String nome;
    private String email;
    private String telefone;
    
    
    /*
     * CONSTRUTOR PARA CRIAR UM NOVO CLIENTE
     * @param id identificador único do cliente
     * @param nome nome completo
     * @param email de contato
     * @param telefone número de telefone
     */

    public Cliente(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
    
// Getters e setters para acessar e alterar os dados do cliente

    public int getId() { return id; }

    public String getNome() { return nome;}

    public String getEmail() {return email;}

    public String getTelefone() {return telefone;}

    public void setNome(String nome) {this.nome = nome;}

    public void setEmail(String email) {this.email = email;}

    public void setTelefone(String telefone) {this.telefone = telefone;}

    //RETORNA EM FORMATO DE TEXTO OS DADOS DOS CLIENTES
    
    @Override
    public String toString() {
        return "ID: " + id +
                ", Nome: " + nome +
                ", Email: " + email +
                ", Telefone: " + telefone;
    }
}