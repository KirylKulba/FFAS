package ffas.portfolio.app.business.user;

import ffas.portfolio.app.business.user.dto.UserDto;
import ffas.portfolio.app.business.user.form.CreateUserForm;
import ffas.portfolio.app.business.user.form.UpdateUserForm;
import ffas.portfolio.app.business.user.port.UserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("userFacade")
public class UserFacadeImpl implements UserFacade {

    private final UserPort userPort;

    @Autowired
    public UserFacadeImpl(final UserPort userPort) {
        this.userPort = userPort;
    }

    @Override
    public UserDto save(final CreateUserForm userForm) {
        return userPort.save(userForm);
    }

    @Override
    public UserDto findByUuid(final UUID uuid) {
        return userPort.findByUuid(uuid);
    }

    @Override
    public UserDto update(final UpdateUserForm userForm) {
        return userPort.update(userForm);
    }

    @Override
    public void delete(final UUID uuid) {
        userPort.deleteUser(uuid);
    }
}
