package cn.soaryang.elasticsearch.service;


import cn.soaryang.elasticsearch.bean.UserInfo;
import cn.soaryang.elasticsearch.dao.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public void saveUser(UserInfo userInfo){
        userInfoRepository.save(userInfo);
    }

    public UserInfo findById(String id){
        return  userInfoRepository.findById(id);
    }

    public long finAllCount(){
        return userInfoRepository.count();
    }

    public Iterable<UserInfo> findAll(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return userInfoRepository.findAll(sort);
    }

    public List<UserInfo> findAllList(){
        Stream<UserInfo> stream = userInfoRepository.findAllByCustomQueryAndStream();
        List<UserInfo> userInfoList = new ArrayList<>();
        stream.forEach(s->userInfoList.add(s));
        return userInfoList;
    }
}
