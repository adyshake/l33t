//https://leetcode.com/problems/multiply-strings/
class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();

        int [] product = new int [n1 + n2];
        //Are all elements init to 0?

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int index = n1 + n2 - i - j - 2;
                product[index] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                product[index + 1] += product[index]/10;
                product[index] = product[index] % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = product.length - 1; i > 0; i--){
            if (sb.length() == 0 && product[i] == 0)
                continue;
            sb.append(product[i]);
        }

        sb.append(product[0]);

        return sb.toString();
    }
}