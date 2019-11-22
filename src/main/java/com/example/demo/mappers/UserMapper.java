package com.example.demo.mappers;

import com.example.demo.dto.UserDTO;
import com.example.demo.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends DomainToDtoMapper<User, UserDTO> {

    @Override
    public UserDTO toDTO(User domain) {
        UserDTO dto = new UserDTO();
        dto.setId(domain.getId());
        dto.setMatchStatus("NOT IMPLEMENTED YET, DAVE");
        dto.setUsername(domain.getUsername());
        return dto;
    }

    @Override
    public User toDomain(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setId(dto.getId());
        return user;
    }
}
