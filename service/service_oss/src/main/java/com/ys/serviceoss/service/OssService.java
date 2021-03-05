package com.ys.serviceoss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author ys
 */
public interface OssService {
    String uploadAvatarFile(MultipartFile file);
}
