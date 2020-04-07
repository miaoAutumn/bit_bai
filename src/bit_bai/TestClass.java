package bit_bai;

public class TestClass {
        private  void testMethod(){
            System.out.println("testMethod");
        }
        public static void main(String[] args) {
            ((TestClass)null).testMethod();
        }
    }

