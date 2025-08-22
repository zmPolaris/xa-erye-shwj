package cn.xa.eyre.common.utils;

public class FuzzyMatcher {

    /**
     * 判断字符串a的80%长度个字符是否与字符串b模糊匹配
     *
     * @param a 汉字字符串A
     * @param b 汉字字符串B
     * @return 如果符合模糊匹配标准，则返回true；否则返回false
     */
    public static boolean fuzzyMatch(String a, String b) {
        int lengthA = a.length();
        int matchLength = (int) Math.ceil(lengthA * 0.8); // 向下取整可用 (int)Math.floor
        // 但此处为包含80%长度的所有可能情况，故使用ceil保证长度足够（尽管可能多算几个字符）
        // 若要严格80%且向下取整，则后续遍历需调整上限为 lengthA - (lengthA % (lengthA / 5)) 且 step=lengthA/5（若可整除）
        // 但此处为简化实现，采用ceil方式

        // 遍历a的所有可能子串（长度为matchLength）
        for (int i = 0; i <= lengthA - matchLength; i++) {
            String subStrA = a.substring(i, i + matchLength);
            int matchCount = 0;

            // 检查子串subStrA与字符串b的匹配字符数量
            for (int j = 0; j < subStrA.length(); j++) {
                char charA = subStrA.charAt(j);
                if (b.indexOf(charA) != -1) {
                    matchCount++;
                }
            }

            // 如果匹配字符数量达到matchLength的一定比例（此处简化为50%，可根据需求调整）
            // 或直接判断matchCount >= 所需最小匹配数（根据业务逻辑定义，如固定值或动态计算）
            // 但由于我们要求的是“模糊匹配”，且已基于a的80%长度来确定matchLength
            // 因此此处不再额外设定比例，而是直接检查是否达到matchLength（即认为80%长度内完全匹配即为符合）
            // 若要更灵活的模糊匹配，可引入Levenshtein距离等算法
            if (matchCount == matchLength) { // 严格匹配matchLength个字符
                return true;
            }
            // 若要宽松匹配，可设定一个匹配阈值，如：
            // if (matchCount >= someThreshold) { return true; }
        }

        // 未找到符合条件的子串，返回false
        return false;
    }

    public static void main(String[] args) {
        String a = "支气管炎";// 前置软件描述
        String b = "慢性支气管炎";// 医院系统描述
        boolean result = fuzzyMatch(a, b);
        System.out.println("模糊匹配结果: " + result);
    }
}

