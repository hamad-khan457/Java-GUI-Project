import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Register{
    private String pin;
    private String name;
    private String initialDeposit;
    public void RegisterPage(){
        JFrame frame = new JFrame("Register");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel initialDepositLabel = new JLabel("Initial Deposit amount:");
        JTextField initialDepositField = new JTextField();
        JLabel passwordLabel = new JLabel("4-Digit pin:");
        JPasswordField passwordField = new JPasswordField();
        JButton registerButton = new JButton("Register");
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(initialDepositLabel);
        panel.add(initialDepositField);
        panel.add(registerButton);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name = nameField.getText();
                pin = new String(passwordField.getPassword());
                initialDeposit = initialDepositField.getText();
                int lineCount = 0;
                try (Scanner scanner = new Scanner(new File("customerDataFile.txt"))) {
                    while (scanner.hasNextLine()) {
                        scanner.nextLine();
                        lineCount++;
                    }
                } catch (FileNotFoundException ea) {
                    ea.printStackTrace();
                }
                lineCount++;
                String[] customerData = new String[lineCount];
                try {
                    FileHandler handle = new FileHandler();
                    customerData = handle.readFullFile();
                } catch (Exception eq) {
                    System.out.println("problem"+ eq);
                }
                long lastCustomerCreditNumber = Long.parseLong(customerData[customerData.length-1].substring(0,16));
                long newlyRegisteredCreditNumber = lastCustomerCreditNumber + 1;
                String newlyRegisteredCustomerData = Long.toString(newlyRegisteredCreditNumber) + "," + pin + "," + name;
                lineCount--;
                customerData[lineCount-1] = newlyRegisteredCustomerData;
                try(FileWriter writer = new FileWriter("customerDataFile.txt", true)){
                    writer.write("\n"+newlyRegisteredCustomerData);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                try (FileWriter writer = new FileWriter("customerBalanceFile.txt", true)) {
                    writer.write("\n"+initialDeposit);
                } catch (IOException es) {
                    es.printStackTrace();
                }
                frame.dispose();
                Login login = new Login();
                login.LoginPage();
                JOptionPane.showMessageDialog(panel,
                        "Your account has been registered successfully! \nYour credit card number is" + newlyRegisteredCreditNumber,
                        "Error", JOptionPane.WARNING_MESSAGE);
                    return;
            }
        });
        frame.add(panel);
        frame.setVisible(true);
    }

}
