package com.itheima.controller;


import com.itheima.poji.Items;
import com.itheima.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemsController {
        @Autowired
        private ItemsService service;
           @RequestMapping("/list")
        public String  show01(Model model){
           List<Items> itemsList = service.findAll();
                //这是干嘛的呢？
           model.addAttribute("items",itemsList);

         System.out.println("itemsList = " + itemsList);
         //装到model容器中
               return "items";
           }

        @RequestMapping("/save")
        public String  show(Items items){
                int save = service.save(items);
                System.out.println("save = " + save);
                return "redirect:/items/list";
        }



}
