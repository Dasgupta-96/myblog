package com.myblog.myblog11.service;

import com.myblog.myblog11.entity.Comment;
import com.myblog.myblog11.entity.Post;
import com.myblog.myblog11.exception.ResourceNotFoundException;
import com.myblog.myblog11.payload.CommentDto;
import com.myblog.myblog11.repository.CommentRepository;
import com.myblog.myblog11.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    CommentRepository commentRepo;
    PostRepository postRepo;
    private ModelMapper modelMapper;

    public CommentService(CommentRepository commentRepo, PostRepository postRepo, ModelMapper modelMapper) {
        this.commentRepo = commentRepo;
        this.postRepo = postRepo;
        this.modelMapper=modelMapper;
    }

    public CommentDto CreateComment(CommentDto commentDto, int id) {

        Post post = postRepo.findById(id).orElseThrow(

                () -> new ResourceNotFoundException("The post is not present in this id: " + id)
        );


        Comment c1 = maptoentity(commentDto);
        c1.setPosts(post);

        Comment save = commentRepo.save(c1);

        CommentDto dto = maptoDto(save);
        return dto;
    }

    public void deleteById(int id) {

        commentRepo.deleteById(id);
    }

    public CommentDto updateComment(CommentDto commentDto, int id, int postId) {

        Post post = postRepo.findById(postId).orElseThrow(

                () -> new ResourceNotFoundException("post is not present in this id " + postId)
        );
        Comment comment = commentRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Comment is not present in this id " + id)

        );
        Comment c1 = maptoentity(commentDto);
        c1.setId(comment.getId());
        c1.setPosts(post);
        Comment savedCommnt = commentRepo.save(c1);

        CommentDto dto = maptoDto(savedCommnt);
return dto;
    }
CommentDto maptoDto(Comment comment){
    CommentDto dto = modelMapper.map(comment, CommentDto.class);

   return dto;

}
Comment maptoentity(CommentDto commentDto){
    Comment comment = modelMapper.map(commentDto, Comment.class);

        return comment;

}


}