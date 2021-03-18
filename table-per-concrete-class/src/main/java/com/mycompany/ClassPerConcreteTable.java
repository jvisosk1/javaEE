package com.mycompany;

import javax.persistence.*;

import com.mycompany.Car;
import com.mycompany.Sedan;
import com.mycompany.Truck;
import com.mycompany.Suv;
import com.mycompany.Van;

public class ClassPerConcreteTable {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("testPersistenceUnit");
        EntityManager em = emf.createEntityManager();
     
     	EntityTransaction transaction = em.getTransaction();
		transaction.begin();
        
		Sedan sedan1 = new Sedan();
		em.persist(acuratl);

		Van van1 = new Van();
		em.persist(pilot);

		Suv suv1 = new Suv();
		em.persist(bmw);

    	Truck truck1= new Truck();
		em.persist(truck);

    	transaction.commit();

    }

}

