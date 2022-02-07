package by.bsuir.constant.ref;

import by.bsuir.entity.domain.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum UserStatusRef {
    NON_ACTIVE(1, "NON_ACTIVE"),
    ACTIVE(2, "ACTIVE"),
    BANNED(3, "BANNED");

    private Integer id;
    private String name;

    public static List<UserStatus> getAll(){
        return Arrays.stream(UserStatusRef.values())
                .map(userStatusRef -> UserStatus.builder()
                        .statusId(userStatusRef.getId())
                        .statusName(userStatusRef.getName())
                        .build()).collect(Collectors.toList());
    }

}
