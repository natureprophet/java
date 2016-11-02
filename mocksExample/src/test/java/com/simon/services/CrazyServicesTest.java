package com.simon.services;

import com.simon.models.JiraTicket;
import com.simon.utils.AverageUtils;
import com.simon.utils.GoogleUtils;
import com.simon.utils.JiraUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CrazyServicesTest {

    @InjectMocks
    @Autowired
    private CrazyServices crazyServices;

    @Mock
    private AverageUtils averageUtils;

    @Mock
    private GoogleUtils googleUtils;

    @Mock
    private JiraUtils jiraUtils;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * EN ESTE SERVICIO HAY 4 ESCENARIOS POSIBLES:
     *
     * Google OFF + Promedio edad < 50 OK
     * Google OFF + Promedio edad > 50
     * Google ON + Promedio edad < 50
     * Google ON + Promedio edad > 50
     */

    @Test
    public void testDoCrazyWithGoogleOffAndYoungAverage() {
        when(averageUtils.getGlobalAverageAge()).thenReturn(25);
        when(googleUtils.isGoogleServerAvailable()).thenReturn(false);
        when(jiraUtils.createTicket(anyString(), anyString())).thenReturn("123456");

        JiraTicket jiraTicket = crazyServices.doCrazyThing();
        Assert.assertEquals("123456", jiraTicket.getNumber());
        Assert.assertNotNull(jiraTicket.getNumber());
        Assert.assertEquals("El servicio de google fue hackeado", jiraTicket.getTitle());
        Assert.assertEquals("La poblacion en general es joven", jiraTicket.getDescription());
    }

}
