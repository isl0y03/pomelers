package com.pomelers.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pomelers.domain.entity.Channel;
import com.pomelers.domain.repository.ChannelRepository;

@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    @Override
    public List<Channel> findUserChannels(final Integer userid) {
        return this.channelRepository.findByUserid(userid);
    }

}
