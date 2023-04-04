package com.CommerceTool.configuration;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.defaultconfig.ApiRootBuilder;
import com.commercetools.api.defaultconfig.ServiceRegion;
import io.vrap.rmf.base.client.oauth2.ClientCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.HttpAuthenticationBuilder;


@Configuration
public class Client {


    @Bean
    public static ProjectApiRoot createApiClient() {
        final ProjectApiRoot apiRoot = ApiRootBuilder.of()
                .defaultClient(ClientCredentials.of()
                                .withClientId("w2159vG2m9ZSbsyYBVNF5xrk")
                                .withClientSecret("BkaxoNBfkM-thQLJ-s-eIBpPtRfMt8uJ")
                                .build(),
                        ServiceRegion.GCP_AUSTRALIA_SOUTHEAST1)
                .build("rishabh_ct");

        return apiRoot;
    }



//    @Bean
//    public Docket api() {
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(getInfo())
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//
//    }
//
//    private ApiInfo getInfo() {
//
//
//        return new ApiInfo("Blogging Application : Backend Course",
//                "This project is developed by Sahu", "1.0", "Terms of Service",
//                new Contact("Rishabh", "https://learncodewithdurgesh.com", "Rishabh.sahu@hybrisworld.com"),
//                "License of APIS", "API license URL", Collections.emptyList());
//    }

//    @Bean
//    public Docket postApi(){
//        return new Docket(DocumentationType.SWAGGER_2).select()
//                .apis(RequestHandlerSelectors.basePackage("com.techinterface"))
//                .paths(PathSelectors.any())
//                .build().apiInfo(apiInfo());
//
//    }
//
//    private ApiInfo apiInfo()
//    {
//        return new ApiInfoBuilder()
//                .title("CommerceTool Apis")
//                .description("sample documentation of commerceTool")
//                .termsOfServiceUrl("https://docs.commercetools.com/api/projects/carts#ctp:api:type:CustomLineItem")
//                .license("CommerceTool_License")
//                .licenseUrl("https://docs.commercetools.com/api/projects/carts#ctp:api:type:CustomLineItem")
//                .version("1.0")
//                .build();
//    }

}
