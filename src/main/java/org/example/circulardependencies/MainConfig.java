package org.example.circulardependencies;

import org.springframework.context.annotation.*;


@Configuration
@ComponentScan(basePackages = {"org.example"})
//@ImportResource(value = {"classpath:beans/beans.xml"})
@EnableAspectJAutoProxy
public class MainConfig {



}
