// GameTreeClass.java
// Game Tree Class
// By: Peter Schurhammer

public class GameTreeClass extends BinaryTreeBasis<String> implements GameTree {

    //calling TreeNode class to create/use a tree
    public TreeNode<String> currentNode;
    public TreeNode<String> root;

    public void startGame(String question, String yesAnswer, String noAnswer) {
        makeEmpty(); //makes sure the tree is empty before we start the game
        //creation of the root of the tree
        root = new TreeNode(question,  new TreeNode<>(yesAnswer), new TreeNode<>(noAnswer));
        currentNode = root;
    } //end startGame

    public void newRound() {
        //checks to make sure the current node isn't empty then resets currentNode to root
        //starting the game over again from the top
        if (currentNode == null) {
            endGame();
        } else {
            currentNode = root;
        } //end else
    } //end newRound

    public void endGame() {
        //simple method to kill program if called
        System.out.println("Game has ended, thanks for playing");
        makeEmpty(); //empties tree before ending
        System.exit(0);
    } //end endGame

    public void moveYes() throws TreeException {
        if (currentNode.leftChild == null) {        //exception for empty node
            isEmpty();
            throw new TreeException("Couldn't move to next node");
        } //end if
        //moves currentNode to the right based on Yes answer given by user
        currentNode = currentNode.leftChild;
    } //end moveYes

    public void moveNo() throws TreeException {
        if (currentNode.rightChild == null) {       //exception for empty node
            isEmpty();
            throw new TreeException("Couldn't move to next node");
        } //end if
        //moves currentNode to the right based on No answer given by user
        currentNode = currentNode.rightChild;
    } //end moveNo

    public String getQuestion() throws TreeException {
        if (currentNode.item == null) {
            isEmpty();
            throw new TreeException("No Question");
        } //end if
        //gets question from currentNode
        String question = currentNode.item;
        //more of a formatting thing that I added to add a question mark if one wasn't already there
        if(question.endsWith("?") ){
            return question;
        } else {
            return question + "?";
        } //end else
    } //end getQuestion

    public void setQuestion(String question, String answer) {
        //brute force way to get a new question and answer, couldn't figure out a more elegant way to implement
        String oldAnswer = currentNode.item;
        currentNode.item = question;
        currentNode.leftChild = new TreeNode<>(answer);
        currentNode.rightChild = new TreeNode<>(oldAnswer);
    } //end setQuestion

    public String getAnswer() throws TreeException {
        if(currentNode == null) {                 //exception for empty node
            isEmpty();
            throw new TreeException("There is no node.");
        } //end if                  //checks to see if either the left or right child have values, if they do return null
        if(currentNode.leftChild != null || currentNode.rightChild != null) {
            return null;
        } //end if
        //returns the current item(answer) in the node
        return currentNode.item;
    } //end getAnswer

    public boolean isQuestion() {
        //similar to the getAnswer method line 66 but shortened a bit
        isEmpty();
        return currentNode.leftChild != null && currentNode.rightChild != null;
    } //end isQuestion

    public void setRootItem(String newItem) {
        throw new UnsupportedOperationException();
    } //end setRootItem
} //end GameTreeClass

