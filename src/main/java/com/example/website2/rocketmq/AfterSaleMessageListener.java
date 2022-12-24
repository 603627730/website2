package com.example.website2.rocketmq;

import com.example.website2.generator.domain.LiBrand;
import com.example.website2.generator.service.LiBrandService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.shaded.com.google.gson.Gson;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Slf4j
@Component
@RocketMQMessageListener(topic = "TopicTest", consumerGroup = "please_rename_unique_group_name")
public class AfterSaleMessageListener implements RocketMQListener<MessageExt> {

    @Autowired
    private LiBrandService liBrandService;

    @Override
    public void onMessage(MessageExt messageExt) {
        String s = new String(messageExt.getBody(), StandardCharsets.UTF_8);
        Gson gson = new Gson();
        LiBrand liBrand = gson.fromJson(s, LiBrand.class);
        liBrandService.save(liBrand);
    }
}
