package com.CommerceTool.GraphQL;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.graph_ql.GraphQLRequest;
import com.commercetools.api.models.graph_ql.GraphQLResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/graph-ql")
public class GraphQLController {

    @Autowired
    ProjectApiRoot apiRoot;
    @GetMapping("/customers")
    public GraphQLResponse getAllCustomer()
    {
        return apiRoot.graphql().post(GraphQLRequest.builder().query("query Sphere {\n" +
                "  customers(limit:100) {\n" +
                "    results\n" +
                "    {\n" +
                "      email\n" +
                "    customerNumber\n" +
                "    }\n" +
                "  }\n" +
                "    }").build()).executeBlocking().getBody();
    }
}
