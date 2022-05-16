package enablement.trasnformers.hackathon.poi;

import enablement.trasnformers.hackathon.entities.CompanyDiversityInfo;
import enablement.trasnformers.hackathon.entities.LeaderDiversityInfo;
import enablement.trasnformers.hackathon.service.DiversityInclusionService;
import enablement.trasnformers.hackathon.service.DiversityInclusionServiceImpl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.util.IOUtils;
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
            IOUtils.setByteArrayMaxOverride(147379697);
            FileInputStream file = new FileInputStream(new File("Hackathon_Data_MinorityWomenOwned_2022 v2.xlsx"));


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
                System.out.println("outside loop");
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

                    System.out.println("Inside loop "+iColumnIndex);

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
                    }else if(iColumnIndex == 8){    // Business Contact 1
                        objLDI1.setName(strValue);
                    }else if(iColumnIndex == 9){    // Business Contact 1 - Gender
                        objLDI1.setGender(strValue);
                    }else if(iColumnIndex == 10){   // Business Contact 1 - Ethnicity
                        objLDI1.setEthnicity(strValue);
                    }else if(iColumnIndex == 11){   // Business Contact 1 - LGBT
                        objLDI1.setIsLgbt(strValue);
                    }else if(iColumnIndex == 12){   // Business Contact 1 - Veteran
                        objLDI1.setIsVeteran(strValue);
                    }else if(iColumnIndex == 13){   // Business Contact 1 - Disabled
                        objLDI1.setIsDisable(strValue);
                    }else if(iColumnIndex == 14){   // Business Contact 1 - Share %
                        //objLDI1.setSharePercentage(Long.parseLong(strValue)); // Commenting as we do not have values for share %
                        setOfLeaders.add(objLDI1);
                    }else if(iColumnIndex == 15){   // Business Contact 2
                        objLDI2.setName(strValue);
                    }else if(iColumnIndex == 16){   // Business Contact 2 - Gender
                        objLDI2.setGender(strValue);
                    }else if(iColumnIndex == 17){   // Business Contact 2 - Ethnicity
                        objLDI2.setEthnicity(strValue);
                    }else if(iColumnIndex == 18) {  // LGBT
                        objLDI2.setIsLgbt(strValue);
                    }else if(iColumnIndex == 19) {  // Veteran
                        objLDI2.setIsVeteran(strValue);
                    }else if(iColumnIndex == 20) {  // Disabled
                        objLDI2.setIsDisable(strValue);
                    }else if(iColumnIndex == 21){   // Share Percentage
                        //objLDI2.setSharePercentage(Long.parseLong(strValue)); // Commenting as we do not have values for share %
                        setOfLeaders.add(objLDI2);
                        objCDI.setLeaders(setOfLeaders);
                        lsCDI.add(objCDI);
                        lsLDI.add(objLDI1);
                        lsLDI.add(objLDI2);
                    }
                }

                System.out.println("#################### DONE ##########################");
                if(i==3){
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
