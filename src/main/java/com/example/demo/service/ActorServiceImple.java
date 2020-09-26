package com.example.demo.service;

import com.example.demo.dao.ActorDao;

import com.example.demo.entity.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ActorServiceImple implements ActorService {

    private ActorDao actorDao;

    @Autowired
    public ActorServiceImple(ActorDao theActorDao){
        actorDao = theActorDao;
    }

    @Override
    @Transactional
    public List<Actor> findAll(){
        return actorDao.findAll();
    }

    @Override
    @Transactional
    public void createOrUpdateActor(Actor theActor){
        actorDao.createOrUpdateActor(theActor);
    }

    @Override
    @Transactional
    public void deleteActor(int id){
        actorDao.deleteActor(id);
    }

    @Override
    @Transactional
    public Actor findActorById(int id){
        return actorDao.findActorById(id);
    }
}
