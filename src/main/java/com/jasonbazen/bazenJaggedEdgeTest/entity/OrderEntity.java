package com.jasonbazen.bazenJaggedEdgeTest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String clOrdLinkID;

    private double simpleOrderQty;

    private String ordRejReason;

    private String clOrdID;

    private double avgPx;

    private String pegPriceType;

    private String currency;

    private String timestamp;

    private double displayQty;

    private String workingIndicator;

    private String contingencyType;

    private String side;

    private String cumQty;

    private String exDestination;

    private String transactTime;

    private double pegOffsetValue;

    private String triggered;

    private String execInst;

    private String text;

    private String settlCurrency;

    private String orderID;

    private String symbol;

    private String multiLegReportingType;

    private String timeInForce;

    private String ordType;

    private String ordStatus;

    private double stopPx;

    private double price;

    private double simpleCumQty;

    private double leavesQty;

    private double account;

    private double simpleLeavesQty;

    private double orderQty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClOrdLinkID() {
        return clOrdLinkID;
    }

    public void setClOrdLinkID(String clOrdLinkID) {
        this.clOrdLinkID = clOrdLinkID;
    }

    public double getSimpleOrderQty() {
        return simpleOrderQty;
    }

    public void setSimpleOrderQty(double simpleOrderQty) {
        this.simpleOrderQty = simpleOrderQty;
    }

    public String getOrdRejReason() {
        return ordRejReason;
    }

    public void setOrdRejReason(String ordRejReason) {
        this.ordRejReason = ordRejReason;
    }

    public String getClOrdID() {
        return clOrdID;
    }

    public void setClOrdID(String clOrdID) {
        this.clOrdID = clOrdID;
    }

    public double getAvgPx() {
        return avgPx;
    }

    public void setAvgPx(double avgPx) {
        this.avgPx = avgPx;
    }

    public String getPegPriceType() {
        return pegPriceType;
    }

    public void setPegPriceType(String pegPriceType) {
        this.pegPriceType = pegPriceType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public double getDisplayQty() {
        return displayQty;
    }

    public void setDisplayQty(double displayQty) {
        this.displayQty = displayQty;
    }

    public String getWorkingIndicator() {
        return workingIndicator;
    }

    public void setWorkingIndicator(String workingIndicator) {
        this.workingIndicator = workingIndicator;
    }

    public String getContingencyType() {
        return contingencyType;
    }

    public void setContingencyType(String contingencyType) {
        this.contingencyType = contingencyType;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getCumQty() {
        return cumQty;
    }

    public void setCumQty(String cumQty) {
        this.cumQty = cumQty;
    }

    public String getExDestination() {
        return exDestination;
    }

    public void setExDestination(String exDestination) {
        this.exDestination = exDestination;
    }

    public String getTransactTime() {
        return transactTime;
    }

    public void setTransactTime(String transactTime) {
        this.transactTime = transactTime;
    }

    public double getPegOffsetValue() {
        return pegOffsetValue;
    }

    public void setPegOffsetValue(double pegOffsetValue) {
        this.pegOffsetValue = pegOffsetValue;
    }

    public String getTriggered() {
        return triggered;
    }

    public void setTriggered(String triggered) {
        this.triggered = triggered;
    }

    public String getExecInst() {
        return execInst;
    }

    public void setExecInst(String execInst) {
        this.execInst = execInst;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSettlCurrency() {
        return settlCurrency;
    }

    public void setSettlCurrency(String settlCurrency) {
        this.settlCurrency = settlCurrency;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getMultiLegReportingType() {
        return multiLegReportingType;
    }

    public void setMultiLegReportingType(String multiLegReportingType) {
        this.multiLegReportingType = multiLegReportingType;
    }

    public String getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(String timeInForce) {
        this.timeInForce = timeInForce;
    }

    public String getOrdType() {
        return ordType;
    }

    public void setOrdType(String ordType) {
        this.ordType = ordType;
    }

    public String getOrdStatus() {
        return ordStatus;
    }

    public void setOrdStatus(String ordStatus) {
        this.ordStatus = ordStatus;
    }

    public double getStopPx() {
        return stopPx;
    }

    public void setStopPx(double stopPx) {
        this.stopPx = stopPx;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSimpleCumQty() {
        return simpleCumQty;
    }

    public void setSimpleCumQty(double simpleCumQty) {
        this.simpleCumQty = simpleCumQty;
    }

    public double getLeavesQty() {
        return leavesQty;
    }

    public void setLeavesQty(double leavesQty) {
        this.leavesQty = leavesQty;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public double getSimpleLeavesQty() {
        return simpleLeavesQty;
    }

    public void setSimpleLeavesQty(double simpleLeavesQty) {
        this.simpleLeavesQty = simpleLeavesQty;
    }

    public double getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(double orderQty) {
        this.orderQty = orderQty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return Double.compare(that.simpleOrderQty, simpleOrderQty) == 0 &&
                Double.compare(that.avgPx, avgPx) == 0 &&
                Double.compare(that.displayQty, displayQty) == 0 &&
                Double.compare(that.pegOffsetValue, pegOffsetValue) == 0 &&
                Double.compare(that.stopPx, stopPx) == 0 &&
                Double.compare(that.price, price) == 0 &&
                Double.compare(that.simpleCumQty, simpleCumQty) == 0 &&
                Double.compare(that.leavesQty, leavesQty) == 0 &&
                Double.compare(that.account, account) == 0 &&
                Double.compare(that.simpleLeavesQty, simpleLeavesQty) == 0 &&
                Double.compare(that.orderQty, orderQty) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(clOrdLinkID, that.clOrdLinkID) &&
                Objects.equals(ordRejReason, that.ordRejReason) &&
                Objects.equals(clOrdID, that.clOrdID) &&
                Objects.equals(pegPriceType, that.pegPriceType) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(timestamp, that.timestamp) &&
                Objects.equals(workingIndicator, that.workingIndicator) &&
                Objects.equals(contingencyType, that.contingencyType) &&
                Objects.equals(side, that.side) &&
                Objects.equals(cumQty, that.cumQty) &&
                Objects.equals(exDestination, that.exDestination) &&
                Objects.equals(transactTime, that.transactTime) &&
                Objects.equals(triggered, that.triggered) &&
                Objects.equals(execInst, that.execInst) &&
                Objects.equals(text, that.text) &&
                Objects.equals(settlCurrency, that.settlCurrency) &&
                Objects.equals(orderID, that.orderID) &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(multiLegReportingType, that.multiLegReportingType) &&
                Objects.equals(timeInForce, that.timeInForce) &&
                Objects.equals(ordType, that.ordType) &&
                Objects.equals(ordStatus, that.ordStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clOrdLinkID, simpleOrderQty, ordRejReason, clOrdID, avgPx, pegPriceType, currency, timestamp, displayQty, workingIndicator, contingencyType, side, cumQty, exDestination, transactTime, pegOffsetValue, triggered, execInst, text, settlCurrency, orderID, symbol, multiLegReportingType, timeInForce, ordType, ordStatus, stopPx, price, simpleCumQty, leavesQty, account, simpleLeavesQty, orderQty);
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", clOrdLinkID='" + clOrdLinkID + '\'' +
                ", simpleOrderQty=" + simpleOrderQty +
                ", ordRejReason='" + ordRejReason + '\'' +
                ", clOrdID='" + clOrdID + '\'' +
                ", avgPx=" + avgPx +
                ", pegPriceType='" + pegPriceType + '\'' +
                ", currency='" + currency + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", displayQty=" + displayQty +
                ", workingIndicator='" + workingIndicator + '\'' +
                ", contingencyType='" + contingencyType + '\'' +
                ", side='" + side + '\'' +
                ", cumQty='" + cumQty + '\'' +
                ", exDestination='" + exDestination + '\'' +
                ", transactTime='" + transactTime + '\'' +
                ", pegOffsetValue=" + pegOffsetValue +
                ", triggered='" + triggered + '\'' +
                ", execInst='" + execInst + '\'' +
                ", text='" + text + '\'' +
                ", settlCurrency='" + settlCurrency + '\'' +
                ", orderID='" + orderID + '\'' +
                ", symbol='" + symbol + '\'' +
                ", multiLegReportingType='" + multiLegReportingType + '\'' +
                ", timeInForce='" + timeInForce + '\'' +
                ", ordType='" + ordType + '\'' +
                ", ordStatus='" + ordStatus + '\'' +
                ", stopPx=" + stopPx +
                ", price=" + price +
                ", simpleCumQty=" + simpleCumQty +
                ", leavesQty=" + leavesQty +
                ", account=" + account +
                ", simpleLeavesQty=" + simpleLeavesQty +
                ", orderQty=" + orderQty +
                '}';
    }
}
