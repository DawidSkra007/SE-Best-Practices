package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Ballot {

    private List<VoterInterface> voters = new ArrayList<VoterInterface>();
    private int param = 0;
    private int numYes = 0;
    private int numNo = 0;
    private boolean result;

    public int getVotersSize() {
        return voters.size();
    }

    public int getNumYes() {
        return numYes;
    }

    public int getNumNo() {
        return numNo;
    }

    public Ballot(int voters) {
        param = 1;
        for (int i = 0; i < voters; i++) {
            this.voters.add(new Voter());
        }
    }

    public Ballot(List<VoterInterface> voters) {
        param = 2;
        this.voters = voters;
    }

    public boolean election() {
        //System.out.println("A");
        if (param == 1) {                           // USING RANDOM VOTES when param is 1 (not used in this exersize)
            //System.out.println("B");
            for (VoterInterface voter : voters) {
                if (voter.vote() == "yes") {
                    //System.out.println("C");
                    numYes++;
                } else {
                   // System.out.println("D");
                    numNo++;
                }
                //System.out.println("E");
                if (numYes > voters.size() / 2 || numNo > voters.size() / 2) {
                    //System.out.println("F");
                    break;
                }
                //System.out.println("G");
            }
        } else if (param == 2) { // if param is 2, votes already exist
            //System.out.println("H");
            for (VoterInterface voter : voters) {
                if (voter.vote() == "yes") {
                    //System.out.println("I");
                    numYes++;
                } else {
                    //System.out.println("J");
                    numNo++;
                }
                //System.out.println("K");
                if (numYes > voters.size() / 2 || numNo > voters.size() / 2) {
                   // System.out.println("L");
                    break;
                }
                //System.out.println("M");
            }
        }
        //System.out.println("N");
        //boolean result = numYes > numNo; //change HERE
        if (numYes > numNo) {
            result = true;
            contactVoters("Yes");
        } else if(numYes == numNo) {
            contactVoters("Draw");
        } else if(numYes < numNo){
            result = false;
            contactVoters("No");
        }
        return result;
    }

    public void contactVoters(String message) {
        for (VoterInterface voter : voters) {
            voter.inform(message);
        }
    }

    // public void contactVoters(Boolean message) {
    //     for (VoterInterface voter : voters) {
    //         voter.inform(message);
    //     }
    // }

    public static void main( String[] args ) {
    }
}
