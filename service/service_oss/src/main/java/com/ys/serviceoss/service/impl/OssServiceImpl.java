package com.ys.serviceoss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.ys.serviceoss.service.OssService;
import com.ys.serviceoss.util.OssPropertiesUtil;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author ys
 */
@Service
public class OssServiceImpl implements OssService {
    @Override
    public String uploadAvatarFile(MultipartFile file) {
        String url = "";
        try {
            // Endpoint以杭州为例，其它Region请按实际情况填写。
            String endpoint = OssPropertiesUtil.END_POINT;
            // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
            String accessKeyId = OssPropertiesUtil.KEY_ID;
            String accessKeySecret = OssPropertiesUtil.KEY_SECRET;
            String accessKeyBucketName = OssPropertiesUtil.BUCKET_NAME;
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // 获得文件名称
            String fileName = file.getOriginalFilename();

            //通过uuid 让文件名唯一
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            fileName = uuid+fileName;
            //添加时间文件夹
            String datePath = new DateTime().toString("yyyy/MM/dd");
            fileName = datePath+fileName;

            // 上传文件流。
            InputStream inputStream = file.getInputStream();

            // 参数说明
            // 1:BucketName
            // 2:文件路径+名称
            // 3:文件流
            ossClient.putObject(accessKeyBucketName, fileName, inputStream);

            // 关闭OSSClient。
            ossClient.shutdown();

            url="https://"+accessKeyBucketName+"."+endpoint+"/"+fileName;
        }catch (Exception e){
            e.printStackTrace();
        }

        return url;
    }
}
