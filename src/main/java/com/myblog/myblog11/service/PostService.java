package com.myblog.myblog11.service;

import com.myblog.myblog11.entity.Post;
import com.myblog.myblog11.exception.ResourceNotFoundException;
import com.myblog.myblog11.payload.PostDto;
import com.myblog.myblog11.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private PostRepository postRepo;

    public PostService(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    public PostDto createPost(PostDto postDto) {

        Post post = mapToEntity(postDto);

        Post savedPost = postRepo.save(post);

        PostDto dto = mapToDto(savedPost);

        return dto;


    }

    public PostDto getDataById(int id) {

        Post post = postRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("The post is not present in this id " + id)

        );
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setContent(post.getContent());
        post.setTitle(post.getTitle());
        post.setDescription(post.getDescription());

        return dto;
    }

    public void deleteData(int id) {

        postRepo.deleteById(id);
    }

    public List<PostDto>  getAllData(){

        List<Post> posts = postRepo.findAll();
        List<PostDto> dtos = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        return dtos;
    }
  PostDto mapToDto(Post post){

      PostDto dto = new PostDto();
dto.setId(post.getId());
      dto.setContent(post.getContent());
      dto.setTitle(post.getTitle());
      dto.setDescription(post.getDescription());

      return  dto;
  }

    Post mapToEntity(PostDto postDto){

        Post post = new Post();
post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        return post;
    }

    public List<PostDto> pagination(int pageNo, int pageSize){

        PageRequest pageable = PageRequest.of(pageNo, pageSize);
        Page<Post> posts = postRepo.findAll(pageable);
        List<Post> post = posts.getContent();

        List<PostDto> dto = post.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        return dto;

    }
// public List<Post> getData(){
//
//     List<Post> result = postRepo.findAll();
//     return result;
// }
}