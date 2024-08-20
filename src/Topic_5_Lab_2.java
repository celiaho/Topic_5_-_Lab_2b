/* *****************************************
 *  File : Topic_5_Lab_2.java
 *  Author : Celia Ho  
 *  Last Modified : Fri 5 April 2024
 *  Description : Create a JavaFX application with an attractive layout that allows the user to 
 *  enter a username into a textfield, a password into a password textfield, and the user's age 
 *  into a textfield, with a button to enter the data.  
 *      When the button is pressed, get the age from the textfield and add 5 to that value, and 
 *  store it in newAge. The username, password, and age should be written to a text label that says
 *  "Welcome username, your password is password, and in 5 years your age will be newAge." Write 
 *  the username, password, age, and newAge value to the console. Update the username, password, 
 *  and age textbox fields so they are again empty.
 *      The primary stage should have the title "LOGIN: " and your name.
 *  Learning Outcomes Assessed: 
 *      - JavaFX layouts
 *      - JavaFX Actions
 *      - JavaFX widgets
 * ******************************************/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Topic_5_Lab_2 extends Application {
    
    // MAIN METHOD
    public static void main(String[] args) throws Exception {
        launch(args);
    }
    
    // Class fields for scene
    Label usernameLabel, passwordLabel, ageLabel, welcomeLabel;
    TextField usernameTField, passwordTField, ageTField;
    Button submitButton;
    int newAge;
    Scene scene;
    Stage stage;
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;

        // Create an attractive layout
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));

        // Create widgets

        usernameLabel = new Label("Username: ");
        usernameTField = new TextField();

        passwordLabel = new Label("Password: ");
        passwordTField = new TextField();

        ageLabel = new Label("Age: ");
        ageTField = new TextField();

        submitButton = new Button("Submit");
        
        welcomeLabel = new Label();
        
        // Register the event handler (e -> buttonSubmitCLick()) with the Submit button: When the button is clicked, have the handler call the buttonSubmitClick method and pass the ActionEvent argument e to it
        submitButton.setOnAction(e -> buttonSubmitClick());
        
        // Add widgets to the pane
        vbox.getChildren().addAll(usernameLabel, usernameTField, passwordLabel, passwordTField, ageLabel, ageTField, submitButton, welcomeLabel);

        // Create a scene
        Scene scene = new Scene(vbox, 450, 225);
        // Set the scene
        primaryStage.setScene(scene);
        // Set primary stage with title "LOGIN: " and your name.
        primaryStage.setTitle("LOGIN: Celia Ho");
        // Show the stage
        primaryStage.show();
    }
    
    
    // Definition of buttonSubmitClick method to handle the button click event
    private void buttonSubmitClick() {

        // Extract user-entered values from text fields
        String username = usernameTField.getText();
        String password = passwordTField.getText();
        int age = Integer.parseInt(ageTField.getText());

        // Add 5 to the value entered into the age text field, add 5 to that value, and store it in newAge
        newAge = age + 5;

        // Test that the value in the age text field extracts properly
        // System.out.println("My age" + ageTField.getText());

        // Write username, password, and age to a text label that says "Welcome username, your password is password, and in 5 years your age will be newAge." 
        welcomeLabel.setText("\nWelcome " + usernameTField.getText() + ", your password is " + passwordTField.getText() + ", and in 5 years your age will be " + newAge + "."); 
    
        // Write the username, password, age, and newAge value to the console. 
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Age: " + age);
        System.out.println("New Age: " + newAge);

        // Update the username, password, and age textbox fields so they are again empty.
        usernameTField.setText("");
        passwordTField.setText("");
        ageTField.setText("");
    }
}