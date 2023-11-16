package com.example.Actividad5.interfaz;

import com.example.Actividad5.modelo.Pelicula;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntPelicula extends CrudRepository<Pelicula, Integer> {
    
    public Optional<Pelicula> findAllById(int id);
    
}
