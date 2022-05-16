package com.sample.payload.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteUser {
    public String email;
}
