package com.noam.mcpclientdemo;

import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.spec.McpSchema;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class McpClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpClientDemoApplication.class, args);
    }


//    @Bean
//    CommandLineRunner run(List<McpSyncClient> clients, AiService aiService){
//    return args -> {
//                  McpSyncClient client = clients.get(0);
//                  McpSchema.ListToolsResult listToolsResult = client.listTools();
//                  listToolsResult.tools().forEach(tool -> {
//                      System.out.println(tool.name() + ": " + tool.description());
//                  });
//
//                  McpSchema.CallToolResult getAllCoursesResult = client.callTool(new
//       McpSchema.CallToolRequest("get_courses","{}"));
//
//       getAllCoursesResult.content().stream().map(Objects::toString).forEach(System.out::println);
//
//
//      String complete = aiService.complete("5*4+7=? Use tools if possible");
//      System.out.println(complete);
//    };
//    }
}
