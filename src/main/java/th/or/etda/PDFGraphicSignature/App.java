package th.or.etda.PDFGraphicSignature;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
		/**** Sample Input ****/   	
    	/*String inputFilePath = "src/main/resources/PDFA3.pdf";
    	String signatureFilePath = "src/main/resources/richard.png";
    	String outputFilePath = "src/main/resources/PDFA3_Append.pdf";
    	
    	int xCoordinate = 375;
    	int yCooredinate = 290;
    	int signatureWidth = 120;
    	int pagenumber = 0;
    	*/
    	
    	String inputFilePath = args[0];
    	String signatureFilePath = args[1];
    	String outputFilePath = args[2];    	
    	int xCoordinate = Integer.parseInt(args[3]);
    	int yCooredinate = Integer.parseInt(args[4]);
    	int signatureWidth = Integer.parseInt(args[5]);
    	int pagenumber = Integer.parseInt(args[6]);
    	
    	GraphicSignature sig = new GraphicSignature(inputFilePath,outputFilePath,signatureFilePath);
    	
    	/* Set signature picture 's origin coordinate (0,0 is bottom-left of PDF page)
    	 * 
    	 * This tutorial use PDFA3.pdf as example.
    	 * The signature slot's area on PDF starts at coordinates (375,290) with 120 px width..
    	 * so height will keep resize by keep as same ratio as width.
    	*/
    	
    	//set Graphic signature coordinate
    	sig.setCordinate(xCoordinate, yCooredinate);
    	
    	//we'll set signature at firstpage (default is page0)
    	sig.setPageNumber(0);
    	
    	//set PDF's signature width
    	sig.setSignatureWidth(signatureWidth);    	
    	
    	try {
    	//Start append graphic signature 
			sig.Append();
		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
