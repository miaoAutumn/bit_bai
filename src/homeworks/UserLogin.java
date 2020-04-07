package homeworks;

import java.util.Scanner;

public class UserLogin {
    Scanner scanner=new Scanner(System.in);
    private static String userName="admin";
    private static String password="123456";
    public static void main(String[] args){
        try{
            login("admin","12456");
        }catch (UserError userError){
            //打印出现异常的调用栈,将JVM栈之间方法的调用关系打印出来
            userError.printStackTrace();
        }catch(PasswordError passwordError){
            passwordError.printStackTrace();
        }
    }
    public static void login(String username,String password)throws UserError,PasswordError{
        if (!UserLogin.userName.equals(username)){
            throw new UserError("用户名错误");
        }
        if (!UserLogin.password.equals(password)){
            throw new UserError("密码错误");
        }
        System.out.println("登录成功");

    }

}
class UserError extends Exception{
    public UserError(String message){
        super(message);
    }
}
class PasswordError extends Exception{
    public PasswordError(String message){
        super(message);
    }
}

