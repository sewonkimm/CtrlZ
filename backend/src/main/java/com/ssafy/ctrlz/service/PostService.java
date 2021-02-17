package com.ssafy.ctrlz.service;

import java.util.List;
import com.ssafy.ctrlz.model.Post;

public interface PostService {

	public Post createPost(Post post);

	public List<Post> findAll();

	public Post findByPost(long postId);

	public List<Post> findByChallenge(String challengeId);

	public List<Post> findByUser(Long userId);

	public List<Post> findByUserAndMission(Long userId, String missionId);

	public List<Post> findByUserAndChallenge(Long userId, String challengeId);

	public long countAll();

}
