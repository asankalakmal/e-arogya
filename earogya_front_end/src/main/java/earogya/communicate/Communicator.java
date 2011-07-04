package earogya.communicate;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.client.Options;

import javax.xml.namespace.QName;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAPHeaderBlock;

public class Communicator {
	
	private String message;
	private String service;
	private ConfigurationContext confcontext;
	private URL wsdlUrl;
	private QName serviceName;
	private String port;
	
	public Communicator(String message, String service) throws MalformedURLException{
		this.message=message;
		this.service=service;
	}
	
	private void sendMessage(String method, String namespace) throws AxisFault{
	//	ServiceClient client = new ServiceClient(confcontext, wsdlUrl, serviceName, port);
		ServiceClient client=new ServiceClient();
		// create option object
		Options opts = new Options();
		//setting target EPR
		opts.setTo(new EndpointReference(service));
		//Setting action ,and which can be found from the wsdl of the service
		opts.setAction("tns:"+method);
		//setting created option into service client
		client.setOptions(opts);
		OMElement res = client.sendReceive(createPayLoad(namespace, method));
		System.out.println(res);
	}
	
	private OMElement createPayLoad(String namespace, String methodName) {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace(
        		namespace, "ns1");
        OMElement method = fac.createOMElement(methodName, omNs);
        OMElement value = fac.createOMElement("value", omNs);
        value.setText(message);
        method.addChild(value);
        System.out.println(method);
        return method;
	}
	
	/*public static void main(String args[]) throws MalformedURLException, AxisFault, UnsupportedEncodingException{
		String message="MSH|^~\\&|||||200701011539||QRY^A19|||2.5.1 \\r"
		+"QRD||||||||250|^old admissions";
		String encodedMessage=URLEncoder.encode(message, "ISO-8859-1");
		Communicator c=new Communicator(message, "http://localhost:8080/eArogya-0.0.2-SNAPSHOT/services/EHRMedicalRecordsService");
		c.sendMessage("getMedicalRecords", "http://ws.ehr.medical_records.ehr.earogya/");
	}*/
	
	public static void main(String args[]) throws MalformedURLException, AxisFault, UnsupportedEncodingException{
		String message="MSH|^~\\&|||||200701011539||QRY^A19|||2.5.1 \\r"
		+"QRD||||||||250|^old admissions";
		String encodedMessage=URLEncoder.encode(message, "ISO-8859-1");
		Communicator c=new Communicator(message, "http://localhost:8081/services/Mirth");
		c.sendMessage("acceptMessage", "http://ws.connectors.connect.mirth.com/");
	}
	
}
