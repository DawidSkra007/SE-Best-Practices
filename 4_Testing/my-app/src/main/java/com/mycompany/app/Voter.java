package com.mycompany.app;


public class Voter implements VoterInterface {
    private String vote;

    // getter for vote
    public String getVote() {
        return vote;
    }

    // setter for vote
    public void setVote(String vote) {
        this.vote = vote;
    }

    public static void main(String[] args) {
        Voter voter = new Voter();
        System.out.println("Voter voted: " + voter.vote(voter.getVote()));
    }

    public String vote(String vote) {
        if (vote == "") { // if vote is empty, generate a random vote
            vote = Math.random() < 0.5 ? "yes" : "no";
        } 
        return vote;
    }

    public void inform(boolean result) {
        System.out.println("The election result is " + (result ? "yes" : "no") + "!"); // print the result
    }

    public void inform(String result) {
        System.out.println("The election result is " + result + "!"); // print the result
    }

    //Constructores
    public Voter() {
    }

    public Voter(String vote) {
        this.vote = vote;
    }

    @Override
    public String vote() {
        return vote;
    }

}
