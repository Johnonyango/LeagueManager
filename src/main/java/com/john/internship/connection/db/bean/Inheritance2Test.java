package com.john.internship.connection.db.bean;


import com.john.internship.model.inheritance2.Audi;
import com.john.internship.model.inheritance2.Car;
import com.john.internship.model.inheritance2.Toyota;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Remote
public class Inheritance2Test {
    @PersistenceContext
    private EntityManager em;

    public void addSomeCars(){
        Toyota toyota = new Toyota();
        toyota.setJapanTown("Nagasaki");
        toyota.setName("Rav4");
        toyota.setBodyType("SUV");
        em.merge(toyota);

        Audi audi = new Audi();
        audi.setGermanTown("Munich");
        audi.setName("Benz");
        audi.setBodyType("SUV");
        em.merge(audi);

        Car car = new Car();
        car.setName("Ford");
        car.setBodyType("SUV");
        em.merge(car);
    }

    public void listToyota( String searchBy, int start, int max){

        List<Toyota> toyotas = em.createNamedQuery("Toyota.All")
               // .setFirstResult(start)
               // .setMaxResults(max)
                .getResultList();

        for (Toyota toyota:toyotas){
            System.out.println(toyota.toyotaDetails());
        }
    }
}
