package com.papa.baguwen1.baguwen1;

import com.papa.baguwen1.baguwen1.elasticjob.FileCustom;
import com.papa.baguwen1.baguwen1.importor.TestA;
import com.papa.baguwen1.baguwen1.importor.TestB;
import com.papa.baguwen1.baguwen1.importor.TestC;
import com.papa.baguwen1.baguwen1.importor.TestD;
import com.papa.baguwen1.baguwen1.limit.SimpleRateLimiter;
import com.papa.baguwen1.baguwen1.service.HelloServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Baguwen1Application.class)
public class JavaBootTest {
    @Autowired
    private TestA testA;
    @Autowired
    private TestB testB;
    @Autowired
    private TestC testC;
    @Autowired
    private TestD testD;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private HelloServiceImpl helloService;
    @Autowired
    private SimpleRateLimiter simpleRateLimiter;

    @Test
    public void testLimit(){
        for (int i = 0; i <= 20; i++){
            System.out.println(simpleRateLimiter.isActionAllowed("testUserId", "reply", 60, 8));
        }
    }

    @Test
    public void value(){
        String s = helloService.sayHello();
        System.out.println("word is " + s);
    }

    @Test
    public void test(){
        testA.printName();
        testB.printName();
        testC.printName();
        testD.printName();
    }

    @Test
    public void testGenerateTestData(){
        //清除数据
        clearTestFiles();
        //制造数据
        generateTestFiles();
    }
    /**
     * 清除模拟数据
     */
    public void clearTestFiles(){
        jdbcTemplate.update("delete from t_file");
    }

    /**
     * 创建模拟数据
     */
    public void generateTestFiles(){
        List<FileCustom> files =new ArrayList<>();
        for(int i=1;i<11;i++){
            files.add(new FileCustom(String.valueOf(i),"文件"+ i,"text","content"+ i));
            files.add(new FileCustom(String.valueOf((i+10)),"文件"+(i+10),"image","content"+ (i+10)));
            files.add(new FileCustom(String.valueOf((i+20)),"文件"+(i+20),"radio","content"+ (i+20)));
            files.add(new FileCustom(String.valueOf((i+30)),"文件"+(i+30),"vedio","content"+ (i+30)));
        }
        for(FileCustom file : files){
            jdbcTemplate.update("insert into t_file (id,name,type,content,backedUp) values (?,?,?,?,?)",
                    new Object[]{file.getId(),file.getName(),file.getType(),file.getContent(),file.getBackedUp()});
        }
    }

    @Test
    public void getSpringVersion() {
        String version = SpringVersion.getVersion();
        String version1 = SpringBootVersion.getVersion();
        System.out.println(version);
        System.out.println(version1);
    }
}
