package com.miclefeng.service.impl;

import com.miclefeng.mapper.StuMapper;
import com.miclefeng.pojo.Stu;
import com.miclefeng.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author miclefengzss
 * 2021/8/4 上午11:57
 */
@Service
public class StuServiceImpl implements IStuService {

    @Autowired
    private StuMapper stuMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Stu getStuInfo(int id) {
        return stuMapper.selectByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveStu() {
        Stu stu = new Stu();
        stu.setName("wdj");
        stu.setAge(27);
        stuMapper.insert(stu);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateStu(int id) {
        Stu stu = new Stu();
        stu.setId(id);
        stu.setName("zss");
        stu.setAge(29);
        stuMapper.updateByPrimaryKey(stu);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteStu(int id) {
        stuMapper.deleteByPrimaryKey(id);
    }



    public void saveParent() {
        Stu stu = new Stu();
        stu.setName("p-wdj");
        stu.setAge(27);
        stuMapper.insert(stu);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveChildren() {
        saveChild1();
//        int a = 1 / 0;
        saveChild2();
    }

    private void saveChild1() {
        Stu stu = new Stu();
        stu.setName("c-zss");
        stu.setAge(29);
        stuMapper.insert(stu);
    }

    private void saveChild2() {
        Stu stu = new Stu();
        stu.setName("c-miclefeng");
        stu.setAge(19);
        stuMapper.insert(stu);
    }
}
