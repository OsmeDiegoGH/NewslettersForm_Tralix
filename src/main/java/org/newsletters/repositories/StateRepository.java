package org.newsletters.repositories;

import java.util.List;
import org.newsletters.daos.OracleDAO;
import org.newsletters.entities.State;

public class StateRepository{
    
    private final OracleDAO<State> DAO;
    
    public StateRepository(){
        this(new OracleDAO(State.class));
    }
    
    public StateRepository(OracleDAO<State> dao){
        this.DAO = dao;
    }

    public List<State> get() {
        return this.DAO.get();
    }
}
