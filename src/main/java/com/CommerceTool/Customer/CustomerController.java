package com.CommerceTool.Customer;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.customer.*;
import com.commercetools.api.models.customer_group.CustomerGroup;
import com.commercetools.api.models.customer_group.CustomerGroupDraft;
import com.commercetools.api.models.customer_group.CustomerGroupPagedQueryResponse;
import com.commercetools.api.models.type.FieldDefinition;
import com.commercetools.api.models.type.Type;
import com.commercetools.api.models.type.TypePagedQueryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    ProjectApiRoot projectApiRoot;

    @Autowired
    CustomerService service;



    // Create Customer
    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerDetails customerdetails)
    {
      return new ResponseEntity(service.createCustomer(customerdetails),HttpStatus.CREATED);
    }



    //Get all Customer
    @GetMapping
    public ResponseEntity<CustomerPagedQueryResponse> getAllCustomer(@RequestParam(defaultValue = "50",required = false) String Limit)
    {
        return new ResponseEntity<>(service.getAllCustomer(Limit),HttpStatus.OK);
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
