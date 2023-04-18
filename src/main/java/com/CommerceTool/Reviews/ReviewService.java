package com.CommerceTool.Reviews;

import com.CommerceTool.DataProvider.DataProvider;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product.ProductResourceIdentifier;
import com.commercetools.api.models.review.*;
import com.commercetools.api.models.state.StateResourceIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    ProjectApiRoot apiRoot;

    DataProvider cdp = new DataProvider();


    // Create Review
    public Review createReview(ReviewDetails reviewDetails) {

        ReviewDraft reviewDraft = ReviewDraft
                .builder()
                .key(reviewDetails.getKey())
                .authorName(reviewDetails.getAuthorName())
                .title(reviewDetails.getTitle())
                .text(reviewDetails.getText())
                .rating(reviewDetails.getRating())
                .target(ProductResourceIdentifier.builder().id(reviewDetails.getProductId()).build())
                .state(StateResourceIdentifier.builder()
                        .key(reviewDetails.getStateKey())
                        .build())
                .build();

        return cdp.createReview(reviewDraft);
    }




    // Get All Reviews
    public ReviewPagedQueryResponse GetAllReview(String limit,String where)
    {
        ReviewPagedQueryResponse reviews = apiRoot
                .reviews()
                .get()
                .withLimit(limit)
              //  .withWhere(where)
                .executeBlocking()
                .getBody();

        return reviews;
    }



    // Get Review By Id
    public Review GetReviewById(String id)
    {
        Review review = apiRoot
                .reviews()
                .withId(id)
                .get()
                .executeBlocking()
                .getBody();

        return review;
    }




    // Delete Review By Id
    public Review deleteReviewById(String id,String version)
    {
        Review review = apiRoot
                .reviews()
                .withId(id)
                .delete(version)
                .executeBlocking()
                .getBody();

        return review;
    }



    // Set transitionState
    public Review setTransitionState(ReviewDetails reviewDetails,String id)
    {
        Review review = apiRoot.reviews().withId(id).get().executeBlocking().getBody();

        ReviewUpdate reviewUpdate = ReviewUpdate
                .builder()
                .version(review.getVersion())
                .actions(ReviewUpdateAction
                        .transitionStateBuilder()
                        .state(StateResourceIdentifier
                                .builder()
                                .key(reviewDetails.getStateKey())
                                .build())
                        .build())
                .build();

        Review updatedReview = apiRoot
                .reviews()
                .withId(review.getId())
                .post(reviewUpdate)
                .executeBlocking()
                .getBody();
        return updatedReview;
    }
}
