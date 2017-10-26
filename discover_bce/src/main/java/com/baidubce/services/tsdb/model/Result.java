package com.baidubce.services.tsdb.model;

import java.util.List;

/**
 * Represent the result for querying datapoints from Tsdb.
 */
public class Result {
    
    private String metric;
    
    private long rawCount;
    
    private List<Group> groups;

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public long getRawCount() {
        return rawCount;
    }

    public void setRawCount(long rawCount) {
        this.rawCount = rawCount;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
