package com.brightkut.other.jasper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jaspers")
public class JasperController {
    private final JasperService jasperService;


    public JasperController(JasperService jasperService) {
        this.jasperService = jasperService;
    }


    @GetMapping("/pdf")
    public String generatePdfReport() throws Exception {
        return jasperService.exportReport();
    }
}
