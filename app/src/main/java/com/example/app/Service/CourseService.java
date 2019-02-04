package com.example.app.Service;


import com.example.app.persistance.Model.CourseDAO;
import com.example.app.persistance.Model.TopicDAO;
import com.example.app.persistance.Repository.CourseRepository;
import com.example.contracts.request.CourseRequest;
import com.example.contracts.response.CourseResponse;
import com.example.contracts.response.TopicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService implements ICourseService {


    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseResponse> getAllperTopic(int topicId)
    {
        List<CourseDAO>  courseDAOS = courseRepository.findByTopicDAOId(topicId);
        List<CourseResponse> courseResponses = new ArrayList<>();
        for(CourseDAO courseDAO : courseDAOS)
        {
            CourseResponse courseResponse = new CourseResponse(courseDAO.getId(), courseDAO.getName(), courseDAO.getDesc());
            courseResponse.setTopicResponse(new TopicResponse(courseDAO.getTopicDAO().getId(),courseDAO.getTopicDAO().getName(),courseDAO.getTopicDAO().getDesc()));
            courseResponses.add(courseResponse);
        }
        return courseResponses;
    }

    @Override
    public CourseResponse getCourse(int id)
    {
        CourseDAO courseDAO = courseRepository.findById(id).orElse(null );
        CourseResponse courseResponse = new CourseResponse(courseDAO.getId(),courseDAO.getName(),courseDAO.getDesc());
        courseResponse.setTopicResponse(new TopicResponse(courseDAO.getTopicDAO().getId(),courseDAO.getTopicDAO().getName(),courseDAO.getTopicDAO().getDesc()));
        return courseResponse;
    }

    @Override
    public CourseResponse addCourse(CourseRequest courseRequest, int topicId)
    {
        CourseDAO courseDAO = new CourseDAO(courseRequest.getId(),courseRequest.getName(),courseRequest.getDesc());
        courseDAO.setTopicDAO(new TopicDAO(topicId,"",""));
        courseRepository.saveAndFlush(courseDAO);
        CourseResponse courseResponse = new CourseResponse(courseDAO.getId(),courseDAO.getName(),courseDAO.getDesc());
        TopicResponse topicResponse = new TopicResponse(courseDAO.getTopicDAO().getId(),courseDAO.getTopicDAO().getName(),courseDAO.getTopicDAO().getDesc());
        courseResponse.setTopicResponse(topicResponse);
        return courseResponse;

    }

    @Override
    public CourseResponse updateCourse(CourseRequest courseRequest, int topicId)
    {
        CourseDAO courseDAO = new CourseDAO(courseRequest.getId(),courseRequest.getName(),courseRequest.getDesc());
        courseDAO.setTopicDAO(new TopicDAO(topicId,"",""));
        courseRepository.saveAndFlush(courseDAO);
        CourseResponse courseResponse = new CourseResponse(courseDAO.getId(),courseDAO.getName(),courseDAO.getDesc());
        courseResponse.setTopicResponse(new TopicResponse(courseDAO.getTopicDAO().getId(),courseDAO.getTopicDAO().getName(),courseDAO.getTopicDAO().getDesc()));
        return courseResponse;
    }


    @Override
    public CourseResponse deleteCourse(int id)
    {
        CourseResponse courseResponse = getCourse(id);
        courseRepository.deleteById(id);
        return courseResponse;
    }
}
