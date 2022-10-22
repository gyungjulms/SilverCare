package kr.onthelive.silver.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.onthelive.silver.dtos.base.BaseResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class LoginAccessDeniedHandler implements AccessDeniedHandler {
    private static BaseResponseDto baseResponseDto = new BaseResponseDto(false, "Forbidden");
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {

        //response.sendRedirect("/exception/accessdenied");
        //response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "******** Access Denied. ******** ");

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.FORBIDDEN.value());
        try (OutputStream os = response.getOutputStream()) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(os, baseResponseDto);
            os.flush();
        }

    }
}
