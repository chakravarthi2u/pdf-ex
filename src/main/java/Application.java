import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.IOException;
import java.io.InputStream;

public class Application {

    public static void main(String[] args) {
        try {
            InputStream input1 = getInputStreamForPdf("annexure-d.pdf");
            InputStream input2 = getInputStreamForPdf("annexure-e.pdf");
            mergePDFs(input1, input2, "output//merged.pdf");
            System.out.println("PDFs merged successfully.");
        } catch (IOException e) {
            System.err.println("Error merging PDFs: " + e.getMessage());
        }
    }

    private static void mergePDFs(InputStream input1, InputStream input2, String output) throws IOException {
        PDFMergerUtility mergerUtility = new PDFMergerUtility();
        mergerUtility.setDestinationFileName(output);
        mergerUtility.addSource(input1);
        mergerUtility.addSource(input2);
        mergerUtility.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
    }

    private static InputStream getInputStreamForPdf(String pdfFileName) {
        return Application.class.getResourceAsStream("/" + pdfFileName);
    }
}
