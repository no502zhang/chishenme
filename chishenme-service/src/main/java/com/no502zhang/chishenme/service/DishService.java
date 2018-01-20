package com.no502zhang.chishenme.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.no502zhang.chishenme.mapper.IDishMapper;
import com.no502zhang.chishenme.model.Dish;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DishService {

    @Resource
    private IDishMapper dishMapper;

    public Dish createDish(Dish dish) {
        dishMapper.insertDish(dish);
        return dish;
    }

    public boolean updateDish(Dish dish) {
        return false;
    }

    public boolean deleteDish(int id) {
        return false;
    }

    public Dish getDish(int id) {
        return dishMapper.getDish(id);
    }

    public PageInfo<Dish> listDish(Dish dish, Page<Dish> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Dish> list = dishMapper.listDish(dish);
        PageInfo<Dish> dishPageResult = new PageInfo<Dish>(list);
        return dishPageResult;
    }
}
