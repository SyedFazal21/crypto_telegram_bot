package com.crypto.bot.crypto_bot;

import com.crypto.bot.crypto_bot.Controllers.Responder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class CryptoBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoBotApplication.class, args);
		try{
			TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
			telegramBotsApi.registerBot(new Responder());

		}catch(TelegramApiException ex){
			ex.printStackTrace();
		}
	}

}
