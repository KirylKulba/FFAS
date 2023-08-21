package ffas.portfolio.app.external.controllers;

import ffas.portfolio.app.business.user.UserFacade;
import ffas.portfolio.app.business.user.dto.UserDto;
import ffas.portfolio.app.business.user.form.CreateUserForm;
import ffas.portfolio.app.business.user.form.UpdateUserForm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

import static java.util.Objects.nonNull;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/user")
public class UserController {

    private final UserFacade userFacade;

    public UserController(@Qualifier("userFacade") final UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody final CreateUserForm user){
        return nonNull(userFacade.save(user)) ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value="/{uuid}", method = RequestMethod.GET)
    public ResponseEntity<?> findUser(@PathVariable final UUID uuid){
        final UserDto user = userFacade.findByUuid(uuid);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody final UpdateUserForm userForm) {
        return ResponseEntity.ok(userFacade.update(userForm));
    }

    @RequestMapping(value="/{uuid}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable final UUID uuid) {
        userFacade.delete(uuid);
        return (ResponseEntity<?>) ResponseEntity.ok();
    }
}
