package cn.soaryang.elasticsearch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@EnableElasticsearchRepositories(basePackages = {"ltd.miku.esl.dao"})  
public class AppMain implements CommandLineRunner
{  
    public static ConfigurableApplicationContext ctx;
  
    //private static final Logger LOG = LoggerFactory.getLogger(AppMain.class);
  
    @Override  
    public void run(String... strings) throws Exception  
    {  
  
    }  
  
    public static void main(String[] args)  
    {  
        ctx = SpringApplication.run(AppMain.class, args);
        //LOG.info(" application running...");
  
    }  
  
} 