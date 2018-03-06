package groupproject.itmd515finalproject;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XmlParser {
	
	
	/* ---------------
	 * | Constructors  |
	 * ---------------	
	 */	
	
		//Default Constructor
		public XmlParser () {
		}
		
	/* ---------------
	 * | ATTRIBUTES  |
	 * ---------------	
	 */
	//lists that will hold all of the entity information to be passed via jdbc to sql
		
	//DeliveryTransactions dtarray[] = new DeliveryTransactions[600]; //array of delivery Transactions
	DeliveryTransactions [] dtArray;
	ArrayList<DeliveryTransactions> dtList = new ArrayList<DeliveryTransactions>();
	
	//method to parse through the delivery transactions xml
	public void parseDTXML() {
		
		try {

			
			//NOTE: IN FINAL DEV --> REMOVE HARD CODING OF FILE LOCATION
			File fXmlFile = new File("C:\\Users\\Tom\\Documents\\IIT\\ITMD415\\Assignments\\proj_Assign_1\\itmd515finalproject\\deliverytrans.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("transaction");

			System.out.println("----------------------------");
			System.out.println("Reading Delivery Transactions from XML");

			for (int index = 0; index < nList.getLength(); index++) {

				//node list
				Node nNode = nList.item(index);
				//creates new DeliveryTransactions obj in dtList
				//dtList[index] = new DeliveryTransactions(); 

				dtList.add(new DeliveryTransactions());
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					//fill out the deliveryTransactions obj
					dtList.get(index).setTid(Integer.parseInt(eElement.getElementsByTagName("trans_id").item(0).getTextContent()));
					dtList.get(index).setUserid(eElement.getElementsByTagName("user_id").item(0).getTextContent());
					dtList.get(index).setDriverid(eElement.getElementsByTagName("driver_id").item(0).getTextContent());
					dtList.get(index).setDateOfSale(java.sql.Date.valueOf(eElement.getElementsByTagName("date").item(0).getTextContent()));
					dtList.get(index).setRate(Double.parseDouble(eElement.getElementsByTagName("rate").item(0).getTextContent()));
					dtList.get(index).setPickupTime(java.sql.Time.valueOf(eElement.getElementsByTagName("pickup_time").item(0).getTextContent()));
					dtList.get(index).setPickupLocation(eElement.getElementsByTagName("pickup_loc").item(0).getTextContent());
					dtList.get(index).setDropoffTime(java.sql.Time.valueOf(eElement.getElementsByTagName("drop_time").item(0).getTextContent()));
					dtList.get(index).setDropoffLocation(eElement.getElementsByTagName("drop_loc").item(0).getTextContent());
					//note package size will take only the first char as an upper case so if xml has large it will be stored as L
					dtList.get(index).setPackageSize(eElement.getElementsByTagName("drop_loc").item(0).getTextContent().toUpperCase().charAt(0));

				}
			}
			dtArray = dtList.toArray(new DeliveryTransactions[dtList.size()]);
		    
		} catch (Exception e) {
			e.printStackTrace();
		    }
		  }

}
