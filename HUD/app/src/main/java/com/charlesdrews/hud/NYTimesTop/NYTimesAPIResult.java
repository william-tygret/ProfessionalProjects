package com.charlesdrews.hud.NYTimesTop;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.transform.Result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class NYTimesAPIResult {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("num_results")
    @Expose
    private Integer numResults;
    @SerializedName("results")
    @Expose
    private List<com.charlesdrews.hud.NYTimesTop.Result> results = new ArrayList<>();

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The copyright
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     *
     * @param copyright
     * The copyright
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     *
     * @return
     * The numResults
     */
    public Integer getNumResults() {
        return numResults;
    }

    /**
     *
     * @param numResults
     * The num_results
     */
    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    /**
     *
     * @return
     * The results
     */
    public List<com.charlesdrews.hud.NYTimesTop.Result> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    public void setResults(List<com.charlesdrews.hud.NYTimesTop.Result> results) {
        this.results = results;
    }

}
