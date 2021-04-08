package com.qpj.week01.been;

public class Rhesis {
    private int rhesis_id;
    private String rhesis_sentence;
    private String rhesis_writer;
    private String rhesis_book;
    private String inputtime;


    public int getRhesis_id() {
        return rhesis_id;
    }

    public String getRhesis_sentence() {
        return rhesis_sentence;
    }

    public void setRhesis_id(int rhesis_id) {
        this.rhesis_id = rhesis_id;
    }

    public void setRhesis_sentence(String rhesis_sentence) {
        this.rhesis_sentence = rhesis_sentence;
    }

    public void setRhesis_writer(String rhesis_writer) {
        this.rhesis_writer = rhesis_writer;
    }

    public void setRhesis_book(String rhesis_book) {
        this.rhesis_book = rhesis_book;
    }

    public String getRhesis_writer() {
        return rhesis_writer;
    }

    public String getRhesis_book() {
        return rhesis_book;
    }

    public String getInputtime(){
        return inputtime;
    }

    public void setInputtime(String inputtime) {
        this.inputtime = inputtime;
    }

    @Override
    public String toString() {
        return "Rhesis{" +
                "id=" + rhesis_id +
                ", rhesis_sentence='" + rhesis_sentence + '\'' +
                ", rhesis_writer='" + rhesis_writer + '\'' +
                ", rhesis_book='" + rhesis_book + '\'' +
                ", inputtime='" + inputtime + '\'' +
                '}';
    }
}
