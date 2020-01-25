package com.pomelers.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.pomelers.domain.entity.Channel;
import com.pomelers.service.ChannelService;

@Controller
public class HomeController {

    @Autowired
    private ChannelService channelService;

    @GetMapping("/{userid}")
    public String home(@PathVariable final String userid, final Model model) {
        final List<Channel> channels = this.channelService.findUserChannels(Integer.valueOf(userid));
        model.addAttribute("channels", channels);
        return "home";
    }

}
