package com.rare_earth_track.portal.service.impl;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.portal.TransactionTest;
import com.rare_earth_track.portal.service.RetFilesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

/**
 * @ClassName RetFilesServiceImplTest
 * @Description: TODO
 * @Author 匡龙
 * @Date 2022/7/4 9:54
 * @Version V1.0
 */
public class RetFileServiceImplTest extends TransactionTest {

    private final String testPath = new File("${file.upload.path}").getAbsolutePath();
    private final Long testId = 1L;

    @Autowired
    RetFilesService filesService;

    @Test
    void getFileList() {
        filesService.getFileList(new PageInfo(1, 5));
    }

    @Test
    void deleteFileById() {
        filesService.deleteFileById(testId);
    }

}
