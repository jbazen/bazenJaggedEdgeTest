package com.jasonbazen.bazenJaggedEdgeTest.pojo;

import java.io.Serializable;
import java.util.Objects;

public class OrderRequest implements Serializable {

    private String symbol;

    private String side;

    private int orderQty;

    private String ordType;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public String getOrdType() {
        return ordType;
    }

    public void setOrdType(String ordType) {
        this.ordType = ordType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRequest that = (OrderRequest) o;
        return orderQty == that.orderQty &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(side, that.side) &&
                Objects.equals(ordType, that.ordType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, side, orderQty, ordType);
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "symbol='" + symbol + '\'' +
                ", side='" + side + '\'' +
                ", orderQty=" + orderQty +
                ", ordType='" + ordType + '\'' +
                '}';
    }

}
