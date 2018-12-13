package com.library.components.model.reviewcomment;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.components.model.bookreview.Review;

public interface ReviewCommentRepository extends JpaRepository<Review,Long> {

}
