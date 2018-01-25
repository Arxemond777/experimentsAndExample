package ch_15_web_programmin_server_side.asyncExample;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@WebServlet(
        urlPatterns = {"/bgwait", "/abc"},
        asyncSupported = true
)
public class BackgroundWaitServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final AsyncContext asyncContext = request.startAsync();

        ScheduledExecutorService executor = (ScheduledExecutorService)request
                .getServletContext()
                .getAttribute("BackgroundWaitExecutor");//Из контекста сервлета передается версия Runnable (755 стр)
        executor.schedule(new RespondLaterJob(asyncContext), 5, TimeUnit.SECONDS);

    }

    class RespondLaterJob implements Runnable
    {
        private AsyncContext asyncContext;
        RespondLaterJob(AsyncContext asyncContext) {
            this.asyncContext = asyncContext;
        }

        @Override
        public void run() {
            try {
                ServletResponse response = asyncContext.getResponse();
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<html><body><h1>Response servlet WaitServlet in: " + new Date().toString() + "</h1></body></html>");
            } catch (IOException e) {
                e.printStackTrace();
            }

            /**
             * 0) Не обязательно сразу вызывать .complete();
             *      Мы могли бы записать часть результата и вернуться в спящий режим и ожидать,
             *      когда наш сервеис разбудит нас и предоставит новые данные.
             *      Именно так и стоит работать с источниками информации NIO
             * 1) Вместо .complete() можно использовать
             *      .dispatch() - без аргументов передает начальному обработчику
             *      .dispatch(URL) - перенаправляет запрос другому обработчику
             */
            asyncContext.complete();
        }
    }
}
