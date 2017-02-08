package hackerRank;

import java.util.Scanner;

public class LIsaWorkBook {

	public static class pageChapterProblemNo {
        int pageNo;
        int chapterNo;
        int firstProbleNo;
        int lastProblemNo;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named OddEvenChar. */
        Scanner scan = new Scanner(System.in);
        int numberOfChapter = scan.nextInt();
        int numberOfPrbPage = scan.nextInt();
        int pageNumber = 0;
        int matchFound = 0;
        
        pageChapterProblemNo book = new pageChapterProblemNo();
        
        for(int i = 1; i <=numberOfChapter ; i++) {
            int numberOfProblems = scan.nextInt();
            int numberOfPagesForChapter = 0;
            int leftNumberOfProblems = numberOfProblems % numberOfPrbPage;
            if( leftNumberOfProblems == 0) {
                numberOfPagesForChapter = numberOfProblems / numberOfPrbPage;
            } else {
                numberOfPagesForChapter = numberOfProblems / numberOfPrbPage + 1;
            }
            for (int j =1 ; j <= numberOfPagesForChapter ; j++) {
                book.pageNo = ++pageNumber;
                book.chapterNo = i;
                book.firstProbleNo = 1 + (numberOfPrbPage*(j-1));
                if( (book.firstProbleNo + numberOfPrbPage - 1) > numberOfProblems) {
                    book.lastProblemNo = book.firstProbleNo + leftNumberOfProblems - 1;
                } else {
                    book.lastProblemNo = book.firstProbleNo + numberOfPrbPage - 1;
                }
                if(book.pageNo >= book.firstProbleNo && book.pageNo <= book.lastProblemNo)
                    matchFound++;
                System.out.println(book.pageNo + " " + book.chapterNo + " " + book.firstProbleNo + " " + book.lastProblemNo );   
            }
        }
        
        System.out.println(matchFound);
        scan.close();
    }
}
