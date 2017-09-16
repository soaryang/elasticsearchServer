package cn.soaryang.elasticsearch.config;


import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

@Configuration
@EnableElasticsearchRepositories(basePackages = "cn.soaryang.elasticsearch.dao.user",elasticsearchTemplateRef = "firstElasticSearchTemplate")
public class ElasticSearchConfig {

    @Primary
    @Bean(name = "elasticsearchProperties")
    @ConfigurationProperties(prefix = "spring.data.elasticsearch.first")
    public ElasticsearchProperties elasticsearchProperties() {
        return new ElasticsearchProperties();
    }

    @Bean(name = "firstElasticSearchTemplate")
    public ElasticsearchTemplate danmuMongoTemplate() throws Exception {
        ElasticsearchProperties elasticsearchProperties = elasticsearchProperties();

        String EsHosts = elasticsearchProperties.getClusterNodes();
        Settings settings = Settings.settingsBuilder().put("cluster.name", elasticsearchProperties.getClusterName()).put("tclient.transport.sniff", true).build();
        TransportClient tclient = TransportClient.builder().settings(settings).build();
        String[] nodes = EsHosts.split(",");
        for (String node : nodes) {
            if(nodes.length>0){
                String[] hostPort = node.split(":");
                tclient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(hostPort[0]), Integer.parseInt(hostPort[1])));
            }
        }
        ElasticsearchTemplate elasticsearchTemplate = new ElasticsearchTemplate(tclient);
        return elasticsearchTemplate;

    }
}
