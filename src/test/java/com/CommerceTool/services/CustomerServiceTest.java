package com.CommerceTool.services;

import com.CommerceTool.Customer.CustomerDetails;
import com.CommerceTool.Customer.CustomerService;
import com.CommerceTool.DataProvider.DataProvider;
import com.commercetools.api.models.customer.Customer;
import com.commercetools.api.models.customer.CustomerDraft;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
//    @InjectMocks
//    private CustomerService customerService;
//
//    @Mock
//    private DataProvider cdp;
//
//    @Test
//    public void testCreateCustomer() {
//        CustomerDetails customerDetails = new CustomerDetails();
//        customerDetails.setFirstName("John");
//        customerDetails.setLastName("Doe");
//        customerDetails.setEmail("john.doe@example.com");
//        customerDetails.setPassword("password");
//        customerDetails.setCustomerNumber("123456");
//        customerDetails.setExternalId("7890");
//        customerDetails.setCompanyName("Acme Inc.");
//
//        CustomerDraft expectedDraft = CustomerDraft.builder()
//                .firstName("John")
//                .lastName("Doe")
//                .email("john.doe@example.com")
//                .password("password")
//                .customerNumber("123456")
//                .externalId("7890")
//                .companyName("Acme Inc.")
//                .build();
//
//        Customer expectedCustomer = new Customer();
//        expectedCustomer.setFirstName("John");
//        expectedCustomer.setLastName("Doe");
//        expectedCustomer.setEmail("john.doe@example.com");
//        expectedCustomer.setCustomerNumber("123456");
//        expectedCustomer.setExternalId("7890");
//        expectedCustomer.setCompanyName("Acme Inc.");
//
//      //  when(cdp.createCustomer(expectedDraft)).thenReturn(expectedD);
//
//        Customer actualCustomer = customerService.createCustomer(customerDetails);
//
//        verify(cdp).createCustomer(expectedDraft);
//        assertEquals(expectedCustomer, actualCustomer);
//    }


    private CustomerService customerService;

    @BeforeEach
    public void setup() {
        customerService = new CustomerService();
    }

    @Test
    public void testCreateCustomer() {
        // Create a CustomerDetails object to use as input to the method
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setFirstName("Shubham");
        customerDetails.setLastName("Mishra");
        customerDetails.setEmail("Shubham@gmail.com");
        customerDetails.setPassword("password");
        customerDetails.setCustomerNumber("123");
        customerDetails.setExternalId("456");
        customerDetails.setCompanyName("hybris");

        // Call the createCustomer method and store the result in a variable
        Customer customer = customerService.createCustomer(customerDetails);

        // Verify that the returned customer object is not null
        Assertions.assertNotNull(customer);

        // Verify that the returned customer object has the expected properties
        Assertions.assertEquals(customer.getFirstName(), customerDetails.getFirstName());
        Assertions.assertEquals(customer.getLastName(), customerDetails.getLastName());
        Assertions.assertEquals(customer.getEmail(), customerDetails.getEmail());
        Assertions.assertEquals(customer.getCustomerNumber(), customerDetails.getCustomerNumber());
        Assertions.assertEquals(customer.getExternalId(), customerDetails.getExternalId());
        Assertions.assertEquals(customer.getCompanyName(), customerDetails.getCompanyName());
    }

}
