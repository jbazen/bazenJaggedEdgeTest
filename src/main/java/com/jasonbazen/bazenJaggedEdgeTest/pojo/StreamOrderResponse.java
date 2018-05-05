package com.jasonbazen.bazenJaggedEdgeTest.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class StreamOrderResponse implements Serializable {

    @JsonIgnore
    private String table;

    @JsonIgnore
    private String action;

    private List<OrderResponse> data;

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

    public List<OrderResponse> getData() {
        return data;
    }

    public void setData(List<OrderResponse> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreamOrderResponse that = (StreamOrderResponse) o;
        return Objects.equals(table, that.table) &&
                Objects.equals(action, that.action) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table, action, data);
    }

    @Override
    public String toString() {
        return "StreamOrderResponse{" +
                "table='" + table + '\'' +
                ", action='" + action + '\'' +
                ", data=" + data +
                '}';
    }

}
