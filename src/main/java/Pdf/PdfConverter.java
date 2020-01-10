package Pdf;

import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;

import java.io.*;

/**
 * caution: only works on windows with office installed.
 * <p>
 * author lyn
 * create_date_time 2020/1/10 9:29
 */
public class PdfConverter {

    public void word2pdf(String inputPath, String outputPath) throws IOException {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);
        try {
            InputStream inputStream = new FileInputStream(inputFile);
            OutputStream outputStream = new FileOutputStream(outputFile);
            IConverter converter = LocalConverter.builder().build();
            // extract the file type parameter out to adapt more file type
            converter.convert(inputStream).as(DocumentType.DOC).to(outputStream).as(DocumentType.PDF).execute();
            outputStream.close();
            inputStream.close();
            converter.shutDown();
        } catch (IOException e) {
            e.printStackTrace();
            if (outputFile.delete()) {
                System.out.println("pdf generation failed, delete the tmp file");
            }
            throw e;
        }

    }

    public void word2pdf(String inputPath) throws IOException {
        String outputPath = inputPath.substring(0, inputPath.lastIndexOf(".")) + ".pdf";
        this.word2pdf(inputPath, outputPath);
    }

    public static void main(String[] args) throws IOException {
        PdfConverter pc = new PdfConverter();
        pc.word2pdf("C:\\Users\\lyn\\lynmeigOneDrive\\OneDrive\\文档\\kayak\\liuzhou\\代码文档\\代码文档.docx");
    }
}
