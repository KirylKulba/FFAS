package ffas.portfolio.app.business.user;

import ffas.portfolio.app.business.user.dto.UserDto;
import ffas.portfolio.app.business.user.form.CreateUserForm;
import ffas.portfolio.app.business.user.form.UpdateUserForm;

import java.util.UUID;

public interface UserFacade {
    UserDto findByUuid(final UUID uuid);
    UserDto save(final CreateUserForm userForm);
    UserDto update(final UpdateUserForm userForm);
    void delete(final UUID id);
}
