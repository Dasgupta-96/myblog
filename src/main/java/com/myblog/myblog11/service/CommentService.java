package com.myblog.myblog11.service;

import com.myblog.myblog11.entity.Comment;
import com.myblog.myblog11.entity.Post;
import com.myblog.myblog11.exception.ResourceNotFoundException;
import com.myblog.myblog11.payload.CommentDto;
import com.myblog.myblog11.repository.CommentRepository;
import com.myblog.myblog11.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    CommentRepository commentRepo;
    PostRepository postRepo;

    public CommentService(CommentRepository commentRepo,  PostRepository postRepo) {
        this.commentRepo = commentRepo;
        this.postRepo= postRepo;
    }

    public CommentDto CreateComment(CommentDto commentDto, int id){

        Post post = postRepo.findById(id).orElseThrow(

                () -> new ResourceNotFoundException("The post is not present in this id: " + id)
        );

        Comment c1 = new Comment();
        c1.setId(commentDto.getId());
        c1.setText(commentDto.getText());
        c1.setEmail(commentDto.getEmail());
        c1.setPosts(post);

        Comment save = commentRepo.save(c1);
        CommentDto dto = new CommentDto();
     dto.setId(save.getId());
     dto.setEmail(save.getEmail());
     dto.setText(save.getText());

     return dto;
    }

}
