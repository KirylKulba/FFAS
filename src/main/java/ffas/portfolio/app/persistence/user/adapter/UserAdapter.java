package ffas.portfolio.app.persistence.user.adapter;

import ffas.portfolio.app.business.common.exceptions.NotFoundException;
import ffas.portfolio.app.business.user.dto.UserDto;
import ffas.portfolio.app.business.user.form.CreateUserForm;
import ffas.portfolio.app.business.user.form.UpdateUserForm;
import ffas.portfolio.app.business.user.port.UserPort;
import ffas.portfolio.app.persistence.user.entity.User;
import ffas.portfolio.app.persistence.user.entity.UserMapper;
import static ffas.portfolio.app.persistence.user.entity.UserMapper.toUser;
import static ffas.portfolio.app.persistence.user.entity.UserMapper.toDto;
import ffas.portfolio.app.persistence.user.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserAdapter implements UserPort {

    private final UserRepository userRepository;

    public UserAdapter(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(final CreateUserForm createUserForm) {
        final User createdUser = userRepository.save(toUser(createUserForm));
        return toDto(createdUser);
    }

    @Override
    public UserDto update(final UpdateUserForm updateUserForm) {
        final User user = userRepository.findUserByUuid(updateUserForm.getUuid())
                .orElseThrow(() -> new NotFoundException("User not found with uuid: " + updateUserForm.getUuid().toString()));
        updateValues(user, updateUserForm);
        final User updatedUser = userRepository.save(user);
        return toDto(updatedUser);
    }

    private void updateValues(final User user, final UpdateUserForm updateUserForm) {
        user.setAge(updateUserForm.getAge());
        user.setSex(updateUserForm.getSex());
        user.setCitizenNumber(updateUserForm.getCitizenNumber());
    }

    @Override
    public UserDto findByUuid(final UUID uuid) {
        return userRepository.findUserByUuid(uuid)
                .map(UserMapper::toDto)
                .orElseThrow(() -> new NotFoundException("User not found with uuid: " + uuid.toString()));
    }

    @Override
    public void deleteUser(final UUID uuid) {
        final User user = userRepository.findUserByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("User not found with uuid: " + uuid.toString()));
        userRepository.delete(user);
    }
}
