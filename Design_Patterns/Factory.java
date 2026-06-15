public class Factory {

    public static void main(String[] args) {

        // Create Word Document
        DocumentFactory wordFactory = new WordFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        // Create PDF Document
        DocumentFactory pdfFactory = new PdfFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        // Create Excel Document
        DocumentFactory excelFactory = new ExcelFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}

/* =========================
   PRODUCT INTERFACE
   ========================= */

interface Document {
    void open();
}

/* =========================
   CONCRETE PRODUCTS
   ========================= */

class WordDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening Word Document");
    }
}

class PdfDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening PDF Document");
    }
}

class ExcelDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening Excel Document");
    }
}

/* =========================
   FACTORY ABSTRACT CLASS
   ========================= */

abstract class DocumentFactory {

    public abstract Document createDocument();
}

/* =========================
   CONCRETE FACTORIES
   ========================= */

class WordFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}