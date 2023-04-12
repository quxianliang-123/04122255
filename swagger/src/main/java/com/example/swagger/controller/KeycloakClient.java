//package com.example.swagger.controller;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class KeycloakClient {
//    public void excute() {
//        try {
//            // 创建URL对象
//            URL url = new URL("http://localhost:8080/realms/SpringBootKeycloak/protocol/openid-connect/token");
//
//            // 打开连接
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//            // 设置请求方法为POST
//            connection.setRequestMethod("POST");
//
//            // 设置请求头
//            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//
//            // 启用输入和输出流
//            connection.setDoOutput(true);
//            connection.setDoInput(true);
//
//            // 构建请求参数
//            String requestBody = "grant_type=client_credentials&client_id=login-app&client_secret=dShG5epq70sm3th1EEwkm5YQBheBtdBx";
//
//            // 发送请求体
//            connection.getOutputStream().write(requestBody.getBytes("UTF-8"));
//
//            // 获取响应码
//            int responseCode = connection.getResponseCode();
//
//            // 读取响应内容
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String line;
//            StringBuilder response = new StringBuilder();
//            while ((line = reader.readLine()) != null) {
//                response.append(line);
//            }
//            reader.close();
//
//            // 打印响应内容
//            System.out.println("Response Code: " + responseCode);
//            System.out.println("Response Body: " + response.toString());
//
//            // 关闭连接
//            connection.disconnect();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
