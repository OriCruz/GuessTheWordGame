/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;


import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Oriana Cruz 
 * This file is created to be used as a template where the programmer
 * is able to create their own version of the program.
 * 
 * API Documentation and Examples inside the .ZIP file
 * 
 * Lines for programmer to change are labeled with CODE GOES HERE:
 * Uncomment code in the Start method and follow the API to create your own version 
 * of this game.
 */
public class GuessTheWordGame_Template extends API_GuessTheWordGame {
   //Global variables
    String currentWord;
    int sc;
    int currentScore = 0;
    @Override
    public void start(Stage primaryStage) {
        //To acces methods of the API use hmGame
        //API object
        API_GuessTheWordGame hmGame = new API_GuessTheWordGame();
        
         //Scene structure
        BorderPane bp = new BorderPane();
        //CODE GOES HERE:
        //Create an Image object with your background Image here (only URL)
        //Image img = 
        
        //CODE GOES HERE:
        //Create a scene - hmGame.createScene(bp, 0, 0, img)
        //Scene scene = 
        
        //CODE GOES HERE: 
        //create the GridPane - hmGame.wordBoxes("")
        //with the TextFields NOTE: no need to add a string to this method just add ""
        //GridPane gp = 
        
        //CODE GOES HERE:
         //Defines the currentWord - hmGame.cWord() 
        //currentWord = 
        
        
        //CODE GOES HERE:
        //Here the name and backgroundColor of the Buttons are defined to work along with Createbutton method
        //String Bname1 = "";
        //String Bstyle1 = "";

        //CODE GOES HERE:
        //Creates new button - hmGame.Createbutton(Bname1, Bstyle1)
        //Button newButton = 
       
        
        //Top box 
        VBox top = new VBox(5); // padding purposes no need to change unless wanted to
        HBox top1 = new HBox(10); // padding purposes no need to change unless wanted to

        //CODE GOES HERE: 
        //Creates a hint label and defines the font, color, and size of it.  
        //Label hintLabel = new Label(hmGame.getHint(""));
        //hintLabel.setFont(Font.font());
        //hintLabel.setTextFill();
        
        //CODE GOES HERE:
        //Creates a score label and defines the font, color, and size of it.  
        // Label scoreLabel = new Label("Score: ");
        // scoreLabel.setFont(Font.font());
        //scoreLabel.setTextFill();
        
        //CODE GOES HERE:
        //Creates a points label and defines the font, color, and size of it. 
        //Label points = new Label(sc + "");
        //points.setFont(Font.font());
        //points.setTextFill();
        
        // Button functionality
        //Set newWord to what you named your button
        //buttonName.setOnAction((ActionEvent e) -> {
            //CODE GOES HERE:
            //Re-defines the currentWord - hmGame.cWord(); everytime a button is clicked. 
            // currentWord = 
            //Tt sets the wordBoxes - wordBoxes(currentWord) to the center of the BorderPane
            //bp.setCenter();
            //Set the text of the hintLabel - getHint(currentWord) to the currentWord hint
            //hintLabel.setText();
        //});

        //Set newWord to what you named your button
        //buttonName.setOnAction((ActionEvent e) -> {
            //CODE GOES HERE:
            //Sets the currentScore by calling guessWord(),
            //passing currentWord and currentScore(initially set to 0)
            //currentScore = guessWord();
            //points.setText(currentScore + "");
            
        //});
        //Optional close button. 
        //buttonName.setOnAction((ActionEvent e) -> {
           System.exit(0);
        //});
        
        //NOTE: all syntax issues will resolve once the code above is complete. 
        //Aligning the labels
        top.setAlignment(Pos.CENTER);
        top1.setAlignment(Pos.CENTER);
        
        //Adding the label to both the HBox and VBox
        top1.getChildren().addAll(scoreLabel, points);
        top.getChildren().addAll(top1);
        top.getChildren().add(hintLabel);
        
        //Horizontal Box
        HBox hb = new HBox(10);
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(newWord, guess, close);
        
        bp.setBottom(hb);
        bp.setTop(top);
        bp.setCenter(gp);
        
        
        primaryStage.setTitle("Hangman Game!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
