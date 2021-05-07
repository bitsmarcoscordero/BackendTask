package com.backend.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.backend.task.model.Task;
import com.backend.task.service.TaskService;

@RestController
@RequestMapping("api/v1/task")
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> save(@RequestBody Task task) {
		
		try {
			service.save(task);			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(task);
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
		) {
		
        Page<Task> result = service.TaskByPage(PageRequest.of(page, size));

        return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id")  Long id) {
		
		try {
			service.delete(id);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not exist");
		}

		return ResponseEntity.ok("Task deleted succesfuly");
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> edit(@PathVariable("id")  Long id, @RequestBody Task task) {
		
		try {
			if (service.exist(id)) {
				Task taskTemp = service.FindById(id);
				task.setCreatedAt(taskTemp.getCreatedAt());
				task.setId(id);
				service.save(task);
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not exist");
			}
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString());
		}

		return ResponseEntity.status(HttpStatus.OK).body(task);
	}
	

}
