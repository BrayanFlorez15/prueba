package pruebaAngularSpring.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebaAngularSpring.demo.model.usuario;

import java.util.Optional;

@Repository
public interface usuarioRepositorio extends JpaRepository<usuario,Long> {
//metodos para el crud jpa
    public Optional<usuario> findById(Long id);

}
