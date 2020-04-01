import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.sql.ResultSet;
import java.sql.SQLException;

/*Mudar o nome da tabela e as variaveis conforme a tabela que estiver no banco de dados
* Deixei a tabela do outro programa como placeholder para os testes e para nao crashar
* Se mudar os nomes das arrays aqui tem que mudar na classe JanelaVerClientes tambem pois as arrays sao usadas la*/

public class AcaoVerClientesBtn implements EventHandler<ActionEvent>
{
    private String tabela = "Usuario";
    private String coluna1 = "codUsuario";
    private String coluna2 = "nome";
    private String coluna3 = "telefone";
    private String coluna4 = "endereco";
    @Override
    public void handle(ActionEvent event)
    {
        if(!JanelaVerClientes.janelaAberta)
        {
            try
            {
                //Codigo SQL para pegar dados da tabela                                 mudar essa tabela
                ResultSet rs = ConectarServidor.createQueryStatement("SELECT * FROM " + tabela);
                while (rs.next())
                {
                                                                       //Mudar para o nome da coluna
                    if(!JanelaVerClientes.coluna1.contains(rs.getString(coluna1)))
                    {
                        //loop para adicionar as rows da tabela do banco de dados para as arrays
                        JanelaVerClientes.coluna1.add(rs.getString(coluna1)); //Mudar
                        JanelaVerClientes.coluna2.add(rs.getString(coluna2)); //Mudar
                        JanelaVerClientes.coluna3.add(rs.getString(coluna3));//Mudar
                        JanelaVerClientes.coluna4.add(rs.getString(coluna4)); //Mudar
                        //Caso houver mais de 3 colunas no banco de dados, criar outro array e copiar o comando dentro do if
                    }
                }
                //inicializa a array e coloca os valores da arrayList
                JanelaVerClientes.coluna1Array = new String[JanelaVerClientes.coluna1.size()];
                for (int iterate = 0; iterate < JanelaVerClientes.coluna1.size(); iterate++)
                {
                    JanelaVerClientes.coluna1Array[iterate] = JanelaVerClientes.coluna1.get(iterate);
                    System.out.println(JanelaVerClientes.coluna1Array[iterate]); //Escreve a array no prompt de comando, para testes
                }
                //inicializa a array e coloca os valores da arrayList
                JanelaVerClientes.coluna2Array = new String[JanelaVerClientes.coluna2.size()];
                for (int iterate = 0; iterate < JanelaVerClientes.coluna2.size(); iterate++)
                {
                    JanelaVerClientes.coluna2Array[iterate] = JanelaVerClientes.coluna2.get(iterate);
                    System.out.println(JanelaVerClientes.coluna2Array[iterate]); //Escreve a array no prompt de comando, para testes
                }
                //inicializa a array e coloca os valores da arrayList
                JanelaVerClientes.coluna3Array = new String[JanelaVerClientes.coluna3.size()];
                for (int iterate = 0; iterate < JanelaVerClientes.coluna3.size(); iterate++)
                {
                    JanelaVerClientes.coluna3Array[iterate] = JanelaVerClientes.coluna3.get(iterate);
                    System.out.println(JanelaVerClientes.coluna3Array[iterate]); //Escreve a array no prompt de comando, para testes
                }
                //inicializa a array e coloca os valores da arrayList
                JanelaVerClientes.coluna4Array = new String[JanelaVerClientes.coluna4.size()];
                for (int iterate = 0; iterate < JanelaVerClientes.coluna4.size(); iterate++)
                {
                    JanelaVerClientes.coluna4Array[iterate] = JanelaVerClientes.coluna4.get(iterate);
                    System.out.println(JanelaVerClientes.coluna4Array[iterate]); //Escreve a array no prompt de comando, para testes
                }
                //Se houver mais colunas tem que criar o for loop para adicionar os valores na array
            } catch (SQLException e1)
            {
                e1.printStackTrace();
            }
            new JanelaVerClientes(750,500);
            JanelaVerClientes.janelaAberta = true;
        }
    }
}
