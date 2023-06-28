package com.SplitEasier.spliteasier.splitwise.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Expense {
    private BigDecimal cost;
    private String description;
    @JsonProperty(value = "group_id", access = JsonProperty.Access.READ_WRITE)
    private int groupId;
    @JsonProperty(value = "split_equally", access = JsonProperty.Access.READ_WRITE)
    private boolean splitEqually;

    public Expense(BigDecimal cost, String description, int groupId, boolean splitEqually) {
        this.cost = cost;
        this.description = description;
        this.groupId = groupId;
        this.splitEqually = splitEqually;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public boolean isSplitEqually() {
        return splitEqually;
    }

    public void setSplitEqually(boolean splitEqually) {
        this.splitEqually = splitEqually;
    }
}
