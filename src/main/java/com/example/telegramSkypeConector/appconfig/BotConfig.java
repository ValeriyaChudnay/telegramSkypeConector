package com.example.telegramSkypeConector.appconfig;


import com.example.telegramSkypeConector.bot.MainBot;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "telegramBot")
public class BotConfig {
    private String webHookPath;
    private String botUserName;
    private String botToken;
    private DefaultBotOptions.ProxyType proxyType;
    private String proxyHost;
    private int proxyPort;

    @Bean
    public MainBot createBot() {
        DefaultBotOptions options = ApiContext.getInstance(DefaultBotOptions.class);
        options.setProxyHost(proxyHost);
        options.setProxyPort(proxyPort);
        options.setProxyType(proxyType);
        MainBot bot = new MainBot(options);
        bot.setBotToken(botToken);
        bot.setBotUserName(botUserName);
        bot.setWebHookPath(webHookPath);
        return bot;
    }


}
