package exercise.controller;

import java.util.Collections;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import lombok.extern.java.Log;

public class SessionsController {

    // BEGIN
    public static void show(Context ctx) {
        var name = ctx.sessionAttribute("currentUser");
        var page = new MainPage(name);
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }
    public static void create(Context ctx) throws Exception {
        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(UsersRepository::existsByName, "Wrong username or password")
                    .get();
            var passwordHash = Security.encrypt(ctx.formParam("password"));
            var user = UsersRepository.findByName(name);
            if (user != null && user.getPassword().equals(passwordHash)) {
                ctx.sessionAttribute("currentUser", name);
                ctx.redirect("/");
            } else throw new NotFoundResponse("Wrong username or password");
        } catch (NotFoundResponse e) {
            var name = ctx.formParam("name");
            var page = new LoginPage(name, e.getMessage());
            ctx.render("build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void build(Context ctx) {
        var page = new LoginPage(null, null);
        ctx.render("build.jte", Collections.singletonMap("page", page));
        ctx.redirect("/");
    }

    public static void delete(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
        var page = new MainPage(ctx.sessionAttribute("name"));
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }
    // END
}
