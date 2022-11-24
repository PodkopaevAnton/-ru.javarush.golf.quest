<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Beginning</title>
    <meta content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <link href="main.css" rel="stylesheet">

</head>
<body>
<div class="container text-center" >
    <div class="row-align-items-center">
        <br><br>
        <h1 class="text-center fw-bold"><%= "Prologue" %>
        </h1>
        <p class="text-center" >In the Hobbitania, things went on as usual. The people there lived cheerful and quick-witted.
            Different holidays were a special delight for them. Today is one of those! Came to this event
            your old friend. A tall old man with a big hat and staff. The feast was for the whole world, and in the heat you lost your uncle!
        </p>
        <h1 class="text-center fw-bold"><%= "Interesting find"%></h1>
        <p class="text-center">You quickly ran home, expecting to find him there. When you opened the door, you found an unusual ring on the floor.</p>

        <p class="text-center fst-italic fs-4">Enter your name and choose a ring</p>
        <br><br>
        <form action="gameServlet" method="get">
            <input hidden name="id" value="1">
            <div class="d-grid gap-2 col-6 mx-auto">
                <label for="input_name_new" >Имя:</label>
                <input type="text" id="input_name_new" name="name" required size ="12" maxLength="12" class="shadow-sm p-3 mb-5 bg-body rounded">
                <button  type="submit" class="btn btn-warning ">Pick up</button>
            </div>
        </form>
        <br><br>

        <img class="img-thumbnail" srcset="img\begin.jpg" alt="ring">

    </div>
</div>

<div class="container">
    <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
        <div class="col-md-4 d-flex align-items-center">
            <span class="mb-3 mb-md-0 text-muted"></span>
        </div>
    </footer>
</div>
</body>
</html>