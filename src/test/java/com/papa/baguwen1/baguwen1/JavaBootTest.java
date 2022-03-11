package com.papa.baguwen1.baguwen1;

import com.papa.baguwen1.baguwen1.elasticjob.FileCustom;
import com.papa.baguwen1.baguwen1.importor.TestA;
import com.papa.baguwen1.baguwen1.importor.TestB;
import com.papa.baguwen1.baguwen1.importor.TestC;
import com.papa.baguwen1.baguwen1.importor.TestD;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
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
}
