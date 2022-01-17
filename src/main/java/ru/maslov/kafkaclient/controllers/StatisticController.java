package ru.maslov.kafkaclient.controllers;

import ru.maslov.kafkaclient.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistic")
public class StatisticController {

    private static Long messageId = 0L;

    @Autowired
    private KafkaTemplate<Long, MessageDto> kafkaMessageTemplate;

    @GetMapping("/1")
    public void test() {
        System.out.println("hell");
    }

    @GetMapping
    public void getCurrencyByPeriod(@RequestParam("start_date") String startDate,
                                    @RequestParam("end_date") String endDate,
                                    @RequestParam("currency") String currencyCode) {
        MessageDto messageDto = new MessageDto(messageId, startDate, endDate, currencyCode);
        messageId++;

        ListenableFuture<SendResult<Long, MessageDto>> future = kafkaMessageTemplate.send("statistic", messageDto.getMessageId(), messageDto);
        future.addCallback(System.out::println, System.err::println);
        kafkaMessageTemplate.flush();
    }
}
