package clinic.rabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
public class RabbitController {
    Logger log = Logger.getLogger(RabbitController.class.getName());
    private final AmqpTemplate template;

    public RabbitController(AmqpTemplate template) {
        this.template = template;
    }


    @RequestMapping("/emit")
    @ResponseBody
    String clinicQueue() {
        log.info("Emit to queue1");
        template.convertAndSend("queue1", "Message to queue");
        return "Emit to queue";
    }
}
