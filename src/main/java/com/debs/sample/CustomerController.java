package com.debs.sample;

@RestController
@RequestMapping(/sample/v1/customer)
public class CustomerController {
	
	@RequestMapping(method="GET", path="/search", pathVariable="id")
	public String getCustomer(String id){
		if(id == null)
			throw new Exception("Id cannot be null.Id is required.");
		else if(id.equals("1")){
			return "Charlie Chaplin";
		} else
			return "Customer not found";
	}
	
	

}
