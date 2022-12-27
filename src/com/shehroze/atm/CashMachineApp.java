package com.shehroze.atm;

import com.shehroze.atm.bank.Bank;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class CashMachineApp extends Application {

    private TextField field = new TextField();
    private TextField textField=new TextField();

    private CashMachine cashMachine = new CashMachine(new Bank());

    private Parent createContent() {
        VBox vbox = new VBox(10);
        vbox.setPrefSize(600, 600);
        vbox.setBackground(Background.fill(Color.BLACK));
        field.setText("Card Detected Successfully Enter Your Pin:");
        field.setFont(Font.font("Bold", 30));
        field.setBackground(Background.fill(Color.SNOW));
        field.setMaxHeight(50);
        field.setMinHeight(50);


        TextArea areaInfo = new TextArea();
        areaInfo.setBackground(Background.fill(Color.BLUE));


        Button btnSubmit = new Button("Submit");
        btnSubmit.setOnAction(e -> {
            int id = Integer.parseInt(textField.getText());
            cashMachine.login(id);

            areaInfo.setText(cashMachine.toString());
            btnSubmit.setTextFill(Color.BLUE);
        });

        Button btnDeposit = new Button("Deposit");
        btnDeposit.setOnAction(e -> {
            int amount = Integer.parseInt(textField.getText());
            cashMachine.deposit(amount);

            areaInfo.setText(cashMachine.toString());
            btnDeposit.setTextFill(Color.BLUE);
        });

        Button btnWithdraw = new Button("Withdraw");
        btnWithdraw.setOnAction(e -> {
            int amount = Integer.parseInt(textField.getText());
            cashMachine.withdraw(amount);

            areaInfo.setText(cashMachine.toString());
            btnWithdraw.setTextFill(Color.BLUE);
        });

        Button btnExit = new Button("Exit");
        btnExit.setOnAction(e -> {
            cashMachine.exit();

            areaInfo.setText(cashMachine.toString());
        });

        vbox.getChildren().addAll(field,textField, btnSubmit, btnDeposit, btnWithdraw, btnExit, areaInfo);
        return vbox;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("ATM Machine");
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}