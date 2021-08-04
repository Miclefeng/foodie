package com.test;

import com.miclefeng.Application;
import com.miclefeng.service.impl.StuServiceImpl;
import com.miclefeng.service.impl.TestTransServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author miclefengzss
 * 2021/8/4 下午3:07
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TransTest {

    @Autowired
    private StuServiceImpl stuService;

    @Autowired
    private TestTransServiceImpl testTransService;

    @Test
    public void myTest() {
        testTransService.testPropagationTrans();
    }
}
