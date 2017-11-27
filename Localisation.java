package esprit.tn.netlammou10.entities;

/**
 * Created by USER on 23/11/2017.
 */

public class Localisation {
    private int id;
    private float altitude;
    private float longitude;
    private String type;

    public Localisation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
