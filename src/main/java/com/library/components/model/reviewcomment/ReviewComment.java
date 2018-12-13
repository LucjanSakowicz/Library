package com.library.components.model.reviewcomment;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.library.components.model.bookreview.Review;
import com.library.components.model.user.User;
import com.library.components.model.vote.Vote;

import lombok.Data;
@Entity
@Data
public class ReviewComment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String shortDescription;
	private String text;
	@ManyToOne
	@JoinColumn(name="review_id")
	private Review review;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@OneToMany(mappedBy="reviewComment")
	private List<Vote> votes=new ArrayList<>();
}
