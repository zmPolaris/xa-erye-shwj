package cn.xa.eyre.common.security;


import cn.hutool.core.codec.Base64Encoder;
import cn.xa.eyre.common.utils.StringUtils;

public class SM3Digest {
	 /** SM3值的长度 */  
   private static final int BYTE_LENGTH = 32;  
     
   /** SM3分组长度 */  
   private static final int BLOCK_LENGTH = 64;  
     
   /** 缓冲区长度 */  
   private static final int BUFFER_LENGTH = BLOCK_LENGTH * 1;  
     
   /** 缓冲区 */  
   private byte[] xBuf = new byte[BUFFER_LENGTH];  
     
   /** 缓冲区偏移量 */  
   private int xBufOff;  
     
   /** 初始向量 */  
   private byte[] V = SM3.iv.clone();
     
   private int cntBlock = 0;  
 
   public SM3Digest() {  
   }  
 
   public SM3Digest(SM3Digest t)  
   {  
       System.arraycopy(t.xBuf, 0, this.xBuf, 0, t.xBuf.length);  
       this.xBufOff = t.xBufOff;  
       System.arraycopy(t.V, 0, this.V, 0, t.V.length);  
   }  
     
   /** 
    * SM3结果输出 
    *  
    * @param out 保存SM3结构的缓冲区 
    * @param outOff 缓冲区偏移量 
    * @return 
    */  
   public int doFinal(byte[] out, int outOff)   
   {  
       byte[] tmp = doFinal();  
       System.arraycopy(tmp, 0, out, 0, tmp.length);  
       return BYTE_LENGTH;  
   }  
 
   public void reset()   
   {  
       xBufOff = 0;  
       cntBlock = 0;  
       V = SM3.iv.clone();  
   }  
 
   /** 
    * 明文输入 
    *  
    * @param in 
    *            明文输入缓冲区 
    * @param inOff 
    *            缓冲区偏移量 
    * @param len 
    *            明文长度 
    */  
   public void update(byte[] in, int inOff, int len)  
   {  
       int partLen = BUFFER_LENGTH - xBufOff;  
       int inputLen = len;  
       int dPos = inOff;  
       if (partLen < inputLen)   
       {  
           System.arraycopy(in, dPos, xBuf, xBufOff, partLen);  
           inputLen -= partLen;  
           dPos += partLen;  
           doUpdate();  
           while (inputLen > BUFFER_LENGTH)   
           {  
               System.arraycopy(in, dPos, xBuf, 0, BUFFER_LENGTH);  
               inputLen -= BUFFER_LENGTH;  
               dPos += BUFFER_LENGTH;  
               doUpdate();  
           }  
       }  
 
       System.arraycopy(in, dPos, xBuf, xBufOff, inputLen);  
       xBufOff += inputLen;  
   }  
 
   private void doUpdate()   
   {  
       byte[] B = new byte[BLOCK_LENGTH];  
       for (int i = 0; i < BUFFER_LENGTH; i += BLOCK_LENGTH)   
       {  
           System.arraycopy(xBuf, i, B, 0, B.length);  
           doHash(B);  
       }  
       xBufOff = 0;  
   }  
 
   private void doHash(byte[] B)  
   {  
       byte[] tmp = SM3.CF(V, B);  
       System.arraycopy(tmp, 0, V, 0, V.length);  
       cntBlock++;  
   }  
 
   private byte[] doFinal()   
   {  
       byte[] B = new byte[BLOCK_LENGTH];  
       byte[] buffer = new byte[xBufOff];  
       System.arraycopy(xBuf, 0, buffer, 0, buffer.length);  
       byte[] tmp = SM3.padding(buffer, cntBlock);  
       for (int i = 0; i < tmp.length; i += BLOCK_LENGTH)  
       {  
           System.arraycopy(tmp, i, B, 0, B.length);  
           doHash(B);  
       }  
       return V;  
   }  
 
   public void update(byte in)   
   {  
       byte[] buffer = new byte[] { in };  
       update(buffer, 0, 1);  
   }  
     
   public int getDigestSize()   
   {  
       return BYTE_LENGTH;  
   }  
     
   public static String sm3(String text){
	   byte[] md = new byte[32];  
	   byte[] msg1 = text.getBytes();
	   SM3Digest sm3 = new SM3Digest();  
       sm3.update(msg1, 0, msg1.length);  
       sm3.doFinal(md, 0);  
       return  new String(new Base64Encoder().encode(md));
   }
   
   public static String sm3Hex(String text){
	   byte[] md = new byte[32];  
	   byte[] msg1 = text.getBytes();
	   SM3Digest sm3 = new SM3Digest();  
       sm3.update(msg1, 0, msg1.length);  
       sm3.doFinal(md, 0);  
       return StringUtils.bytesToHex(md);
       //return  Hex.bytesToHexString(md);
   }
   
   public String getSM3(byte[] bytes) {
       SM3Digest digest = new SM3Digest();
       digest.update(bytes, 0, bytes.length);
       byte[] out = new byte[32];
       digest.doFinal(out, 0);
       StringBuffer sb = new StringBuffer();
       for (int i = 0; i < out.length; i++) {
           String hex = Integer.toHexString(out[i] & 0xFF);
           if (hex.length() < 2) {
               sb.append(0);
           }
           sb.append(hex);
       }
       return sb.toString();
   }
   
   public static void main(String[] args)   
   {  
//       byte[] md = new byte[32];
//       byte[] msg1 = "ererfeiisgod".getBytes();
//       SM3Digest sm3 = new SM3Digest();
//       sm3.update(msg1, 0, msg1.length);
//       sm3.doFinal(md, 0);
//     //  String s = new String(Hex.encode(md));
//       String s = new String(new Base64Encoder().encode(md));
//       System.out.println(s.toUpperCase());
       String hex = sm3Hex("c2d08bb2-43df-4614-bd3c-12a57fa0a1b1_20210322092414_31353835373033373432353630333834");
       System.out.println(hex);
   }  
}