package th.or.etda.PDFGraphicSignature;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class GraphicSignature {

	private String inputFilePath = "";
	private String outputFilePath = "";
	private String signatureFilePath = "";
	
	int xCoordinate = 0;
	int yCooredinate = 0;
	int signatureWidth = 0;
	int signatureHeight = 0;
	int pageNumber = 0;
	
	public int getxCordinate() {
		return xCoordinate;
	}
	
	public int getyCooredinate() {
		return yCooredinate;
	}

	/**
	 * Set origin coordinate of signature's image.
	 * The coordinate starts (0,0) at top-left corner of the page.  
	 * @param xCoordinate
	 * @param yCooredinate
	 */
	public void setCordinate(int xCoordinate,int yCooredinate) {
		this.xCoordinate = xCoordinate;
		this.yCooredinate = yCooredinate;
	}

	/**
	 * Get signature's image width.
	 * @return signature's image width. 
	 */
	public int getSignatureWidth() {
		return signatureWidth;
	}

	
	/**set signature's image width. 
	 * @param signature's image width. 
	 */
	public void setSignatureWidth(int signatureWidth) {
		this.signatureWidth = signatureWidth;
	}

	/** Set pageNumber of PDF for choosing which page we'll insert signature'image.
	 * Page 0 is default.
	 * @param pageNumber
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	/**Set input ,output, image filepath
	 * @param inputFilePath(PDF file)
	 * @param outputFilePath(PDF file)
	 * @param signatureFilePath(Signature's Image file)
	 */
	public GraphicSignature(String inputFilePath,String outputFilePath,String signatureFilePath) {
		this.inputFilePath = inputFilePath;
		this.outputFilePath = outputFilePath;
		this.signatureFilePath = signatureFilePath;
	}
	
	/**Insert signature's image into PDF.
	 * Resizing signature's image to fit signatureWidth area on x,y coordinate. 
	 *
	 * @throws InvalidPasswordException
	 * @throws IOException
	 */
	public void Append() throws InvalidPasswordException, IOException {
		
		PDDocument doc = PDDocument.load(new File(this.inputFilePath));	
		
		PDPage page = doc.getPage(pageNumber);
		
	    //Creating PDImageXObject object
	    PDImageXObject pdImage = PDImageXObject.createFromFile(signatureFilePath,doc);           
	    
	    //calculate same height with keep aspect ratio from width	
	    heightCalculate(pdImage.getWidth(),pdImage.getHeight());
	      
	    //creating the PDPageContentStream object
	    PDPageContentStream contents = new PDPageContentStream(doc, page , AppendMode.APPEND , false);		      
	      
	    //Drawing the image in the PDF document
	    contents.drawImage(pdImage,xCoordinate,yCooredinate,signatureWidth,signatureHeight);

	    System.out.println("Image inserted");
	      
	    //Closing the PDPageContentStream object
	    contents.close();
			
	    //Saving the document
	    doc.save(outputFilePath);
	            
	    //Closing the document
	    doc.close();	     		
	}
	
	/** Calculate new signature's height from resizing signature's image 
	 * @param imgWidth
	 * @param imgHeight
	 */
	private void heightCalculate(int imgWidth,int imgHeight) {		  
	      this.signatureHeight = imgHeight/(imgWidth / signatureWidth);		
	}
}
