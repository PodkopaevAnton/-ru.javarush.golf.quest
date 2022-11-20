package ru.javarush.quest.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.Map;

@WebServlet(name = "gameServlet", value = "/gameServlet")
public class GameServlet extends HttpServlet {

    private GameService gameService;

    @Override
    public void init() {
        gameService = new GameService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        Integer counter = (Integer)session.getAttribute("counter");
        Integer winCounter = (Integer)session.getAttribute("winCounter");
        String name = request.getParameter("name");
        if(counter == null){
            session.setAttribute("counter", 1);
            session.setAttribute("winCounter", 0);
            counter = 1;
            winCounter=0;
        }

        if(name != null) {
            session.setAttribute("name", name);
        }

        session.setAttribute("ip", Inet4Address.getLocalHost().getHostAddress());
        String ip = (String) session.getAttribute("ip");
        String sessionId = session.getId();

        String id = request.getParameter("id");
        if (gameService.checkLose(id)) {
            session.setAttribute("counter", counter + 1);
            request.getRequestDispatcher("lose.jsp").forward(request, response);
        }else if(gameService.checkWin(id)){
            session.setAttribute("winCounter", winCounter + 1);
            session.setAttribute("counter", counter + 1);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
            int intId = Integer.parseInt(id);
            String question = gameService.getQuestionById(intId);
            Map<String, Integer> answers = gameService.getAnswersById(intId);
            request.setAttribute("question", question);
            request.setAttribute("answers", answers);
            request.setAttribute("name", name);
            request.setAttribute("sessionIp",ip);
            request.setAttribute("sessionId",sessionId);

            request.getRequestDispatcher("quest.jsp").forward(request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    public void destroy() {
    }
}
