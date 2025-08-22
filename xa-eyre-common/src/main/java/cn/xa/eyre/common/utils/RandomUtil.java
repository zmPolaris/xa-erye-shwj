package cn.xa.eyre.common.utils;


import java.util.Random;

public class RandomUtil {
	private static Random rand;
	static{
		rand=new Random();
	}
	
	public static int randomInt(int seed){
		Random r = new Random();
		return r.nextInt(seed);
	}
	// 返回一个当前时间+随机数
	public static String randomByTime(int seed){
		Random r = new Random();
		return DateUtils.dateTimeNow()+ String.valueOf(r.nextInt(seed));
	}

	/**
	 * 随机获取指定位数纯数字字符串
	 * @return
	 */
	public static String getNumbers(int number){
		String str="";
		for(int i=0;i<number;i++){
			str+=getRadomInt(0, 9);
		}
		return str;
	}
	/**
	 * 获取一个范围内的随机数字
	 * @return
	 */
	public static int getRadomInt(int min,int max){
		return rand.nextInt(max-min+1)+min;
	}


	/**
	 * 生成英文加中文随机数
	 * @param length
	 * @return
	 */
	public static String generateRandomNumber(int length) {
		String val = "";
		Random random = new Random();
		// 参数length，表示生成几位随机数
		for (int i = 0; i < length; i++) {
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 输出字母还是数字
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 输出是大写字母还是小写字母
				int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (random.nextInt(26) + temp);
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
}
