<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Beginning</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <link href="main.css" rel="stylesheet">

</head>
<body>
<div class="container text-center" >
    <div class="row-align-items-center">
        <br><br>
        <h1 class="text-center fw-bold"><%= "Пролог" %>
        </h1>
        <p class="text-center" >В Хоббитании дела шли своим чередом. Люди там жили веселые и отходчивые.
            Разные праздники были для них особой усладой. Сегодня как раз один из таких! На такое событие приехал
            ваш старый знакомый. Высокий старик с большой шляпой и посохом. Пир был на весь мир,и в пылу ты потерял своего дядю!
        </p>
        <h1 class="text-center fw-bold"><%= "Интересная находка"%></h1>
        <p class="text-center">Ты быстро побежал домой. Открыв дверь, ты обнаружил на полу необычное колечко.</p>

        <p class="text-center fst-italic fs-4">Введи свое имя и подбери кольцо</p>
        <br><br>
        <form action="gameServlet" method="get">
            <input hidden name="id" value="1">
            <div class="d-grid gap-2 col-6 mx-auto">
                <label for="input_name_new" >Имя:</label>
                <input type="text" id="input_name_new" name="name" required size ="12" maxLength="12" class="shadow-sm p-3 mb-5 bg-body rounded">
                <button  type="submit" class="btn btn-warning ">Подобрать</button>
            </div>
        </form>
        <br><br>
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