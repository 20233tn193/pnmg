package com.backend.service.modules.people;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PeopleServices {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<Person> obtenerTodos() {
        return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    @Transactional
    public Person registrar(Person person) {
        person.setId(null);
        person.setName(person.getName().trim());
        em.persist(person);
        return person;
    }
}
