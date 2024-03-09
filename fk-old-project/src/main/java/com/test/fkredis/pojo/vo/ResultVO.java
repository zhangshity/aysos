package com.test.fkredis.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResultVO<T> {

    private T response;
}
