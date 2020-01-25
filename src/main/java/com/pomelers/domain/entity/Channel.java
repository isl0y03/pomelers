package com.pomelers.domain.entity;

import com.pomelers.domain.kbn.Visibility;
import lombok.Getter;
import lombok.Setter;

public class Channel {

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Visibility visibility;
}
