package com.simon.services;

import com.simon.models.JiraTicket;
import com.simon.utils.AverageUtils;
import com.simon.utils.GoogleUtils;
import com.simon.utils.JiraUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrazyServices {

    @Autowired
    private AverageUtils averageUtils;

    @Autowired
    private GoogleUtils googleUtils;

    @Autowired
    private JiraUtils jiraUtils;

    /**
     * Este servicio se va a encargar de consultar la edad promedio
     * del mundo, verificar si los servicios de google estan disponibles,
     * y crear un ticket en jira al respecto.
     */
    public JiraTicket doCrazyThing() {

        // Datos que necesito en mi logica
        boolean googleAvailable = googleUtils.isGoogleServerAvailable();
        int worldAgeAverage = averageUtils.getGlobalAverageAge();

        // Logica para obtener el titulo del ticket de jira
        String title = "";
        if(googleAvailable == true) {
            title = "El servicio de google esta disponible";
        } else {
            title = "El servicio de google fue hackeado";
        }

        // Logica para obtener la descripcion del ticket de jira
        String description = "";
        if(worldAgeAverage < 50) {
            description = "La poblacion en general es joven";
        } else {
            description = "La poblacion en general es vieja";
        }

        // Lógica para crear el ticket y obtener el numero de ticket
        String number = jiraUtils.createTicket(title, description);


        return new JiraTicket(number, title, description);
    }
}
