package com.hxf.demo.demo.test;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/8/24 10:10
 */
public class StringDemo {

    public static void main(String[] args) {
        String a = "a";
        Integer b = 0;
        Long c = 1000L;
        useStringBuilder(a, b, c);
        usePlus(a, b, c);
    }

    /**
     * 使用 StringBuilder 拼接
     */
    private static void useStringBuilder(String a, Integer b, Long c) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a).append(b).append(c);
        System.out.println(stringBuilder.toString());
    }

    /**
     * 直接使用+号进行字符串拼接
     */
    private static void usePlus(String a, Integer b, Long c) {
        System.out.println(a + b + c);
    }

}

/**
 * public class com.hxf.demo.demo.test.StringDemo {
public com.hxf.demo.demo.test.StringDemo();
        Code:
        0: aload_0
        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
        4: return

public static void main(java.lang.String[]);
        Code:
        0: ldc           #2                  // String a
        2: astore_1
        3: iconst_0
        4: invokestatic  #3                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        7: astore_2
        8: ldc2_w        #4                  // long 1000l
        11: invokestatic  #6                  // Method java/lang/Long.valueOf:(J)Ljava/lang/Long;
        14: astore_3
        15: aload_1
        16: aload_2
        17: aload_3
        18: invokestatic  #7                  // Method useStringBuilder:(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;)V
        21: aload_1
        22: aload_2
        23: aload_3
        24: invokestatic  #8                  // Method usePlus:(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;)V
        27: return

private static void useStringBuilder(java.lang.String, java.lang.Integer, java.lang.Long);
        Code:
        0: new           #9                  // class java/lang/StringBuilder
        3: dup
        4: invokespecial #10                 // Method java/lang/StringBuilder."<init>":()V
        7: astore_3
        8: aload_3
        9: aload_0
        10: invokevirtual #11                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        13: aload_1
        14: invokevirtual #12                 // Method java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        17: aload_2
        18: invokevirtual #12                 // Method java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        21: pop
        22: getstatic     #13                 // Field java/lang/System.out:Ljava/io/PrintStream;
        25: aload_3
        26: invokevirtual #14                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        29: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        32: return

private static void usePlus(java.lang.String, java.lang.Integer, java.lang.Long);
        Code:
        0: getstatic     #13                 // Field java/lang/System.out:Ljava/io/PrintStream;
        3: new           #9                  // class java/lang/StringBuilder
        6: dup
        7: invokespecial #10                 // Method java/lang/StringBuilder."<init>":()V
        10: aload_0
        11: invokevirtual #11                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        14: aload_1
        15: invokevirtual #12                 // Method java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        18: aload_2
        19: invokevirtual #12                 // Method java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        22: invokevirtual #14                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        25: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        28: return
        }*/























