package com.example.demo.service;

import com.example.demo.entity.Actor;

import java.util.List;

public interface ActorService {

    public List<Actor>findAll();

    public void createOrUpdateActor(Actor actor);

    public void deleteActor(int actorId);

    public Actor findActorById(int actorId);
}
