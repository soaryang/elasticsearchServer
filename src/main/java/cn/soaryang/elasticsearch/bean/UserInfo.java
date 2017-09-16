package cn.soaryang.elasticsearch.bean;


import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "user",type="userInfo",shards=5,replicas=1,refreshInterval="-1")
public class UserInfo {

    private String id;

    private String name;

    private String email;

    private String password;


}
