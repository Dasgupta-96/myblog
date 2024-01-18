package com.myblog.myblog11.payload;

import com.myblog.myblog11.entity.Registration;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PostRegDto {

  private Registration reg;
  private String message;

    public void setReg(Registration reg) {
        this.reg = reg;
    }

    public Registration getReg() {
        return reg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
