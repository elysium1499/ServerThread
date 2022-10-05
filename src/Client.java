import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements ActionListener {
    private ClientGUI gui;
    private Socket socket;

    public Client(ClientGUI gui) {
        this.gui = gui;
        try{
            this.socket = new Socket("localhost", 1345);
        } catch (IOException e) {
            System.out.println("Connection server Error");
            System.exit(0);
        }
    }

    private String response(BufferedReader in){
        String l=null;
        try {
            while (l == null) {
                l = in.readLine();
            }
        }catch (IOException ex){
            System.out.println("Server close connection");
            l ="Client close connection, retry to connect";
        }
        return l;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        PrintWriter out = null;
        BufferedReader in= null;

        try{
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String line = null;

        if ("Send prenotation".equals(ev.getActionCommand())) {

            String nome = gui.event.getText().trim();
            int posti;

            try {
                posti = Integer.parseInt(gui.num.getText().trim());
            } catch (NumberFormatException e) {
                posti = 0;
            }

            out.println("Prenota");
            out.println(nome);
            out.println(posti);
            out.flush();

            line= response(in);

            gui.event.setText("");
            gui.num.setText("");
            gui.result.setText(line);
        }

        if("List events".equals(ev.getActionCommand())) {

            out.println("ListaEventi");
            out.flush();

            line= response(in);

            gui.event.setText("");
            gui.num.setText("");
            gui.result.setText(line);
        }
    }
}



