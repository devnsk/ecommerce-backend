package com.dev.ecommerce.config;

import com.cloudinary.Cloudinary;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("classpath:config/secret.properties")
public class ProjectConfig {

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

    @Value("${cloudinary.api_key}")
    String key;

    @Value("${cloudinary.api_secret}")
    String apiSecret;

    @Value("${cloudinary.cloud_name}")
    String cloudName;


    @Bean
    public Cloudinary getCloudinary(){
        Map<String,Object> config=new HashMap<String,Object>();
        config.put("cloud_name",cloudName);
        config.put("api_key",key);
        config.put("api_secret",apiSecret);
        config.put("secure",true);

        return new Cloudinary(config);
    }
}
