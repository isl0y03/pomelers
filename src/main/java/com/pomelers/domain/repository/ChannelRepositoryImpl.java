package com.pomelers.domain.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.pomelers.domain.entity.Channel;
import com.pomelers.mapper.ChannelMapper;

@Repository
public class ChannelRepositoryImpl implements ChannelRepository {

    @Autowired
    private ChannelMapper channelMapper;

    @Override
    public List<Channel> findByUserid(final Integer userid) {
        return this.channelMapper.findByUserid(userid);
    }

}
