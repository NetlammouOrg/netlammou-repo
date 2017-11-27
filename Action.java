package esprit.tn.netlammou10.entities;

import java.util.Date;

/**
 * Created by USER on 24/11/2017.
 */

public class Action {

    private int id;
    private String name;
    private Date date;
    private Localisation localisation;
    private ActionType type;
    private String description;
    private boolean actif;
    private int desiredVolenteers;

    public Action() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public int getDesiredVolenteers() {
        return desiredVolenteers;
    }

    public void setDesiredVolenteers(int desiredVolenteers) {
        this.desiredVolenteers = desiredVolenteers;
    }

    public Action(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Action(int id, String name, Date date, Localisation localisation, ActionType type, String description, boolean actif, int desiredVolenteers) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.localisation = localisation;
        this.type = type;
        this.description = description;
        this.actif = actif;
        this.desiredVolenteers = desiredVolenteers;
    }

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setType(String type) {

    }
}
