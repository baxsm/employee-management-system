package baxsm;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JTable;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ExportPDF {

    private static Document document;

    public ExportPDF() {}
    
    public static void export(JTable table) throws FileNotFoundException, DocumentException {
    	openPdf();
    	PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
    	addData(pdfTable, table);
    	closePdf();
    }

    public static void openPdf() throws FileNotFoundException, DocumentException {
        document = new Document(PageSize.A4.rotate(), 5, 5, 30, 30);
        PdfWriter.getInstance(document, new FileOutputStream("ems-report.pdf"));
        document.open();
    }

    public static void closePdf() {
        document.close();
    }

    public static void addData(PdfPTable pdfTable, JTable table) throws DocumentException {
        pdfTable.setHeaderRows(1);
        PdfPCell cell;
        for (int x = 0; x < table.getColumnCount(); x++) {
            cell = new PdfPCell(new Paragraph(table.getColumnName(x)));
            cell.setBackgroundColor(new GrayColor(0.7f));
            pdfTable.addCell(cell);
        }
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                pdfTable.addCell(table.getModel().getValueAt(i, j).toString());
            }
        }
        document.add(pdfTable);
    }
}
