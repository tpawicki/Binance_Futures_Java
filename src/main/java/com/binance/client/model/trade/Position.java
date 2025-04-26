package com.binance.client.model.trade;

import com.binance.client.constant.BinanceApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

public class Position {
    private String symbol;
    private String positionSide;
    private BigDecimal positionAmt;
    private BigDecimal unrealizedProfit;
    private BigDecimal isolatedMargin;
    private BigDecimal notional;
    private BigDecimal isolatedWallet;
    private BigDecimal initialMargin;
    private BigDecimal maintMargin;
    private Long updateTime;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPositionSide() {
        return positionSide;
    }

    public void setPositionSide(String positionSide) {
        this.positionSide = positionSide;
    }

    public BigDecimal getPositionAmt() {
        return positionAmt;
    }

    public void setPositionAmt(BigDecimal positionAmt) {
        this.positionAmt = positionAmt;
    }

    public BigDecimal getUnrealizedProfit() {
        return unrealizedProfit;
    }

    public void setUnrealizedProfit(BigDecimal unrealizedProfit) {
        this.unrealizedProfit = unrealizedProfit;
    }

    public BigDecimal getIsolatedMargin() {
        return isolatedMargin;
    }

    public void setIsolatedMargin(BigDecimal isolatedMargin) {
        this.isolatedMargin = isolatedMargin;
    }

    public BigDecimal getNotional() {
        return notional;
    }

    public void setNotional(BigDecimal notional) {
        this.notional = notional;
    }

    public BigDecimal getIsolatedWallet() {
        return isolatedWallet;
    }

    public void setIsolatedWallet(BigDecimal isolatedWallet) {
        this.isolatedWallet = isolatedWallet;
    }

    public BigDecimal getInitialMargin() {
        return initialMargin;
    }

    public void setInitialMargin(BigDecimal initialMargin) {
        this.initialMargin = initialMargin;
    }

    public BigDecimal getMaintMargin() {
        return maintMargin;
    }

    public void setMaintMargin(BigDecimal maintMargin) {
        this.maintMargin = maintMargin;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("positionSide", positionSide)
                .append("positionAmt", positionAmt)
                .append("unrealizedProfit", unrealizedProfit)
                .append("isolatedMargin", isolatedMargin)
                .append("notional", notional)
                .append("isolatedWallet", isolatedWallet)
                .append("initialMargin", initialMargin)
                .append("maintMargin", maintMargin)
                .append("updateTime", updateTime).toString();
    }
}
