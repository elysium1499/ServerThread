import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame implements ActionListener {

    JButton admin, user;

    public LoginGUI(){
        super("Client-Server event");

        JLabel intro = new JLabel("Are you Admin or User?");
        intro.setLayout(null);

        admin = new JButton("Admin");
        admin.setLayout(null);

        user=new JButton("User");
        user.setLayout(null);

        admin.addActionListener(this);
        user.addActionListener(this);

        JPanel Panel = new JPanel();
        Panel.add(intro);
        Panel.add(admin);
        Panel.add(user);

        getContentPane().add(Panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setSize(400, 200);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(user)) {
            this.dispose();
            ClientGUI client = new ClientGUI();
            client.setVisible(true);

        }

        if (e.getSource().equals(admin)) {
            this.dispose();
            AdminGUI client = new AdminGUI();
            client.setVisible(true);

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginGUI();
            }
        });
    }
}
