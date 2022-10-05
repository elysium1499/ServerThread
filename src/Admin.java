import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Admin implements ActionListener{
    private AdminGUI gui;
    private Socket socket;

    public Admin(AdminGUI gui) {
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

        if ("Create new Event".equals(ev.getActionCommand())) {

            String nome = gui.event.getText().trim();
            int posti;

            try {
                posti = Integer.parseInt(gui.num.getText().trim());
            } catch (NumberFormatException e) {
                posti = 0;
            }

            out.println("Crea");
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

        if ("Add seats Event".equals(ev.getActionCommand())) {

            String nome = gui.event.getText().trim();
            int posti;

            try {
                posti = Integer.parseInt(gui.num.getText().trim());
            } catch (NumberFormatException e) {
                posti = 0;
            }

            out.println("Aggiungi");
            out.println(nome);
            out.println(posti);
            out.flush();

            line= response(in);

            gui.event.setText("");
            gui.num.setText("");
            gui.result.setText(line);
        }

        if ("Close Event".equals(ev.getActionCommand())) {

            String nome = gui.event.getText().trim();

            out.println("Chiudi");
            out.println(nome);
            out.flush();

            line= response(in);

            gui.event.setText("");
            gui.num.setText("");
            gui.result.setText(line);
        }
    }
}
