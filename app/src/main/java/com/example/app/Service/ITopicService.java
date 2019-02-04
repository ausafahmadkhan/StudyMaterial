package com.example.app.Service;

import com.example.contracts.request.TopicRequest;
import com.example.contracts.response.TopicResponse;

import java.util.List;

public interface ITopicService {


    public List<TopicResponse> getAll();

    public TopicResponse getTopic(int id);

    public TopicResponse saveTopic(TopicRequest topicRequest);

    public TopicResponse updateTopic(TopicRequest topicRequest);

    public TopicResponse deleteTopic(int id);
}
