package com.example.app.persistance.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Topics")
public class TopicDAO {

    @Id
    private int id;

    @Column
    private  String name;

    @Column
    private String desc;


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

    public TopicDAO(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }
    public TopicDAO() {
        id = 0;
        name = "";
        desc = "";
    }


}
