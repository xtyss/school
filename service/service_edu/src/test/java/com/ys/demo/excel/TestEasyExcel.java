package com.ys.demo.excel;


import com.alibaba.excel.EasyExcel;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestEasyExcel {
    @Test
    public void test1() {
        String path = "C:\\Users\\xt_ys\\Desktop\\easyExcleTest";

        String fileName = "test1.xlsx";

        String filePath = path + "\\" + fileName;
        //方法一  会自动关闭流
        EasyExcel.write(filePath, DemoDate.class).sheet(1, "名单1").doWrite(getTestData());
    }

    @Test
    public void test2() {
        String path = "C:\\Users\\xt_ys\\Desktop\\easyExcleTest";

        String fileName = "test1.xlsx";

        String filePath = path + "\\" + fileName;
        EasyExcel.read(filePath, DemoDate.class, new ReadListenDemo()).sheet().doRead();

    }

    private List<DemoDate> getTestData() {
        ArrayList<DemoDate> demoDates = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            demoDates.add(new DemoDate(i, "Lucy" + i));
        }
        return demoDates;
    }

    @Test
    public void test3() {
        File file = new File("D:\\10.Java\\JavaSE\\eclipse\\Myprogram", "yinzhengjie");
        //获取文件名称
        String fileName = file.getName();
        System.out.println(fileName);
        //获取父路径
        String getParent = file.getParent();
        System.out.println(getParent);
        //获取绝对路径
        File absoluteFile = file.getAbsoluteFile();
        System.out.println(absoluteFile);

    }
}
