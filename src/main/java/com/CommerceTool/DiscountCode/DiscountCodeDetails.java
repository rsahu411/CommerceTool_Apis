package com.CommerceTool.DiscountCode;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
public class DiscountCodeDetails {
    public String name;
    public String description;
    public String code;
    public ZonedDateTime validFrom;
    public ZonedDateTime validUntil;
    public Boolean isActive;
    public long maxApplication;
    public long maxApplicationPerCustomer;
    public List<CartDiscountVariable> cartDiscountvariables;

}

//@Getter
//@Setter
// class CartDiscountDetails {
//  public  String CartDiscountId;
//
//}
