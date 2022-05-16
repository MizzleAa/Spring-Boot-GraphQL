package com.sample.payload.request;

import lombok.Data;

@Data
public class UpdateUser {
    public String beforeEmail;
    public String newEmail;

}
