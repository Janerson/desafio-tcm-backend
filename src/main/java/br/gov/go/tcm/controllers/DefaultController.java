package br.gov.go.tcm.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ApiIgnore
@RestController
public class DefaultController implements ErrorController {

    @RequestMapping("/error")
    public void handleErrorWithRedirect(HttpServletResponse response) throws IOException {
        //response.sendRedirect("api/swagger-ui.html");
    }

    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("swagger-ui.html");
    }
}
