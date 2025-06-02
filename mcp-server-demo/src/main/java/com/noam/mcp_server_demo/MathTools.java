package com.noam.mcp_server_demo;

import org.springframework.ai.tool.annotation.Tool;

public class MathTools {
    @Tool(description = "Adds two numbers")
    public int sumNumbers(int a, int b) {
        return a + b;
    }

    @Tool(description = "Multiplies two numbers")
    public int multiplyNumbers(int a, int b) {
        return a * b;
    }

}
