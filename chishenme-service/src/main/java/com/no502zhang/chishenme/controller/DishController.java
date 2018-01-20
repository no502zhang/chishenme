package com.no502zhang.chishenme.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.no502zhang.chishenme.model.Dish;
import com.no502zhang.chishenme.service.DishService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping({"/dishes"})
public class DishController {

    @Resource
    private DishService dishService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Dish> create(@RequestBody Dish dish) {
        dishService.createDish(dish);
        return ResponseEntity.ok().body(dish);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        boolean flag = dishService.deleteDish(id);
        return ResponseEntity.ok().body(flag);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Dish> update(@PathVariable("id") int id,
                                       @RequestBody Dish dish) {
        dishService.updateDish(dish);
        return ResponseEntity.ok().body(dish);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Dish> get(@PathVariable("id") int id) {
        Dish dish = dishService.getDish(id);
        return ResponseEntity.ok().body(dish);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<PageInfo<Dish>> list(Dish dish, Page<Dish> page) {
        PageInfo<Dish> dishPage = dishService.listDish(dish, page);
        return ResponseEntity.ok().body(dishPage);
    }
}
