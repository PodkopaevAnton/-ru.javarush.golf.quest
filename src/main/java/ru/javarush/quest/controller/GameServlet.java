package ru.javarush.quest.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.javarush.quest.entity.Quest;
import ru.javarush.quest.repository.AnswerRepository;
import ru.javarush.quest.repository.QuestionRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.Map;

@WebServlet(name = "gameServlet", value = "/gameServlet")
public class GameServlet extends HttpServlet {

    private GameService gameService;
    private AnswerRepository answerRepository;
    private QuestionRepository questionRepository;
    private static final  Logger log = LogManager.getLogger(GameServlet.class);


    @Override
    public void init() {
        gameService = new GameService();
        Quest quest = new Quest();
        answerRepository = new AnswerRepository(quest.getAnswers());
        questionRepository = new QuestionRepository(quest.getQuestions());
        log.info("Method init. Create Repositories and Quest");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.info("method doGet");
        HttpSession session = request.getSession();
        Integer counter = (Integer)session.getAttribute("counter");
        Integer winCounter = (Integer)session.getAttribute("winCounter");
        String name = request.getParameter("name");

        if(counter == null){
            log.debug("Game counter is null");
            session.setAttribute("counter", 0);
            session.setAttribute("winCounter", 0);
        }

        if(name != null) {
            session.setAttribute("name", name);
            log.debug("name isn't null");
        }

        session.setAttribute("ip", Inet4Address.getLocalHost().getHostAddress());
        String ip = (String) session.getAttribute("ip");

        String id = request.getParameter("id");
        if (gameService.checkLose(id)) {
            session.setAttribute("counter", counter + 1);
            request.setAttribute("sessionIp",ip);
            log.info("answer is wrong");
            request.getRequestDispatcher("lose.jsp").forward(request, response);

        }else if(gameService.checkWin(id)){
            session.setAttribute("winCounter", winCounter + 1);
            session.setAttribute("counter", counter + 1);
            log.info("You win");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }else{
            int intId = Integer.parseInt(id);
            log.info("Next question");
            String question = gameService.getQuestionById(questionRepository,intId);
            log.debug("Get question by id");
            Map<String, Integer> answers = gameService.getAnswersById(answerRepository,intId);
            log.debug("Get answers by id");
            request.setAttribute("question", question);
            request.setAttribute("answers", answers);
            request.setAttribute("name", name);
            request.setAttribute("sessionIp",ip);
            request.getRequestDispatcher("quest.jsp").forward(request, response);
        }
    }
}
