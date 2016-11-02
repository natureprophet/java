package concesionaria.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.security.AccessControlException;

/**
 * Handler global para excepciones.
 */
@ControllerAdvice
public class GlobalDefaultHandler {

    /**
     * Handler para las excepciones de las conversiones.
     * @param e Excepción a manejar.
     */
    @ExceptionHandler({
                    HttpRequestMethodNotSupportedException.class,
                    MethodArgumentNotValidException.class,
                    HttpMessageConversionException.class,
                    HttpMessageNotReadableException.class,
                    HttpMediaTypeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final void handleBadRequestException(Exception e) {
        // solo enviar al log si estamos en modo depuración
        System.out.println(e);
    }

    /**
     * Handler para los errores de acceso.
     */
    @ExceptionHandler(AccessControlException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleAccessControlException() {

    }

    /**
     * Handler para las excepciones de estado con código HTTP.
     * @param e Excepción a manejar.
     * @return Response entity con el mensaje en formato JSON.
     */
    @ExceptionHandler(StatusCodeException.class)
    public ResponseEntity<Object> handleStatusCodeException(StatusCodeException e) {
        // enviar error al log en caso de error interno
        if (e.getStatusCode().is5xxServerError()) {
            System.out.println(e);
        }
        // devolver respuesta con el codigo de status
        return new ResponseEntity<>(e.getStatusCode());
    }
}
