package com.CommerceTool.Customer;

import com.CommerceTool.DataProvider.DataProvider;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.common.BaseAddress;
import com.commercetools.api.models.customer.*;
import com.commercetools.api.models.customer_group.CustomerGroup;
import com.commercetools.api.models.customer_group.CustomerGroupDraft;
import com.commercetools.api.models.customer_group.CustomerGroupPagedQueryResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    ProjectApiRoot apiRoot;
    DataProvider cdp = new DataProvider();


    // Create a new Customer
    public Customer createCustomer(CustomerDetails customerDetails)
    {
        CustomerDraft customerDraft=CustomerDraft
                .builder()
                .firstName(customerDetails.getFirstName())
                .middleName(customerDetails.getMiddleName())
                .lastName(customerDetails.getLastName())
                .email(customerDetails.getEmail())
                .password(customerDetails.getPassword())
                .customerNumber(customerDetails.getCustomerNumber())
                .externalId(customerDetails.getExternalId())
                .companyName(customerDetails.getCompanyName())
                .build();
        return cdp.createCustomer(customerDraft);
    }




    // Get All Customers
    public CustomerPagedQueryResponse getAllCustomer(String limit)
    {
        CustomerPagedQueryResponse pageQuery =apiRoot
                .customers()
                .get()
                .withLimit(limit)
                .executeBlocking()
                .getBody();

        return pageQuery;
    }




    // Get Customer By Id
    public Customer getCustomerById(String id)
    {
        Customer customer = apiRoot
                .customers()
                .withId(id)
                .get()
                .executeBlocking()
                .getBody();
        return customer;
    }





    // Customer Update
    public Customer updateCustomer(String id,CustomerDetails customerDetails)
    {
        Customer customer = apiRoot.customers().withId(id).get().executeBlocking().getBody();

        CustomerUpdate customerUpdate = CustomerUpdate
                .builder()
                .version(customer.getVersion())
                .plusActions(actionBuilder -> actionBuilder
                        .addAddressBuilder()
                        .address(BaseAddress
                                .builder()
                                .streetNumber(customerDetails.getStreetNumber())
                                .streetName(customerDetails.getStreetName())
                                .building(customerDetails.getBuilding())
                                .apartment(customerDetails.getApartment())
                                .pOBox(customerDetails.getPOBox())
                                .postalCode(customerDetails.getPostalCode())
                                .city(customerDetails.getCity())
                                .state(customerDetails.getState())
                                .country(customerDetails.getCountry())
                                .region(customerDetails.getRegion())
                                .build()))
                .build();

        Customer updatedcustomer = apiRoot.customers().withId(customer.getId()).post(customerUpdate).executeBlocking().getBody();

        return updatedcustomer;
    }





    // Delete Customer By Id
    public Customer deleteCustomerById(String id,long version)
    {
        Customer customer = apiRoot
                .customers()
                .withId(id)
                .delete(version)
                .executeBlocking()
                .getBody();
        return customer;
    }





    // Get Customer Token
    public CustomerToken getCustomerToken(CustomerDetails customerDetails)
    {
        CustomerCreatePasswordResetToken customerCreatePasswordResetToken = CustomerCreatePasswordResetToken
                .builder().email(customerDetails.getEmail()).build();
        return cdp.getCustomerToken(customerCreatePasswordResetToken);
    }





    // Reset Password
    public  Customer resetPassword(@NotNull CustomerDetails customerDetails)
    {
        CustomerResetPassword customerResetPassword= CustomerResetPassword
                .builder()
                .tokenValue(customerDetails.getTokenValue())
                .newPassword(customerDetails.getNewPassword())
                .build();
        return cdp.resetPassword(customerResetPassword);
    }






    // Change Password
    public  Customer changePassword(CustomerDetails customerDetails)
    {
        CustomerChangePassword changePassword = CustomerChangePassword
                .builder()
                .id(customerDetails.getId())
                .version(customerDetails.getVersion())
                .currentPassword(customerDetails.getCurrentPassword())
                .newPassword(customerDetails.getNewPassword())
                .build();
        return cdp.changePassword(changePassword);
    }






    // Customer SignIn
    public  CustomerSignInResult getustomerByLogIn(CustomerDetails customerDetails)
    {
        CustomerSignin customer= CustomerSignin
                .builder()
                .email(customerDetails.getEmail())
                .password(customerDetails.getPassword())
                .build();
        return cdp.getCustomerByLogin(customer);
    }





    // Create Customer-Group
    public CustomerGroup createCustomerGroup(CustomerDetails customerDetails) {

        CustomerGroupDraft customerGroupDraft = CustomerGroupDraft
                .builder()
                .groupName(customerDetails.getCustomerGroupName())
                .key(customerDetails.getCustomerGroupKey())
                .build();
        return cdp.createCustomerGroup(customerGroupDraft);
    }



    // Get All Customer Group
    public CustomerGroupPagedQueryResponse getCustomerGroupCustomer() {

        CustomerGroupPagedQueryResponse queryResponse = apiRoot
                .customerGroups()
                .get()
                .executeBlocking()
                .getBody();
        return queryResponse;
    }



    // Get Customer-Group By id
    public CustomerGroup getCustomerGroupById(String id) {

        CustomerGroup customerGroup = apiRoot
                .customerGroups()
                .withId(id)
                .get()
                .executeBlocking()
                .getBody();
        return customerGroup;
    }



    // Delete Customer-Group By id
    public CustomerGroup deleteCustomerGroupById(String id, long version) {

        CustomerGroup customerGroup = apiRoot
                .customerGroups()
                .withId(id)
                .delete(version)
                .executeBlocking()
                .getBody();
        return customerGroup;
    }
}
