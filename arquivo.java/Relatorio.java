public class Relatorio
{
    String nome, telefone, pedido;

    public void setNome(String n){nome = n;}
    public void setTelefone(String c){telefone = c;}
    public void setPedido(String q){pedido = q;}
    public String getNome(){return nome;}
    public String getTelefone(){return telefone;}
    public String getPedido(){return pedido;}

    Relatorio(String nome, String telefone, String pedido)
    {
        setNome(nome);
        setTelefone(telefone);
        setPedido(pedido);
    }
}