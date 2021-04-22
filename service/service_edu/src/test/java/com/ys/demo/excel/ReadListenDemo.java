package com.ys.demo.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

public class ReadListenDemo extends AnalysisEventListener<DemoDate> {

    // 一行一行读取内容
    @Override
    public void invoke(DemoDate demoDate, AnalysisContext analysisContext) {
        System.out.println(demoDate);
    }
    // 全部读取之后
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println(analysisContext.toString());
    }
}
