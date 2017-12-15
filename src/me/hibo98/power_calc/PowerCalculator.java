package me.hibo98.power_calc;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PowerCalculator extends Application {

    private final String version = "2.0";
    private final TextField dbW = new TextField();
    private final TextField kW = new TextField();
    private final Label status = new Label();

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(15));
        gp.setHgap(15);
        gp.setVgap(15);
        Button calculate = new Button("Calculate");
        calculate.setOnAction((e) -> {
            status.setText("");
            if (kW.getText().isEmpty() && !dbW.getText().isEmpty()) {
                // dbW -> kW
                kW.setText(String.valueOf(Math.pow(10, getdbW() / 10) / 1000));
            } else if (dbW.getText().isEmpty() && !kW.getText().isEmpty()) {
                // kW -> dbW
                dbW.setText(String.valueOf(10 * Math.log10(getkW() * 1000)));
            } else if (!dbW.getText().isEmpty() && !kW.getText().isEmpty()) {
                status.setText("STATUS: Type only into one field!");
            }
        });
        gp.add(new StackPane(calculate), 0, 0, 2, 1);
        gp.add(new Label("dbW:"), 0, 1);
        dbW.setOnAction((e) -> {
            status.setText("");
            kW.setText(String.valueOf(Math.pow(10, getdbW() / 10) / 1000));
        });
        gp.add(dbW, 1, 1);
        gp.add(new Label("kW:"), 0, 2);
        kW.setOnAction((e) -> {
            status.setText("");
            dbW.setText(String.valueOf(10 * Math.log10(getkW() * 1000)));
        });
        gp.add(kW, 1, 2);
        gp.add(status, 0, 3, 2, 1);
        bp.setCenter(gp);
        stage.setScene(new Scene(bp));
        stage.setTitle("Power Calc " + version);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public double getkW() {
        return Double.parseDouble(kW.getText().replaceAll(",", "."));
    }

    public double getdbW() {
        return Double.parseDouble(dbW.getText().replaceAll(",", "."));
    }
}
