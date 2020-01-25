package com.pomelers.domain.repository;

import java.util.List;
import com.pomelers.domain.entity.Channel;

public interface ChannelRepository {

    List<Channel> findByUserid(Integer userid);
}
