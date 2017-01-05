package me.hibo98.power_calc;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class PowerCalculator extends JFrame {

    private final String version = "1.5";
    private final JPanel panel = new JPanel();
    private final JPanel statusPanel = new JPanel();
    public JButton calculate = new JButton("Calculate");
    public JTextField dbW = new JTextField(15);
    public JTextField kW = new JTextField(15);
    public JLabel status = new JLabel("STATUS: Ready");

    public PowerCalculator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(205, 190);
        setLocation(200, 200);
        setResizable(false);
        setVisible(true);
        setTitle("Power Calc by hibo98 v" + version);
        panel.add(new JLabel("dbW:"));
        panel.add(dbW);
        dbW.addActionListener((e) -> {
            setkW(Math.pow(10, getdbW() / 10) / 1000);
            status.setText("STATUS: Ready");
        });
        panel.add(new JLabel("kW:"));
        panel.add(kW);
        kW.addActionListener((e) -> {
            setdbW(10 * Math.log10(getkW() * 1000));
            status.setText("STATUS: Ready");
        });
        calculate.addActionListener((e) -> {
            if (kW.getText().isEmpty() && !dbW.getText().isEmpty()) {
                // dbW -> kW
                setkW(Math.pow(10, getdbW() / 10) / 1000);
            } else if (dbW.getText().isEmpty() && !kW.getText().isEmpty()) {
                // kW -> dbW
                setdbW(10 * Math.log10(getkW() * 1000));
            } else if (!dbW.getText().isEmpty() && !kW.getText().isEmpty()) {
                status.setText("STATUS: Type only into one field!");
                return;
            }
            status.setText("STATUS: Ready");
        });
        statusPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        statusPanel.setSize(getWidth(), 16);
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        statusPanel.add(status);
        status.setHorizontalAlignment(SwingConstants.LEFT);
        add(calculate, BorderLayout.NORTH);
        add(panel);
        add(statusPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new PowerCalculator();
    }

    public Double getkW() {
        return Double.parseDouble(kW.getText().replaceAll(",", "."));
    }

    public Double getdbW() {
        return Double.parseDouble(dbW.getText().replaceAll(",", "."));
    }

    public void setkW(Double kW) {
        this.kW.setText(String.valueOf(kW));
    }

    public void setdbW(Double dbW) {
        this.dbW.setText(String.valueOf(dbW));
    }
}
