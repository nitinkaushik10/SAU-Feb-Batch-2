package checkLicence;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
public class checkLicence {
       public static void IsValidLicence(Document file, String check)
    {
        try {
            NodeList license_list = file.getElementsByTagName("License");

            for(int i = 0; i <license_list.getLength(); i++) {
                Node license = license_list.item(i);
                Element licenseElement = (Element) license;

                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String expirationDate = licenseElement.getAttribute("License_Expiration_Date");
                LocalDate licenseExpirationDate = LocalDate.parse(expirationDate, dateTimeFormatter);

                LocalDate today = LocalDate.now();
                int diff = today.compareTo(licenseExpirationDate);

                if(check.equals("valid")) {
                	if(diff > 0) {
                		licenseElement.getParentNode().removeChild(licenseElement);
                	}
                }
                else if(check.equals("invalid")){
                	if(diff < 0) {
                		licenseElement.getParentNode().removeChild(licenseElement);
                	}
                }
            }

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(file);
            StreamResult result = new StreamResult(new StringWriter());
            transformer.transform(source, result);

            Writer output = new BufferedWriter(new FileWriter(check + "XML.xml"));
            String xmlOutput = result.getWriter().toString();
            output.write(xmlOutput);
            output.close();
        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }
	public static void merge_file(Document doc1,Document doc2)
	{
		
		try {
			NodeList csr_producer_list1 = doc1.getElementsByTagName("CSR_Producer");
	        NodeList csr_producer_list2 = doc2.getElementsByTagName("CSR_Producer");
	        for(int i = 0; i <csr_producer_list1.getLength(); i++) {
                Node csr1_node = csr_producer_list1.item(i);
                Element csr1_element = (Element) csr1_node;
                boolean csrMatched = false;

               for (int j = 0; j < csr_producer_list2.getLength(); j++) {
                    Node csr2_node = csr_producer_list2.item(j);
                    Element csr2_element = (Element) csr2_node;

                    if (csr1_element.getAttribute("NIPR_Number").equals(csr2_element.getAttribute("NIPR_Number"))) {

                        csrMatched = true;
                        NodeList csr1_license_list = csr1_element.getChildNodes();
                        NodeList csr2_license_list = csr2_element.getChildNodes();

                        for (int k = 0; k < csr1_license_list.getLength(); k++) {
                            Node curr_license_csr1_license_list = csr1_license_list.item(k);
                            boolean licenseMatched = false;

                            if(curr_license_csr1_license_list.getNodeType() == Node.ELEMENT_NODE) {
                                Element curr_license_csr1_license_listElement = (Element) curr_license_csr1_license_list;
                                for (int l = 0; l < csr2_license_list.getLength(); l++) {
                                    Node detail2 = csr2_license_list.item(l);
                                    if (detail2.getNodeType() == Node.ELEMENT_NODE) {
                                        Element detail2Element = (Element) detail2;
                                        if ((curr_license_csr1_license_listElement.getAttribute("Date_Status_Effective").equals(detail2Element.getAttribute("Date_Status_Effective")))
                                                && (curr_license_csr1_license_listElement.getAttribute("State_Code").equals(detail2Element.getAttribute("State_Code")))
                                                && (curr_license_csr1_license_listElement.getAttribute("License_Number").equals(detail2Element.getAttribute("License_Number")))) {

                                            licenseMatched = true;
                                            NodeList childNodes = detail2.getChildNodes();
                                            for (int m = 0; m < childNodes.getLength(); m++) {
                                                Node n = (Node) doc1.importNode(childNodes.item(m),true);
                                                curr_license_csr1_license_listElement.appendChild(n);
                                            }
                                        }

                                    }
                                }
                                if(!licenseMatched)
                                {
                                    curr_license_csr1_license_list.getParentNode().removeChild(curr_license_csr1_license_list);
                                }
                            }

                        }
                    }

                }
                if(!csrMatched)
                {
                    csr1_node.getParentNode().removeChild(csr1_node);
                } 
            }
           TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc1);
            StreamResult result = new StreamResult(new StringWriter());
            transformer.transform(source, result);

            Writer output = new BufferedWriter(new FileWriter("merged_files.xml"));
            String xmlOutput = result.getWriter().toString();
            output.write(xmlOutput);
            output.close();
	
			}
		catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	

  public static void main(String[] args) {
  
   try {
	   	    File f1 = new File("Licence1.xml");
		    File f2 = new File("Licence2.xml");
		    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		    Document doc1 = dBuilder.parse(f1);
		    Document doc2 = dBuilder.parse(f2);
		    doc1.getDocumentElement().normalize();
		    doc2.getDocumentElement().normalize();
                    merge_file(doc1,doc2);
                    IsValidLicence(doc2, "valid");
		    IsValidLicence(doc1, "invalid");
		        
   		}
   catch(Exception e)
   		{
			e.printStackTrace();
   		}
  }
  
}