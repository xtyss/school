package com.ys.serviceoss.util;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author ys
 */
public class OssUtil {

    @Value("{aliyun.oss.file.endpoint}")
    private String endpoint;

    @Value("{aliyun.oss.file.keyid}")
    private String keyId;

    @Value("{aliyun.oss.file.keysecret}")
    private String keySecret;

    @Value("{aliyun.oss.file.bucketname}")
    private String bucketName;


}
