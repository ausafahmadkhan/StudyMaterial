package com.example.app.persistance.Repository;

import com.example.app.persistance.Model.TopicDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<TopicDAO, Integer > {
}
