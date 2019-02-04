package com.example.app.Service;

import com.example.app.persistance.Model.TopicDAO;
import com.example.app.persistance.Repository.TopicRepository;
import com.example.contracts.request.TopicRequest;
import com.example.contracts.response.TopicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TopicService implements ITopicService {

    @Autowired
    private TopicRepository topicRepository;



    @Override
    public List<TopicResponse> getAll()
    {
        List<TopicDAO> topicDAOS = topicRepository.findAll();
        List<TopicResponse> topicResponses = new ArrayList<>();
        for(TopicDAO topicDAO : topicDAOS)
        {
            TopicResponse topicResponse = new TopicResponse(0,"","");
            topicResponse.setId(topicDAO.getId());
            topicResponse.setName(topicDAO.getName());
            topicResponse.setDesc(topicDAO.getDesc());
            topicResponses.add(topicResponse);
        }
        return topicResponses;
    }

    @Override
    public TopicResponse getTopic(int id)
    {
        TopicDAO topicDAO = topicRepository.findById(id).orElse(null);
        TopicResponse topicResponse = new TopicResponse(topicDAO.getId(), topicDAO.getName(), topicDAO.getDesc());
        return topicResponse;
    }

    @Override
    public TopicResponse saveTopic(TopicRequest topicRequest)
    {
        TopicDAO topicDAO = new TopicDAO();
        topicDAO.setId(topicRequest.getId());
        topicDAO.setName(topicRequest.getName());
        topicDAO.setDesc(topicRequest.getDesc());
        topicRepository.saveAndFlush(topicDAO);
        TopicResponse topicResponse = new TopicResponse(topicRequest.getId(), topicRequest.getName(), topicRequest.getDesc());
        return topicResponse;
    }

    @Override
    public TopicResponse updateTopic(TopicRequest topicRequest)
    {
        TopicDAO topicDAO = new TopicDAO(topicRequest.getId(), topicRequest.getName(), topicRequest.getDesc());
        topicRepository.saveAndFlush(topicDAO);
        TopicResponse topicResponse = new TopicResponse(topicRequest.getId(), topicRequest.getName(), topicRequest.getDesc());
        return topicResponse;
    }

    @Override
    public TopicResponse deleteTopic(int id)
    {
        TopicDAO topicDAO = topicRepository.findById(id).orElse(null);
        topicRepository.deleteById(id);
        TopicResponse topicResponse = new TopicResponse(topicDAO.getId(), topicDAO.getName(), topicDAO.getDesc());
        return topicResponse;
    }
}
