/*Classe utilizada para criar uma instância de cada cliente com os dados que forem buscados no banco de dados.
Uma nova instância pra cada linha da tabela. Caso for adicionado mais colunas na tabela é preciso adicionar uma nova
variável para esta coluna e fazer as alterações necessárias nas classes JanelaVerClientes.java e AcaoVerClientesBtn.java
*/
public class Cliente
{
    String id, nome, telefone, endereco;

    public void setId(String id){ this.id = id;}
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getId() {
        return id;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getNome() {
        return nome;
    }
    Cliente(String id, String nome, String telefone, String endereco)
    {
        setId(id);
        setNome(nome);
        setTelefone(telefone);
        setEndereco(endereco);
    }
}
