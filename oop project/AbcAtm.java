import java.awt.*;
import javax.swing.*;

public class AbcAtm extends JFrame {
    public AbcAtm() {
        super("ATM");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JLabel welcomeLabel = new JLabel("Welcome to ATM");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center label
        add(Box.createVerticalStrut(20)); // Add spacing above label
        add(welcomeLabel);
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Arial", Font.PLAIN, 18));
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center button
        add(Box.createVerticalStrut(30)); // Add spacing between buttons
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 18));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center button
        registerButton.addActionListener(e -> {dispose(); RegisterButton(); });
        loginButton.addActionListener(e -> {dispose(); LoginButton(); });
        add(registerButton);
        add(loginButton);
        getContentPane().setBackground(Color.GRAY);
        ((JComponent)getContentPane()).setBorder(BorderFactory.createMatteBorder(50, 50, 50, 50, Color.GRAY));
        setSize(400, 300); // Set initial window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void LoginButton(){
        Login login = new Login();
        login.LoginPage();
    }
    public static void RegisterButton(){
        Register reg = new Register();
        reg.RegisterPage();
    }

    public static void main(String[] args) {
        new AbcAtm();
    }
}


    // public static void main(String[] args) {
    //     Login login = new Login();
    //     login.LoginPage();
    //     Register reg = new Register();
    //     reg.RegisterPage();
    // }