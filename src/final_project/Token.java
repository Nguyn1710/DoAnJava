/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package final_project;

/**
Tên "Token" được sử dụng ở đây vì nó phản ánh ý nghĩa của lớp, tức là một "token" trong xử lý ngôn ngữ tự nhiên. 
* Trong ngữ cảnh của xử lý ngôn ngữ tự nhiên (NLP), một "token" thường được hiểu là một đơn vị cơ bản nhất của văn bản, 
* có thể là một từ, một ký tự đặc biệt, một dấu câu, hoặc một phần tử khác của văn bản.
 */
class Token {
    private int index;
    private String word;
    private String POS;
    private String NER_Label;
    private int startPos;
    private int endPos;

    public Token(int index, String word,String POS, int startPos, int endPos) {
        this.index = index;
        this.word = word;
        this.POS = POS;
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public Token(int index, String word, int startPos, int endPos) {
        this.index = index;
        this.word = word;
        this.POS = null;
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public Token(String word, int startPos, int endPos, String POS) {
        this.word = word;
        this.POS = POS;
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public Token(int index, String word, String POS, String NER_Label, int startPos, int endPos) {
        this.index = index;
        this.word = word;
        this.POS = POS;
        this.NER_Label = NER_Label;
        this.startPos = startPos;
        this.endPos = endPos;
    }
    

    public String getWord() {
        return word;
    }
    public String getPOS() {
        return POS;
    }
    public int index(){
        return index;
    }

    public int getStartPos() {
        return startPos;
    }

    public int getEndPos() {
        return endPos;
    }

    public int getIndex() {
        return index;
    }

    public String getNER_Label() {
        return NER_Label;
    }
    

    @Override
    public String toString() {
        return index + word + " [" + startPos + ", " + endPos + "]";
    }
}

