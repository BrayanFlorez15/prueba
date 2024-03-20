package pruebaAngularSpring.demo.Servicio;

import pruebaAngularSpring.demo.model.usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    public Optional<usuario> obtenerUsuario(Long idusuario);

    public void eliminarUsuario(Long idUsuario);

    public List<usuario> listarTodosLosUsuarios();

    public usuario guardarUsiario(usuario user);
    public usuario actualizarUsuario( usuario detalleUsuario);

}
