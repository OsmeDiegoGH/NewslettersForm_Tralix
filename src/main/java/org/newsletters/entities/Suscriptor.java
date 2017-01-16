package org.newsletters.entities;

public class Suscriptor {
    private int id;
    private String email;
    private String name;
    private String lastName;
    private String maternalLastName;
    private int stateId;
    private int industryId;

    public Suscriptor(){}

    public Suscriptor(int id, String email, String name, String lastName, String maternalLastName, int stateId, int industryId) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.maternalLastName = maternalLastName;
        this.stateId = stateId;
        this.industryId = industryId;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMaternalLastName() {
        return maternalLastName;
    }

    public void setMaternalLastName(String maternalLastName) {
        this.maternalLastName = maternalLastName;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public int getIndustryId() {
        return industryId;
    }

    public void setIndustryId(int industryId) {
        this.industryId = industryId;
    }
}
