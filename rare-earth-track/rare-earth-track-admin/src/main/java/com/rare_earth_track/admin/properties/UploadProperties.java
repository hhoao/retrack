package com.rare_earth_track.admin.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @ClassName UploadProperties
 * @Description: 使用ConfigurationProperties将配置读取到Java文件
 * @Author 匡龙
 * @Date 2022/6/21 20:07
 * @Version V1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "file.upload")
public class UploadProperties {
    private String path;
    private List<String> allowTypes;
}
