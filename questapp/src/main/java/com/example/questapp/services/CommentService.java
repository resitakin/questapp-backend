package com.example.questapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.example.questapp.Respository.CommentRepository;
import com.example.questapp.entities.Comment;
import com.example.questapp.entities.Post;
import com.example.questapp.entities.User;
import com.example.questapp.requests.CommentCreateRequest;
import com.example.questapp.requests.UpdateCommentRequest;

@Service
public class CommentService {
	
	private CommentRepository commentRepository;
	private PostService postService;
	private UserService userService;
	
	
	public CommentService(CommentRepository commentRepository, PostService postService, UserService userService) {
		this.commentRepository = commentRepository;
		this.postService = postService;
		this.userService = userService;
	}


	public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
		if(postId.isPresent() && userId.isPresent()) {
			
			return commentRepository.findByUserIdAndPostId(userId.get(),postId.get());
		}
		else if(userId.isPresent()) {
			
			return commentRepository.findByPostId(userId.get()); 
		}
		else if(postId.isPresent()) {
			
			return commentRepository.findByUserId(postId.get());
		}
		
		else 
		
		return commentRepository.findAll();
		
			
		
		
		
	}


	public Comment getOneCommentById(Long commentId) {
		
		return commentRepository.findById(commentId).orElse(null);
	}


	public Comment createOneComment(CommentCreateRequest request) {
		
		User user = userService.getOneUserById(request.getUserId());
		Post post = postService.getOnePostById(request.getPosId());
		
		if(user != null && post !=null) {
			 Comment commentToSave=new Comment();
			 commentToSave.setId(request.getId());
			 commentToSave.setUser(user);
			 commentToSave.setPost(post);
			 commentToSave.setText(request.getText());
			 
			 return commentRepository.save(commentToSave);
			
		}
		else
		
			return null;
	}


	public Comment updateOneCommentById(Long commentId, UpdateCommentRequest request) {
		
		Optional<Comment> comment=commentRepository.findById(commentId);
		if(comment.isPresent()) {
			
			Comment commentToUpdate=comment.get();
			commentToUpdate.setText(request.getText());
			commentRepository.save(commentToUpdate);
		}
		
			
			return null;
		
		
		}


	public void deleteOneCommentById(Long commentId) {
		
		
		commentRepository.deleteById(commentId);
	}









	}




	 
	

