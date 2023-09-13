package com.xuejingpan.xjpboot.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @Interface FileService
 * @Description 文件服务
 * @Author xuejingpan
 */
public interface FileService {

    /**
     * 上传文件
     * @param file 文件
     */
    void upload(MultipartFile file);

    /**
     * 下载文件
     * @param response http返回
     */
    void download(HttpServletResponse response);

    /**
     * 删除文件
     * @param id 文件id
     */
    void delete(Integer id);
}
