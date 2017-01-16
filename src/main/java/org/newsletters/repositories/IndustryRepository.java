package org.newsletters.repositories;

import java.util.List;
import org.newsletters.daos.OracleDAO;
import org.newsletters.entities.Industry;

public class IndustryRepository{
    
    private final OracleDAO<Industry> DAO;
    
    public IndustryRepository(){
        this(new OracleDAO(Industry.class));
    }
    
    public IndustryRepository(OracleDAO<Industry> dao){
        this.DAO = dao;
    }

    public List<Industry> get() {
        return this.DAO.get();
    }
}
