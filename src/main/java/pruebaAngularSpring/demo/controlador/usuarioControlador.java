package pruebaAngularSpring.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pruebaAngularSpring.demo.Repositorio.usuarioRepositorio;
import pruebaAngularSpring.demo.Servicio.UsuarioService;
import pruebaAngularSpring.demo.model.usuario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// anotaciones @xxx
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class usuarioControlador {

    @Autowired
    private UsuarioService usuarioService;
    //metodo para listar los usuarios registrados
    @GetMapping("/usuario")
    public List<usuario> listarTodosLosUsuarios(){
        return usuarioService.listarTodosLosUsuarios();
    }
    //metodo para guardar por metodo post los usuarios
    @PostMapping("/usuario")
    public usuario guardar(@RequestBody usuario user){
        System.out.println("si entrea al controlador");
        return  usuarioService.guardarUsiario(user);
    }
    //metodo par buscar datos de un usuario por medio de la id
    @GetMapping("/usuario/{id}")
    public ResponseEntity<usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        Optional<usuario> optionalUsuario = usuarioService.obtenerUsuario(id);

        return optionalUsuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // metodo para editar la informacionde un usuario
    @PutMapping("/usuario/{id}")
    public ResponseEntity<usuario> actualizarUsuario(@PathVariable Long id, @RequestBody usuario detalleUsuario) {
        Optional<usuario> optionalUsuario = usuarioService.obtenerUsuario(id);

        if (optionalUsuario.isPresent()) {
            usuario usuarioExistente = optionalUsuario.get();
            usuarioExistente.setEmail(detalleUsuario.getEmail());
            usuarioExistente.setPassword(detalleUsuario.getPassword());
            usuarioExistente.setName(detalleUsuario.getName());
            usuarioExistente.setDireccion(detalleUsuario.getDireccion());

            usuario usuarioActualizado = usuarioService.actualizarUsuario(usuarioExistente);
            return ResponseEntity.ok(usuarioActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //metodo en cargado para eliminar un usuario por medio de la id
    @DeleteMapping("/usuario/{id}")
    public void eliminarEmpleado(@PathVariable Long id){
        usuarioService.eliminarUsuario(id);
    }
}
