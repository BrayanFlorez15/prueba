package pruebaAngularSpring.demo.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceotion extends RuntimeException{
    //metodo en cargado para hacer unas exepciones personalizadas
    private static final long serialVersionUID=1l;

    public ResourceNotFoundExceotion(String mensaje){
        super(mensaje);
    }

}
