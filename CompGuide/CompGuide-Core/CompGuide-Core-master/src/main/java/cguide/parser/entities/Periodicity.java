package cguide.parser.entities;

import cguide.execution.entities.CyclePartDefinition;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: tiago
 * Date: 20-08-2013
 * Time: 22:53
 * To change this template use File | Settings | File Templates.
 */
public class Periodicity  {
    private String id;
    private ArrayList<ConditionSet> stopConditionSet;
    private Integer repetitionValue;
    private String temporalUnit;
    private Double periodicityValue;
    private CyclePartDefinition cyclePartDefinition;

    public Periodicity(){
           stopConditionSet = new ArrayList<ConditionSet>();
    }

    public static Periodicity fromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Periodicity.class);
    }

    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    public void  addStopConditionSet(ConditionSet conditionSet){
        this.stopConditionSet.add(conditionSet);
    }
    public Integer getRepetitionValue() {
        return repetitionValue;
    }

    public Double getPeriodicityValue() {
        return periodicityValue;
    }

    public void setPeriodicityValue(Double periodicityValue) {
        this.periodicityValue = periodicityValue;
    }

    public void setRepetitionValue(Integer repetitionValue) {
        this.repetitionValue = repetitionValue;
    }

    public CyclePartDefinition getCyclePartDefinition() {
        return cyclePartDefinition;
    }

    public void setCyclePartDefinition(CyclePartDefinition cyclePartDefinition) {
        this.cyclePartDefinition = cyclePartDefinition;
    }

    public String getTemporalUnit() {
        return temporalUnit;
    }

    public void setTemporalUnit(String temporalUnit) {
        this.temporalUnit = temporalUnit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<ConditionSet> getStopConditionSet() {
        return stopConditionSet;
    }

    public void setStopConditionSet(ArrayList<ConditionSet> stopConditionSet) {
        this.stopConditionSet = stopConditionSet;
    }
}
