package cn.soaryang.elasticsearch.dao.user;


import cn.soaryang.elasticsearch.bean.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component

@EnableElasticsearchRepositories
public interface UserInfoRepository extends ElasticsearchRepository<UserInfo,String> {

    UserInfo findById(String id);


    @Query("select u from UserInfo u")
    Stream<UserInfo> findAllByCustomQueryAndStream();




//    @Query("select * from UserInfo a where a.id=?1")
//    public UserInfo findById(String id);
}
