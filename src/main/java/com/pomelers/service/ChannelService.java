package com.pomelers.service;

import java.util.List;
import com.pomelers.domain.entity.Channel;

public interface ChannelService {

    List<Channel> findUserChannels(Integer userid);
}
