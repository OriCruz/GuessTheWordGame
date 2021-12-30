/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;



import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Oriana Cruz 
 * 
 * This API is the backbone to create a simple hangman game like shown in the 
 * the documentation and example images.
 * 
 * DO NOT edit anything in this API EXCEPT for the currentW() method 
 * to changed the words that will be used in the game. 
 * 
 * Also, the getHint(String cW) method shall be edited  ONLY IF THE currentW() is changed 
 * with the purpose to give the player an accurate hint.
 */
public class API_GuessTheWordGame extends Application {
    private static String currentWord = "";
    private static TextField[] tfs;
    static int points = 0;
    private static Label pointsLabel;
    private static Label hintLabel;
    @Override
    public void start(Stage primaryStage) {
      
    }

    /**
     * Creates scene of the given width & height. If either value is less
     * than 100 then the window will default to a size of 500 X 500
     *
     * @param bp BorderPane
     * @param w Desired WIDTH of the GUI
     * @param h Desired HEIGHT of the GUI
     * @return Scene with desired Width & Height
     */
     public Scene createScene(BorderPane bp, int w, int h, Image bg) {
        int[] sizeArr = {w, h};

        if (w < 100 || h < 100) {
            System.err.println("Invalid height or width. Setting default size... "
                    + "(500, 500) has been set");
            sizeArr[0] = 500;
            sizeArr[1] = 500;
        }
        Image img = bg;
        BackgroundImage bImg = new BackgroundImage(img,
                                                   BackgroundRepeat.NO_REPEAT,
                                                   BackgroundRepeat.NO_REPEAT,
                                                   BackgroundPosition.DEFAULT,
                                                   BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
        bp.setBackground(bGround);
        Scene scene = new Scene(bp, sizeArr[0], sizeArr[1]);
        return scene;
    }
     /**
      * This method creates a String [] to storage the words that will be later used 
      * to select the word that will be displaying on the GUI
      * 
      * @return a String dictionary []
      */
     public String[] currentW(){
         String[] dictionary ={"MAP", "SUN", "PENCIL", "OXYGEN", "ZOMBIE", "ANCIENT",
         "LEFT", "AUTUMN", "FOOTBALL", "HALLOWEEN"};
         return dictionary;
     }
     
      /**
     * This method assigns a random number to the current word for later use along 
     * with other methods
     * 
     * @return String cw
     */
     public String cWord(){
         int r = ranNum();
         String w [] = currentW();
         String cw = w[r];
         return cw;
     }
     /**
      * This method creates a gripPane, where TextFields will be displayed 
      * according to the size of the current word (cw)
      * @param cw String for current word
      * @return a GridPane
      */
      public GridPane wordBoxes(String cw) {
        String [] words = currentW();
        int r = ranNum();
        currentWord = cw;
        int size = cw.length();
        tfs = new TextField[size];
        GridPane gp = new GridPane();

        for (int i = 0; i < size; i++) {
            tfs[i] = new TextField();
            gp.add(tfs[i], i, 0);
            gp.setPrefWidth(5);
            tfs[i].setPrefHeight(50);
            tfs[i].setFont(Font.font("Arial", FontWeight.BOLD,
                    FontPosture.REGULAR, 20));
            tfs[i].setOnKeyPressed((KeyEvent ke) -> {
                System.out.println("Key Pressed: " + ke.getText());
                final TextField t[] = tfs;
                moveUp(t);
            });
        }
        return gp;
    }
      
     /**
     * Method's purpose is to generate a random number 
     * that will be called in other methods.
     * 
     * @return r
     */
      public int ranNum(){
        String [] words = currentW();
        int r = (int) (Math.random() * words.length);
        return r;
      }
      
       /**
     * This method moves the cursor to the next line one the current TextField is
     * filled.
     * @param tfs TextField[] 
     */
      public void moveUp(TextField[] tfs) {
        
        for (int i = 0; i < tfs.length; i++) {

            if(!tfs[i].getText().equals("")) {
                System.out.println("Current space is filled so moving up.");
                tfs[i+1].requestFocus();
                System.out.println(i);
            }
            else {
                break;
            }
                
        }

    }

      /**
       * This method creates a new object button and it takes the following parameters:
       * 
       * @param name String to set the title of the button
       * @param style String to set the background color of the button
       * 
       * @return a Button with the desire title and background color. 
       */
    public Button Createbutton(String name, String style){
        Button newButton = new Button();
        newButton.setText(name);
        newButton.setStyle(style);
        
        
        return newButton;
    } 
    
     /**
     * This method generates a hint for each word entered using switch statements
     * 
     * @param crWord for current word 
     * @return String hint
     */
    public String getHint(String crWord){
        String hint;
        
        switch(crWord){
            case "MAP": 
                hint ="Use a \"M\" when you get lost.";
                break;
            case "SUN": 
                hint ="Don't look directly at the \"S\" you eyes will hurt!";
                break;
            case "PENCIL": 
                hint ="You always use a \"P\" to write on the exam!";
                break;
            case "OXYGEN": 
                hint ="Humans need \"O\" to live!";
                break;
            case "ZOMBIE": 
                hint ="You better run \"Z\" will eat your brain!";
                break;
            case "ANCIENT": 
                hint ="\"A\" civilizations are a good topic for books.";
                break;
            case "LEFT": 
                hint ="Some people are right-handed some other are \"L\"-Handed.";
                break;
            case "AUTUMN": 
                hint = "\"A\" is my favorite season!";
                break;
            case "FOOTBALL": 
                hint = "My favorite sport to watch is \"F\"(Not american tho)";
                break;
             case "HALLOWEEN": 
                hint = " \"H\" comes before Thanksgiving and Chritsmas.";
                break;
             default:
                 hint = "N/A";
                 break;
        }
        return hint;
    }
    
     /**
     * Method check if the word entered by the player matches with the 
     * current word that is being used. 
     *Based of that it assigns the score and the results are displayed 
     * 
     * @param  points integer for current points
     * @param  cWord  String for current word 
     * @return totalPoints
     */
    public int guessWord(String cWord, int points) {

        int lettersCorrect = 0;
        int totalPoints = points;
        Image winner = new Image(MyImages.winner, 600, 600, false, false);
        Image loser = new Image(MyImages.loser, 300, 300, false, false);

        for (int i = 0; i < cWord.length(); i++) {

            try {
                // If the input at pos i == the word at that char keep it
                if (tfs[i].getText().toUpperCase().charAt(0) == cWord.charAt(i))
                {
                    tfs[i].setStyle("-fx-background-color: #98FB98;");
                    lettersCorrect++;
                    
                } 
                else {
                    //tfs[i].setText(""); // Empty text field
                    tfs[i].setStyle("-fx-background-color: #ffcccb;");
                    
                }
            }
            catch (Exception e) {
                System.err.println("Please complete the word.");
            }
               if(lettersCorrect == cWord.length()) {

                totalPoints++;
              }
                
        }
             if(lettersCorrect == cWord.length()){
                showWinner(totalPoints, winner);
                } 

             else{
                   showWinner(totalPoints, loser);
               }

        return totalPoints;
    }

     /**
     * This method generates a second stage that will show an image based
     * on the results determining the winner or loser
     * 
     * @param img Image object 
     * @param s integer for the score 
     * @return void 
     */
    public static void showWinner(int s, Image img){
        
        // SECOND STAGE & SCENE
        Stage resultsStage = new Stage();
        resultsStage.setTitle("Game Resulst!");
        ImageView IV = new ImageView(img);
        Group root = new Group(IV);
        Scene resultsScene = new Scene(root, 300, 300);
        resultsStage.setScene(resultsScene);
        resultsStage.setX(100);
        resultsStage.setY(110);
        
        resultsStage.show();
        
    }

}
