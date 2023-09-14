package com.sparta.springtestweek3.dto;

import lombok.Getter;

@Getter
public class StatusResponseDto {
    private String msg;

    public StatusResponseDto(String msg){
        this.msg = msg;
    }
}
