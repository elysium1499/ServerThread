import javax.swing.*;

public class AdminGUI extends JFrame {

    JButton crea, aggiungi, chiudi, listaeventi;
    JTextField event, num;
    JLabel result;


    public AdminGUI(){
        super("Admin space");

        JLabel tname = new JLabel("Insert Event Name");
        event = new JTextField(20);
        event.setLayout(null);

        JLabel tnumber = new JLabel("Number of seats");
        num = new JTextField(20);
        num.setLayout(null);

        crea = new JButton("Create new Event");
        crea.setLayout(null);

        listaeventi=new JButton("List events");
        listaeventi.setLayout(null);

        aggiungi=new JButton("Add seats Event");
        aggiungi.setLayout(null);

        chiudi=new JButton("Close Event");
        chiudi.setLayout(null);

        result = new JLabel("");

        Admin adminInterface  = new Admin(this);
        aggiungi.addActionListener(adminInterface);
        listaeventi.addActionListener(adminInterface);
        crea.addActionListener(adminInterface);
        chiudi.addActionListener(adminInterface);

        JPanel Panel = new JPanel();
        Panel.add(tname);
        Panel.add(event);
        Panel.add(tnumber);
        Panel.add(num);
        Panel.add(listaeventi);
        Panel.add(crea);
        Panel.add(aggiungi);
        Panel.add(chiudi);

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