package th.or.etda.PDFGraphicSignature;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
	@Test
    void AppTest01()
    {
		/**** Sample Input ****/   	
    	String inputFilePath = "src/main/resources/PDFA3.pdf";
    	String signatureFilePath = "src/main/resources/richard.png";
    	String outputFilePath = "src/test/resources/PDFA3_Append.pdf";
    	
    	int xCoordinate = 375;
    	int yCooredinate = 290;
    	int signatureWidth = 120;
    	int pagenumber = 0;
    	
    	GraphicSignature sig = new GraphicSignature(inputFilePath,outputFilePath,signatureFilePath);    	
    	sig.setCordinate(xCoordinate, yCooredinate);
    	sig.setPageNumber(0);
    	sig.setSignatureWidth(signatureWidth);    	
    	
    	try {
			sig.Append();
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}    	
    	Assert.assertTrue(new File(outputFilePath).exists());    	
    }




}
