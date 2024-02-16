package com.myblog.myblog11.controller;

import com.myblog.myblog11.entity.Post;
import com.myblog.myblog11.payload.PostDto;
import com.myblog.myblog11.service.PostService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService ser;

    public PostController(PostService ser) {
        this.ser = ser;
    }

    // http://localhost:8080/api/posts

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){

        PostDto dto = ser.createPost(postDto);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

  //  http://localhost:8080/api/posts/particular?id=1
    @GetMapping("/particular")
    public ResponseEntity<PostDto> getData(@RequestParam("id") int id){

        PostDto dto = ser.getDataById(id);

        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
public ResponseEntity<?> deletePost(@PathVariable int id){

        ser.deleteData(id);

        return new ResponseEntity<>("The post is deleted in this id "+id, HttpStatus.OK);

}
// http://localhost:8080/api/posts
@GetMapping
public  List<PostDto> getAllData(){

    List<PostDto> dto = ser.getAllData();

   return dto;

}
//    public ResponseEntity<?> getAll(){
//
//    List<Post> data = ser.getData();
//
//    return new ResponseEntity<>(data, HttpStatus.OK);
//}

    @GetMapping("/pagination")
    // http://localhost:8080/api/posts/pagination?pageNo=0&pageSize=2&sortBy=title
    public List<PostDto> pagination(

     @RequestParam(name="pageNo", required = false, defaultValue = "0") int pageNo,
     @RequestParam(name="pageSize", required = false, defaultValue = "2") int pageSize,
     @RequestParam(name="sortBy",required = false,defaultValue = "id") String sortBy

    ){
        List<PostDto> dtos = ser.pagination(pageNo, pageSize,sortBy);
        return dtos;


    }


}
