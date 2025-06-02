package com.noam.mcp_server_demo;

import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class McpServerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpServerDemoApplication.class, args);
    }


    @Bean
    public ToolCallbackProvider mathTools() {
        return MethodToolCallbackProvider.builder().toolObjects(new MathTools()).build();
    }
    @Bean
    public ToolCallbackProvider courseTools() {
    return MethodToolCallbackProvider.builder().toolObjects(new CourseService()).build();
    }
}
