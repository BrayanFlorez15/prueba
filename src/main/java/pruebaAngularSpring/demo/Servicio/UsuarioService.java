package pruebaAngularSpring.demo.Servicio;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pruebaAngularSpring.demo.Exeption.ResourceNotFoundExceotion;
import pruebaAngularSpring.demo.model.usuario;

import java.util.List;

public interface UsuarioService {
    public usuario obtenerUsuario(Long idusuario);

    public void eliminarUsuario(usuario user);

    public List<usuario> listarTodosLosUsuarios();

    public usuario guardarUsiario(usuario user);

    public usuario actualizarUsuario( usuario detalleUsuario);

}