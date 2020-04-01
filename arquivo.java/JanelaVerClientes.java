import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

class JanelaVerClientes extends Stage
{
    static ArrayList<String> coluna1 = new ArrayList<>();
    static ArrayList<String> coluna2 = new ArrayList<>();
    static ArrayList<String> coluna3 = new ArrayList<>();
    static ArrayList<String> coluna4 = new ArrayList<>();
    static String[] coluna1Array;
    static String[] coluna2Array;
    static String[] coluna3Array;
    static String[] coluna4Array;
    static Cliente rowData;
    //Mudar o nome dessas variaveis para o nome das colunas no banco de dados de clientes para identificar melhor

    private int largura;
    private  int altura;
    private TableView<Cliente> tabelaVerClientes = new TableView<>(); //Tabela
    private VBox empilhar = new VBox(5); // Adicionar tabela aqui para aparecer na janela
    private BorderPane base = new BorderPane();
    static boolean janelaAberta = false;
    // Condicao para nao permitir que varias janelas sejam abertas ao mesmo tempo

    private int getLargura()
    {
        return largura;
    }
    private int getAltura()
    {
        return altura;
    }
    private void definirLargura(int l)
    {
        largura = l;
    }
    private void definirAltura(int a)
    {
        altura = a;
    }

    /* Sempre que clickar no X para fechar a janela isto vai ser executado.
    /* Utilizado em conjunto com o if na classe AcaoAdicionarBtn para
    /*permitir apenas 1 instancia desta janela por vez*/
    private void operacaoDeSaida()
    {
        coluna3.clear();
        coluna1.clear();
        coluna2.clear();
        close();
        janelaAberta = false; // Se for falso, pode ser aberta novamente, se for verdadeiro nao pode
        //Sempre que abre a janela se torna verdadeiro, sempre que fecha se torna falso
    }

    private static ObservableList<Cliente> getClientes() //Cria instancias da classe Cliente com os dados que foram buscados
    {
        ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
        for (int i = 0; i < coluna2.size(); i++) {
            listaClientes.add(new Cliente(coluna1Array[i], coluna2Array[i], coluna3Array[i], coluna4Array[i]));
        }
        return listaClientes;
    }

    private void definirTabelaVerClientes()
    {
        //Adiciona a funcao de click para a tabela. Definicao da funcao na classe AcaoClickarTabela
        tabelaVerClientes.setRowFactory(tv -> {
            TableRow<Cliente> linha = new TableRow<>();
            linha.setOnMouseClicked(event -> { if (event.getClickCount() == 2 && (! linha.isEmpty()) ) {
                rowData = linha.getItem();
                new AcaoClickarTabela();} });
            return linha ; });

        TableColumn<Cliente, String> colunaId = new TableColumn<>("ID");
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id")); //busca o valor da variavel id da classe Cliente
        colunaId.setMinWidth(getLargura() /4 - 1);//Divide a largura pela quantidade de colunas para encher a tela toda

        TableColumn<Cliente, String> colunaNome = new TableColumn<>("Nome");
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome")); //busca o valor da variavel nome da classe Cliente
        colunaNome.setMinWidth(getLargura() /4 - 1);//Divide a largura pela quantidade de colunas para encher a tela toda

        TableColumn<Cliente, String> colunaTelefone = new TableColumn<>("Telefone");
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));//busca o valor da variavel telefone da classe Cliente
        colunaTelefone.setMinWidth(getLargura() /4);//Divide a largura pela quantidade de colunas para encher a tela toda

        TableColumn<Cliente, String> colunaEndereco = new TableColumn<>("Endereco");
        colunaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));//busca o valor da variavel endereco da classe Cliente
        colunaEndereco.setMinWidth(getLargura() /4 - 1);//Divide a largura pela quantidade de colunas para encher a tela toda

        Label titulo = new Label("Clientes");
        titulo.setId("titulo");

        tabelaVerClientes.setItems(getClientes());//Coloca os clientes da funcao getClientes() na tabela
        tabelaVerClientes.getColumns().addAll(colunaId,colunaNome,colunaTelefone,colunaEndereco);//Adiciona as colunas
        empilhar.getChildren().add(titulo);
        empilhar.getChildren().add(tabelaVerClientes);//Nao deletar, caso contrario a tabela nao vai aparecer
        base.setTop(empilhar);
    }

    private void inicializar()
    {
        definirTabelaVerClientes();
        Scene conteudo = new Scene(base, getLargura(), getAltura());
        conteudo.getStylesheets().add("styles/TabelaDark.css");
        setTitle("Clientes");
        setScene(conteudo);
        setOnCloseRequest(event -> operacaoDeSaida());
        show();
    }

    JanelaVerClientes(int largura, int altura)
    {
        definirLargura(largura);
        definirAltura(altura);
        inicializar();
    }
}
