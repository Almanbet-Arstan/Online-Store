package com.example.onlinestore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage<T> {
    private T value;

    private String status;

    private String message;

    public ResponseMessage<T> prepareSuccessMessage(T value){
        return ResponseMessage.<T>builder()
                .value(value)
                .message(null)
                .status("OK")
                .build();
    }

    public ResponseMessage<T> prepareFailMessage(T value){
        return ResponseMessage.<T>builder()
                .value(value)
                .message(null)
                .status("FAIL")
                .build();
    }

    public ResponseMessage<T> prepareErrorMessage(T value){
        return ResponseMessage.<T>builder()
                .value(value)
                .message(null)
                .status("ERROR")
                .build();
    }
}
