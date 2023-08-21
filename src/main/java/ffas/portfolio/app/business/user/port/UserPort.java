package ffas.portfolio.app.business.user.port;

import ffas.portfolio.app.business.user.dto.UserDto;
import ffas.portfolio.app.business.user.form.CreateUserForm;
import ffas.portfolio.app.business.user.form.UpdateUserForm;

import java.util.UUID;

public interface UserPort {
    UserDto save(final CreateUserForm createUserForm);
    UserDto update(final UpdateUserForm updateUserForm);
    UserDto findByUuid(final UUID uuid);
    void deleteUser(final UUID uuid);
}
