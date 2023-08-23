package com.crypto.bot.crypto_bot.DBManager;

import com.crypto.bot.crypto_bot.Models.CryptoData;
import com.crypto.bot.crypto_bot.Models.CurrencyConverter;
import org.springframework.web.client.RestTemplate;

public class Config {

    public static CryptoData getCryptoData() {
        getCryptos();
        return cryptoData;
    }

    public static void setCryptoData(CryptoData cryptoData) {
        Config.cryptoData = cryptoData;
    }

    static CryptoData cryptoData = null;
    static float indianRupees;

    public static float getIndianRupees() {
        return indianRupees;
    }

    public static void setIndianRupees(int indianRupees) {
        Config.indianRupees = indianRupees;
    }

    public static final String BOT_TOKEN = "6143817614:AAFVC424gkv_YZBClsv1tQ3VC-tvKaUzWqU";
    public static final String BOT_USERNAME = "Live_Crypto_Price_Bot";

    static void getCryptos(){
        if(cryptoData == null){
            CryptoData cryptoRes = new CryptoData();
            RestTemplate restTemplate = new RestTemplate();
            cryptoRes = restTemplate.getForEntity("https://api.coincap.io/v2/markets", CryptoData.class).getBody();
            cryptoData = cryptoRes;
            getCurrencyRates();
        }
    }

    static void getCurrencyRates(){
        CurrencyConverter currencyConverter = new CurrencyConverter();
        RestTemplate restTemplate = new RestTemplate();
        currencyConverter = restTemplate.getForEntity("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/usd/inr.json", CurrencyConverter.class).getBody();
        indianRupees = currencyConverter.getINR();
    }
}
