package edu.zipcloud.cloudstreetmarket.core.user.service;

import java.util.List;

import edu.zipcloud.cloudstreetmarket.core.user.dto.UserActivityDTO;

public interface ICommunityService {
    List<UserActivityDTO> getLastUserPublicActivity(int number);
}
