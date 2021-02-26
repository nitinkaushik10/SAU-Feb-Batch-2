
package WordCount;

import java.io.*;
public class WordCountWithThread {
    static void solution(String text) throws IOException {
       
        int wordCount = 0;

        FileReader fileReader = new FileReader(new File(text));
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String data;
        while((data = bufferedReader.readLine()) != null){

            String [] addup = data.split("\\s+");
            wordCount += addup.length;

        }

         System.out.println("Word Count : "+ wordCount);
    }
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        String text= "Stringfile.txt";
      Thread wordCountThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    solution(text);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        wordCountThread.start();

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time in with Thread: "+ totalTime);
    }
}
