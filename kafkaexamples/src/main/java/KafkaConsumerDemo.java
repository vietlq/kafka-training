import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by vietlq on 02/07/2017.
 */
public class KafkaConsumerDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();

        // https://kafka.apache.org/documentation/#consumerconfigs
        // Bootstrap server
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        properties.setProperty("key.deserializer", StringDeserializer.class.getName());
        properties.setProperty("value.deserializer", StringDeserializer.class.getName());
        // Group ID
        properties.setProperty("group.id", "group1");
        // True by default
        properties.setProperty("enable.auto.commit", "true");
        properties.setProperty("auto.commit.interval.ms", "1000");
        // Offset reset
        properties.setProperty("auto.offset.reset", "earliest");

        // Create a consumer
        KafkaConsumer<String, String> kafkaConsumer =
                new KafkaConsumer<String, String>(properties);
        // Add topics
        kafkaConsumer.subscribe(Arrays.asList("dummy"));

        while (true) {
            ConsumerRecords<String, String> consumerRecords =
                    kafkaConsumer.poll(100);
            for (ConsumerRecord<String, String> consumerRecord: consumerRecords) {
                //consumerRecord.value();
                //consumerRecord.key();
                //consumerRecord.offset();
                //consumerRecord.partition();
                //consumerRecord.topic();
                //consumerRecord.timestamp();

                System.out.println("Partition: " + consumerRecord.partition() +
                        "; Key: " + consumerRecord.key() +
                        "; Value: " + consumerRecord.value());
            }
        }
    }
}
