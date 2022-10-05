import javax.swing.*;

public class ClientGUI extends JFrame {

    JButton send, listaeventi;
    JTextField event, num;
    JLabel result;


    public ClientGUI(){
        super("Client space");

        JLabel tname = new JLabel("Insert Event Name");
        event = new JTextField(20);
        event.setLayout(null);

        JLabel tnumber = new JLabel("Number of seats");
        num = new JTextField(20);
        num.setLayout(null);

        send = new JButton("Send prenotation");
        send.setLayout(null);
        result = new JLabel("");
        listaeventi=new JButton("List events");
        listaeventi.setLayout(null);


        //client interface
        Client clientInterface  = new Client(this);
        send.addActionListener(clientInterface);
        listaeventi.addActionListener(clientInterface);

        JPanel Panel = new JPanel();
        Panel.add(tname);
        Panel.add(event);
        Panel.add(tnumber);
        Panel.add(num);
        Panel.add(send);
        Panel.add(listaeventi);
        Panel.add(result);

        getContentPane().add(Panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setSize(400, 200);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
