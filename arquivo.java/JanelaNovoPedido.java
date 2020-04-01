import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.ResultSet;
import java.sql.SQLException;

class JanelaNovoPedido extends Stage
{
    static boolean janelaAberta;
    private int largura;
    private  int altura;
    private VBox empilhar = new VBox(20); // Adicionar tabela aqui para aparecer na janela
    private BorderPane base = new BorderPane();

    private Label nomeLabel = new Label("Nome:");
    static ComboBox<String> nomeTextField = new ComboBox<>();
    private Label telefoneLabel = new Label("Telefone:");
    static TextField telefoneTextField = new TextField();
    private Label pedidoLabel = new Label("Pedido:");
    static TextField pedidoTextField;
    private Button confirmButton = new Button("Confirmar");
    private Button cancelButton = new Button("Cancelar");
    private Label enderecoLabel = new Label("Endereco: ");
    static TextField enderecoTextField;
    private static HBox innerPanel;
    private HBox cancelConfirmPanel;

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
        close();
        janelaAberta = false; // Se for falso, pode ser aberta novamente, se for verdadeiro nao pode
        //Sempre que abre a janela se torna verdadeiro, sempre que fecha se torna falso
    }

    private ObservableList<String> getClientes()
    {
        String tabela = "Usuario";
        String coluna = "nome";
        ObservableList<String> listaClientes  = FXCollections.observableArrayList();
        try
        {
            ResultSet rs = ConectarServidor.createQueryStatement("SELECT * FROM " + tabela);
            while (rs.next()) {
                listaClientes.add(rs.getString(coluna));
            }

        }catch(SQLException e){e.printStackTrace();}
        return listaClientes;
    }
    private void setNomeTextFieldProperties()
    {
        nomeTextField.setEditable(true);
        nomeTextField.setPromptText("Nome do cliente");
        nomeTextField.setItems(getClientes());
        nomeTextField.setMinSize(200, 20);
    }
    private void definirPedido()
    {
        pedidoTextField = new TextField();
        pedidoTextField.setEditable(true);
        pedidoTextField.setMinSize(200, 20);

        enderecoTextField = new TextField();
        enderecoTextField.setEditable(true);
        enderecoTextField.setMinSize(200, 20);
    }
    private void setCancelConfirmProperties()
    {
        cancelConfirmPanel = new HBox(20);
        cancelConfirmPanel.setAlignment(Pos.CENTER);
        confirmButton.setOnAction(new AcaoConfirmarAdicionarBtn());
        confirmButton.setMinSize(200, 20);

        cancelButton.setOnAction(e -> {
                nomeTextField.setEditable(true);
            AcaoConfirmarAdicionarBtn.pedidos.clear();
            close();
            janelaAberta = false;
        });
        cancelButton.setMinSize(200, 20);
        cancelConfirmPanel.getChildren().add(confirmButton);
        cancelConfirmPanel.getChildren().add(cancelButton);
    }
    private void setContentPanelProperties()
    {
        nomeLabel.setMinSize(120, 20);
        telefoneLabel.setMinSize(120, 20);
        pedidoLabel.setMinSize(120, 20);
        telefoneTextField.setMinSize(120, 20);
        enderecoLabel.setMinSize(120, 20);

        innerPanel = new HBox(20);
        HBox in = new HBox(20);
        HBox i = new HBox(20);
        HBox v = new HBox(20);

        innerPanel.getChildren().add(nomeLabel);
        innerPanel.getChildren().add(nomeTextField);
        in.getChildren().add(telefoneLabel);
        in.getChildren().add(telefoneTextField);
        i.getChildren().add(pedidoLabel);
        i.getChildren().add(pedidoTextField);
        v.getChildren().add(enderecoLabel);
        v.getChildren().add(enderecoTextField);
        empilhar.getChildren().addAll(innerPanel, in, i, v);
    }

    private void inicializar()
    {
        base.getChildren().add(empilhar);
        setNomeTextFieldProperties();
        definirPedido();
        setCancelConfirmProperties();
        setContentPanelProperties();
        base.setBottom(cancelConfirmPanel);
        Scene conteudo = new Scene(base, getLargura(), getAltura());
        conteudo.getStylesheets().add("styles/JanelaNovoPedidoDark.css");
        setTitle("Novo Pedido");
        setScene(conteudo);
        setOnCloseRequest(event -> operacaoDeSaida());
        show();
    }
    JanelaNovoPedido(int largura, int altura)
    {
        definirLargura(largura);
        definirAltura(altura);
        inicializar();
    }
}