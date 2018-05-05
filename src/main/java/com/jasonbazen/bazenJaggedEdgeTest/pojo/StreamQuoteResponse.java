package com.jasonbazen.bazenJaggedEdgeTest.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class StreamQuoteResponse implements Serializable {

    @JsonIgnore
    private String table;

    @JsonIgnore
    private String action;

    private List<QuoteResponse> data;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public List<QuoteResponse> getData() {
        return data;
    }

    public void setData(List<QuoteResponse> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreamQuoteResponse that = (StreamQuoteResponse) o;
        return Objects.equals(action, that.action) &&
                Objects.equals(table, that.table) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, table, data);
    }

    @Override
    public String toString() {
        return "StreamQuoteResponse{" +
                "action='" + action + '\'' +
                ", table='" + table + '\'' +
                ", data=" + data +
                '}';
    }

}
