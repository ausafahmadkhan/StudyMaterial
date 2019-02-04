package com.example.app.Service;

import com.example.contracts.request.CourseRequest;
import com.example.contracts.response.CourseResponse;

import java.util.List;

public interface ICourseService {

    public List<CourseResponse> getAllperTopic(int topicId);
    public CourseResponse getCourse(int id);
    public CourseResponse addCourse(CourseRequest courseRequest, int topicId);
    public CourseResponse updateCourse(CourseRequest courseRequest, int topicId);
    public CourseResponse deleteCourse(int id);
}
