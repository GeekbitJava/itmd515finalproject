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
		
	//lists and arrays that will hold all of the entity information to be passed via jdbc to sql
		//PURPOSE: lists allow for dynamic memory allocation, arrays are more easily passed to be stored.
		
	//Delivery Transactions
	private DeliveryTransactions [] dtArray;
	private ArrayList<DeliveryTransactions> dtList = new ArrayList<DeliveryTransactions>();
	
	//Taxi Transactions
	private TaxiTransactions [] taxArray;
	private ArrayList<TaxiTransactions> taxList = new ArrayList<TaxiTransactions>();
	
	//Users
	private Users [] UsrArray;
	private ArrayList<Users> UsrList = new ArrayList<Users>();
	
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

	
	
	public DeliveryTransactions[] getDtArray() {
		return dtArray;
	}

	public void setDtArray(DeliveryTransactions[] dtArray) {
		this.dtArray = dtArray;
	}

	public void parseTTXML() {
		
		try {

			
			//NOTE: IN FINAL DEV --> REMOVE HARD CODING OF FILE LOCATION
			File fXmlFile = new File("C:\\Users\\Tom\\Documents\\IIT\\ITMD415\\Assignments\\proj_Assign_1\\itmd515finalproject\\taxitrans.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("transaction");

			System.out.println("----------------------------");
			System.out.println("Reading Taxi Transactions from XML");

			for (int index = 0; index < nList.getLength(); index++) {

				//node list
				Node nNode = nList.item(index);

				taxList.add(new TaxiTransactions());
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					//fill out the deliveryTransactions obj
					taxList.get(index).setTid(Integer.parseInt(eElement.getElementsByTagName("trans_id").item(0).getTextContent()));
					taxList.get(index).setUserid(eElement.getElementsByTagName("user_id").item(0).getTextContent());
					taxList.get(index).setDriverid(eElement.getElementsByTagName("driver_id").item(0).getTextContent());
					taxList.get(index).setDateOfSale(java.sql.Date.valueOf(eElement.getElementsByTagName("date").item(0).getTextContent()));
					taxList.get(index).setRate(Double.parseDouble(eElement.getElementsByTagName("rate").item(0).getTextContent()));
					taxList.get(index).setPickupTime(java.sql.Time.valueOf(eElement.getElementsByTagName("pickup_time").item(0).getTextContent()));
					taxList.get(index).setPickupLocation(eElement.getElementsByTagName("pickup_loc").item(0).getTextContent());
					taxList.get(index).setDropoffTime(java.sql.Time.valueOf(eElement.getElementsByTagName("drop_time").item(0).getTextContent()));
					taxList.get(index).setDropoffLocation(eElement.getElementsByTagName("drop_loc").item(0).getTextContent());
					taxList.get(index).setRating(Byte.valueOf(eElement.getElementsByTagName("rating").item(0).getTextContent()));

				}
			}
			taxArray = taxList.toArray(new TaxiTransactions[taxList.size()]);
		    
		} catch (Exception e) {
			e.printStackTrace();
		    }		
	}

	public TaxiTransactions[] gettTaxArray() {
		return taxArray;
	}

	public void setTaxArray(TaxiTransactions[] taxArray) {
		this.taxArray = taxArray;
	}
	
	public void parseUserXML() {
		
		try {

			
			//NOTE: IN FINAL DEV --> REMOVE HARD CODING OF FILE LOCATION
			File fXmlFile = new File("C:\\Users\\Tom\\Documents\\IIT\\ITMD415\\Assignments\\proj_Assign_1\\itmd515finalproject\\users.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("user");

			System.out.println("----------------------------");
			System.out.println("Reading Users from XML");

			for (int index = 0; index < nList.getLength(); index++) {

				//node list
				Node nNode = nList.item(index);

				UsrList.add(new Users());
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					//fill out the deliveryTransactions obj
					UsrList.get(index).setUserid(eElement.getElementsByTagName("user_id").item(0).getTextContent());;
					UsrList.get(index).setPassword(eElement.getElementsByTagName("password").item(0).getTextContent());;
					UsrList.get(index).setFirstName(eElement.getElementsByTagName("first_name").item(0).getTextContent());;
					UsrList.get(index).setLastName(eElement.getElementsByTagName("last_name").item(0).getTextContent());;
					UsrList.get(index).setUserType(eElement.getElementsByTagName("user_type").item(0).getTextContent());;
					UsrList.get(index).setRating(Byte.valueOf(eElement.getElementsByTagName("rating").item(0).getTextContent()));;
					UsrList.get(index).setEmail(eElement.getElementsByTagName("email").item(0).getTextContent());;
					UsrList.get(index).setCurr_Loc(eElement.getElementsByTagName("current_loc").item(0).getTextContent());;

				}
			}
			UsrArray = UsrList.toArray(new Users[UsrList.size()]);
		    
		} catch (Exception e) {
			e.printStackTrace();
		    }		
	}	
	
	public Users[] getUsrArray() {
		return UsrArray;
	}

	public void setUsrArray(Users[] UsrArray) {
		this.UsrArray = UsrArray;
	}
}
