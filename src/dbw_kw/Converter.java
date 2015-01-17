package dbw_kw;

import dbw_kw.listener.WindowListener;
import dbw_kw.listener.ConverterListener;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Converter {

    public static Converter instance;
    private final String version = "1.3";
    private final String author = "hibo98";
    private final JFrame converter = new JFrame("Leistungs Rechner by " + author + " v" + version);
    private final JPanel panel1 = new JPanel();
    private final JPanel panel2 = new JPanel();
    public JButton convert = new JButton("Konvertieren");
    public JButton deldbW = new JButton("X");
    public JButton delkW = new JButton("X");
    public JTextField dbW_a = new JTextField(15);
    public JTextField kW_a = new JTextField(15);
    public JLabel status_a = new JLabel();
    private final ConverterListener AL = new ConverterListener(this);

    public Converter() {
        panel1.add(convert);
        panel2.add(new JLabel("dbW:"));
        panel2.add(dbW_a);
        dbW_a.addActionListener(AL);
        panel2.add(deldbW);
        panel2.add(new JLabel("kW:"));
        panel2.add(kW_a);
        kW_a.addActionListener(AL);
        panel2.add(delkW);
        panel2.add(status_a);
        convert.addActionListener(AL);
        deldbW.addActionListener(AL);
        deldbW.setBorder(BorderFactory.createEtchedBorder());
        delkW.addActionListener(AL);
        delkW.setBorder(BorderFactory.createEtchedBorder());
        converter.add(panel1, BorderLayout.NORTH);
        converter.add(panel2);
        converter.addWindowListener(new WindowListener());
        converter.setSize(200, 190);
        converter.setLocation(200, 200);
        converter.setResizable(false);
        converter.setVisible(true);
        status_a.setText("Bereit!");
    }
    
    public static void main(String[] args) {
        instance = new Converter();
    }
}
