package com.example.demo.controller;

import com.example.demo.entity.Actor;
import com.example.demo.entity.Salary;
import com.example.demo.service.ActorService;
import com.example.demo.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/fun")
public class FunController {

    private ActorService theActor;

    @Autowired
    private SalaryService salaryService;

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
    public Actor createActor(){
        Actor actor = new Actor("Raghav","chadda",new Date());

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

    @GetMapping("/salary")
    public List<Salary> findAllSalary(){
        return salaryService.findAll();
    }

    @GetMapping("/salary/max")
    public String findMaxSalary(){
        Float maxSalary = salaryService.findMaxSalary();
        if(maxSalary != null)
            System.out.println("Maximum salary" + maxSalary);
        return "max salary";
    }
     //adding for revert testing: feature_branch1
    public String findByName(){return null;}

    //adding feature2
    public String findByValue(){return null;}
}
