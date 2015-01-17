package dbw_kw;

public class API {
    
    private static final Converter con = Converter.instance;
    
    public static void setStatus(String status) {
        con.status_a.setText(status);
    }
    
    public static Double getkW() {
        return Double.parseDouble(con.kW_a.getText());
    }
    
    public static void setkW(Double kW) {
        con.kW_a.setText(String.valueOf(kW));
    }
    
    public static void resetkW() {
        con.kW_a.setText("");
    }
    
    public static Double getdbW() {
        return Double.parseDouble(con.dbW_a.getText());
    }
    
    public static void setdbW(Double dbW) {
        con.dbW_a.setText(String.valueOf(dbW));
    }
    
    public static void resetdbW() {
        con.dbW_a.setText("");
    }
}
