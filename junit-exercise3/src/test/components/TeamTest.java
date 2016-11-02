package test.components;

import main.components.Player;
import main.components.Position;
import main.components.Team;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by simon.gomez on 10/12/2016.
 */
public class TeamTest {

    private Team team;
    private Player messi;

    @Before
    public void setUp() throws Exception {
        team = new Team("Giorgio FC");
        messi = new Player("Messi", 29, 99, Position.DELANTERO);
    }

    @After
    public void tearDown() throws Exception {
        team = null;
    }

    @Test
    public void testContractPlayer() throws Exception {
        //Primero probamos agregar a messi
        Assert.assertTrue(team.contractPlayer(messi));

        //Ahora probamos que no se agregue de vuelta
        Assert.assertFalse(team.contractPlayer(messi));

        //Ahora probamos de buscar a messi
        Player player = team.getPlayer("Messi");
        Assert.assertNotNull(player);

        Assert.assertEquals("Messi", player.getName());

    }

}