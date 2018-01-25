package ch_15_web_programmin_server_side.asyncExample;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Лучшим средством для отслеживания разделяемых сервисов и ресурсов внутри контекста сервлета является
 * объект ServletContextListener. Он содержит 2 метода для управления жизненным циклом, с помощью которых при
 * запуске и завершение работы сервлета можно подключать и отключать различные сервисы.
 */
@WebListener
public class BackgroundWaitService implements ServletContextListener
{
    ScheduledExecutorService executor;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.executor = Executors.newScheduledThreadPool(3);
        sce.getServletContext().setAttribute("BackgroundWaitExecutor", executor);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        executor.shutdownNow();
    }
}
