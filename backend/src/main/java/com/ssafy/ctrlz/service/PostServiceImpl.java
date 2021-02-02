package com.ssafy.ctrlz.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ssafy.ctrlz.model.Post;
import com.ssafy.ctrlz.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void createPost(Long postId,Long userId, String challengeId,String postContent, MultipartFile postImage) {
		Post post = new Post();
		String UPLOAD_PATH = "C:\\Users\\multicampus\\fileupload\\src\\assets\\post";
		UUID uuid = UUID.randomUUID();
		String saveName = uuid+"_"+postImage.getOriginalFilename();

		File saveFile = new File(UPLOAD_PATH, saveName);
        
		try {
			postImage.transferTo(saveFile);
//            saveName = "http://i4a202.p.ssafy.io/postimg/" + saveName;
        } catch (IOException e) {
            e.printStackTrace();
        }
		post.setPostId(postId);
		post.setUserId(userId);
		post.setChallengeId(challengeId);
		post.setPostContent(postContent);
		post.setPostImage(saveName);
		postRepository.save(post);
		
	}

	@Override
	public List<Post> selectPost(Post post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPost(long postId) {
		// TODO Auto-generated method stub
		return null;
	}
}