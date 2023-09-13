package com.xuejingpan.xjpboot.service.Impl;

import com.xuejingpan.xjpboot.common.exception.GlobalException;
import com.xuejingpan.xjpboot.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName FileServiceImpl
 * @Description TODO
 * @Author xuejingpan
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Override
    public void upload(MultipartFile file) {
        String uploadPath = "D:";
        File localFile = new File(uploadPath + File.separator + file.getOriginalFilename());
        try {
            file.transferTo(localFile);
        } catch (IOException e) {
            log.error("文件保存失败：{}", e.toString());
            throw new GlobalException("文件上传失败");
        }
    }

    @Override
    public void download(HttpServletResponse response) {

    }

    @Override
    public void delete(Integer id) {

    }
}
