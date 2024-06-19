package com.brightkut.other.jasper;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JasperService {

    public String exportReport() throws Exception {
        // Example data
        List<CountryReport> data = new ArrayList<>();
        CountryReport countryReport = new CountryReport()
                .setCountry("Thailand")
                .setName("TH");

        CountryReport countryReport2 = new CountryReport()
                .setCountry("England")
                .setName("EN");

        data.add(countryReport);
        data.add(countryReport2);

        File file = ResourceUtils.getFile("classpath:report/employee_report_01.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
        //Fill Jasper report
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

        String outputFilePath = "CountryReport.pdf";
        //Export report
        JasperExportManager.exportReportToPdfFile(jasperPrint,outputFilePath);

        return "Generate Success File saved at: " + new File(outputFilePath).getAbsolutePath();
    }


}
