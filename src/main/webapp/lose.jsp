<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <meta content="text/html; charset=utf-8" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</head>
<body>
<div class="container text-center" >
    <div class="row-align-items-center">
        <br><br>
        <h1 class="text-center fw-bold"><%= "Defeat" %></h1>
        <p class="text-center" >
            Dear ${name}. Unfortunately, you were unable to complete the task.
            Sauron got the ring.
        </p>
        <form action="index.jsp" method="post">
            <div class="d-grid gap-2 col-6 mx-auto">
                <button type="submit" class="btn btn-primary btn btn-danger">Заново</button>
            </div>
        </form>
    </div>
    <br><br>
    <br><br>
    <div class="text-center gap-2 col-5 mx-auto">
        <img class="w-100 img-thumbnail" srcset="img\lose.jpg" alt="ring">
    </div>
</div>
<br><br>
<br><br>
<table class="table table-hover">
    <thead>
    <tr class="table-light">
        <th class="text-center" scope="col">Statistics</th>
        <th class="text-center" scope="col">Name</th>
        <th class="text-center" scope="col">ip address</th>
        <th class="text-center" scope="col">Number of games played</th>
        <th class="text-center" scope="col">Number of wins</th>
    </tr>
    </thead>
    <tbody class="table-group-divider table-info">
    <tr class="table-info">
        <th scope="row" class="text-center">#</th>
        <td class="text-center">${name}</td>
        <td class="text-center">${sessionIp}</td>
        <td class="text-center">${counter}</td>
        <td class="text-center">${winCounter}</td>
    </tr>
    </tbody>
</table>
</body>
</html>
