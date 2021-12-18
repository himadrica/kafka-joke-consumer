package com.inspo.solutions.kafkajokeconsumer.service;

import com.inspo.solutions.kafkajokeconsumer.model.Joke;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Consumer;

@Configuration
public class JokeConsumer {

    @Bean
    Consumer<KStream<String, Joke>> jokeConsumerService(){
        return kstream -> kstream.foreach((key, joke) -> {
            System.out.println(String.format("Joke setup[%s] delivery[%s]", joke.getSetup(), joke.getDelivery()));
        });
    }
}
