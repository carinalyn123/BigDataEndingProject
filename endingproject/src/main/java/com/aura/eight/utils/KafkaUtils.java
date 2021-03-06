package com.aura.eight.utils;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;

public class KafkaUtils {
    private static String KAFKA_SERVER = "bigdata";
    public static String KAFKA_ADDR = KAFKA_SERVER + ":9092";
    private static KafkaProducer<String,String> producer= null;

    private static String KAFKA_USER_TOPIC = "t_click";
    private static String KAFKA_ORDER_TOPIC = "t_order";
    private static String KAFKA_LOAN_TOPIC = "t_loan";

    static{
        Map<String,String> props = new HashMap<>();
        props.put("bootstrap.servers", KAFKA_ADDR);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer(props);
    }

    public static void sendTClickMsg(String value)
    {
        producer.send(new ProducerRecord<>(KAFKA_USER_TOPIC, value));
    }

    public static void sendTOrderMsg(String value)
    {
        producer.send(new ProducerRecord<>(KAFKA_ORDER_TOPIC, value));
    }

    public static void sendTLoanMsg(String value)
    {
        producer.send(new ProducerRecord<>(KAFKA_LOAN_TOPIC, value));
    }
}
