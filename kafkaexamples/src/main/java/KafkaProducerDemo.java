import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * Created by vietlq on 02/07/2017.
 */
public class KafkaProducerDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();

        // https://kafka.apache.org/documentation/#producerconfigs
        // Bootstrap server
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());
        // Producer acks
        properties.setProperty("acks", "1");
        properties.setProperty("retries", "3");
        properties.setProperty("linger.ms", "1");

        // Create a producer
        Producer<String, String> producer =
                new org.apache.kafka.clients.producer.KafkaProducer<String, String>(properties);

        // Key will dictate to which partition
        ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(
                "dummy", "3", "message"
        );
        ProducerRecord<String, String> producerRecord2 = new ProducerRecord<String, String>(
                "dummy", "3", "message2"
        );

        // Send the producer records
        producer.send(producerRecord);
        producer.send(producerRecord2);

        for (int key = 0; key < 10; ++key) {
            ProducerRecord<String, String> producerRecord3 = new ProducerRecord<String, String>(
                    "dummy", Integer.toString(key), "Got a new message: " + Integer.toString(key)
            );
            producer.send(producerRecord3);
        }

        // Replaces linger.ms property
        //producer.flush();
        producer.close();
    }
}
