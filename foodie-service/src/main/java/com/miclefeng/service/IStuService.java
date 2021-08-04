package com.miclefeng.service;

import com.miclefeng.pojo.Stu;

/**
 * @author miclefengzss
 * 2021/8/4 上午11:56
 */
public interface IStuService {

    public Stu getStuInfo(int id);

    public void saveStu();

    public void updateStu(int id);

    public void deleteStu(int id);
}
