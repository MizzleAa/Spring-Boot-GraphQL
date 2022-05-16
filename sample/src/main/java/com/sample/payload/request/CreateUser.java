package com.sample.payload.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUser {
    
    public String email;
    public String password;

}
