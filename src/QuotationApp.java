import javax.swing.*;

public class QuotationApp extends JFrame{
    private JPanel mainPanel;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JList list1;
    private JComboBox comboBox1;
    private JTextField textField2;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;

    public QuotationApp(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();


    }

    public static void main(String[] args) {
        JFrame frame = new QuotationApp("B2C Quotation App");
        frame.setBounds(400, 100, 1000, 800);
        frame.setVisible(true);
    }
}
