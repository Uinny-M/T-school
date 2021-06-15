//package clinic.rabbitMQ;
//
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.ConnectionFactory;
//import com.rabbitmq.client.impl.Environment;
//import lombok.SneakyThrows;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.io.IOException;
//import java.security.KeyManagementException;
//import java.security.NoSuchAlgorithmException;
//import java.util.concurrent.TimeoutException;
//import java.util.logging.Logger;
//
//@Service
//public class RabbitServiceImpl implements RabbitService {
//
//    Logger log = Logger.getLogger(RabbitServiceImpl.class.getName());
//    private final Environment environment;
//
//    Connection connection;
//    Channel channel;
//
//    public RabbitServiceImpl(Environment environment) {
//        this.environment = environment;
//    }
//
//    @SneakyThrows
//    @PostConstruct
//    public void init() throws IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
//
//        // Establish connection with host localhost
//        ConnectionFactory connectionFactory = new ConnectionFactory();
////        connectionFactory.setHost(environment.getProperty("rabbitmq.host"));
////        connectionFactory.setUsername(environment.getProperty("rabbitmq.user"));
////        connectionFactory.setPassword(environment.getProperty("rabbitmq.password"));
//
//
//        connection = connectionFactory.newConnection();
//        channel = connection.createChannel();
//
//        // Declare new queue named queue1
//        channel.queueDeclare("queue1", false, false, false, null);
//    }
//
//
//    @Override
//    public void send(String message) {
//
//        try {
//            // Publish basic text message
//            channel.basicPublish("", "queue1", null, message.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        log.info("Message [" + message + "] has been sent");
//    }
//}
