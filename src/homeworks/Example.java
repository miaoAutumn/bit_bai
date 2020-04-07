package homeworks;

public class Example {
        public static void main(String args[]){
            String str = new String("good");
            char[ ] ch = { 'a' , 'b' , 'c' };
            Example ex = new Example();
            ex.change(str,ch);
            System.out.print(str + " and ");
            System.out.print(ch);
        }
        public void change(String str,char ch[ ]){
            str = "test ok";//字符串不变
            ch[0] = 'g';
        }
    }

