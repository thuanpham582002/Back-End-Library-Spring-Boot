package dev.noroom.thuvien.model.dto;

import dev.noroom.thuvien.model.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    Long id;
    String username;
    String email;
    String role;

    public static UserDto fromUser(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    public static User toUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .role(userDto.getRole())
                .build();
    }
}
