package com.crypto.bot.crypto_bot.Controllers;

import com.crypto.bot.crypto_bot.DBManager.Config;
import com.crypto.bot.crypto_bot.Models.CryptoData;
import com.crypto.bot.crypto_bot.Models.CryptoResponse;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.text.NumberFormat;
import java.util.Locale;

public class Responder extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        CryptoData cryptoData = Config.getCryptoData();
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));

        long chatId = update.getMessage().getChatId();
        String message = update.getMessage().getText().trim();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Please Enter Crypto Symbol or Crypto Name\nFor Example: 'BTC' or 'Bitcoin'");

        System.out.println(message);

        for(CryptoResponse res : cryptoData.data){
            if(message.equalsIgnoreCase(res.getBaseSymbol()) || message.equalsIgnoreCase(res.getBaseId())){
                sendMessage.setText(res.toString() + "Price in INR:            " + formatter.format(Float.parseFloat(res.getPriceQuote()) * Config.getIndianRupees()));
            }
        }

        try {
            sendApiMethod(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return Config.BOT_USERNAME;
    }

    @Override
    public String getBotToken(){
        return Config.BOT_TOKEN;
    }
}
