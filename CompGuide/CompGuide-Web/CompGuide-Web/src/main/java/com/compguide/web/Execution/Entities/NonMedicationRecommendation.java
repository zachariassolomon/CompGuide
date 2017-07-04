package com.compguide.web.Execution.Entities;

import com.google.gson.Gson;

/**
 * Created with IntelliJ IDEA. User: tiago Date: 20-08-2013 Time: 23:32 To
 * change this template use File | Settings | File Templates.
 */
public class NonMedicationRecommendation extends ClinicalAction {

    public static NonMedicationRecommendation fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, NonMedicationRecommendation.class);
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
