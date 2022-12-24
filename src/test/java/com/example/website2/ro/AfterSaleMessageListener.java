package com.example.website2.ro;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "${lili.data.rocketmq.after-sale-topic}", consumerGroup = "${lili.data.rocketmq.after-sale-group}")
public class AfterSaleMessageListener implements RocketMQListener<MessageExt> {

    @Override
    public void onMessage(MessageExt messageExt) {

    }
}
