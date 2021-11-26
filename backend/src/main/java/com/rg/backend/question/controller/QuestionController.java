package com.rg.backend.question.controller;

import com.alibaba.fastjson.JSON;
import com.rg.backend.college.entity.College;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.rg.backend.util.Constant.DEVELOP_ORIGIN;
import static com.rg.backend.util.Constant.PRODUCE_ORIGIN;

@Api(value = "查询信息接口",tags = "查询信息接口说明")
@CrossOrigin(origins={DEVELOP_ORIGIN, PRODUCE_ORIGIN}, allowCredentials="true")
@RestController
@RequestMapping("/qa/{question}")
public class QuestionController {
    @ApiOperation(value = "智能查询")
    @GetMapping("/")
    public String askQuestion(@PathVariable String question){
        String answer = sendPost("http://127.0.0.1:5000","question="+question);
        return answer;
    }

    //发送请求
    public static String sendPost(String url, String param) {
        StringBuffer result = new StringBuffer();
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "close");
            conn.setRequestProperty("user-agent",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
            if (conn.getResponseCode() == 200) {
                in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), "utf-8"));
                String line = null;
                while ((line = in.readLine()) != null) {
                    result.append(line);
                }
            }else {
                in = new BufferedReader(
                        new InputStreamReader(conn.getErrorStream(), "utf-8"));
                String line = null;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result.toString();
    }
}
