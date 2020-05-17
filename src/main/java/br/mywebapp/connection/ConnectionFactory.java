package br.mywebapp.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
    public static EntityManagerFactory emf;
    
    public static EntityManager getConnection(){
    	if (emf == null) {
			emf  = Persistence.createEntityManagerFactory("mywebappPU");
		}
        return emf.createEntityManager();
    }
}
