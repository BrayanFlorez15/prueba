package pruebaAngularSpring.demo.Servicio.impl;
import pruebaAngularSpring.demo.Repositorio.usuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pruebaAngularSpring.demo.Servicio.UsuarioService;
import pruebaAngularSpring.demo.model.usuario;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private usuarioRepositorio usuarioRepositorio;

    @Override
    public Optional<usuario> obtenerUsuario(Long idusuario) {
        return usuarioRepositorio.findById(idusuario);
    }

    @Override
    public void eliminarUsuario(Long idUsuario) {
        usuarioRepositorio.deleteById(idUsuario);
    }

    @Override
    public List<usuario> listarTodosLosUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public usuario guardarUsiario(usuario user) {
        System.out.println("si entra al impl");
        return usuarioRepositorio.save(user);
    }

    @Override
    public usuario actualizarUsuario(usuario detalleUsuario) {
        return usuarioRepositorio.save(detalleUsuario);
    }


}
