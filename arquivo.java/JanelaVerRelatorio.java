import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

class JanelaVerRelatorio extends Stage
{
    static String id;
    static ArrayList<String> coluna1 = new ArrayList<>();
    static ArrayList<String> coluna2 = new ArrayList<>();
    static ArrayList<String> coluna3 = new ArrayList<>();
    static String[] coluna1Array;
    static String[] coluna2Array;
    static String[] coluna3Array;
    static boolean janelaAberta = false;

    private int largura;
    private  int altura;
    private TableView<Relatorio> tabelaVerRelatorio = new TableView<>(); //Tabela
    private VBox empilhar = new VBox(5); // Adicionar tabela aqui para aparecer na janela
    private BorderPane base = new BorderPane();

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
    private void operacaoDeSaida()
    {
        coluna3.clear();
        coluna1.clear();
        coluna2.clear();
        close();
        janelaAberta = false; // Se for falso, pode ser aberta novamente, se for verdadeiro nao pode
        //Sempre que abre a janela se torna verdadeiro, sempre que fecha se torna falso
    }

    private static ObservableList<Relatorio> getRelatorio() //Cria instancias da classe Relatorio com os dados que foram buscados
    {
        ObservableList<Relatorio> listaRelatorio = FXCollections.observableArrayList();
        for (int i = 0; i < coluna1Array.length; i++) {
            listaRelatorio.add(new Relatorio(coluna1Array[i], coluna2Array[i], coluna3Array[i]));
        }
        return listaRelatorio;
    }

    private void definirTabelaVerRelatorio()
    {
        String pesquisarColuna1 = "nome";
        String pesquisarColuna2 = "telefone";
        String pesquisarColuna3 = "pedido";

        TableColumn<Relatorio, String> coluna1 = new TableColumn<>("Nome");
        coluna1.setCellValueFactory(new PropertyValueFactory<>(pesquisarColuna1)); //busca o valor da variavel nome da classe Relatorio
        coluna1.setMinWidth(getLargura() /3 - 1);//Divide a largura pela quantidade de colunas para encher a tela toda

        TableColumn<Relatorio, String> coluna2 = new TableColumn<>("Telefone");
        coluna2.setCellValueFactory(new PropertyValueFactory<>(pesquisarColuna2));//busca o valor da variavel codigo da classe Relatorio
        coluna2.setMinWidth(getLargura() /3);//Divide a largura pela quantidade de colunas para encher a tela toda

        TableColumn<Relatorio, String> coluna3 = new TableColumn<>("Pedido");
        coluna3.setCellValueFactory(new PropertyValueFactory<>(pesquisarColuna3));//busca o valor da variavel quantidade da classe Relatorio
        coluna3.setMinWidth(getLargura() /3 - 1);//Divide a largura pela quantidade de colunas para encher a tela toda

        Label titulo = new Label("Relatorio");
        titulo.setId("titulo");

        tabelaVerRelatorio.setItems(getRelatorio());
        tabelaVerRelatorio.getColumns().addAll(coluna1,coluna2,coluna3);//Adiciona as colunas
        empilhar.getChildren().add(titulo);
        empilhar.getChildren().add(tabelaVerRelatorio);//Nao deletar, caso contrario a tabela nao vai aparecer
        empilhar.setMinHeight(getAltura());
        empilhar.setMinWidth(getAltura());
        base.setCenter(empilhar);
    }
    
    private void inicializar()
    {
        definirTabelaVerRelatorio();
        Scene conteudo = new Scene(base, getLargura(), getAltura());
        conteudo.getStylesheets().add("styles/TabelaDark.css");
        setTitle("Relatorio");
        setScene(conteudo);
        setOnCloseRequest(event -> operacaoDeSaida());
        show();
    }

    JanelaVerRelatorio(int largura, int altura)
    {
        definirLargura(largura);
        definirAltura(altura);
        inicializar();
    }
}

