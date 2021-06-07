package com.ys.serviceedu.entity.chapter;

import io.swagger.annotations.ApiModel;
import lombok.Data;
@ApiModel(value = "课时信息")
@Data
public class VideoVo {
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private Boolean free;
}
