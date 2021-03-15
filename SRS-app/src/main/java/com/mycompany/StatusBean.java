package com.mycompany;

import javax.ejb.Stateless;
import java.io.*; 
import com.mycompany.DBConnection;
import java.sql.*;
import java.io.IOException;
import javax.sql.DataSource;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;  
import com.mycompany.Courses;
import com.mycompany.Registrar;

@Stateless 
public class StatusBean {

	// public String course_seating = "";
	// public static EntityManager entityManager;

    public String getStatus (String cid) {
		DBConnection db = new DBConnection();
   		ResultSet res = null;
   		String course_seating = "";

   		// EntityManagerFactory emf =
     //            Persistence.createEntityManagerFactory("testPersistenceUnit");
     //    entityManager = emf.createEntityManager();
     //    entityManager.getTransaction().begin();
     //    queryNative("Courses");

   		try {
			res = db.stm.executeQuery("SELECT Courses.course_id, Registrar.num_registered, Courses.course_title FROM Courses INNER JOIN Registrar ON Courses.course_id = Registrar.course_id WHERE Registrar.course_id = '" + cid + "';");
			while(res.next()){
				course_seating += (res.getString(1) + " : " + res.getString(2) + " : " + 
					res.getString(3)+ "<br>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return course_seating;
    }

    // private static void queryNative(String table) {
    //     System.out.println("----\n" + table.toUpperCase() + " TABLE");
    //     Query nativeQuery = entityManager.createNativeQuery("select * from " + table);
    //     List resultList = nativeQuery.getResultList();
    //     for (Object o : resultList) {
    //         Object oa[] = (Object[]) o;
    //         System.out.println(Arrays.asList(oa));
    //     }
    // }

    public String getAllStatus () {
   		DBConnection db = new DBConnection();
   		ResultSet res = null;
   		String course_seating_all = "";

   		try {
			res = db.stm.executeQuery("SELECT DISTINCT Courses.course_id, Registrar.num_registered, Courses.course_title FROM Courses COURSES INNER JOIN Registrar ON Courses.course_id = Registrar.course_id ORDER BY Courses.course_id;");
			while(res.next()){
				course_seating_all += (res.getString(1) + " : " + res.getString(2)) + " : " + 
					res.getString(3)+ "<br>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return course_seating_all;
    }
}