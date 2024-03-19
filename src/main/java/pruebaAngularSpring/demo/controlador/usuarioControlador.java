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
// anotaciones @xxx
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class usuarioControlador {
    @Autowired
    private usuarioRepositorio repositorio;
    private UsuarioService usuarioService;
    //metodo para listar los usuarios registrados
    @GetMapping("/usuario")
    public List<usuario> listarTodosLosUsuarios(){
        return usuarioService.listarTodosLosUsuarios();
    }
    //metodo para guardar por metodo post los usuarios
    @PostMapping("/usuario")
    public usuario guardar(@RequestBody usuario user){
        return usuarioService.guardarUsiario(user);
    }
    //metodo par buscar datos de un usuario por medio de la id
    @GetMapping("/usuario/{id}")
    public ResponseEntity<usuario> obtenerEmpleadoPorId(@PathVariable Long id){
        usuario usuario=usuarioService.obtenerUsuario(id);
                return ResponseEntity.ok(usuario);
    }
    // metodo para editar la informacionde un usuario
    @PutMapping("/usuario/{id}")
    public ResponseEntity<usuario> actualizarUsuario(@PathVariable Long id,@RequestBody usuario detalleUsuario ){
        usuario Usuario=usuarioService.obtenerUsuario(id);
        Usuario.setEmail(detalleUsuario.getEmail());
        Usuario.setPassword(detalleUsuario.getPassword());
        Usuario.setName(detalleUsuario.getName());
        Usuario.setDireccion(detalleUsuario.getDireccion());

        usuario usuarioactualizado=usuarioService.actualizarUsuario(Usuario);
        return ResponseEntity.ok(usuarioactualizado);
    }
    //metodo en cargado para eliminar un usuario por medio de la id
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable Long id){
        usuario Usuario = usuarioService.obtenerUsuario(id);

        usuarioService.eliminarUsuario(Usuario);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
