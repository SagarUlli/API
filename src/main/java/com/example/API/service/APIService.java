package com.example.API.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class APIService {

	@Value("${razorpay.key}")
	private String razorpayKey;

	@Value("${razorpay.secret}")
	private String razorpaySecret;

	public String prime(ModelMap map) throws RazorpayException {
		RazorpayClient client = new RazorpayClient(razorpayKey, razorpaySecret);

		JSONObject orderRequest = new JSONObject();
		orderRequest.put("amount", 19900);
		orderRequest.put("currency", "INR");
		orderRequest.put("receipt", "rcptid_11");

		try {
			Order order = client.orders.create(orderRequest);

			map.put("key", razorpayKey);
			map.put("amount", order.get("amount"));
			map.put("currency", order.get("currency"));
			map.put("orderId", order.get("id"));

			return "razorpay.html";
		} catch (RazorpayException e) {
			e.printStackTrace();
			map.put("error", "An error occurred while creating the payment order.");
			return "error.html";
		}
	}
}
