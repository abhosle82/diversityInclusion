package enablement.trasnformers.hackathon.poi;

public class DiversityInclusionFactory {
    public static DiversityInclusion createDiversityInclusion(String strDAndI){
        if("DI".equals(strDAndI)){
            return new DiversityInclusionReadExcel();
        }
        return null;
    }
}
