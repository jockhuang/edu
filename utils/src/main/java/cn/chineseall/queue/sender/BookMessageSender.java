package cn.chineseall.queue.sender;

import java.util.HashMap;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class BookMessageSender {
    private Logger logger = Logger.getLogger(BookMessageSender.class);
    private JmsTemplate jmsTemplate;
    private Destination destination;

    /**
     * 发送jms消息
     * 
     * @param map(type:操作类型,ids:操作id集合)
     */
    public void sendMessage(final HashMap<String, Object> map) {
        jmsTemplate.send(destination, new MessageCreator(){
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage om = session.createObjectMessage(map);
                return om;
            }
        });
        logger.info("成功发送了一条JMS消息--BookMessageSender");
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
