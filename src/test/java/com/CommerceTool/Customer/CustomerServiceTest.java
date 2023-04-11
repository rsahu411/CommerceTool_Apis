package com.CommerceTool.Customer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.customer.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomerService.class})
@ExtendWith(SpringExtension.class)
class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;

    @MockBean
    private ProjectApiRoot projectApiRoot;

    /**
     * Method under test: {@link CustomerService#createCustomer(CustomerDetails)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateCustomer() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: interface com.commercetools.api.models.customer.CustomerDraft: email is missing
        //       at java.util.Objects.requireNonNull(Objects.java:233)
        //       at com.commercetools.api.models.customer.CustomerDraftBuilder.build(CustomerDraftBuilder.java:915)
        //       at com.CommerceTool.Customer.CustomerService.createCustomer(CustomerService.java:37)
        //   See https://diff.blue/R013 to resolve this issue.

        customerService.createCustomer(new CustomerDetails());
    }

    /**
     * Method under test: {@link CustomerService#createCustomer(CustomerDetails)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateCustomer2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.concurrent.RejectedExecutionException
        //       at java.util.concurrent.ForkJoinPool.externalPush(ForkJoinPool.java:2179)
        //       at java.util.concurrent.ForkJoinPool.externalSubmit(ForkJoinPool.java:2196)
        //       at java.util.concurrent.ForkJoinPool.submit(ForkJoinPool.java:2690)
        //       at java.util.concurrent.ForkJoinPool.submit(ForkJoinPool.java:181)
        //       at dev.failsafe.internal.util.DelegatingScheduler.schedule(DelegatingScheduler.java:155)
        //       at dev.failsafe.Functions.lambda$toAsync$8(Functions.java:207)
        //       at dev.failsafe.internal.RetryPolicyExecutor.handleAsync(RetryPolicyExecutor.java:145)
        //       at dev.failsafe.internal.RetryPolicyExecutor.lambda$applyAsync$1(RetryPolicyExecutor.java:125)
        //       at dev.failsafe.AsyncExecutionImpl.executeAsync(AsyncExecutionImpl.java:149)
        //       at dev.failsafe.FailsafeExecutor.callAsync(FailsafeExecutor.java:407)
        //       at dev.failsafe.FailsafeExecutor.getStageAsync(FailsafeExecutor.java:195)
        //       at io.vrap.rmf.base.client.http.OAuthMiddlewareImpl.invoke(OAuthMiddlewareImpl.java:99)
        //       at io.vrap.rmf.base.client.http.HandlerStack.lambda$resolve$0(HandlerStack.java:64)
        //       at io.vrap.rmf.base.client.ClientBuilder.lambda$null$49(ClientBuilder.java:1242)
        //       at io.vrap.rmf.base.client.http.HandlerStack.lambda$resolve$0(HandlerStack.java:64)
        //       at io.vrap.rmf.base.client.http.AcceptGZipMiddleware.invoke(AcceptGZipMiddleware.java:18)
        //       at io.vrap.rmf.base.client.http.HandlerStack.lambda$resolve$0(HandlerStack.java:64)
        //       at io.vrap.rmf.base.client.http.HandlerStack.invoke(HandlerStack.java:82)
        //       at io.vrap.rmf.base.client.http.HandlerStack.execute(HandlerStack.java:76)
        //       at io.vrap.rmf.base.client.ApiHttpClientImpl.execute(ApiHttpClientImpl.java:41)
        //       at io.vrap.rmf.base.client.ApiHttpClientImpl.execute(ApiHttpClientImpl.java:51)
        //       at io.vrap.rmf.base.client.ApiMethod.executeBlocking(ApiMethod.java:365)
        //       at com.commercetools.api.client.ByProjectKeyCustomersPost.executeBlocking(ByProjectKeyCustomersPost.java:74)
        //       at io.vrap.rmf.base.client.ApiMethod.executeBlocking(ApiMethod.java:337)
        //       at com.CommerceTool.DataProvider.DataProvider.createCustomer(DataProvider.java:33)
        //       at com.CommerceTool.Customer.CustomerService.createCustomer(CustomerService.java:38)
        //   See https://diff.blue/R013 to resolve this issue.

        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setEmail("jane.doe@example.org");
        customerService.createCustomer(customerDetails);
    }

    /**
     * Method under test: {@link CustomerService#createCustomer(CustomerDetails)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateCustomer3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.CommerceTool.Customer.CustomerDetails.getFirstName()" because "customerDetails" is null
        //       at com.CommerceTool.Customer.CustomerService.createCustomer(CustomerService.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

        customerService.createCustomer(null);
    }

    /**
     * Method under test: {@link CustomerService#createCustomer(CustomerDetails)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateCustomer4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.concurrent.RejectedExecutionException
        //       at java.util.concurrent.ForkJoinPool.externalPush(ForkJoinPool.java:2179)
        //       at java.util.concurrent.ForkJoinPool.externalSubmit(ForkJoinPool.java:2196)
        //       at java.util.concurrent.ForkJoinPool.submit(ForkJoinPool.java:2690)
        //       at java.util.concurrent.ForkJoinPool.submit(ForkJoinPool.java:181)
        //       at dev.failsafe.internal.util.DelegatingScheduler.schedule(DelegatingScheduler.java:155)
        //       at dev.failsafe.Functions.lambda$toAsync$8(Functions.java:207)
        //       at dev.failsafe.internal.RetryPolicyExecutor.handleAsync(RetryPolicyExecutor.java:145)
        //       at dev.failsafe.internal.RetryPolicyExecutor.lambda$applyAsync$1(RetryPolicyExecutor.java:125)
        //       at dev.failsafe.AsyncExecutionImpl.executeAsync(AsyncExecutionImpl.java:149)
        //       at dev.failsafe.FailsafeExecutor.callAsync(FailsafeExecutor.java:407)
        //       at dev.failsafe.FailsafeExecutor.getStageAsync(FailsafeExecutor.java:195)
        //       at io.vrap.rmf.base.client.http.OAuthMiddlewareImpl.invoke(OAuthMiddlewareImpl.java:99)
        //       at io.vrap.rmf.base.client.http.HandlerStack.lambda$resolve$0(HandlerStack.java:64)
        //       at io.vrap.rmf.base.client.ClientBuilder.lambda$null$49(ClientBuilder.java:1242)
        //       at io.vrap.rmf.base.client.http.HandlerStack.lambda$resolve$0(HandlerStack.java:64)
        //       at io.vrap.rmf.base.client.http.AcceptGZipMiddleware.invoke(AcceptGZipMiddleware.java:18)
        //       at io.vrap.rmf.base.client.http.HandlerStack.lambda$resolve$0(HandlerStack.java:64)
        //       at io.vrap.rmf.base.client.http.HandlerStack.invoke(HandlerStack.java:82)
        //       at io.vrap.rmf.base.client.http.HandlerStack.execute(HandlerStack.java:76)
        //       at io.vrap.rmf.base.client.ApiHttpClientImpl.execute(ApiHttpClientImpl.java:41)
        //       at io.vrap.rmf.base.client.ApiHttpClientImpl.execute(ApiHttpClientImpl.java:51)
        //       at io.vrap.rmf.base.client.ApiMethod.executeBlocking(ApiMethod.java:365)
        //       at com.commercetools.api.client.ByProjectKeyCustomersPost.executeBlocking(ByProjectKeyCustomersPost.java:74)
        //       at io.vrap.rmf.base.client.ApiMethod.executeBlocking(ApiMethod.java:337)
        //       at com.CommerceTool.DataProvider.DataProvider.createCustomer(DataProvider.java:33)
        //       at com.CommerceTool.Customer.CustomerService.createCustomer(CustomerService.java:38)
        //   See https://diff.blue/R013 to resolve this issue.

        CustomerDetails customerDetails = mock(CustomerDetails.class);
        when(customerDetails.getCompanyName()).thenReturn("Company Name");
        when(customerDetails.getCustomerNumber()).thenReturn("42");
        when(customerDetails.getEmail()).thenReturn("jane.doe@example.org");
        when(customerDetails.getExternalId()).thenReturn("42");
        when(customerDetails.getFirstName()).thenReturn("Jane");
        when(customerDetails.getLastName()).thenReturn("Doe");
        when(customerDetails.getMiddleName()).thenReturn("Middle Name");
        when(customerDetails.getPassword()).thenReturn("iloveyou");
        Customer customer = customerService.createCustomer(customerDetails);
        Assertions.assertNotNull(customer);

        Assertions.assertEquals(customer.getFirstName(), customerDetails.getFirstName());


    }
}

