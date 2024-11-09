package com.example.demo.controller;

import com.example.demo.entity.Actors;
import com.example.demo.entity.ActorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ActorController {

    @Autowired
    private ActorsRepository actorsRepository;

    @GetMapping("/actors")
    public List<Actors> findAllActors() {
       List<Actors> actorsList =  actorsRepository.findAll();
       return actorsList;
    }

    @PostMapping("/actors")
    public Actors createActor(@RequestBody Actors actors) {
        Actors actors1 = actorsRepository.save(actors);
        return actors1;
    }

    @GetMapping("/actors/{id}")
    public Actors getActor(@PathVariable Long id) {
        Actors actors = actorsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Actor with given id not found"));
        return actors;
    }

    @PutMapping("/actors/{id}")
    public Actors updateActor(@RequestBody Actors actors,@PathVariable Long id) {
        Actors actors1 = actorsRepository.getOne(id);
        if(actors1 != null) {
            actors1.setName(actors.getName());
            actors1.setSex(actors.getSex());
            return actorsRepository.save(actors1);
        }
        return null;
    }
}
