import java.io.*;
import java.util.Iterator;
import javax.xml.stream.*;

public class MapReduce 
{
	public static void main(String[] args) throws FileNotFoundException, XMLStreamException
	{
		
		FileInputStream in = new FileInputStream("dblp.xml");
		XMLStreamReader xmlStrRea = XMLInputFactory.newInstance().createXMLStreamReader(in);
		
	}

}
