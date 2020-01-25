package com.pomelers.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.pomelers.domain.entity.Channel;

@Mapper
public interface ChannelMapper {

    List<Channel> findByUserid(Integer userid);

}
