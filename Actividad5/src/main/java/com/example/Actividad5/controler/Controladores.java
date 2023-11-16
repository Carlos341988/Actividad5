package com.example.Actividad5.controler;

import com.example.Actividad5.interfazService.InterPelicula;
import com.example.Actividad5.modelo.Pelicula;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class Controladores {
    
     @Autowired
     private InterPelicula service;
     
     @GetMapping("/")
     public String listar (Model model){
         List<Pelicula> peliculas = service.listar();
         model.addAttribute("catalogo", peliculas);
         return "Index";
     }
     
     @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("pelicula", new Pelicula());
        return "Form";
    }
    
    @PostMapping("/save")
    public String save(@ModelAttribute Pelicula p){
        System.out.println(p);
        service.save(p);
        return "redirect:/";
    }
    
    @GetMapping("/update/{id}")
    public String update(Model model,@PathVariable String id){
        Optional<Pelicula> peliculas = service.listarId(Integer.parseInt(id));
        if(peliculas.isPresent()){
            model.addAttribute("pelicula", peliculas.get());
        }
        return "Form";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        service.delete(Integer.parseInt(id));
        return "redirect:/";
    }
    
    
}
