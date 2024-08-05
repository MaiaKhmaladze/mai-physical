package com.mai.physical;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(value = "app.physical", ignoreUnknownFields = false)
public class AppConfiguration
{

}
