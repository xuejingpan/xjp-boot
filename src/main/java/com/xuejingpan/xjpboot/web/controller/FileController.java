package com.xuejingpan.xjpboot.web.controller;

import com.xuejingpan.xjpboot.common.result.ResponseResult;
import com.xuejingpan.xjpboot.service.FileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName FileController
 * @Description TODO
 * @Author xuejingpan
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseResult<?> upload(@RequestPart MultipartFile file) {
        fileService.upload(file);
        return ResponseResult.success();
    }

    @GetMapping("/download")
    public void download(HttpServletResponse response) {
        fileService.download(response);
    }

    @DeleteMapping("/{id}")
    public ResponseResult<?> deleteFile(@PathVariable("id") Integer id) {
        fileService.delete(id);
        return ResponseResult.success();
    }
}
