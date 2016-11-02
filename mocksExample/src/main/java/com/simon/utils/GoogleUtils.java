package com.simon.utils;

import org.springframework.stereotype.Component;

@Component
public class GoogleUtils {

    public boolean isGoogleServerAvailable() {
        /**
         * Este método realiza una conexión contra un servidor de google y verifica la disponibilidad
         * de sus servicios, demora aproximadamente 15 minutos.
         *
         * Para poder probar este codigo en caso de que falle necesitaria tirar los
         * servidores de google.
         *
         * ESTO HAY QUE MOCKEARLO
         */
        return false;
    }
}
