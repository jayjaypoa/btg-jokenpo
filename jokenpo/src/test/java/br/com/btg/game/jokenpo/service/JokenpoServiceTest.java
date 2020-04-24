package br.com.btg.game.jokenpo.service;

import br.com.btg.game.jokenpo.dto.JokenpoResponse;
import br.com.btg.game.jokenpo.dto.MoveRequest;
import br.com.btg.game.jokenpo.dto.PlayerRequest;
import br.com.btg.game.jokenpo.dto.PlayerResponse;
import br.com.btg.game.jokenpo.enumeration.EnumMovement;
import br.com.btg.game.jokenpo.exception.JokenpoException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class JokenpoServiceTest {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private MoveService moveService;

    @Autowired
    private JokenpoService jokenpoService;

    @Test
    public void insertManyPlayersForTestWithSucess() throws JokenpoException {
        // clear singleton data
        this.playerService.clearAll();
        this.moveService.clearAll();
        // insert many players
        List<String> playerNames = new ArrayList<>(Arrays.asList("P1", "P2", "P3", "P4", "P5", "P6"));
        List<PlayerResponse> playerResponse = this.insertManyDifferentPlayers(playerNames);
        // check assertments
        Assert.assertEquals(playerNames.size(), playerResponse.size());
    }

    @Test
    public void clearAllWithSucess() throws JokenpoException {
        this.insertManyPlayersForTestWithSucess();
        this.moveService.insert(new MoveRequest("P1", EnumMovement.SPOCK.getName()));
        this.moveService.insert(new MoveRequest("P2", EnumMovement.PAPER.getName()));
        this.moveService.insert(new MoveRequest("P3", EnumMovement.SCISSORS.getName()));
        Assert.assertNotEquals(0, this.playerService.getAll().size());
        Assert.assertNotEquals(0, this.moveService.getAll().size());
        this.jokenpoService.clear();
        Assert.assertEquals(0, this.playerService.getAll().size());
        Assert.assertEquals(0, this.moveService.getAll().size());
    }

    @Test
    public void testPaperVersusScissors() throws JokenpoException {
        // clear singleton data
        this.playerService.clearAll();
        this.moveService.clearAll();
        // insert players
        List<String> playerNames = new ArrayList<>(Arrays.asList("P1", "P2"));
        this.insertManyDifferentPlayers(playerNames);
        // insert movements
        this.moveService.insert(new MoveRequest("P1", EnumMovement.PAPER.getName()));
        this.moveService.insert(new MoveRequest("P2", EnumMovement.SCISSORS.getName()));
        JokenpoResponse response = this.jokenpoService.play();
        System.out.println("TEST RESULT = " + response.getGameResult());
        Assert.assertNotNull(response.getGameResult());
        String expected = "P2 IS THE WINNER!".toUpperCase().trim();
        Assert.assertEquals(expected, response.getGameResult());
    }

    @Test
    public void testPaperVersusScissorsVersusStone() throws JokenpoException {
        // clear singleton data
        this.playerService.clearAll();
        this.moveService.clearAll();
        // insert players
        List<String> playerNames = new ArrayList<>(Arrays.asList("P1", "P2", "P3"));
        this.insertManyDifferentPlayers(playerNames);
        // insert movements
        this.moveService.insert(new MoveRequest("P1", EnumMovement.PAPER.getName()));
        this.moveService.insert(new MoveRequest("P2", EnumMovement.SCISSORS.getName()));
        this.moveService.insert(new MoveRequest("P3", EnumMovement.STONE.getName()));
        JokenpoResponse response = this.jokenpoService.play();
        Assert.assertNotNull(response.getGameResult());
        String expected = "NOBODY WON!".toUpperCase().trim();
        Assert.assertEquals(expected, response.getGameResult());
    }

    @Test
    public void testLizardVersusScissorsVersusPaper() throws JokenpoException {
        // clear singleton data
        this.playerService.clearAll();
        this.moveService.clearAll();
        // insert players
        List<String> playerNames = new ArrayList<>(Arrays.asList("P1", "P2", "P3"));
        this.insertManyDifferentPlayers(playerNames);
        // insert movements
        this.moveService.insert(new MoveRequest("P1", EnumMovement.LIZARD.getName()));
        this.moveService.insert(new MoveRequest("P2", EnumMovement.SCISSORS.getName()));
        this.moveService.insert(new MoveRequest("P3", EnumMovement.PAPER.getName()));
        JokenpoResponse response = this.jokenpoService.play();
        Assert.assertNotNull(response.getGameResult());
        String expected = "P2 IS THE WINNER!".toUpperCase().trim();
        String notExpected = "NOBODY WON!".toUpperCase().trim();
        Assert.assertNotEquals(notExpected, response.getGameResult());
        Assert.assertEquals(expected, response.getGameResult());
    }

    @Test
    public void testSpockVersusPaper() throws JokenpoException {
        // clear singleton data
        this.playerService.clearAll();
        this.moveService.clearAll();
        // insert players
        List<String> playerNames = new ArrayList<>(Arrays.asList("P1", "P2"));
        this.insertManyDifferentPlayers(playerNames);
        // insert movements
        this.moveService.insert(new MoveRequest("P1", EnumMovement.SPOCK.getName()));
        this.moveService.insert(new MoveRequest("P2", EnumMovement.PAPER.getName()));
        JokenpoResponse response = this.jokenpoService.play();
        Assert.assertNotNull(response.getGameResult());
        String expected = "P2 IS THE WINNER!".toUpperCase().trim();
        String notExpected = "NOBODY WON!".toUpperCase().trim();
        Assert.assertNotEquals(notExpected, response.getGameResult());
        Assert.assertEquals(expected, response.getGameResult());
    }

    @Test
    public void testLizardVersusScissors() throws JokenpoException {
        // clear singleton data
        this.playerService.clearAll();
        this.moveService.clearAll();
        // insert players
        List<String> playerNames = new ArrayList<>(Arrays.asList("P1", "P2"));
        this.insertManyDifferentPlayers(playerNames);
        // insert movements
        this.moveService.insert(new MoveRequest("P1", EnumMovement.SCISSORS.getName()));
        this.moveService.insert(new MoveRequest("P2", EnumMovement.LIZARD.getName()));
        JokenpoResponse response = this.jokenpoService.play();
        Assert.assertNotNull(response.getGameResult());
        String expected = "P1 IS THE WINNER!".toUpperCase().trim();
        String notExpected = "NOBODY WON!".toUpperCase().trim();
        Assert.assertNotEquals(notExpected, response.getGameResult());
        Assert.assertEquals(expected, response.getGameResult());
    }

    @Test(expected = JokenpoException.class)
    public void textInvalidMovementWithException() throws JokenpoException {
        // clear singleton data
        this.playerService.clearAll();
        this.moveService.clearAll();
        // insert players
        List<String> playerNames = new ArrayList<>(Arrays.asList("P1", "P2"));
        this.insertManyDifferentPlayers(playerNames);
        // insert movements
        this.moveService.insert(new MoveRequest("P1", EnumMovement.SCISSORS.getName()));
        this.moveService.insert(new MoveRequest("P2", "INEXISTENTE"));
    }

    @Test
    public void testHistoryWithSucess() throws JokenpoException {
        // clear singleton data
        this.playerService.clearAll();
        this.moveService.clearAll();
        // insert players
        List<String> playerNames = new ArrayList<>(Arrays.asList("P1", "P2", "P3"));
        this.insertManyDifferentPlayers(playerNames);
        // insert movements
        this.moveService.insert(new MoveRequest("P1", EnumMovement.SCISSORS.getName()));
        this.moveService.insert(new MoveRequest("P2", EnumMovement.LIZARD.getName()));
        this.moveService.insert(new MoveRequest("P3", EnumMovement.STONE.getName()));
        JokenpoResponse response = this.jokenpoService.play();
        Assert.assertNotEquals(0, response.getHistory().size());
        Assert.assertEquals(3, response.getHistory().size());
    }

    private List<PlayerResponse> insertManyDifferentPlayers(List<String> playerNames) throws JokenpoException {
        List<PlayerResponse> list = new ArrayList<>();
        for(String name : playerNames){
            PlayerResponse playerResponse = this.playerService.insert(new PlayerRequest(name));
            list.add(playerResponse);
        }
        return list;
    }

}
