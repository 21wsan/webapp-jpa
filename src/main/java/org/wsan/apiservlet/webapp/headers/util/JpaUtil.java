package org.wsan.apiservlet.webapp.headers.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    private static final EntityManagerFactory entitiManagerFactory = buidEntityManagerFactory();

    private static EntityManagerFactory buidEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("ejemploJpa");
    }

    public static EntityManager getEntityManager(){
        return entitiManagerFactory.createEntityManager();
    }
}
