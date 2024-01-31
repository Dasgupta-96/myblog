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

}
