package com.getPaymentMethod.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getPaymentMethod.Bean.ReturnLinks;
import com.getPaymentMethod.Repository.ReturnLinksRepository;
@RestController
@RequestMapping("/return")
public class ReturnLinksController
{
	@Autowired
	private ReturnLinksRepository repository;
	
	@GetMapping("/readrl")
	public Iterable<ReturnLinks> readAll()
	{
		Iterable<ReturnLinks> all = repository.findAll();
		return all;
	}
	@PostMapping("/createrl")
	public ReturnLinks create(@RequestBody ReturnLinks returnlinks)
	{
		return repository.save(returnlinks);
	}
}
