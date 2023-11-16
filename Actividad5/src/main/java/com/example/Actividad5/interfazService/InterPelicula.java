package com.example.Actividad5.interfazService;

import com.example.Actividad5.modelo.Pelicula;
import java.util.List;
import java.util.Optional;


public interface InterPelicula {
    
    public List<Pelicula> listar();
    public Optional<Pelicula> listarId(int id);
    public int save(Pelicula p);
    public int delete(int id);
    
}
