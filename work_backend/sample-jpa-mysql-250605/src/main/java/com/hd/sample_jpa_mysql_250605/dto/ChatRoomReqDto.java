package com.hd.sample_jpa_mysql_250605.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ChatRoomReqDto { // 채팅방 생성 요청 시 전달되는 데이터
    private String name;
}