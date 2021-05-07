package com.backend.task.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.task.model.Task;

@Service  
@Transactional
public interface ITaskService {
	
	Task save(Task task);
	
	Page<Task> TaskByPage(PageRequest p);
	
	void delete(Long id);
	
	Boolean exist(Long id);
	
	Task FindById(Long id);

}
