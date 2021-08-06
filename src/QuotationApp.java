import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.FileWriter;


public class QuotationApp extends JFrame{
    private JPanel mainPanel;
    private JTextField quotationTitleTextField;
    private JButton businessSubmitButton;
    private JButton customerSubmitButton;
    private JList businessQuotationList;
    private JComboBox categoryComboBox;
    private JTextField quotationStatusTextField;
    private JCheckBox emergencyCheckBox;
    private JCheckBox financialCheckBox;
    private JLabel businessSideLabel;
    private JTextField quotationDescriptionTextField;
    private JLabel customerSideLabel;
    private JLabel customerSubmitStatusLabel;
    private JLabel businessSubmitStatusLabel;
    private JScrollBar scrollBar1;
    private static FileWriter file;

    public QuotationApp(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();


        customerSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get all the info
                // push them to .json



                // check for empty textfield
                if (quotationTitleTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"ERROR: QUOTATION TITLE IS EMPTY!");
                }
                else if (quotationDescriptionTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ERROR: QUOTATION DESCRIPTION IS EMPTY!");
                }
                else if (categoryComboBox.getSelectedItem().toString().equals("Choose a category")) {
                    JOptionPane.showMessageDialog(null,"ERROR: CHOOSE A CATEGORY!");
                }
                else {

                    String quotationTitle = quotationTitleTextField.getText();
                    String quotationDescription = quotationDescriptionTextField.getText();
                    String category = categoryComboBox.getSelectedItem().toString();
                    Boolean emergencyStatus = emergencyCheckBox.isSelected();
                    Boolean financialStatus = financialCheckBox.isSelected();


                    JSONObject quotation = new JSONObject();
                    quotation.put("Title", quotationTitle);
                    quotation.put("Description", quotationDescription);
                    quotation.put("Category", category);
                    quotation.put("EmergencyStatus", emergencyStatus);
                    quotation.put("FinancialStatus", financialStatus);

                    JSONArray quotationList = new JSONArray();
                    quotationList.add(quotation);

                    try {

                        // Constructs a FileWriter given a file name, using the platform's default charset
                        file = new FileWriter("./src/quotationList.json", true);
                        file.append(quotationList.toJSONString());
                        file.flush();
                        file.close();

                        // submission successful message and clear it after 3 secs


                        try {
                            customerSubmitStatusLabel.setText("Submitted!");
                            sleep(1000);
                            customerSubmitStatusLabel.setText("");
                        } catch (InterruptedException s) {
                            System.out.print(s);
                        }

                    } catch ( IOException c) {
                        c.printStackTrace();
                    }
                }
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new QuotationApp("B2C Quotation App");
        frame.setBounds(400, 100, 1000, 800);
        frame.setVisible(true);
    }
}
