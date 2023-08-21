package ffas.portfolio.app.business.user.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class UpdateUserForm{
    private UUID uuid;
    private String citizenNumber;
    private String sex;
    private Integer age;
}
