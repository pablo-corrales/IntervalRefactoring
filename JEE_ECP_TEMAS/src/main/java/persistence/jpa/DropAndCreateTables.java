package persistence.jpa;

import javax.persistence.EntityManagerFactory;

import persistence.models.daos.jpa.DAOJPAFactory;

public class DropAndCreateTables {
	
	public static void main(String[] args) {    
	 DAOJPAFactory.dropAndCreateTables();
	 EntityManagerFactory em = DAOJPAFactory.getEntityManagerFactory();
	 em.createEntityManager();
    }

}
