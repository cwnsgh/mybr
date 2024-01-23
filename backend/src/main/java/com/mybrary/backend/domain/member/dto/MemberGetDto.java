package com.mybrary.backend.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberGetDto {

    private Long memberId;
    private String name;
    private String nickname;
    private String intro;
    private String profileImageUrl;
    private boolean isProfilePublic;
    private boolean isNotifyEnabled;

}
