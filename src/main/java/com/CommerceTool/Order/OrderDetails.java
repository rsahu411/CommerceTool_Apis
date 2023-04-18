package com.CommerceTool.Order;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {

    private String cartId;
    private long version;
    private String orderNumber;

    private String stateId;

    // payment id & key
    private String paymentId;
    private String paymentKey;

    // Delivery details

    private String deliveryId;
    List<DeliveryItemDetails> items;

    List<ParcelDetails> parcels;

    // Delivery address details
    private String key;
    private String title;
    private String salutation;
    private String firstName;
    private String lastName;
    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String region;
    private String city;
    private String state;
    private String country;
    private String company;
    private String department;
    private String building;
    private String apartment;
    private String poBox;
    private String mobile;
    private String phone;
    private String email;
    private String fax;
    private String additionalAddressInfo;
    private String externalId;
    private String additionalStreetInfo;

}
