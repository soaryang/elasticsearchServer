package cn.soaryang.elasticsearch.controller;


import cn.soaryang.elasticsearch.bean.UserInfo;
import cn.soaryang.elasticsearch.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping(value="/user/{id}",method= RequestMethod.GET)
    public UserInfo findById(@PathVariable String id){
        return userInfoService.findById(id);
    }

    @RequestMapping(value="/user/all",method= RequestMethod.GET)
    public Iterable<UserInfo> findAll() {
        return userInfoService.findAll();
    }

    @RequestMapping(value="/user/allList",method= RequestMethod.GET)
    public List<UserInfo> findAllList() {
        return userInfoService.findAllList();
    }

    @RequestMapping(value="/user/count",method= RequestMethod.GET)
    public long count() {
        return userInfoService.finAllCount();
    }

    @RequestMapping(value="/user",method= RequestMethod.GET)
    public void save(){

        for(int i=0; i<10; i++){
            UserInfo userInfo = new UserInfo();
            userInfo.setId("id"+i);
            userInfo.setName("name"+i);
            userInfo.setEmail("mail"+i);
            userInfoService.saveUser(userInfo);

        }


    }

}
