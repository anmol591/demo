package com.example.demo.dao;

import com.example.demo.entity.Actor;

import java.util.List;

public interface ActorDao {

    public List<Actor> findAll();

    public void createOrUpdateActor(Actor actor);

    public void deleteActor(int id);

    public Actor findActorById(int id);
}
