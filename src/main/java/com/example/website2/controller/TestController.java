package com.example.website2.controller;

//import com.example.website2.generator.domain.LiBrand;
//import com.example.website2.generator.service.LiBrandService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.website2.generator.domain.LiBrand;
import com.example.website2.generator.service.LiBrandService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private LiBrandService liBrandService;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping
    public IPage<LiBrand> test1(){
        Page<LiBrand> page = new Page<>(2, 5);
        IPage<LiBrand> result = liBrandService.page(page);
//        rocketMQTemplate.sendOneWay();
//        System.out.println(rocketMQTemplate);
        System.out.println(result.getTotal());
        rocketMQTemplate.syncSend("TopicTest", MessageBuilder.withPayload(result.getRecords().get(1)).build());
//        rocketMQTemplate
        return result;
    }
    @GetMapping("/a")
    public String add(){
        LiBrand liBrand = new LiBrand();
        liBrandService.save(liBrand);
        return liBrand.toString() + "321";
    }
}
