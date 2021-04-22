package com.ys.serviceedu.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程树展示在页面上时单个课程节点
 *
 * @author xt_ys
 */
@Data
public class Subject {

    private String id;

    private String label;

    private List<Subject> children = new ArrayList<>();
}
