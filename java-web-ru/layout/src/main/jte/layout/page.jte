<!-- BEGIN -->
@import gg.jte.Content
@param Content content

<!DOCTYPE html>
<html lang = "en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Sample Page with Layouts</title>
</head>
<body>
<header>
    <a href="/">Home</a>
    <a href="/users">Users</a>
</header>
<main>
    ${content}
</main>
<footer>
    <p>Nothing here</p>
</footer>
</body>
</html>
<!-- END -->
