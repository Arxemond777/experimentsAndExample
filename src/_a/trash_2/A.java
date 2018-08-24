package _a.trash_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class A {
    public static void main(String[] args) {
        HardCodeUsersLogin[] deniedUsersLogins = {HardCodeUsersLogin.RF_LOGINS, HardCodeUsersLogin.KZ_LOGINS};

        String collect = Arrays.stream(deniedUsersLogins)
                .flatMap(s -> s.getUsersLoginsList().stream())
                .collect(toList())
                .stream()
//                .map(Object::toString)
                .map(UserLogin::getName)
                .collect(joining(":"));

        System.out.println(collect);
    }

}

enum HardCodeUsersLogin {
    DEFAULT(emptyList()),
    RF_LOGINS(unmodifiableList(Arrays.asList(
            UserLogin.RM_LOGIN_TRAIN_INSPECTOR,
            UserLogin.RM_LOGIN_TRAIN_MONITORING,
            UserLogin.RM_LOGIN_AUTO_INSPECTOR,
            UserLogin.RM_LOGIN_AUTO_MONITORING
    ))),
    KZ_LOGINS(unmodifiableList(Arrays.asList(
            UserLogin.KZ_LOGIN_AUTO_INSPECTOR,
            UserLogin.KZ_LOGIN_AUTO_MONITORING,
            UserLogin.KZ_LOGIN_DEPLUMB
    )));

    private final List<UserLogin> userLogins;

    HardCodeUsersLogin(List<UserLogin> usersList) {
        this.userLogins = usersList;
    }

    public List<UserLogin> getUsersLoginsList() {
        return userLogins;
    }
}

enum UserLogin {
    RM_LOGIN_TRAIN_INSPECTOR("pochta_train_insp"),
    RM_LOGIN_TRAIN_MONITORING("pochta_train_monitoring"),
    RM_LOGIN_AUTO_INSPECTOR("pochta_auto_insp"),
    RM_LOGIN_AUTO_MONITORING("pochta_auto_monitoring"),

    KZ_LOGIN_AUTO_INSPECTOR("kz_auto_insp"),
    KZ_LOGIN_AUTO_MONITORING("kz_auto_monitoring"),
    KZ_LOGIN_DEPLUMB("kz_deplumb");

    private String name;

    UserLogin(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
