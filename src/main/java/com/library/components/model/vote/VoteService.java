package com.library.components.model.vote;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class VoteService {

	private VoteRepository voteRepository;
	private VoteMapper voteMapper;
	
	public VoteService(VoteRepository voteRepository, VoteMapper voteMapper) {
		this.voteRepository=voteRepository;
		this.voteMapper=voteMapper;
	}
	
	public Optional<VoteDto> getVoteById(Long i) {
		return voteRepository.findById(i).map(voteMapper::toDto);
	}

}
