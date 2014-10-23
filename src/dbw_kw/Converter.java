package dbw_kw;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Converter {
    
    String version = "1.0";
    String author = "hibo98";
    JFrame converter = new JFrame("Leistungs Rechner by "+author+" v"+version);
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    Border delBorder = BorderFactory.createEtchedBorder();
    public JButton convert = new JButton("Konvertieren");
    public JButton deldbW = new JButton("X");
    public JButton delkW = new JButton("X");
    public JTextField dbW_a = new JTextField(15);
    public JTextField kW_a = new JTextField(15);
    public JLabel status_a = new JLabel();
    public double kW;
    public double dbW;
    private final MyActionListener AL = new MyActionListener(this);
    
    public Converter() {
        panel1.add(convert);
        panel2.add(new JLabel("dbW:"));
        panel2.add(dbW_a);
        panel2.add(deldbW);
        panel2.add(new JLabel("kW:"));
        panel2.add(kW_a);
        panel2.add(delkW);
        panel2.add(status_a);
        status_a.setText("Bereit!");
        convert.addActionListener(AL);
        deldbW.addActionListener(AL);
        deldbW.setBorder(delBorder);
        delkW.addActionListener(AL);
        delkW.setBorder(delBorder);
        converter.add(panel1,BorderLayout.NORTH);
        converter.add(panel2);
        converter.addWindowListener(new MyWindowListener());
        converter.setSize(200,190);
        converter.setLocation(200,200);
        converter.setResizable(false);
        converter.setVisible(true);
    }
}
