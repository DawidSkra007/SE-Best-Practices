package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BallotTest {
    private Ballot ballot;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private class VoterMock implements VoterInterface {
        private String myVote;
        private int informCount = 0;
        private int voteCount = 0;

        public VoterMock(String vote) {
            myVote = vote;
        }
        public String vote() {
            voteCount++;
            return myVote;
        }
        public void inform(String finalVote) {
            System.out.println("The election result is " + finalVote + "!");
            informCount++;
        }
        public int getCount() {
            return informCount;
        }
        public int getVoteCount() {
            return voteCount;
        }
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    
    @Test
    public void testGetOneVote() {
        ballot = new Ballot(1);
        assertTrue(ballot.getVotersSize() == 1);
    }

    @Test
    public void testNumOfYesVote() {
        List<VoterInterface> voters = new ArrayList<VoterInterface>();
        voters.add(new VoterMock("yes"));
        voters.add(new VoterMock("no"));
        voters.add(new VoterMock("yes"));


        ballot = new Ballot(voters);
        ballot.election();
        int numYes = ballot.getNumYes();
        System.out.println("Number of yes votes: " + numYes);

        assertEquals(2 , numYes);
    }

    @Test
    public void testMajority() {
        List<VoterInterface> voters = new ArrayList<VoterInterface>();
        voters.add(new VoterMock("yes"));
        voters.add(new VoterMock("yes"));
        voters.add(new VoterMock("yes"));
        voters.add(new VoterMock("yes"));
        voters.add(new VoterMock("no"));
        voters.add(new VoterMock("no"));
        voters.add(new VoterMock("no")); // 4 yes votes, 3 no votes

        ballot = new Ballot(voters);
        boolean result = ballot.election();
        assertTrue(result == true);
        assertEquals(ballot.getNumNo(), 0); // function stops after majority is reached
    }

    @Test
    public void testVoterRecResult() {
        List<VoterInterface> voters = new ArrayList<VoterInterface>();
        voters.add(new VoterMock("yes")); // vote just once

        ballot = new Ballot(voters);
        boolean result = ballot.election();
        assertTrue(result == true); // check if election result is yes
        assertEquals("The election result is Yes!", outputStreamCaptor.toString().trim()); 
        assertEquals(1, ((VoterMock) voters.get(0)).getCount()); // check if voter receives result
    }

    @Test
    public void testDrawResult() {
        List<VoterInterface> voters = new ArrayList<VoterInterface>();
        voters.add(new VoterMock("yes"));
        voters.add(new VoterMock("no"));

        ballot = new Ballot(voters);
        ballot.election();
        assertEquals("The election result is Draw!\nThe election result is Draw!", outputStreamCaptor.toString().trim()); 
        assertEquals(1, ((VoterMock) voters.get(0)).getCount());
        assertEquals(1, ((VoterMock) voters.get(1)).getCount());
    }

    @Test
    public void testVote() {
        List<VoterInterface> voters = new ArrayList<VoterInterface>();
        voters.add(new VoterMock("yes"));
        voters.add(new VoterMock("yes"));
        voters.add(new VoterMock("no"));

        ballot = new Ballot(voters);
        ballot.election();
        assertEquals(1, ((VoterMock) voters.get(0)).getVoteCount());
        assertEquals(1, ((VoterMock) voters.get(1)).getVoteCount());
        assertEquals(0, ((VoterMock) voters.get(2)).getVoteCount()); // voter 3 should not vote
    }
}
