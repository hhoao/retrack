package com.rare_earth_track.common.config;

import com.rare_earth_track.common.domain.SwaggerProperties;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Swagger基础配置
 * @author hhoa
 */
public abstract class BaseSwaggerConfig {

    @Bean
    public OpenAPI createRestApi() {
        SwaggerProperties swaggerProperties = swaggerProperties();
        OpenAPI api = new OpenAPI()
                .info(apiInfo(swaggerProperties));
        if (swaggerProperties.isEnableSecurity()) {
            api.components(new Components().securitySchemes(getSecuritySchemes()));
            SecurityRequirement securityRequirement = new SecurityRequirement();
            //name与securitySchemes中的name相对应
            securityRequirement.addList("Authorization", "/**");
            api.security(List.of(securityRequirement));

        }
        return api;
    }

    private Info apiInfo(SwaggerProperties swaggerProperties) {
        return new Info()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .contact(new Contact()
                        .name(swaggerProperties.getContactName())
                        .url(swaggerProperties.getContactUrl())
                        .email(swaggerProperties.getContactEmail()))
                .version(swaggerProperties.getVersion());
    }

    private Map<String, SecurityScheme> getSecuritySchemes() {
        //设置请求头信息
        Map<String, SecurityScheme> result = new HashMap<>();
        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .in(SecurityScheme.In.HEADER)
                //token-head
                .scheme("Bearer")
                .description("jwt安全认证")
                .name("Authorization");
        result.put("Authorization", securityScheme);
        return result;
    }

    /**
     *
     * 自定义Swagger配置
     */
    public abstract SwaggerProperties swaggerProperties();
}
