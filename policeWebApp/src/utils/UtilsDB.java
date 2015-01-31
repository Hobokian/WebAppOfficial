package utils;


import java.sql.SQLException;
import java.util.ArrayList;

/**
 * <i>UtilsDB</i> class to create utilities functions which don't require database connection
 * 
 * @author Iaroslav Malyshev, ....
 *
 */
public class UtilsDB {
	
	private UtilsDB(){};
	
	/**
	 * function convert result from DB to select list
	 * @param array - ArrayList of String arrays
	 * @param name - id of select tag 
	 * @return
	 */
	public static String createSelectListProvince(ArrayList<String[]> array) {
        StringBuffer sb = new StringBuffer();
        sb.append("<option value=\"0\">select province</option>");
        if(array.size()>0) 
        {
        	int i;
        	for(i=0;i<array.size();i++)
        	{
        		sb.append("<option value=\"" + array.get(i)[0] + "\">" + array.get(i)[1] + "</option>\n");
                
        	}
        }
        return sb.toString();
    }
	
	/**
	 * function convert result from DB to select list
	 * @param array - ArrayList of String arrays
	 * @param name - id of select tag
	 * @return
	 */
	public static String createSelectListCity(ArrayList<String[]> array) {
        StringBuffer sb = new StringBuffer();
        int i=0;
        if(array.size()>0) 
        {
        	sb.append("[");
        	for(i=0;i<array.size();i++)
        	{
        		sb.append("'"+array.get(i)[1]+"'");
        		if(i<(array.size()-1)) sb.append(",");
                
        	}
        	sb.append("]"); 
        }
        
        return sb.toString();
    }
	
	/**
	 * 
	 * 
	 * @param rset
	 * @return
	 * @throws SQLException
	 */
	public static String createIncidentReportTable(ArrayList<String[]> rset) {
        StringBuffer sb = new StringBuffer();
        int i;
        sb.append("<table frame=\"box\" border=2 >");
        sb.append("<tr><td>user</td><td>plateNumber</td><td>description</td><td>URL</td></tr>");
        if(rset.size()>0)
        {
        	for(i=0;i<rset.size();i++) 
        	{  
        		sb.append("<tr><td>"+rset.get(i)[1]+"</td><td>"+rset.get(i)[2]+"</td><td>"+rset.get(i)[4]+"</td><td>"+rset.get(i)[3]+"</td></tr>");
        	} 
        }
        sb.append("</table>"); 
        return sb.toString();
    }

}