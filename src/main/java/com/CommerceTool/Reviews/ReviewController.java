package com.CommerceTool.Reviews;

import com.commercetools.api.models.review.Review;
import com.commercetools.api.models.review.ReviewPagedQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;


    //Create Review
    @PostMapping
    public Review createReview(@RequestBody ReviewDetails reviewDetails)
    {
        return reviewService.createReview(reviewDetails);
    }



    // Get All Reviews
    @GetMapping
    public ReviewPagedQueryResponse getAllReviews(@RequestParam(defaultValue ="100",required = false) String limit,@RequestParam(required = false) String where)
    {
        return reviewService.GetAllReview(limit,where);
    }



    // Get Review By Id
//    @GetMapping("/{reviewId}")
//    public Review getReviewById()




    // Delete Review By Id
    @DeleteMapping("/{reviewId}")
    public Review deleteReviewById(@PathVariable String reviewId,@RequestParam(required = false) String version )
    {
        return reviewService.deleteReviewById(reviewId,version);
    }

    // Set TransitionState
    @PostMapping("/set-transitionState/{reviewId}")
    public Review setTransitionState(@RequestBody ReviewDetails reviewDetails, @PathVariable String reviewId)
    {

        return reviewService.setTransitionState(reviewDetails,reviewId);

    }
}
