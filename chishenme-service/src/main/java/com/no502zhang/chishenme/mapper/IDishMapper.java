package com.no502zhang.chishenme.mapper;

import com.no502zhang.chishenme.model.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IDishMapper {
    void insertDish(Dish dish);

    int updateDish(Dish dish);

    int deleteDish(@Param("id") int id);

    Dish getDish(@Param("id") int id);

    List<Dish> listDish(Dish dish);
}
