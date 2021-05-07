package com.backend.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.task.model.Task;
import com.backend.task.repository.ITaskRepository;

@Service  
@Transactional
public class TaskService implements ITaskService {
	
	@Autowired
	private ITaskRepository task;

	@Override
	public Task save(Task task) {
		return this.task.save(task);
	}

	@Override
	public Page<Task> TaskByPage(PageRequest p) {
		return task.findAll(p);
	}

	@Override
	public void delete(Long id) {
		task.deleteById(id);
		
	}

	@Override
	public Boolean exist(Long id) {
		return task.existsById(id);
	}

	@Override
	public Task FindById(Long id) {
		return this.task.findTaskById(id);
	}


}
