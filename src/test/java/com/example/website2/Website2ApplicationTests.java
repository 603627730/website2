package com.example.website2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.website2.generator.domain.LiBrand;
import com.example.website2.generator.mapper.LiBrandMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootTest
class Website2ApplicationTests {

    @Test
    void contextLoads() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        LiBrandMapper mapper = sqlSession.getMapper(LiBrandMapper.class);
        mapper.updateNameBy("123");
    }

}
