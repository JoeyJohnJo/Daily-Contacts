import java.sql.ResultSet;
import java.sql.SQLException;

class AcaoClickarTabela
{
    private void handle()
    {
        String coluna1 = "nome";
        String coluna2 = "telefone";
        String coluna3 = "pedido";
        if(!JanelaVerRelatorio.janelaAberta)
        {
            try
            {
                ResultSet rs = ConectarServidor.createQueryStatement("SELECT * FROM cliente" + JanelaVerClientes.rowData.getTelefone());
                while (rs.next())
                {
                    //loop to add each entry in the table to an array list
                    JanelaVerRelatorio.coluna1.add(rs.getString(coluna1));

                    //loop to add each entry in the table to an array list
                    JanelaVerRelatorio.coluna2.add(rs.getString(coluna2));

                    //loop to add each entry in the table to an array list
                    JanelaVerRelatorio.coluna3.add(rs.getString(coluna3));
                }
                //creates an array to put the values from the array list
                JanelaVerRelatorio.coluna1Array = new String[JanelaVerRelatorio.coluna1.size()];
                for (int iterate = 0; iterate < JanelaVerRelatorio.coluna1.size(); iterate++){
    
                    //loop that iterates through the array list and puts the values in the array
                    JanelaVerRelatorio.coluna1Array[iterate] = JanelaVerRelatorio.coluna1.get(iterate);
                    System.out.println(JanelaVerRelatorio.coluna1Array[iterate]); //prints to the console for testing purposes
                }
                JanelaVerRelatorio.coluna2Array = new String[JanelaVerRelatorio.coluna2.size()];
                for (int iterate = 0; iterate < JanelaVerRelatorio.coluna2.size(); iterate++){

                    //loop that iterates through the array list and puts the values in the array
                    JanelaVerRelatorio.coluna2Array[iterate] = JanelaVerRelatorio.coluna2.get(iterate);
                    System.out.println(JanelaVerRelatorio.coluna2Array[iterate]); //prints to the console for testing purposes
                }
                JanelaVerRelatorio.coluna3Array = new String[JanelaVerRelatorio.coluna3.size()];
                for (int iterate = 0; iterate < JanelaVerRelatorio.coluna3.size(); iterate++){

                    //loop that iterates through the array list and puts the values in the array
                    JanelaVerRelatorio.coluna3Array[iterate] = JanelaVerRelatorio.coluna3.get(iterate);
                    System.out.println(JanelaVerRelatorio.coluna3Array[iterate]); //prints to the console for testing purposes
                }
                new JanelaVerRelatorio(750, 400);
                JanelaVerRelatorio.janelaAberta = true;
                System.out.println("ID = " + JanelaVerRelatorio.id);
            }catch(SQLException a ){a.printStackTrace();}
        }
    }

    AcaoClickarTabela()
    {
        handle();
    }
}