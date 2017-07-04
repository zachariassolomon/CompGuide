package com.compguide.web.Execution.Entities;

import com.google.gson.Gson;

/**
 * Created with IntelliJ IDEA. User: tiago Date: 20-08-2013 Time: 22:53 To
 * change this template use File | Settings | File Templates.
 */
public class Duration {

    private String id;
    private Double maxDurationValue;
    private Double minDurationValue;
    private String temporalUnit;
    private Double durationValue;

    public Duration() {
    }

    public static Duration fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Duration.class);
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public Boolean isSingleDuration() {
        return maxDurationValue.equals(minDurationValue);
    }

    public String getTemporalUnit() {
        return temporalUnit;
    }

    public Double getDurationValue() {
        return durationValue;
    }

    public void setDurationValue(Double durationValue) {
        this.durationValue = durationValue;
    }

    public void setTemporalUnit(String temporalUnit) {
        this.temporalUnit = temporalUnit;
    }

    public Double getMinDurationValue() {
        return minDurationValue;
    }

    public void setMinDurationValue(double minDurationValue) {
        this.minDurationValue = minDurationValue;
    }

    public Double getMaxDurationValue() {
        return maxDurationValue;
    }

    public void setMaxDurationValue(double maxDurationValue) {
        this.maxDurationValue = maxDurationValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean asExactValue() {
        if (durationValue != null) {
            return true;
        }
        return false;
    }

    public boolean asInterval() {
        if (minDurationValue != null && maxDurationValue != null) {
            return true;
        }
        return false;
    }
}
