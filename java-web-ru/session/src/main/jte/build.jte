@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

@template.layout.page(
content = @`
    @if(page.getError() != null)
        <div>
            ${page.getError()}
        </div>
    @endif

    <form action="${NamedRoutes.buildSessionPath()}" method="post">
        <label>
            Name
            <input type="text" placeholder="Name" name="name" value="${page.getName()}">
        </label>
        <label>
            Password
            <input type="password" placeholder="Password" name="password" />
        </label>
        <label>
            Submit
            <input type="submit" />
        </label>
    </form>
`
)