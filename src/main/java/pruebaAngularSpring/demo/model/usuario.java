package pruebaAngularSpring.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
// se le da nombre a la tabla de la base de datos
@Table (name = "usuario")
//getter y setter
@Data
//constructor bacio
@NoArgsConstructor
public class usuario {
    //modelo de los datos a utilizar
    //se le da el nombre a las columnas de la base de datos
    @Id
    @GeneratedValue
    @Column(name ="idusuario")
    private Integer idusuario;
    @Column (name="email")
    private String email;
    @Column (name="password")
    private String password;
    @Column (name="name")
    private String name;
    @Column (name="direccion")
    private String direccion;

}
