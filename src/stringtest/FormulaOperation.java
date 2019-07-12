package stringtest;

/**
 * 计算一个字符串表示的表达式的结果
 * 没有小括号的时(没有负数，没有结合运算);
 * 利用栈结构，放入一个数字和一个运算符号;
 * 再次加入一个数时，查看栈顶的运算符号是否为* / ;
 * 如果是将符号和其下面的元素取出，然后进行运算之后再进行压栈
 *
 * 如果有小括号()
 * 定义一个函数int f(str,index);计算从当前字符开始知道遇到右括号或者结尾，返回计算结果；
 */
public class FormulaOperation {
    public static void main(String[] args){
        String a = null;
        System.out.println(a.length());
    }


}
