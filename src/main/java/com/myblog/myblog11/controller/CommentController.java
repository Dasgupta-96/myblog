package com.myblog.myblog11.controller;

import com.myblog.myblog11.entity.Comment;
import com.myblog.myblog11.payload.CommentDto;
import com.myblog.myblog11.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService ser;

    public CommentController(CommentService ser) {
        this.ser = ser;
    }

    // http://localhost:8080/api/comments?id=1
    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @RequestParam("id") int id){

        CommentDto dto = ser.CreateComment(commentDto, id);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
  // http://localhost:8080/api/comments/2
public ResponseEntity<?> deleteComment(@PathVariable int id){

        ser.deleteById(id);

        return new ResponseEntity<>("The comment is deleted!!", HttpStatus.OK);
}

@PutMapping("/{id}/post/{postId}")
// http://localhost:8080/api/comments/1/post/1
public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto,@PathVariable int id, @PathVariable int postId){

    CommentDto dto = ser.updateComment(commentDto, id, postId);

    return new ResponseEntity<>(dto,HttpStatus.OK);
}

}
