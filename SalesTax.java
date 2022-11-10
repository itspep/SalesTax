import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SalesTax extends JFrame {
    JTextField salesText;
    JLabel salesLabel;

    final double STATE_TAX = 0.04;
    final double COUNTY_TAX = 0.02;
    final int WIDTH = 250;
    final int HEIGHT = 120;
    JPanel panel;
    JButton button;

    public SalesTax() {
        setTitle("Sales Tax");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // build the panels
        buildPanel();
        add(panel);
        setVisible(true);
    }

    public void buildPanel() {
        salesLabel = new JLabel("Enter the total sales for the month:");
        salesText = new JTextField(10);
        button = new JButton("Calculate");
        // build the buttons action listener
        button.addActionListener(new ButtonListener());
        // create a panel object and the the components to it
        panel = new JPanel();
        panel.add(salesLabel);
        panel.add(salesText);
        panel.add(button);
    }

    // create the button listener class
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double Csales_tax, Ssales_tax, sales, totalSales;
            String input;
            input = salesText.getText();
            sales = Double.parseDouble(input);
            Csales_tax = sales * COUNTY_TAX;
            Ssales_tax = sales * STATE_TAX;
            totalSales = Csales_tax + Ssales_tax;
            JOptionPane.showMessageDialog(null,
                    "State Tax: " + Ssales_tax + "\nCounty Tax: " + Csales_tax + "\nTotal Sales Tax: " + totalSales);
        }
    }

    public static void main(String[] args) {
        new SalesTax();
    }
}