<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
  <link href="main.css" rel="stylesheet">
</head>
<style>
  section{
    padding: 5px;
    position: absolute;
    top: 60%;
    left: 10%
  }
</style>
<body>
<div class="container text-center" >
  <%--        <div class="shadow-lg p-3 mb-5 bg-body rounded">--%>
  <div class="row-align-items-center">
    <div class = "col-9"></div>
    <br><br>
    <h2 class="text-center fw-bold">${question}</h2>
    <br><br>
    <form action="gameServlet" method="get" class="serv">
      <c:forEach items="${answers.keySet()}" var="answer">
        <div class="form-check">
          <label class="form-check-label"><input type="radio" name="id" value="${answers.get(answer)}" checked> ${answer}</label>
        </div>
      </c:forEach>
      <p>

      <div class="d-grid gap-2 col-6 mx-auto">
        <button type="submit" class="btn btn-warning">${answers == null ? "Заново" :"Выбрать"}</button>
      </div>
      </p>
    </form>
  </div>
</div>
<%--        </div>--%>
<section class="info">
  <table class="table">
    <thead>
    <tr class="table-light">
      <th class="text-center" scope="col">Статистика</th>
      <th class="text-center" scope="col">Имя в игре</th>
      <th class="text-center" scope="col">ip address</th>
      <th class="text-center" scope="col">Количество игр</th>
      <th class="text-center" scope="col">Количество побед</th>
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
</section>
</div>
</body>
</html>
