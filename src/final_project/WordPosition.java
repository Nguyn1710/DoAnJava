/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package final_project;

/**
 *
 * @author lengu
 */
class WordPosition {
    private int index;
    private String word;
    private String POS;
    private int startPos;
    private int endPos;

    public WordPosition(int index, String word,String POS, int startPos, int endPos) {
        this.index = index;
        this.word = word;
        this.POS = POS;
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public WordPosition(int index, String word, int startPos, int endPos) {
        this.index = index;
        this.word = word;
        this.POS = null;
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

    @Override
    public String toString() {
        return index + word + " [" + startPos + ", " + endPos + "]";
    }
}

