
package com.tourist.telegram.bot.bot;

import com.tourist.telegram.bot.model.City;
import com.tourist.telegram.bot.repository.CityRepository;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {
    
    @Value("${bot.name}")
    private String botName;
    
    @Value("${bot.token}")
    private String botToken;
    
    private final CityRepository repository;

    public Bot(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onUpdateReceived(Update update) {
        
        String chatId = update.getMessage().getChatId().toString();
        String msgFromUser = update.getMessage().getText().toLowerCase();
        City city = repository.findFirstByCityName(msgFromUser);
        String msgToUser = new String();
        
        if(msgFromUser.equals("/start")){
            String firstNameUser = update.getMessage().getChat().getFirstName();
            
            msgToUser = "Привет, " + firstNameUser + " :)\n"
                    + "Я могу выдать информацию по любому городу!\n"
                    + "Если нужна помощь, то напишите: /help";
        }
        else if(msgFromUser.equals("/help")){
            msgToUser = "Введите любое название города:\n"
                    + "Минск - отобразится информация о городе!\n"
                    + "/list - отображение списка всех городов из базы!\n";
        }
        else if(msgFromUser.equals("/list")){
            List<City> listCities = repository.findAll();
            msgToUser = listCities.stream().map(c -> c.getCityName() + "\n").collect(Collectors.joining());
        }
        else if(city != null){
            msgToUser = city.getInformation();
        }
        else {
            msgToUser = "Такого города нет в списке!\n"
                    + "/list - списка всех городов из базы!\n";
        }
        
        sendMessage(chatId, msgToUser);
    }
    
    public void sendMessage(String chatId, String message){
         SendMessage sendMessage = new SendMessage();
         sendMessage.setChatId(chatId);
         sendMessage.setText(message);
         
        try {
            execute(sendMessage);
        } catch (TelegramApiException ex) {
            Logger.getLogger(Bot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
