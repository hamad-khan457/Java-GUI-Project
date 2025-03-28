import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.awt.event.ActionEvent;
public class BalanceInquiryPanel extends JFrame {
    private JPanel mainPanel;
    private JLabel balanceLabel;
    private JLabel extraText;
    private JButton okButton;
    private int index;
    private int balance;
    static String singleCustomerData;
    public BalanceInquiryPanel() {
        super("Balance Inquiry");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        // call the 2d array
        FileHandler handle = new FileHandler();
        try{
            FileReader fr = new FileReader("index.txt");
            int firstChar = fr.read();
            fr.close();
            if (Character.isDigit(firstChar)) {
                index = Character.getNumericValue((char) firstChar);
            }
            singleCustomerData = handle.readLine("customerDataFile.txt", index);
            balance = handle.readSpecificBalance(index);
        }
        catch(Exception e){
            System.out.println("not found");
        }
        mainPanel = new JPanel();
        this.setResizable(false);
        add(mainPanel);
        System.out.println(index);
        balanceLabel = new JLabel("Current Balance:"+"     "+Integer.toString(balance));
        mainPanel.add(balanceLabel);

        extraText = new JLabel("         Click here to exit:");
        mainPanel.add(extraText);

        okButton = new JButton("OK");
        mainPanel.add(okButton);

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public String toString() {
        return "BalanceInquiryPanel [balanceLabel=" + balanceLabel.getText() 
            + ", extraText=" + extraText.getText() + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Same object reference
        if (obj == null || getClass() != obj.getClass()) return false; // Not same class
        BalanceInquiryPanel other = (BalanceInquiryPanel) obj;

        // Compare relevant fields for equality (consider which fields are important)
        return balanceLabel.getText().equals(other.balanceLabel.getText()) &&
            extraText.getText().equals(other.extraText.getText());
    }
}