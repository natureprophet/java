package test.services;

import main.services.TeamServices;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by simon.gomez on 10/13/2016.
 */
public class TeamServicesTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetInstance() throws Exception {
        TeamServices instance1 = TeamServices.getInstance();
        TeamServices instance2 = TeamServices.getInstance();

        Assert.assertNotNull(instance1);
        Assert.assertNotNull(instance2);

        Assert.assertEquals(instance1, instance2);
    }

}