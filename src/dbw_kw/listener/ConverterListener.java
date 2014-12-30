package dbw_kw.listener;

import dbw_kw.API;
import dbw_kw.Converter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterListener implements ActionListener {

    private final Converter con;

    public ConverterListener(Converter converter) {
        this.con = converter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == con.convert) {
            if (con.kW_a.getText().equals("") && !con.dbW_a.getText().equals("")) {
                // dbW -> kW
                API.setStatus("Konvertiere...");
                API.setkW(Math.pow(10, (API.getdbW() / 10)) / 1000);
                API.setStatus("Fertig!");
            } else if (con.dbW_a.getText().equals("") && !con.kW_a.getText().equals("")) {
                // kW -> dbW
                API.setStatus("Konvertiere...");
                API.setdbW((Math.round((10 * Math.log10((API.getkW() * 1000))) * 100)) / 100);
                API.setStatus("Fertig!");
            } else if (con.dbW_a.getText().equals("") && con.kW_a.getText().equals("")) {
                API.setStatus("Bitte ein Feld ausfüllen!");
            } else {
                API.setStatus("Bitte nur ein Feld ausfüllen!");
            }
        } else if (e.getSource() == con.deldbW) {
            API.resetdbW();
        } else if (e.getSource() == con.delkW) {
            API.resetkW();
        }
    }
}
