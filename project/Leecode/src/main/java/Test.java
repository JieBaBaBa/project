/**
 * @author: chenxiaojie
 * @date: 2020/12/10
 * @time: 4:49 下午
 * @description:
 */
public class Test {

    public static boolean lemonadeChange(int[] bills) {
//        if (ArrayUtils.isEmpty(bills)) {
//            return false;
//        }
        if (bills[0] == 10 || bills[0] == 20) {
            return false;
        }
        boolean result = true;
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five += 5;
            } else if (bill == 10) {
                five -= 5;
                ten += 10;
                if (five < 0) {
                    result = false;
                    break;
                }
            } else if (bill == 20) {
                if (ten > 0) {
                    ten -= 10;
                    five -= 5;
                } else {
                    five -= 15;
                }
                if (five < 0 || ten < 0) {
                    result = false;
                    break;
                }
            }
        }
        System.out.println(five + ", " + ten + ", " +result);
        return result;
    }

    public static void main(String[] args) {
        int [] integers = new int[] {5,5,5,5,20,20,5,5,5,5};
        boolean b = lemonadeChange(integers);
        System.out.println(b);
    }
}
