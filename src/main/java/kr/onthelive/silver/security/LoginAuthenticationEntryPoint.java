package kr.onthelive.silver.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.onthelive.silver.dtos.base.BaseResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class LoginAuthenticationEntryPoint implements AuthenticationEntryPoint {

    //    private static ExceptionResponse exceptionResponse =
//            new ExceptionResponse(HttpStatus.UNAUTHORIZED.value(), "UnAuthorized!!!", null);
    private static BaseResponseDto baseResponseDto = new BaseResponseDto(false, "Unauthorized");

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {

        //response.sendRedirect("/exception/entrypoint");
        //response.getWriter().println("******** Unauthorized (commence) ********");
        //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "******** Unauthorized (commence) ********");

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        try (OutputStream os = response.getOutputStream()) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(os, baseResponseDto);
            os.flush();
        }


    }

}