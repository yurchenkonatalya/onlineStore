package by.bsuir.constant.ref;

import by.bsuir.entity.domain.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum UserRoleRef {
    USER(1, "ROLE_USER"),
    ADMIN(2, "ROLE_ADMIN");

    private Integer id;
    private String name;

    public static List<UserRole> getAll(){
        return Arrays.stream(UserRoleRef.values())
                .map(userRoleRef -> UserRole.builder()
                        .roleId(userRoleRef.getId())
                        .roleName(userRoleRef.getName())
                        .build()).collect(Collectors.toList());
    }
}
