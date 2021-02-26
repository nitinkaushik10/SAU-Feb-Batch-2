/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WordCount;

import java.io.*;
public class WordCountWithoutThread {
    static int solution(String text) throws IOException {
       
        int wordCount = 0;

        FileReader fileReader = new FileReader(new File(text));
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String data;
        while((data = bufferedReader.readLine()) != null){

            String [] addup = data.split("\\s+");
            wordCount += addup.length;

        }

        return wordCount;
    }
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        String text = "Stringfile.txt";

        System.out.println("word: "+ solution(text));


        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time in without Thread: "+ totalTime);
    }
}
