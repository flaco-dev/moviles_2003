/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.flaco;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class ControladorPerfil {

    //Esta es la inversion de control o inyeccion de dependencias
    @Autowired
    RepoPerfil repoPerfil;

//en los servicios REST se tiene un urlbase que consiste
    //de la ip o host, seguida del puerto, despues /api/hola
//para este caso mi api REST es:
//http://localhost:8080/api/hola
    @GetMapping("/hola")
    public Saludo saludar() {
        Saludo s = new Saludo();
        s.setNombre("Omar Molina");
        s.setMensaje("Mi primer mensaje en spring rest");
        return s;
    }

//el siguiente metodo va a servir para guardar en un back-end nuestros datos
//del perfil
//para guardad SIEMPRE debes usar el meodo POST
    @PostMapping("/perfil")
    public Estatus guardar(@RequestBody String json) throws Exception {
        //Paso 1 para recibir ese objeto json es leerlo y convertirlo
        //en objeto JAVA a esto se le llama des-serializacion
        ObjectMapper maper = new ObjectMapper();
        Perfil perfil = maper.readValue(json, Perfil.class);
        //por experiencia antes de guardar tenemos que checar que llego bien 
        //todo el objeto y se leyo bien
        System.out.println("Perfil leido" + perfil);
        //aqui este objeto perfil despues se guarda con una sola linea en mongodb
        //aqui va a ir la linea para guardar
        repoPerfil.save(perfil);

        //Despues enviamos un mensaje de estatus al cliente para que se informe
        //si se guardo o no su perfil
        Estatus e = new Estatus();
        e.setSuccess(true);
        e.setMensaje("Perfil guardado con exito!!!!");
        return e;
    }

//vamos a generar nuestros servicios para actualizar un perfil
    @PutMapping("/perfil")
    public Estatus actualizar(@RequestBody String json) throws Exception {
        //Paso 1 para recibir ese objeto json es leerlo y convertirlo
        //en objeto JAVA a esto se le llama des-serializacion
        ObjectMapper maper = new ObjectMapper();
        Perfil perfil = maper.readValue(json, Perfil.class);
        //por experiencia antes de guardar tenemos que checar que llego bien 
        //todo el objeto y se leyo bien
        System.out.println("Perfil leido" + perfil);
        //aqui este objeto perfil despues se guarda con una sola linea en mongodb
        //aqui va a ir la linea para guardar
        repoPerfil.save(perfil);

        //Despues enviamos un mensaje de estatus al cliente para que se informe
        //si se guardo o no su perfil
        Estatus e = new Estatus();
        e.setSuccess(true);
        e.setMensaje("Perfil actualizado con exito!!!!");
        return e;
    }

    @DeleteMapping("/perfil/{id}")
    public Estatus borrar(@PathVariable String id){
        //invocamos el repositorio
        repoPerfil.deleteById(id);
        //GENERAMOS EL ESTATUS
        Estatus e = new Estatus();
        e.setMensaje("Perfil borrado con exito");
        e.setSuccess(true);
        return e;
    }
            
    //el metodo para buscar todos
    @GetMapping("/perfil")
    public List<Perfil> buscarTodos(){
    
        return repoPerfil.findAll();
    }
    
    //finalmente el de buscar por id
    @GetMapping("/perfil/{id}")
    public Perfil buscarPorId(@PathVariable String id){
    
        return repoPerfil.findById(id).get();
        
    }
    
}
