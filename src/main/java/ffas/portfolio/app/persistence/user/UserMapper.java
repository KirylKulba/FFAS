package ffas.portfolio.app.persistence.user;

import ffas.portfolio.app.business.user.dto.UserDto;
import ffas.portfolio.app.business.user.form.CreateUserForm;

class UserMapper {

    static UserDto toDto(final User user) {
        final UserDto dto = new UserDto();
        dto.setUuid(user.getUuid());
        dto.setCitizenNumber(user.getCitizenNumber());
        dto.setAge(user.getAge());
        dto.setSex(user.getSex().name());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());
        return dto;
    }

    static User toUser(final CreateUserForm form) {
        final User newUser = new User();
        newUser.setCitizenNumber(form.getCitizenNumber());
        newUser.setAge(form.getAge());
        newUser.setSex(User.Sex.valueOf(form.getSex()));
        return newUser;
    }
}
