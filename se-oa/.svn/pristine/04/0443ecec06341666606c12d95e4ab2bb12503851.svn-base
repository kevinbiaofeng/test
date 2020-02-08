package com.xjw.util;

/**
 * 发号器
 */
public class SequenceBuilder {
    private static IdWorker idWorker = new IdWorker(0, 0);
   
    public enum SequenceType{
        DP,  /** 存款 */ 
        WD   /** 提款 */
    }
    
    public static String next(SequenceType type) {
       return (type + String.valueOf(idWorker.nextId()));
    }
    
    public static void main(String[] args) throws InterruptedException {
        for(int i=0; i<100; i++) {
            System.out.println(SequenceBuilder.next(SequenceType.DP));
            Thread.sleep(500);
        }
    }
}
