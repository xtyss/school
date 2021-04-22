package com.ys.serviceedu.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class SubjectExcel {
    @ExcelProperty(index = 0)
    private String oneSubject;

    @ExcelProperty(index = 1)
    private String twoSubject;
}
