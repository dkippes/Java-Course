package com.example.springbootformulario.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@Component("tiempoTranscurridoInterceptor")
public class TiempoTranscurridoInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equalsIgnoreCase("post")) {
            return true; // No se aplica el codigo si esta en post
        }
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            logger.info("Es un metodo del controlador: " + method.getMethod().getName());
        }

        logger.info("TiempoTranscurridoInterceptor: preHandler() entrando ...");
        logger.info("Interceptando Handler: " + handler);
        long tiempoInicio = System.currentTimeMillis();
        request.setAttribute("tiempoInicio", tiempoInicio);
        Random random = new Random();
        Integer demora = random.nextInt(500);
        Thread.sleep(demora);

        // Si devuelve un false, entonces deberia seguir
//        response.sendRedirect(request.getContextPath().concat("/error"));
//        return false;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (request.getMethod().equalsIgnoreCase("post")) {
            return; // No se aplica el codigo si esta en post
        }
        long tiempoFin = System.currentTimeMillis();
        long tiempoInicio = (long) request.getAttribute("tiempoInicio");
        long tiempoTranscurrido = tiempoFin - tiempoInicio;

        if (handler instanceof HandlerMethod && modelAndView != null) {
            modelAndView.addObject("tiempoTranscurrido", tiempoTranscurrido);
        }
        logger.info("Tiempo Transcurrido: " + tiempoTranscurrido + " milisegundos");
        logger.info("TiempoTranscurridoInterceptor: postHandler() saliendo ...");
    }
}
