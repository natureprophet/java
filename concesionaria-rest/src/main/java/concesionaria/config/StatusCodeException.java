/**
 * TodoList java backend.
 * Part of the TodoList project.
 * Copyright (c) 2016 GlobalLogic
 * All rights reserved.
 * Distribution under license.
 */
package concesionaria.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

/**
 * Excepción especifica para generar códigos de error HTTP.
 */
public class StatusCodeException extends HttpStatusCodeException {

    private Exception exception;

    /**
     * Constructor que almacena la excepción originaria.
     * @param statusCode Código HTTP a devolver.
     * @param e          Excepcion originaria.
     */
    public StatusCodeException(HttpStatus statusCode, Exception e) {
        super(statusCode);
        this.exception = e;
    }

    /**
     * Constructor.
     * @param statusCode Código HTTP a devolver.
     */
    public StatusCodeException(HttpStatus statusCode) {
        super(statusCode);
        this.exception = null;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
