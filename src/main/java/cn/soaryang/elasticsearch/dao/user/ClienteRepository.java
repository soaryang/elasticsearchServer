package cn.soaryang.elasticsearch.dao.user;

import cn.soaryang.elasticsearch.bean.Cliente;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface ClienteRepository extends ElasticsearchRepository<Cliente,String> {




}
