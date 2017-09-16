package cn.soaryang.elasticsearch.service;

import cn.soaryang.elasticsearch.bean.Cliente;
import cn.soaryang.elasticsearch.dao.user.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EslService {


    @Autowired
    private ClienteRepository clienteRepository;

    public void save(Cliente cliente){
        clienteRepository.save(cliente);
    }
}
