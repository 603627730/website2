package com.example.website2.generator.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.website2.generator.domain.LiBrand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author yantonghui
* @description 针对表【li_brand】的数据库操作Mapper
* @createDate 2022-12-10 15:13:17
* @Entity generator.domain.LiBrand
*/
@Mapper
public interface LiBrandMapper extends BaseMapper<LiBrand> {
    List<LiBrand> selectTest();
    @Select("select * from li_brand where id = #{id}")
    LiBrand selectOneByIdLiBrand(long id);

    void updateNameBy(String name);
}




