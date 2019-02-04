package com.example.app.persistance.Repository;

import com.example.app.persistance.Model.CourseDAO;
import com.example.contracts.response.CourseResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseDAO,Integer> {

    public List<CourseDAO> findByTopicDAOId(int id);
}
