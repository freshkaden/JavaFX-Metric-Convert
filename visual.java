import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class visual extends Application{

    // where user will be able to input value
    public TextField inputField;
    // how the output can be displayed to user
    public Label outputLabel;
    // how the input instructions can be displayed
    public Label inputLabel;
    // let user choose which type of conversion they want by implementing a option box with the available options
    public ChoiceBox<String> conversionChoice = new ChoiceBox<>();

    public static void main(String[] args){


        launch(args);
    }

    public void start(Stage primaryStage){
        primaryStage.setTitle("Metric Converter");

        inputField = new TextField();
        inputField.setPromptText("Input Value: ");
        inputLabel = new Label();
        inputLabel.setText("Input number value in text box");

        //ChoiceBox<String> conversionChoice = new ChoiceBox<>();
        conversionChoice.getItems().addAll("kg to lbs", "kilometers to miles", "Celsius to Fahrenheit", "milimeters to inches");
        

        conversionChoice.setValue("kg to lbs");

        Button convertButton = new Button("Convert!");
        outputLabel = new Label();

        VBox layout = new VBox(10);
        layout.getChildren().addAll(inputField, inputLabel, conversionChoice, convertButton, outputLabel);

        convertButton.setOnAction(e -> convert());

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);

        primaryStage.show();


    }

    private void convert(){
        try{
            double input = Double.parseDouble(inputField.getText());
            String conversionType = conversionChoice.getValue();
            double result = Conversion(input, conversionType);

            // finally output the calculated conversion value to the user with proper formatting
            outputLabel.setText("Result: " + result + " " + resultType);


        }
        
        // error handling if user inputs a non numeric number or has a space or etc
        catch (NumberFormatException e){
            outputLabel.setText("Invalid number");

        }

    }


    // so after the result is output the user will know the units of the result
    public String resultType = "";

    private double Conversion(double value, String conversionType){
        switch (conversionType){
            case "kg to lbs":
                resultType = "lbs";    
                return value * 2.2046;
                
            
            case "kilometers to miles":
                resultType = "miles";
                return value * 0.62137;

            case "Celsius to Fahrenheit":
                resultType = "F";
                return (value * 1.8) + 32;
            
            case "milimeters to inches":
                resultType = "inches";
                return value * 0.03937;
            
            default:
                return 0.00;
        }
    }
}
