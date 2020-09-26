package com.example.demo.controller;

import com.example.demo.entity.Actor;
import com.example.demo.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fun")
public class FunController {

    private ActorService theActor;

    @Autowired
    public FunController(ActorService actorService){
        theActor = actorService;
    }

    @GetMapping("/actors")
    public List<Actor> findAll(){
       return theActor.findAll();
    }

    //create actor
    @PostMapping("/actors")
    public Actor createActor(@RequestBody Actor actor){
        actor.setActorId(0);

        theActor.createOrUpdateActor(actor);

        return actor;

    }

    //update actor
    @PutMapping("/actors")
    public Actor updateActor(@RequestBody Actor actor){
        theActor.createOrUpdateActor(actor);

        return actor;
    }

    //delete actor by id
    @DeleteMapping("/actors/{actorId}")
    public String deleteActorById(@PathVariable int actorId){
       Actor actor = theActor.findActorById(actorId);

       if(actor == null)
           throw new RuntimeException("Actor Id not found" + actorId);

       theActor.deleteActor(actorId);

       return "Actor with Id" + actorId + "deleted successfully";
    }


    //get a single actor
    @GetMapping("actors/{actorId}")
    public Actor findActorById(@PathVariable int actorId){

        Actor actor = theActor.findActorById(actorId);

        if(actor == null)
            throw new RuntimeException("Actor Id not found" + actorId);

        return actor;
    }
}
