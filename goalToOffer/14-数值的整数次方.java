/*
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
*/
public class Solution {
    public double Power(double base, int exponent) {
        if(exponent <0){
            return Power(1/base, -exponent);
        }
        if(exponent==0){
            return 1;
        }
        if(exponent ==1){
            return base;
        }
        int flag = exponent % 2;
        double partRes = Power(base, exponent/2);
        if(flag ==1){
            return partRes *partRes * base;
        }
        return partRes *partRes;
  }
}
