package ru.home.learning.producers;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * CDI компонент, производящий объект типа EntityManager
 */
public class DatabaseProducer {
    @Produces
    @PersistenceContext(unitName = "demoPU")
    private EntityManager entityManager;
}