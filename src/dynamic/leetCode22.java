package dynamic;

import java.util.ArrayList;
import java.util.List;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//        示例 1：
//
//        输入：n = 3
//        输出：["((()))","(()())","(())()","()(())","()()()"]
//        示例 2：
//
//        输入：n = 1
//        输出：["()"]
//        提示：
//
//        1 <= n <= 8
//        Related Topics
//        字符串
//        动态规划
//        回溯
public class leetCode22 {

    public static List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        List<String> tempStroed=new ArrayList<>();
        //初始化result初始状态
        result.add("()");
        //根据生成括号的对数来判断程序要执行的状态
        for(int count=1;count<n;count++){
            for (int num=0;num<result.size();num++) {
                String str=result.get(num);
                //根据上一次的枚举结果来构造括号的组合
                for(int i=0;i<=str.length();i++){
                    String t= str.substring(0,i)+"()"+str.substring(i);
                    boolean contains = tempStroed.contains(t);
                    if(!contains){
                        tempStroed.add(t);
                    }
                }
            }

            result.clear();
            result.addAll(tempStroed);
            tempStroed.clear();
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));

    }
}
