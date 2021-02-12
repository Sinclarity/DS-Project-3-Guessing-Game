// GameDriver.java
// GameDriver
// By: Peter Schurhammer

import java.util.*;

public class GameDriver   {
    private static Scanner scanner = new Scanner(System.in);
    private static GameTree newGame = new GameTreeClass();

    public static void main(String[] args) {

        System.out.println("Welcome to the game!");
        System.out.println("******************************************");
        newGame.startGame("Does it have legs?", "Dog","Slug");
        System.out.println("Think of an animal and I will guess it");

        //used a loop to play the game by grabbing the question and then relating it to the user input
        while(true){
            System.out.println(newGame.getQuestion());
             boolean userInput = getUserInput();
            if(userInput){
                newGame.moveYes();
            } else {
                newGame.moveNo();
            } //end else
            //the game asking if it got the correct answer
            if (!newGame.isQuestion()) {
                System.out.println("Is the answer " + newGame.getAnswer() + "?");

                //end of the game and the start of a new round unless user ends
                if(getUserInput()){
                    System.out.println("Haha I win, wanna play again? ");
                    if(getUserInput()){
                        newGame.newRound();
                    } else {
                        newGame.endGame();
                    } //end else
                } else {

                    //the game giving up and gathering a new animal along with a question to go along with the new animal
                    System.out.println("Ok I give up, what's the correct answer? ");
                    String tempAnswer = scanner.nextLine();
                    System.out.println("Give me a question to ask for new animal where YES is " + tempAnswer + " and " +
                            "NO is the " + newGame.getAnswer());
                    String tempQuestion = scanner.nextLine();
                    newGame.setQuestion(tempQuestion, tempAnswer);

                    //end of the game and the start of a new round unless user ends
                    System.out.println("Thanks for the help, do you want to play again?");
                    if(getUserInput()){
                        newGame.newRound();
                    } else {
                        newGame.endGame();
                    } //end else
                } //end else
            } //end if
        } //end while
    } //end main

    //method to check user input, call it when I need an input
    private static boolean getUserInput() {
        boolean userInput = true ;
        boolean isAnswerInvalid = true;
        while(isAnswerInvalid){                   //loop to check input validity
            String input = scanner.nextLine();
            switch (input.toUpperCase().trim()){  //special case for lowercase input
                case "YES":                       //switch for YES and NO answers
                    isAnswerInvalid = false;
                    userInput = true;
                    break;
                case "NO":
                    isAnswerInvalid = false;
                    userInput = false;
                    break;
                default:   //error message for correct inputs
                    System.out.println("Valid inputs are \"YES\" or \"NO\"");
                    break;
            } //end switch
        } //end while
        //returns either YES or NO based on the user's input
        return userInput;
    } //end getUserInput
} //end GameDriver
