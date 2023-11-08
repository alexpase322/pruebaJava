package com.example.persistant.controller;


import com.example.persistant.interfaces.MallwatchmanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("asignar")
public class MallWatchmanController {
    @Autowired
    MallwatchmanDao mallwatchmanDao;

    @PostMapping("{watchmanId}/{mallId}")
    public boolean asignarVigilante(@PathVariable Long watchmanId, Long mallId){
        try {
            if(mallwatchmanDao.asignarVigilante(watchmanId, mallId)){
                return true;
            }
            return false;
        }catch (NullPointerException e){
            System.out.println(e);
            return false;
        }
    }
}
