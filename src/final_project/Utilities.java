/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package final_project;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.pipeline.Annotation;
import vn.pipeline.VnCoreNLP;
import vn.pipeline.Word;

/**
 Utilities để chứa các hàm chức năng cho JFrame 
 */
public class Utilities {

    public Utilities() {
    }
    
    // phân tích dữ liệu // phân tích ra danh từ tính từ ,... 
    public Annotation PhanTich (String input){
        String[] annotators = {"wseg", "pos", "ner", "parse"};
        VnCoreNLP pipeline = null;
        try {
            pipeline = new VnCoreNLP(annotators);
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        Annotation annotation = new Annotation(input);
        try {
            pipeline.annotate(annotation);
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return annotation;
    }
    
    
    // Phân tách loại từ : phân tách các từ cùng laoi5 vào cùng 1 mảng , text là input và annotation là kết quả khi phân tachs
    //dữ từ từ text 
    public void PhanTachLoaiTu (String text, Annotation annotation, List<WordPosition> nounWords, List<WordPosition> verbWords,List<WordPosition> adjWords, List<WordPosition> nerWords){
        int currentPos = 0;
        int wordIndex = 0 ;

        
        for (Word item : annotation.getWords()) {
            String[] fields = item.toString().split("\t");
            if (fields.length > 3) {
                String word = item.getForm();
                int startPos = text.indexOf(word, currentPos);
                int endPos = startPos + word.length() - 1;
                if (startPos != -1) {
                    switch (fields[2]) {
                        case "N":
                        {
                            WordPosition wordPosition = new WordPosition(wordIndex, word, "N",fields[3], startPos, endPos);
                            nounWords.add(wordPosition);
                            break;
                        } 
                        case "V":
                        {
                            WordPosition wordPosition = new WordPosition(wordIndex, word,"V",fields[3], startPos, endPos);                          
                            verbWords.add(wordPosition);
                            break;
                        }                           
                        case "A":
                        {
                            WordPosition wordPosition = new WordPosition(wordIndex, word, "A",fields[3], startPos, endPos);
                            adjWords.add(wordPosition);
                            break;
                        }  
                        case "Np":
                        {
                            WordPosition wordPosition = new WordPosition(wordIndex, word, "Np",fields[3], startPos, endPos);
                            nerWords.add(wordPosition);
                            break;
                        }  
                        default:
                            break;
                    }
                    currentPos = endPos + 1; // Update current position to search for next word
                    wordIndex++; // Increment the word index
                }
            }
            
        }
   


    }
    // phân tách khi chỉ có input  
    public void PhanTachLoaiTu (String text, List<WordPosition> nounWords, List<WordPosition> verbWords,List<WordPosition> adjWords, List<WordPosition> nerWords){
        Annotation annotation = new Annotation(text);
        annotation = PhanTich(text);
        
        
        int currentPos = 0;
        int wordIndex = 0 ;

        
        for (Word item : annotation.getWords()) {
            String[] fields = item.toString().split("\t");
            if (fields.length > 3) {
                String word = item.getForm();
                int startPos = text.indexOf(word, currentPos);
                int endPos = startPos + word.length() - 1;
                if (startPos != -1) {
                    switch (fields[2]) {
                        case "N":
                        {
                            WordPosition wordPosition = new WordPosition(wordIndex, word, "N",fields[3], startPos, endPos);
                            nounWords.add(wordPosition);
                            break;
                        } 
                        case "V":
                        {
                            WordPosition wordPosition = new WordPosition(wordIndex, word,"V",fields[3], startPos, endPos);                          
                            verbWords.add(wordPosition);
                            break;
                        }                           
                        case "A":
                        {
                            WordPosition wordPosition = new WordPosition(wordIndex, word, "A",fields[3], startPos, endPos);
                            adjWords.add(wordPosition);
                            break;
                        }  
                        case "Np":
                        {
                            WordPosition wordPosition = new WordPosition(wordIndex, word, "Np",fields[3], startPos, endPos);
                            nerWords.add(wordPosition);
                            break;
                        }  
                        default:
                            break;
                    }
                    currentPos = endPos + 1; // Update current position to search for next word
                    wordIndex++; // Increment the word index
                }
            }
        }
        for (WordPosition wp : nerWords) {
       // System.out.println("Word Index: " + wp.getWordIndex());
        System.out.println("Word: " + wp.getWord());
        System.out.println("Type: " + wp.getPOS());
        System.out.println("NER :"+wp.getNER_Label());
        System.out.println("Start Position: " + wp.getStartPos());
        System.out.println("End Position: " + wp.getEndPos());
        System.out.println("--------------");

        }
    
    }
    
   /*
        Label	Meaning
        PER	Names of persons
        LOC	Names of locations
        ORG	Names of organizations
        MISC	Names of miscellaneous entities
    */
    
    public void PhanTichNER (String text,List<WordPosition> PERWords,List<WordPosition> LOCWords, List<WordPosition> ORGWords, List<WordPosition> MISCWords, ){
        Annotation annotation = new Annotation(text);
        annotation = PhanTich(text);
        
        
        int currentPos = 0;
        int wordIndex = 0 ;

        
        for (Word item : annotation.getWords()) {
            String[] fields = item.toString().split("\t");
            if (fields.length > 3) {
                String word = item.getForm();
                int startPos = text.indexOf(word, currentPos);
                int endPos = startPos + word.length() - 1;
                if (startPos != -1) {
                    switch (fields[2]) {
                        case "N":
                        {
                            WordPosition wordPosition = new WordPosition(wordIndex, word, "N",fields[3], startPos, endPos);
                            nounWords.add(wordPosition);
                            break;
                        } 
                        case "V":
                        {
                            WordPosition wordPosition = new WordPosition(wordIndex, word,"V",fields[3], startPos, endPos);                          
                            verbWords.add(wordPosition);
                            break;
                        }                           
                        case "A":
                        {
                            WordPosition wordPosition = new WordPosition(wordIndex, word, "A",fields[3], startPos, endPos);
                            adjWords.add(wordPosition);
                            break;
                        }  
                        case "Np":
                        {
                            WordPosition wordPosition = new WordPosition(wordIndex, word, "Np",fields[3], startPos, endPos);
                            nerWords.add(wordPosition);
                            break;
                        }  
                        default:
                            break;
                    }
                    currentPos = endPos + 1; // Update current position to search for next word
                    wordIndex++; // Increment the word index
                }
            }
        }
        for (WordPosition wp : nerWords) {
       // System.out.println("Word Index: " + wp.getWordIndex());
        System.out.println("Word: " + wp.getWord());
        System.out.println("Type: " + wp.getPOS());
        System.out.println("NER :"+wp.getNER_Label());
        System.out.println("Start Position: " + wp.getStartPos());
        System.out.println("End Position: " + wp.getEndPos());
        System.out.println("--------------");

        }
    
    }
   
    
}
