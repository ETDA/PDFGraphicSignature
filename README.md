# PDFGraphicSignature

insert graphic signature on PDF using PDFbox.

# Developed envoronment
- Java Open JDK1.8
- Eclipse Oxygen 

# Packaging environment
- mavan package 


## Example 

   	GraphicSignature sig = new GraphicSignature(inputFilePath,outputFilePath,signatureFilePath);
    	
    	/* Set signature picture 's origin coordinate (0,0 is bottom-left of PDF page)
    	 * 
    	 * This tutorial use PDFA3.pdf as example.
    	 * The signature slot's area on PDF starts at coordinates (375,290) with 120 px width.
    	 * so height will keep resize by keep as same ratio as width.
    	*/
    	
    	//set Graphic signature coordinate
    	sig.setCordinate(xCoordinate, yCooredinate);
    	
    	//we'll set signature at firstpage (default is page0)
    	sig.setPageNumber(0);
    	
    	//set PDF's signature width
    	sig.setSignatureWidth(signatureWidth);   	

    	//Start append graphic signature 
		sig.Append();

## Changelog

### [0.1.0] - 2018-10-11

**Add**
- Initial version
