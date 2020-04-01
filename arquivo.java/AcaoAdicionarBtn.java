import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AcaoAdicionarBtn implements EventHandler<ActionEvent>
{
    @Override
    public void handle(ActionEvent event)
    {
        if(!JanelaNovoPedido.janelaAberta)
        {
            new JanelaNovoPedido(750,300);
            JanelaNovoPedido.janelaAberta = true;
        }
    }
}
