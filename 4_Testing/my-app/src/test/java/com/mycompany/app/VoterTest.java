package com.mycompany.app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class VoterTest {
    private Voter voter;

    @Before
    public void setUp() {
        voter = new Voter();
    }
    
    @Test
    public void testGetVote() {
        assertEquals(" ", voter.vote(" "));
    }

    @Test
    public void testGetVoteYES() {
        String vote = "yes";
        assertEquals(vote, voter.vote("yes"));
    }

    @Test
    public void testGetVoteNO() {
        String vote = "no";
        assertEquals(vote, voter.vote("no"));
    }
}
