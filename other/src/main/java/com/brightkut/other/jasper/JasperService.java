package com.brightkut.other.jasper;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class JasperService {

    public String exportPdfReport() throws Exception {
        //Get JasperPrint
        JasperPrint jasperPrint = getJasperPrint("country_report_pdf_format.jrxml");

        String outputFilePath = "CountryReport.pdf";
        //Export report
        JasperExportManager.exportReportToPdfFile(jasperPrint,outputFilePath);

        return "Generate Success File saved at: " + new File(outputFilePath).getAbsolutePath();
    }

    public String exportXlsReport() throws Exception {
        //Get JasperPrint
        JasperPrint jasperPrint = getJasperPrint("country_report_xls_format.jrxml");

        //File name
        String outputFilePath = "countryReport.xls";

        //Export report
        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputFilePath));

        SimpleXlsxReportConfiguration reportConfig = new SimpleXlsxReportConfiguration();
        reportConfig.setSheetNames(new String[] { "Country Data" });
        reportConfig.setDetectCellType(true);
        reportConfig.setCollapseRowSpan(false);


        exporter.setConfiguration(reportConfig);

        exporter.exportReport();

        return "Generate Success File saved at: " + new File(outputFilePath).getAbsolutePath();
    }

    public JasperPrint getJasperPrint(String jrxmlFileName) throws Exception {
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

        File file = ResourceUtils.getFile("classpath:report/"+ jrxmlFileName);
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
        //Fill Jasper report
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

        return jasperPrint;
    }

}
