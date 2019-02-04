package com.example.app.persistance.Model;

import javax.persistence.*;

@Entity
@Table(name = "Course")
public class CourseDAO {

    @Id
    private int id;

    @Column
    private  String name;

    @Column
    private String desc;

    @ManyToOne
    private TopicDAO topicDAO;

    public TopicDAO getTopicDAO() {
        return topicDAO;
    }

    public void setTopicDAO(TopicDAO topicDAO) {
        this.topicDAO = topicDAO;
    }

    public CourseDAO(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public CourseDAO()
    {
        this.id = 0;
        this.name = "";
        this.desc = "";
        this.topicDAO = null;
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




}
