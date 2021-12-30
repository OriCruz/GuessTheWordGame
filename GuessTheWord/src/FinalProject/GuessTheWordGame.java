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
 * @author oc080
 */
public class GuessTheWordGame extends API_GuessTheWordGame {
    //Global variables 
    String currentWord;
    int sc;
    int currentScore = 0;
    @Override
    public void start(Stage primaryStage) {
         //API object
        API_GuessTheWordGame hmGame = new API_GuessTheWordGame();
        
         //Scene structure
        BorderPane bp = new BorderPane();
        Image bg = new Image("https://www.teahub.io/photos/full/361-3611543_videogame-pixel-background-animation-free-footage-hd-video.jpg");
        Scene scene = hmGame.createScene(bp, 700, 300, bg);
        GridPane gp = hmGame.wordBoxes("");

        //Buttons
        String Bname1 ="NEW WORD";
        String Bstyle1 = "-fx-background-color: #ADD8E6;";
        String Bname2 = "CHECK WORD";
        String Bstyle2 = "-fx-background-color: #32CD32;";
        String Bname3 = "CLOSE";
        String Bstyle3 = "-fx-background-color: #FF0000;";
        
      
        //CurrentWord
        currentWord = hmGame.cWord();

        //New Word button
        Button newWord = hmGame.Createbutton(Bname1, Bstyle1);
        //Guess Button
        Button guess = hmGame.Createbutton(Bname2, Bstyle2);
        //Close button
        Button close = hmGame.Createbutton(Bname3, Bstyle3);
        
        //Top box 
        VBox top = new VBox(5);
        HBox top1 = new HBox(10);

        //Hint 
        Label hintLabel = new Label(hmGame.getHint(""));
        hintLabel.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL,
                FontPosture.ITALIC, 25));
        hintLabel.setTextFill(Color.WHITE);
        
         //Score 
        Label scoreLabel = new Label("Score: ");
        scoreLabel.setFont(Font.font("Comic Sans MS", FontWeight.BOLD,
                  FontPosture.REGULAR, 50));
        scoreLabel.setTextFill(Color.WHITE);
        
        Label points = new Label(sc + "");
        points.setFont(Font.font("Comic Sans MS", FontWeight.BOLD,
                FontPosture.REGULAR, 50));
        points.setTextFill(Color.WHITE);
        
        // Button functionality
        newWord.setOnAction((ActionEvent e) -> {
            currentWord = hmGame.cWord();
            bp.setCenter(wordBoxes(currentWord));
            
            hintLabel.setText(getHint(currentWord));
            
        });

        guess.setOnAction((ActionEvent e) -> {
            currentScore = guessWord(currentWord, currentScore);
            points.setText(currentScore + "");
            
        });
        
        close.setOnAction((ActionEvent e) -> {
           System.exit(0);
        });
        
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
        
        
        primaryStage.setTitle("Guess the Word Game!");
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
