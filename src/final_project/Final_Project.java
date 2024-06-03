/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import vn.pipeline.*;
import java.io.*;
import vn.pipeline.Annotation;

/**
 *
 * @author Hương Trà
 */
public class Final_Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        // "wseg", "pos", "ner", and "parse" refer to as word segmentation, POS tagging, NER and dependency parsing, respectively. 

        // "wseg", "pos", "ner", and "parse" refer to as word segmentation, POS tagging, NER and dependency parsing, respectively. 
        String[] annotators = {"wseg", "pos", "ner", "parse"};
        VnCoreNLP pipeline = new VnCoreNLP(annotators);

        // input nhập vào 
        String str = "Ngày hôm qua, tôi đã có một trải nghiệm thú vị khi đi dạo quanh hồ Gươm. Khung cảnh tuyệt đẹp với mặt hồ xanh biếc, phản chiếu ánh nắng vàng rực rỡ của buổi chiều. Cây cối xanh mát rợp bóng, tiếng chim hót líu lo khiến lòng người thư thái. Tôi dừng chân ngắm nhìn tháp Rùa cổ kính, cảm nhận rõ nét lịch sử và văn hóa ngàn năm của thủ đô Hà Nội. Không khí trong lành, mát mẻ càng làm cho buổi chiều thêm phần thi vị và khó quên.";

        Annotation annotation = new Annotation(str);
        pipeline.annotate(annotation);
//        System.out.println(annotation.getRawText());
        for (Word item : annotation.getWords()) {
            System.out.println(item.toString().split("\t")[0]);
        }

     System.out.println(annotation.toString());
        // 1    Ông                 Nc  O       4   sub 
        // 2    Nguyễn_Khắc_Chúc    Np  B-PER   1   nmod
        // 3    đang                R   O       4   adv
        // 4    làm_việc            V   O       0   root
        // ...
        //Write to file
//        PrintStream outputPrinter = new PrintStream("output.txt");
//        pipeline.printToFile(annotation, outputPrinter);
        // You can also get a single sentence to analyze individually 
//        Sentence firstSentence = annotation.getSentences().get(0);
//        System.out.println(firstSentence.toString());
    }

}
