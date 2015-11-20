/**
 * Description:KMP实现查找字符串.
 * Created  2015/10/21 14:37  by xinghaifang
 */
public class KMPTest {

    /**
     * Java实现KMP算法
     *
     * 思想：每当一趟匹配过程中出现字符比较不等，不需要回溯i指针，
     * 而是利用已经得到的“部分匹配”的结果将模式向右“滑动”尽可能远
     * 的一段距离后，继续进行比较。
     *
     * 时间复杂度O(n+m)
     *
     * @author xhf
     *
     */
        public static void main(String[] args) {
            String s = "faabc99999999999999999999999999999999999999999999999999999999999999999999999999999999999"
                    +"afdasdfasdfasdfasdfasdfljasdlgjasld;fjasdfasdfasdfasdfasdfasghrtjhdgfsdfgsdfgsdfgsdfgsdfgsdf"
                    +"afdasdfasdfasdfasdfasdfljasdlgjasld;fjasdfasdfasdfasdfasdfasghrtjhdgfsdfgsdfgsdfgsdfgsdfgsdf"
                    +"afdasdfasdfasdfabcsdfasdfljasdlgjasld;fjasdfasdfasdfasdfasdfasghrtjhdgfsdfgsdfgsdfgsdfgsdfgsdf"
                    +"afdasdfasdfasdfasdfasdfljasdlgjasld;fjasdfasdfaabcsdfasdfasdfasghrtjhdgfsdfgsdfgsdfgsdfgsdfgsdf";
            String t = "abc";
            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();
            long beginTime = System.currentTimeMillis();
            System.out.println(beginTime);
            System.out.println("KMP==========:"+KMP_Index(ss, tt)); // KMP匹配字符串
            System.out.println(System.currentTimeMillis());
            long useTime = System.currentTimeMillis()- beginTime;
            System.out.print(useTime);
        }

        /**
         * 获得字符串的next函数值
         *
         * @param t
         *            字符串
         * @return next函数值
         */
        public static int[] next(char[] t) {
            int[] next = new int[t.length];
            next[0] = -1;
            int i = 0;
            int j = -1;
            while (i < t.length - 1) {
                if (j == -1 || t[i] == t[j]) {
                    i++;
                    j++;
                    if (t[i] != t[j]) {
                        next[i] = j;
                    } else {
                        next[i] = next[j];
                    }
                } else {
                    j = next[j];
                }
            }
            return next;
        }

        /**
         * KMP匹配字符串
         *
         * @param s
         *            主串
         * @param t
         *            模式串
         * @return 若匹配成功，返回下标，否则返回-1
         */
        public static int KMP_Index(char[] s, char[] t) {
            int[] next = next(t);
            int i = 0;
            int j = 0;
            while (i <= s.length - 1 && j <= t.length - 1) {
                if (j == -1 || s[i] == t[j]) {
                    i++;
                    j++;
                } else {
                    j = next[j];
                }
            }
            if (j < t.length) {
                return -1;
            } else
                return i - t.length; // 返回模式串在主串中的头下标
        }
    }


