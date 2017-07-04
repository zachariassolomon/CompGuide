package DataBase.Entities;

import com.google.gson.Gson;

/**
 * Created by IntelliJ IDEA. Medication: tiago Date: 18/07/12 Time: 10:25 PM
 */
public class Medication {

    private String idmedication;
    private String name;
    private String activeingredient;
    private String dosage;
    private String pharmaceuticalform;
    private String posology;
    private String description;
    private String time;
    private String idguideexec;
    private String guideline;
    private String user;
    private String patient;

    public Medication() {
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static Medication fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Medication.class);
    }

    public String toJsonListElement() {
        return "{\"idmedication\":\"" + idmedication + "\",\"name\":\"" + name + "\",\"description\":\"" + description + "\",\"idguideexec\":\"" + idguideexec + "\"}";
    }

    // getters and setters
    public void setIdmedication(String idmedication) {
        this.idmedication = idmedication;
    }

    public String getIdmedication() {
        return this.idmedication;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActiveingredient() {
        return activeingredient;
    }

    public void setActiveingredient(String activeingredient) {
        this.activeingredient = activeingredient;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getPosology() {
        return posology;
    }

    public void setPosology(String posology) {
        this.posology = posology;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdguideexec() {
        return idguideexec;
    }

    public void setTipo(String idguideexec) {
        this.idguideexec = idguideexec;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPharmaceuticalform() {
        return pharmaceuticalform;
    }

    public void setPharmaceuticalform(String pharmaceuticalform) {
        this.pharmaceuticalform = pharmaceuticalform;
    }

    public String getGuideline() {
        return guideline;
    }

    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }
}
