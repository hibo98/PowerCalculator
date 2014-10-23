package dbw_kw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
    public Converter con;
    
    public MyActionListener(Converter converter) {
        this.con=converter;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == con.convert) {
            // dbW -> kW
            if ( con.kW_a.getText().equals("") && !con.dbW_a.getText().equals("") ) {
                con.status_a.setText("Konvertiere...");
                con.dbW = Double.parseDouble(con.dbW_a.getText());
                con.kW = (Math.pow(10,(con.dbW/10))/1000);
                con.kW_a.setText(String.valueOf(con.kW));
                con.status_a.setText("Fertig!");
            }
            // kW -> dbW
            else if ( con.dbW_a.getText().equals("") && !con.kW_a.getText().equals("") ) {
                con.status_a.setText("Konvertiere...");
                con.kW = Double.parseDouble(con.kW_a.getText());
                con.dbW = (Math.round((10*Math.log10((con.kW*1000)))*100))/100;
                con.dbW_a.setText(String.valueOf(con.dbW));
                con.status_a.setText("Fertig!");
            }
            else {
                con.status_a.setText("Bitte nur ein Feld ausfüllen!");
            }
        }
        else if (e.getSource() == con.deldbW) {
            con.dbW_a.setText("");
        }
        else if (e.getSource() == con.delkW) {
            con.kW_a.setText("");
        }
    }
}