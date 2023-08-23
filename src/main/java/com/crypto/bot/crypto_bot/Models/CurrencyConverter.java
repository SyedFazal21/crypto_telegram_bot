package com.crypto.bot.crypto_bot.Models;

public class CurrencyConverter {
    private String inr;

    public float getINR() {
        return Float.parseFloat(inr);
    }

    public void setCountry(String inr) {
        this.inr = inr;
    }
}
