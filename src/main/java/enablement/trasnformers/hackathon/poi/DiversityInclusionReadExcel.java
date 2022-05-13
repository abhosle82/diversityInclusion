package enablement.trasnformers.hackathon.poi;

import enablement.trasnformers.hackathon.entities.CompanyDiversityInfo;
import enablement.trasnformers.hackathon.entities.LeaderDiversityInfo;
import enablement.trasnformers.hackathon.service.DiversityInclusionService;
import enablement.trasnformers.hackathon.service.DiversityInclusionServiceImpl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class DiversityInclusionReadExcel implements DiversityInclusion{

    CompanyDiversityInfo objCDI = null;
    LeaderDiversityInfo objLDI1 = null;
    LeaderDiversityInfo objLDI2 = null;
    Set<LeaderDiversityInfo> setOfLeaders = null;
    List<CompanyDiversityInfo> lsCDI = new ArrayList<>();
    List<LeaderDiversityInfo> lsLDI = new ArrayList<>();

    public void readDiversityOwnedData() throws IOException {

        try
        {
            FileInputStream file = new FileInputStream(new File("Hackathon_Data_MinorityWomenOwned_2022 v1.xlsx"));


            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            int i=0;
            String strValue = null;
            int iColumnIndex = 0;

            while (rowIterator.hasNext())
            {
                objCDI = new CompanyDiversityInfo();
                objLDI1 = new LeaderDiversityInfo();
                objLDI2 = new LeaderDiversityInfo();
                setOfLeaders = new HashSet<>();

                i++;
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                if(row.getRowNum()==0){
                    continue;
                }
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()){

                    Cell cell = cellIterator.next();
                    iColumnIndex =cell.getColumnIndex();

                    if(cell.getCellType() == CellType.NUMERIC){
                        strValue = NumberToTextConverter.toText(cell.getNumericCellValue()) ;
                    }else{
                        strValue=cell.getStringCellValue() ;
                    }
                    if(iColumnIndex == 0){
                        objCDI.setDunsNumber(strValue);
                    }else if(iColumnIndex == 1){
                        objCDI.setDunsName(strValue);
                    }else if(iColumnIndex == 2){
                        objCDI.setCounty(strValue);
                    }else if(iColumnIndex == 3){
                        objCDI.setStreetAddress(strValue);
                    }else if(iColumnIndex == 4){
                        objCDI.setCity(strValue);
                    }else if(iColumnIndex == 5){
                        objCDI.setState(strValue);
                    }else if(iColumnIndex == 6){
                        objCDI.setZipCode(strValue);
                    }else if(iColumnIndex == 7){
                        objCDI.setPhone(strValue);
                    }else if(iColumnIndex == 8){
                        objLDI1.setName(strValue);
                        setOfLeaders.add(objLDI1);
                    }else if(iColumnIndex == 9){
                        objLDI2.setName(strValue);
                        setOfLeaders.add(objLDI2);
                    }else if(iColumnIndex == 10) {

                    }else if(iColumnIndex == 11){
                        objLDI1.setCompany(objCDI);
                        objLDI2.setCompany(objCDI);
                        objCDI.setLeaders(setOfLeaders);

                        lsCDI.add(objCDI);
                        lsLDI.add(objLDI1);
                        lsLDI.add(objLDI2);
                    }
                }

                System.out.println("#################### DONE ##########################");
                if(i==5){
                    break;
                }
            }

            file.close();
        }catch (Exception e){
            e.printStackTrace();
        }



    }

    @Override
    public List<LeaderDiversityInfo> getLeaders() {
        return lsLDI;
    }

    @Override
    public List<CompanyDiversityInfo> getCompanies() {
        return lsCDI;
    }

}
