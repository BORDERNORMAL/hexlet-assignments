package exercise;

import io.javalin.Javalin;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import java.util.Collections;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            ctx.json(USERS);
        });

        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var found = false;

            for (var user : USERS) {
                if (Long.toString(user.getID()).equals(id)) {
                    ctx.json(user);
                    found = true;
                }
            };

            if (!found) {
                throw new NotFoundResponse("User not found");
            }
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
