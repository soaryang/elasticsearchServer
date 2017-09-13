package cn.soaryang.elasticsearch.controller;


import cn.soaryang.elasticsearch.bean.Cliente;
import cn.soaryang.elasticsearch.service.EslService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EslController {

    @Autowired
    private EslService eslService;


    @RequestMapping(value="/",method= RequestMethod.GET)
    public void save(){
        Cliente cliente = new Cliente();
        cliente.setCity("china");
        eslService.save(cliente);
    }

}
