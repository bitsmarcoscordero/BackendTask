package com.backend.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.task.model.Task;


public interface ITaskRepository extends JpaRepository<Task, Long> {

	Task findTaskById(Long id); 
}
