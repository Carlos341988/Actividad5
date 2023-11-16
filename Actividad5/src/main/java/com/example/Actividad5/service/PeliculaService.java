package com.example.Actividad5.service;

import com.example.Actividad5.interfaz.IntPelicula;
import com.example.Actividad5.interfazService.InterPelicula;
import com.example.Actividad5.modelo.Pelicula;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaService implements InterPelicula{
    
    @Autowired
    private IntPelicula data; 
    

    @Override
    public List<Pelicula> listar() {
        return (List<Pelicula>) data.findAll();
    }

    @Override
    public Optional<Pelicula> listarId(int id) {
       return data.findById(id);
    }

    @Override
    public int save(Pelicula p) {
       int res = 0;
       Pelicula pelicula =data.save(p);
       if(!pelicula.equals(p)){
           
       }
       return res;
    }

    @Override
    public int delete(int idPelicula) {
      Optional<Pelicula> peliculas = listarId(idPelicula);
      if(peliculas.isPresent()){
          data.delete(peliculas.get());
      }
      return 0;
    }
    
    
    
}
