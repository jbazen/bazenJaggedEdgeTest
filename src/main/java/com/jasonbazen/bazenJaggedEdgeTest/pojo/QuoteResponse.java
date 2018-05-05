package com.jasonbazen.bazenJaggedEdgeTest.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteResponse implements Serializable {

    private String symbol;

    private String timestamp;

    private int bidPrice;

    @JsonIgnore
    private int askPrice;

    @JsonIgnore
    private int askSize;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(int bidPrice) {
        this.bidPrice = bidPrice;
    }

    public int getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(int askPrice) {
        this.askPrice = askPrice;
    }

    public int getAskSize() {
        return askSize;
    }

    public void setAskSize(int askSize) {
        this.askSize = askSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuoteResponse that = (QuoteResponse) o;
        return bidPrice == that.bidPrice &&
                askPrice == that.askPrice &&
                askSize == that.askSize &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, timestamp, bidPrice, askPrice, askSize);
    }

    @Override
    public String toString() {
        return "QuoteResponse{" +
                "symbol='" + symbol + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", bidPrice=" + bidPrice +
                '}';
    }

}
