package com.xl.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class LineNumber的原理 { // 定义计数器实现,读一行，num++
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("1.java");
        MyLineNumberReader mlr = new MyLineNumberReader(fr);
        String leng;
        mlr.setLineNumber(0);
        while ((leng = mlr.myReadLine()) != null) {
            System.out.println(mlr.getLineNumber() + ":" + leng);
        }
        mlr.close(); // 继承的用close,没继承的用myClose()
    }
}

// class MyLineNumberReader { //可以继承BufferedReader类，里面的就可以不写那么多的代码
// private Reader r;
// private int lineNumber;
// MyLineNumberReader(Reader r) {
// this.r = r;
// }
// public String myReadLine() throws IOException {
// lineNumber++; // 读一行自增一次
// StringBuilder sb = new StringBuilder();
// int leng = 0;
// while ((leng = r.read()) != -1) {
// if (leng == '\r')
// continue;
// if (leng == '\n')
// return sb.toString();
// else
// sb.append((char) leng);
// }
// if (sb.length() != 0) // 判断最后一行是否返回
// return sb.toString();
// return null;
// }
// public void setLineNumber(int lineNumber) {
// this.lineNumber = lineNumber;
// }
// public int getLineNumber() {
// return lineNumber;
// }
// public void myClose() throws IOException {
// r.close();
// }
// }
class MyLineNumberReader extends BufferedReader {
    private int lineNumber;

    MyLineNumberReader(Reader r) {
        super(r);
    }

    public String myReadLine() throws IOException {
        lineNumber++;
        return super.readLine();
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
}
