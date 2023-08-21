package ffas.portfolio.app.persistence.user.entity;

import ffas.portfolio.app.business.user.dto.UserDto;
import ffas.portfolio.app.business.user.form.CreateUserForm;

public class UserMapper {

    public static UserDto toDto(final User user) {
        final UserDto dto = new UserDto();
        dto.setUuid(user.getUuid());
        dto.setCitizenNumber(user.getCitizenNumber());
        dto.setAge(user.getAge());
        dto.setSex(user.getSex());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());
        return dto;
    }

    public static User toUser(final UserDto user) {
        final User newUser = new User();
        newUser.setUuid(user.getUuid());
        newUser.setCitizenNumber(user.getCitizenNumber());
        newUser.setAge(user.getAge());
        newUser.setSex(user.getSex());
        newUser.setCreatedAt(user.getCreatedAt());
        newUser.setUpdatedAt(user.getUpdatedAt());
        return newUser;
    }

    public static User toUser(final CreateUserForm form) {
        final User newUser = new User();
        newUser.setCitizenNumber(form.getCitizenNumber());
        newUser.setAge(form.getAge());
        newUser.setSex(form.getSex());
        return newUser;
    }
}
