package com.example.app.controller;


import com.example.app.Service.ICourseService;
import com.example.app.Service.ITopicService;
import com.example.app.persistance.Model.CourseDAO;
import com.example.contracts.request.CourseRequest;
import com.example.contracts.request.TopicRequest;
import com.example.contracts.response.CourseResponse;
import com.example.contracts.response.ResponseModel;
import com.example.contracts.response.TopicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private ITopicService topicService;

    @Autowired
    private ICourseService courseService;

    @RequestMapping(path = "/topic/getAll", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<ResponseModel<List<TopicResponse>>> getAll() {
        List<TopicResponse> topicResponses = topicService.getAll();
        return new ResponseEntity<ResponseModel<List<TopicResponse>>>(new ResponseModel<List<TopicResponse>>(topicResponses), HttpStatus.OK);
    }

    @RequestMapping(path = "/topic/get/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<ResponseModel<TopicResponse>> getTopic(@PathVariable("id") int id) {
        TopicResponse topicResponse = topicService.getTopic(id);
        return new ResponseEntity<ResponseModel<TopicResponse>>(new ResponseModel<TopicResponse>(topicResponse), HttpStatus.OK);
    }


    @RequestMapping(path = "/topic/add", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<ResponseModel<TopicResponse>> saveTopic(@RequestBody TopicRequest topicRequest) {
        TopicResponse topicResponse = topicService.saveTopic(topicRequest);
        return new ResponseEntity<ResponseModel<TopicResponse>>(new ResponseModel<TopicResponse>(topicResponse), HttpStatus.OK);
    }

    @RequestMapping(path = "/topic/update", method = RequestMethod.PUT, consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<ResponseModel<TopicResponse>> updateTopic(@RequestBody TopicRequest topicRequest) {
        TopicResponse topicResponse = topicService.updateTopic(topicRequest);
        return new ResponseEntity<ResponseModel<TopicResponse>>(new ResponseModel<TopicResponse>(topicResponse), HttpStatus.OK);
    }

    @RequestMapping(path = "/topic/delete/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public ResponseEntity<ResponseModel<TopicResponse>> deleteTopic(@PathVariable("id") int id) {
        TopicResponse topicResponse = topicService.deleteTopic(id);
        return new ResponseEntity<ResponseModel<TopicResponse>>(new ResponseModel<TopicResponse>(topicResponse), HttpStatus.OK);
    }

    @RequestMapping(path = "/topic/{topicId}/course", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<ResponseModel<CourseResponse>> addCourse(@PathVariable("topicId") int topicId, @RequestBody CourseRequest courseRequest) {
        CourseResponse courseResponse = courseService.addCourse(courseRequest, topicId);
        return new ResponseEntity<ResponseModel<CourseResponse>>(new ResponseModel<CourseResponse>(courseResponse), HttpStatus.OK);
    }


    @RequestMapping(path = "/topic/{topicId}/courses", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<ResponseModel<List<CourseResponse>>> getAll(@PathVariable("topicId") int id) {
        List<CourseResponse> courseResponses = courseService.getAllperTopic(id);
        return new ResponseEntity<ResponseModel<List<CourseResponse>>>(new ResponseModel<List<CourseResponse>>(courseResponses), HttpStatus.OK);
    }

    @RequestMapping(path = "/topic/{topicId}/course/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<ResponseModel<CourseResponse>> getCourse(@PathVariable("id") int id)
    {
        CourseResponse courseResponse = courseService.getCourse(id);
        return new ResponseEntity<ResponseModel<CourseResponse>>(new ResponseModel<CourseResponse>(courseResponse), HttpStatus.OK);

    }

    @RequestMapping(path = "/topic/{topicId}/updateCourse", method = RequestMethod.PUT, consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<ResponseModel<CourseResponse>> updateCourse(@PathVariable("topicId") int topicId, @RequestBody CourseRequest courseRequest) {
        CourseResponse courseResponse = courseService.updateCourse(courseRequest, topicId);
        return new ResponseEntity<ResponseModel<CourseResponse>>(new ResponseModel<CourseResponse>(courseResponse), HttpStatus.OK);
    }

    @RequestMapping(path = "/topic/{topicId}/course/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public ResponseEntity<ResponseModel<CourseResponse>> deleteCourse(@PathVariable("id") int id)
    {
        CourseResponse courseResponse = courseService.deleteCourse(id);
        return new ResponseEntity<ResponseModel<CourseResponse>>(new ResponseModel<CourseResponse>(courseResponse), HttpStatus.OK);

    }


}
