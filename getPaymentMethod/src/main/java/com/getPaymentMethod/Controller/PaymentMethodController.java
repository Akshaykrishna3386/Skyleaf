package com.getPaymentMethod.Controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getPaymentMethod.Bean.CardExpiry;
import com.getPaymentMethod.Bean.CardHolder;
import com.getPaymentMethod.Bean.PaymentMethod;
import com.getPaymentMethod.Bean.ReturnLinks;
import com.getPaymentMethod.Repository.CardExpiryRepository;
import com.getPaymentMethod.Repository.CardHolderRepository;
import com.getPaymentMethod.Repository.PaymentMethodRepository;
import com.getPaymentMethod.Repository.ReturnLinksRepository;
import com.google.gson.Gson;
@RestController
@RequestMapping("/payment")
public class PaymentMethodController 
{
	@Autowired
	private PaymentMethodRepository repository;
	@Autowired
	private ReturnLinksRepository links;
	@Autowired
	private CardExpiryRepository expiry;
	@Autowired
	private CardHolderRepository holder;
	
	@GetMapping("/readAll")
	public Iterable<PaymentMethod> readAll1()
	{
		Iterable<PaymentMethod> all = repository.findAll();
		return all;
	}
	
	@GetMapping("/hello")
	public String readAll()
	{
		Iterable<PaymentMethod> all = repository.findAll();
		Gson gson = new Gson();
		String json = gson.toJson(all);
		
		JSONArray j1 = new JSONArray(json);
		JSONObject res = new JSONObject(j1.get(0).toString());
		
		
		
		Iterable<ReturnLinks> link = links.findAll();
//		JSONObject linksJson = new JSONObject(new JSONArray(json).get(0).toString());

		json = gson.toJson(link);
		res.put("linksDetails", new JSONArray(json));
		
		
		
		//to get card
		
		Iterable<CardExpiry> expire =  expiry.findAll();
		
		json = gson.toJson(expire);
		JSONObject expiryJson = new JSONObject(new JSONArray(json).get(0).toString());
		
		
		
		
		// get the card holder
		
		Iterable<CardHolder> cardholder = holder.findAll();
		
		json = gson.toJson(cardholder);
		JSONObject cards = new JSONObject(new JSONArray(json).get(0).toString());
		res.put("cardholder", cardholder);
		
		res.put("cardholder",cardholder);
		
		
		
		
		
		Iterable<ReturnLinks> returnlinks = links.findAll();
		
		json = gson.toJson(returnlinks);
		res.put("returnlinks", new JSONArray(json));
		return res.toString();
		
		
	}
	
	@PostMapping("/create")
	public PaymentMethod create(@RequestBody PaymentMethod paymentmethod)
	{
		return repository.save(paymentmethod);
	}
	
	
}
