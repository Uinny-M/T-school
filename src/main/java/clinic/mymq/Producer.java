//package clinic.mymq;
//
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import javax.ejb.LocalBean;
//import javax.ejb.Schedule;
//import javax.ejb.Stateless;
//import javax.jms.*;
//
//
//@Stateless
//@LocalBean
//public class Producer {
//    @Resource(lookup = "java:/clinic/MyConnectionFactory")
//    private ConnectionFactory connectionFactory;
//
//    @Resource(lookup = "java:/clinic/MyQueue")
//    private Destination destination;
//
//   // @Schedule(hour = "*", minute = "*", second = "*/9", persistent = false)
//    public void produceMessage(){
//        try {
//            QueueConnection connection = (QueueConnection) connectionFactory.createConnection();
//            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//            MessageProducer messageProducer = session.createProducer(destination);
//            TextMessage textMessage = session.createTextMessage("funktioniert ");
//
//            messageProducer.send(textMessage);
//            System.out.println("______________________________");
//            connection.close();
//            session.close();
//        }
//        catch (JMSException e){
//            e.printStackTrace();
//        }
//    }
//}
