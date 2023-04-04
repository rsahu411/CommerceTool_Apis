package com.CommerceTool.Channels;

import com.CommerceTool.DataProvider.DataProvider;
//import com.commercetools.api.models.channel;
import com.commercetools.api.models.channel.ChannelDraft;
import com.commercetools.api.models.channel.ChannelRoleEnum;
import com.commercetools.api.models.common.LocalizedString;
import org.springframework.beans.factory.annotation.Autowired;

public class Channel {

    @Autowired
    private DataProvider cdp;

    public Channel createChannel(ChannelDetails channelDetails)
    {
        ChannelDraft channel = ChannelDraft
                .builder()
                .key(channelDetails.getKey())
                .roles(ChannelRoleEnum.findEnum(channelDetails.getRole()))
                .name(LocalizedString.ofEnglish(channelDetails.getName()))
                .description(LocalizedString.ofEnglish(channelDetails.getDescription()))
                .build();

        return  null;

    }



}
