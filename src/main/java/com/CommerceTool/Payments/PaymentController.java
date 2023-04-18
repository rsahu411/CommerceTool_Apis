package com.CommerceTool.Payments;

import com.commercetools.api.models.payment.Payment;
import com.commercetools.api.models.payment.PaymentPagedQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    // Create Payments
    @PostMapping
    public Payment createPayment(@RequestBody PaymentDetails paymentDetails)
    {
        return paymentService.createPayment(paymentDetails);
    }


    // Get All Payments
    @GetMapping
    public PaymentPagedQueryResponse getAllPAyments(@RequestParam(defaultValue = "100",required = false) String limit)
    {
        return paymentService.getAllPayments(limit);
    }


    // Get Payment By Id
    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable String id)
    {
        return paymentService.getPaymentsById(id);
    }



    // Delete Payment By Id
    @DeleteMapping("/{id}")
    public Payment deletePaymentById(@PathVariable String id)
    {
        return paymentService.deletePaymentById(id);
    }
}
