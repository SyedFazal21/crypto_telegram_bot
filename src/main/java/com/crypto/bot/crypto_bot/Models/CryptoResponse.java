package com.crypto.bot.crypto_bot.Models;

import java.text.DecimalFormat;

public class CryptoResponse {
    private String exchangeId;
    private String rank;
    private String baseSymbol;
    private String baseId;
    private String quoteSymbol;
    private String quoteId;
    private String priceQuote;
    private String priceUsd;
    private String volumeUsd24Hr;
    private String percentExchangeVolume;
    private String tradesCount24Hr;
    private float updated;


    // Getter Methods

    public String getExchangeId() {
        return exchangeId;
    }

    public String getRank() {
        return rank;
    }

    public String getBaseSymbol() {
        return baseSymbol;
    }

    public String getBaseId() {
        return baseId;
    }

    public String getQuoteSymbol() {
        return quoteSymbol;
    }

    public String getQuoteId() {
        return quoteId;
    }

    public String getPriceQuote() {
        return priceQuote;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public String getVolumeUsd24Hr() {
        return volumeUsd24Hr;
    }

    public String getPercentExchangeVolume() {
        return percentExchangeVolume;
    }

    public String getTradesCount24Hr() {
        return tradesCount24Hr;
    }

    public float getUpdated() {
        return updated;
    }

    // Setter Methods

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setBaseSymbol(String baseSymbol) {
        this.baseSymbol = baseSymbol;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    public void setQuoteSymbol(String quoteSymbol) {
        this.quoteSymbol = quoteSymbol;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public void setPriceQuote(String priceQuote) {
        this.priceQuote = priceQuote;
    }

    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    public void setVolumeUsd24Hr(String volumeUsd24Hr) {
        this.volumeUsd24Hr = volumeUsd24Hr;
    }

    public void setPercentExchangeVolume(String percentExchangeVolume) {
        this.percentExchangeVolume = percentExchangeVolume;
    }

    public void setTradesCount24Hr(String tradesCount24Hr) {
        this.tradesCount24Hr = tradesCount24Hr;
    }

    public void setUpdated(float updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Crypto Symbol:      " + this.getBaseSymbol() + "\n" +
               "Crypto Name:         " + this.getBaseId() + "\n" +
               "Price in USD:          " + DecimalFormat.getCurrencyInstance().format(Float.parseFloat(this.getPriceQuote())) + "\n";
    }
}
