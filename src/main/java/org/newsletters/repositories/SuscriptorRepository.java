package org.newsletters.repositories;

import org.newsletters.daos.OracleDAO;
import org.newsletters.entities.Suscriptor;

public class SuscriptorRepository{
    
    private final OracleDAO<Suscriptor> DAO;
    
    public SuscriptorRepository(){
        this(new OracleDAO(Suscriptor.class));
    }
    
    public SuscriptorRepository(OracleDAO<Suscriptor> dao){
        this.DAO = dao;
    }

    public void insert(Suscriptor entity) {
        DAO.insert(entity);
    }
}
