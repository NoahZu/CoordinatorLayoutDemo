package com.example.zujinhao.test.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: jzu
 * Date: 2018/9/17
 * Function:
 */
public class TopicGroup {
    int id;
    ArrayList<Topic> content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Topic> getContent() {
        return content;
    }

    public void setContent(ArrayList<Topic> content) {
        this.content = content;
    }
}
