package br.com.jsf_jpa_crud.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
	
	public static void shutdown() {
		if(FACTORY != null) {
			FACTORY.close();
		}
	}
}
