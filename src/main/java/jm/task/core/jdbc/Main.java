package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        for (int i = 1; i <= 4; i++) {
            userService.saveUser("name" + i, "lastname" + i, (byte) i);
            System.out.println("Пользователь с именем - name" + i + " добавлен в базу данных");
        }

        List<User> users = userService.getAllUsers();

        for (User user: users) {
            System.out.println(user.toString());
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
