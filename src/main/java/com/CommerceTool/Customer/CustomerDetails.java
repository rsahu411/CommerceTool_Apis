package com.CommerceTool.Customer;

import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.type.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetails  implements Serializable {

        public String Id;
        public String customerId;
        //public String title;
        public String firstName;
        public String middleName;
        public String lastName;
        public String email;
        public String companyName;
        public String externalId;
        public String customerNumber;
        public String password;
        public String streetNumber;
        public String streetName;
        public String city;
        public String country;
        public String state;
        public String region;
        public String pOBox;
        public String postalCode;
        public String apartment;
        public String Building;
        public String newPassword;
        public  String tokenValue;
        public String currentPassword;

        public  Long version;
        public String EmailPref;
        public String grant_type;
        public Boolean isEmailPr;
        public String customerGroupName;
        public String customerGroupKey;




    public String isEmailPref() {
        return EmailPref;
    }

    public void setEmailPref(String emailPref) {
        EmailPref = emailPref;
    }


}

