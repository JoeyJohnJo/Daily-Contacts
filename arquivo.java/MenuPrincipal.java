import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

class MenuPrincipal extends Stage
{
    private int larguraJanela, alturaJanela;
    private Button verClientes = new Button();
    private Button adicionar = new Button();
    private HBox layoutBotoes; //Botoes Cliente e Relatorio
    private BorderPane base = new BorderPane(); // Adicionar o layout aqui para aparecer na janela

    void definirLarguraJanela(int largura)
    {
        larguraJanela = largura;
    }
    void definirAlturaJanela(int altura)
    {
        alturaJanela = altura;
    }
    int getLarguraJanela()
    {
        return larguraJanela;
    }
    int getAlturaJanela()
    {
        return alturaJanela;
    }

    //Modificar tudo em relacao ao botao na sua devida funcao
    private void definirBotaoVerCliente() //Modificar botao verClientes aqui
    {
        verClientes.setText("Clientes");
        verClientes.setOnAction(new AcaoVerClientesBtn());
    }
    private void definirBotaoAdicionar()
    {
        adicionar.setText("Adicionar");
        adicionar.setOnAction(new AcaoAdicionarBtn());
    }

    private void definirLayout() //Adicionar componentes aqui
    {
        layoutBotoes = new HBox(5); //Mudar o numero para alterar o espacamento
        layoutBotoes.getChildren().add(verClientes);
        layoutBotoes.getChildren().add(adicionar);
        layoutBotoes.setAlignment(Pos.CENTER); //Modificar o Pos para mudar a posicao

        base.setCenter(layoutBotoes); //Nao deletar essa linha, se nao o componente nao aparece na janela
    }

    private void inicializar()
    {
        definirBotaoVerCliente();
        definirBotaoAdicionar();
        definirLayout();
        Scene conteudo = new Scene(base, getLarguraJanela(),getAlturaJanela());
        conteudo.getStylesheets().add("styles/MenuPrincipalDark.css");
        setTitle("Daily Contacts");
        setScene(conteudo);
        show();

    }

    MenuPrincipal(int largura, int altura) //Construtor (E isto que deve ser invocado para inicializar a classe)
    {
        definirLarguraJanela(largura);
        definirAlturaJanela(altura);
        inicializar();
    }
}