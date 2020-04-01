import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
    public  static void main(String[] args)
    {
        ConectarServidor bancoDeDados = new ConectarServidor();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        MenuPrincipal dc = new MenuPrincipal(750,500);
    }
}