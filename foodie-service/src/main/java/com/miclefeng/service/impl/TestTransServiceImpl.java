package com.miclefeng.service.impl;

import com.miclefeng.service.ITestTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author miclefengzss
 * 2021/8/4 下午2:59
 */
@Service
public class TestTransServiceImpl implements ITestTransService {

    @Autowired
    private StuServiceImpl stuService;

    /**
     * 事务传播 - Propagation
     *      REQUIRED: 使用当前的事务，如果当前没有事务，则新建一个事务，子方法必须运行在一个事务中；
     *                如果当前存在事务，则加入这个事务，成为一个整体；
     *             举例：领导没饭吃，你有钱，你自己买饭吃；领导有饭吃，会分给你吃
     *      SUPPORTS: 如果当前有事务，则使用事务；如果当前没有事务，则不使用事务
     *             举例：领导有饭吃，你也有饭吃；领导没饭吃，你也没饭吃
     *      MANDATORY: 该传播属性强制必须存在一个事物，如果没有，则抛出异常；
     *             举例：领导必须管饭，如果不管饭，你就不干了（抛出异常）
     *      REQUIRES_NEW: 如果当前有事务，则挂起该事物，并且自己创建一个新的事务给自己用使用；
     *                    如果当前没有事务，则通 REQUIRED；
     *             举例：领导有饭吃，你不要，你自己买了自己吃
     *      NOT_SUPPORTED: 如果当前有事务，则挂起该事物，自己不使用事务进行数据库操作；
     *             举例：领导有饭吃，分给你吃，你放一边不吃
     *      NEVER: 如果当前存在事务，则抛出异常
     *             举例：领导有饭吃，分给你吃，你不想吃，就抛出异常
     *      NESTED: 如果当前有事务，则开启子事务(嵌套事务),嵌套事务独立提交或者回滚；
     *              如果当前没有事务，则同 REQUIRED;
     *              但是如果主事务提交，则会携带子事务一起提交；
     *              如果主事务回滚，则子事务会一起回滚；相反，子事务异常，则父事务可以选择回滚或者不会滚；
     *             举例：领导决策不对，老板怪罪，领导小弟一起受罚；小弟出了错误，领导可以推卸责任
     */

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void testPropagationTrans() {
        stuService.saveParent();

        stuService.saveChildren();

//        int a = 1 / 0;
    }
}
