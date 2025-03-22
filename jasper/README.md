## Learn Jasper

### Package (Jasper)
- For generate `pdf` report by using jasper we need to create 
`JasperPrint` instance first. For initializing `JasperPrint` we need to create from 
`JasperFillManager.fillReport(...,...,...)` function that we can pass 3 parameter 
1. `JasperReport` = the template of report
2. `Parameter (Map<String,Object>)` = parameter that will be used on jasper
3. `JRBeanCollectionDataSource` = the data source that will be passed in jasper
- For generate `xls` report by using jasper we need to create
`JasperPrint` instance firs and pass it to `JRXlsExporter` to generate xls more over
we configure `xls` format from `SimpleXlsxReportConfiguration` class