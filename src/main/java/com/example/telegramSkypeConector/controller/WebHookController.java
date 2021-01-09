package com.example.telegramSkypeConector.controller;

import com.example.telegramSkypeConector.bot.MainBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class WebHookController {
    private final MainBot bot;

    @Autowired
    public WebHookController(MainBot bot){
        this.bot=bot;
    }

    @PostMapping("/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update){
        return bot.onWebhookUpdateReceived(update);
    }

}
