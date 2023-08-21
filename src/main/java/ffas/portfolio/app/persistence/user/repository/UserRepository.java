package ffas.portfolio.app.persistence.user.repository;

import ffas.portfolio.app.persistence.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByUuid(final UUID uuid);
}
