package com.example.apiserver.config;
// 오버라이드 할 수 있는 설정이 많아 진다.
import com.example.apiserver.controller.formatter.LocalDateFormatter;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Log4j2
public class CustomServletConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        log.info("-------------------------------");
        log.info("addFormatters");
        registry.addFormatter(new LocalDateFormatter());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")      // 모든 경로에 적용
                .maxAge(500)                       // 대기 시간
                .allowedMethods("GET","POST","PUT","DELETE", "HEAD", "OPTIONS")    // 어떤 방식의 호출을 허용할것인지
                .allowedOrigins("*");           // 모든 곳에서 들어오는 요청에 대해 허용
    }
}
