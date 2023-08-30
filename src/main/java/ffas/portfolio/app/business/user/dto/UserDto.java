package ffas.portfolio.app.business.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private UUID uuid;
    private String citizenNumber;
    private String sex;
    private Integer age;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
