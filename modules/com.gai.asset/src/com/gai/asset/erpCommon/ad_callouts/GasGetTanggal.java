// the package name corresponds to the module's manual code folder 
// created above
package com.gai.asset.erpCommon.ad_callouts;
 
import javax.servlet.ServletException;
 
import org.openbravo.utils.FormatUtilities;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.base.secureApp.VariablesSecureApp;
// classes required to retrieve product category data from the 
// database using the DAL
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.plm.ProductCategory;
import java.util.*; 
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.math.*;

// the name of the class corresponds to the filename that holds it 
// hence, modules/modules/org.openbravo.howtos/src/org/openbravo/howtos/ad_callouts/ProductConstructSearchKey.java.
// The class must extend SimpleCallout
public class GasGetTanggal  extends SimpleCallout {
 
  private static final long serialVersionUID = 1L;
 
  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    String hasiltanggalakhir="";
    String tanggal="";
    int hari = 0;
    
    // parse input parameters here; the names derive from the column
    // names of the table prepended by inp and stripped of all
    // underscore characters; letters following the underscore character
    // are capitalized; this way a database column named
    // M_PRODUCT_CATEGORY_ID that is shown on a tab will become
    // inpmProductCategoryId html field
      String calctype = info.getStringParameter("inpamortizationcalctype", null);
      String amortize = info.getStringParameter("inpassetschedule", null);
      String tahun = info.getStringParameter("inpuselifeyears", null);
      String bulan = info.getStringParameter("inpuselifemonths", null);
      String startdate = info.getStringParameter("inpamortizationstartdate", null);
      
      if(calctype.equals("TI")){
        if(amortize.equals("MO")){
          hari = Integer.parseInt(bulan);
        }
        else if(amortize.equals("YE")){
          hari =  Integer.parseInt(tahun) * 12;
        }
      }
    //info.addResult("inpstatus",tag);
      SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
      Calendar cal = Calendar.getInstance();
        Date tgl;
        try {
            tgl = sdf.parse(startdate);
            cal.setTime(tgl);
            cal.add(Calendar.MONTH, hari);
            tanggal = sdf.format(cal.getTime());
            
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

      info.addResult("inpamortizationenddate",tanggal);
    
}
}
