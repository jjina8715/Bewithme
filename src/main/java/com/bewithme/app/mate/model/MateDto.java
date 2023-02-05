package com.bewithme.app.mate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class MateDto {
    private Long id;
    private String nickname;
    private String stat;

    @JsonIgnore Mate requester;
    @JsonIgnore Mate requestee;
    @Getter
    @AllArgsConstructor
    public static class Mate {
        private Long id;
        private String nickname;
    }

}
