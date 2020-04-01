import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import java.sql.SQLException;
import java.util.ArrayList;

public class AcaoConfirmarAdicionarBtn implements EventHandler<ActionEvent> {
    static ArrayList<String> pedidos = new ArrayList<>();

    @Override
    public void handle(ActionEvent event)
    {
        if(JanelaNovoPedido.telefoneTextField.getText().trim().length() == 0 &&
                JanelaNovoPedido.nomeTextField.getEditor().getText().trim().length() == 0)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Campos em branco");
            alert.showAndWait();
        }
		else if(JanelaNovoPedido.nomeTextField.getEditor().getText().trim().length() == 0)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor inserir nome");
            alert.show();
        }
        else if(JanelaNovoPedido.enderecoTextField.getText().trim().length() == 0)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor inserir endereco");
            alert.show();
        }
        else if(JanelaNovoPedido.telefoneTextField.getText().trim().length() == 0)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText( "Por favor inserir o numero de telefone");
            alert.show();
        }
        else if(JanelaNovoPedido.pedidoTextField.getText().trim().length() == 0)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText( "Por favor inserir o pedido");
            alert.show();
        }
        else
        {
            String tabela = "cliente" + JanelaNovoPedido.telefoneTextField.getText().trim();
            try
            {
                ConectarServidor.SQLStatement("CREATE TABLE IF NOT EXISTS " + tabela + "(NOME VARCHAR(255), " +
                        "TELEFONE INTEGER, PEDIDO VARCHAR(255), ENDERECO VARCHAR(255) );");
                ConectarServidor.SQLStatement("INSERT INTO " + tabela + " VALUES ( '" + JanelaNovoPedido.nomeTextField.getEditor().getText()
                 + "', '" + JanelaNovoPedido.telefoneTextField.getText().trim() + "', '" + JanelaNovoPedido.pedidoTextField.getText() +
                        "', '" + JanelaNovoPedido.enderecoTextField.getText() + "');");

                ConectarServidor.SQLStatement("INSERT INTO Usuario (nome, telefone, endereco) SELECT * FROM (SELECT '" +
                JanelaNovoPedido.nomeTextField.getEditor().getText() + "', '" + JanelaNovoPedido.telefoneTextField.getText() + "', '"
                + JanelaNovoPedido.enderecoTextField.getText() + "') AS tmp WHERE NOT EXISTS ( SELECT telefone FROM Usuario WHERE telefone = '" + JanelaNovoPedido.telefoneTextField.getText() + "') LIMIT 1;");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Pedido Adicionado");
                alert.show();
            }catch (SQLException e) {e.printStackTrace();}
        }
    }
}
