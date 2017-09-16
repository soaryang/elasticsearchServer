package cn.soaryang.elasticsearch.controller;


import cn.soaryang.elasticsearch.bean.Cliente;
import cn.soaryang.elasticsearch.service.EslService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EslController {

    @Autowired
    private EslService eslService;


    @RequestMapping(value="/",method= RequestMethod.GET)
    public void save(){


        /*List<Cliente> clienteList = new ArrayList<Cliente>();

        for(int i=0; i<10; i++){
            Cliente cliente = new Cliente();
            cliente.setId("id"+i);
            cliente.setCity("china");
            clienteList.add(cliente);
        }

        eslService.saveList(clienteList);*/

        Cliente cliente = new Cliente();
        cliente.setId("wqeqeqweqeqeqw");
        cliente.setCity("china");
        eslService.save(cliente);
    }

}
