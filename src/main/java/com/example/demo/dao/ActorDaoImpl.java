package com.example.demo.dao;

import com.example.demo.entity.Actor;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;

import java.util.List;

@Repository
public class ActorDaoImpl implements ActorDao {

    private EntityManager entityManager;

    @Autowired
    public ActorDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Actor> findAll(){

        //create session
        Session currentSession = entityManager.unwrap(Session.class);

        //create query
        Query<Actor> theQuery = currentSession.createQuery("from Actor", Actor.class);

        List<Actor> actors = theQuery.getResultList();

        return actors;

    }

    @Override
    public void createOrUpdateActor(Actor actor){
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(actor);
    }

    @Override
    public void deleteActor(int id){

        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery = currentSession.createQuery("delete from Actor where actorId=:actorId");

        theQuery.setParameter("actorId",id);

        theQuery.executeUpdate();
    }

    @Override
    public Actor findActorById(int id){
        Session currentSession = entityManager.unwrap(Session.class);

        Actor theActor = currentSession.get(Actor.class,id);

        return theActor;

    }
}
