package com.CommerceTool.Customer;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.customer.*;
import com.commercetools.api.models.customer_group.CustomerGroup;
import com.commercetools.api.models.customer_group.CustomerGroupPagedQueryResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@RestController
@Slf4j
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    ProjectApiRoot projectApiRoot;

    @Autowired
    CustomerService service;


    ObjectMapper mapper = new ObjectMapper();

    // Create Customer
    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerDetails customerdetails) throws JsonProcessingException {
        Customer customer = service.createCustomer(customerdetails);
        mapper.registerModule(new JavaTimeModule());
       String jsonData= mapper.writeValueAsString(customer);

        System.out.println(jsonData);
      return new ResponseEntity(customer,HttpStatus.CREATED);
    }



    //Get all Customer
    @GetMapping
    public ResponseEntity<CustomerPagedQueryResponse>  getAllCustomer( @RequestParam(defaultValue = "50",required = false) String Limit) {

        return new ResponseEntity<>(service.getAllCustomer(Limit),HttpStatus.OK);
    }


    // Download Csv file
    @GetMapping("/csv")
    public void  downloadCsvOfAllCustomer( HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition","attachment; filename=\"customers.csv\"");

        PrintWriter writer = response.getWriter();
        CustomerPagedQueryResponse customerPagedQueryResponse = projectApiRoot.customers().get().executeBlocking().getBody();

        writer.println("Id,firstName,middleName,lastName,email,customerNumber,externalId");
        for(Customer customer : customerPagedQueryResponse.getResults())
        {
            writer.println(customer.getId()+","+customer.getFirstName()+", "+","+customer.getMiddleName() +customer.getLastName()+
                    ", "+customer.getEmail()+", "+customer.getCustomerNumber()+","+customer.getExternalId());
        }
        writer.flush();
        writer.close();
    }



   // Get Customer By id
    @GetMapping("/{Id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String Id)
    {

        return new ResponseEntity<>(service.getCustomerById(Id),HttpStatus.OK);
    }



    //Delete Customer By id
    public Customer deleteCustomerById(@PathVariable String Id,@RequestParam(required = false,defaultValue = "1L") long version)
    {
        return service.deleteCustomerById(Id,version);
    }




    // Update Customer By id
    @PostMapping("/{Id}")
    public Customer updateCustomer(@PathVariable String Id,@RequestBody CustomerDetails customerDetails)
    {

       return service.updateCustomer(Id,customerDetails);
    }




    // Create Customer Group
    @PostMapping("/groups")
    public CustomerGroup createCustomerGroup(@RequestBody CustomerDetails customerDetails)
    {
        return service.createCustomerGroup(customerDetails);
    }



    // Get All Customer-Groups
    @GetMapping("/groups")
    public CustomerGroupPagedQueryResponse getCustomerGroupCustomer()
    {
        return service.getCustomerGroupCustomer();
    }




    // Get Customer-Group By id
    @GetMapping("/groups/{id}")
    public CustomerGroup getCustomerGroupById(@PathVariable String id)
    {
        return service.getCustomerGroupById(id);
    }




    // Delete Customer-Group By id
    @DeleteMapping("/groups/{id}")
    public CustomerGroup deleteCustomerGroupById(@PathVariable String id,@RequestParam(required = false,defaultValue = "1L") long version)
    {
        return service.deleteCustomerGroupById(id,version);
    }








    // Update Custom Object
//    @PostMapping("/custom-update/{id}")
//    public Type updateCustomObject(@PathVariable String id,@RequestBody CustomerDetails customerDetails)
//    {
//        return service.updateCustomType(customerDetails,id);
//    }




    // Get Token Value
   @PostMapping("/password-token")
    public CustomerToken getTokenValue(@RequestBody CustomerDetails customerDetails)
   {
       return service.getCustomerToken(customerDetails);
   }




   // Reset Password
   @PostMapping("/password/reset")
    public Customer resetPassword(@RequestBody CustomerDetails customerDetails)
    {
        return service.resetPassword(customerDetails);
    }




    // Change Customer Password
    @PostMapping("/password/change")
    public  Customer changePassword(@RequestBody CustomerDetails customerDetails)
    {
        return service.changePassword(customerDetails);
    }




    // Customer SignIn Result
    @GetMapping("/login")
    public  CustomerSignInResult customerByLogIn(@RequestBody CustomerDetails customerDetails)
    {
       return  service.getustomerByLogIn(customerDetails);
    }

}
