package com.example.contracts.response;


public class CourseResponse {

    private int id;
    private String name;
    private String desc;
    private TopicResponse topicResponse;

    public TopicResponse getTopicResponse() {
        return topicResponse;
    }

    public void setTopicResponse(TopicResponse topicResponse) {
        this.topicResponse = topicResponse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }



    public CourseResponse(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }
}
