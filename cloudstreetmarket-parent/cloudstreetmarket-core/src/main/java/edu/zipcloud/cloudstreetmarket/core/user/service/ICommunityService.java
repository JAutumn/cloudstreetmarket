package edu.zipcloud.cloudstreetmarket.core.user.service;

import edu.zipcloud.cloudstreetmarket.core.user.dto.UserActivityDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICommunityService {
    Page<UserActivityDTO> getPublicActivity(Pageable pageable);
}
