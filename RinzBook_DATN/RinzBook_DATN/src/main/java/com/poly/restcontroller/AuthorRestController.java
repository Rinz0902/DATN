package com.poly.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.entity.Author;
import com.poly.service.AuthorService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authors")
public class AuthorRestController {

	@Autowired
	AuthorService authorservice;

	@GetMapping
	public List<Author> getAll() {
		return authorservice.findAll();
	}

	@GetMapping("{id}")
	public Author getOne(@PathVariable("id") Integer id) {
		return authorservice.findById(id);
	}

	@PostMapping
	public Author create(@RequestBody Author author) {
		return authorservice.create(author);
	}

	@PutMapping("{id}")
	public Author update(@PathVariable("id") String id, @RequestBody Author author) {
		return authorservice.update(author);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		authorservice.delete(id);
	}
}
