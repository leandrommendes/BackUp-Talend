package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.utils.NodeUtil;

public class TFTPConnectionBeginJava
{
  protected static String nl;
  public static synchronized TFTPConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPConnectionBeginJava result = new TFTPConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.debug(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_8 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_13 = " - Written records count: \" + nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_16 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_19 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Writing the record \" + nb_line_";
  protected final String TEXT_22 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Processing the record \" + nb_line_";
  protected final String TEXT_25 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_27 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_28 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + " ";
  protected final String TEXT_30 = "  " + NL + "  java.util.Properties props_";
  protected final String TEXT_31 = " = System.getProperties();" + NL + "  props_";
  protected final String TEXT_32 = ".put(\"socksProxyPort\", ";
  protected final String TEXT_33 = ");" + NL + "  props_";
  protected final String TEXT_34 = ".put(\"socksProxyHost\", ";
  protected final String TEXT_35 = ");" + NL + "  props_";
  protected final String TEXT_36 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_37 = ");" + NL + "  ";
  protected final String TEXT_38 = " " + NL + "  String decryptedProxyPassword_";
  protected final String TEXT_39 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "  String decryptedProxyPassword_";
  protected final String TEXT_42 = " = ";
  protected final String TEXT_43 = "; ";
  protected final String TEXT_44 = NL + NL + "  props_";
  protected final String TEXT_45 = ".put(\"java.net.socks.password\", decryptedProxyPassword_";
  protected final String TEXT_46 = ");" + NL + "  java.net.Authenticator.setDefault(new java.net.Authenticator() {" + NL + "        public java.net.PasswordAuthentication getPasswordAuthentication() {" + NL + "            return new java.net.PasswordAuthentication(";
  protected final String TEXT_47 = ", decryptedProxyPassword_";
  protected final String TEXT_48 = ".toCharArray());" + NL + "        }" + NL + "  });";
  protected final String TEXT_49 = NL + "\t\tlog.debug(\"";
  protected final String TEXT_50 = " - \" + ";
  protected final String TEXT_51 = ");" + NL + "\t";
  protected final String TEXT_52 = NL + "\tcom.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_53 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "\tftp_";
  protected final String TEXT_54 = ".setRemoteHost(";
  protected final String TEXT_55 = ");" + NL + "\tftp_";
  protected final String TEXT_56 = ".setRemotePort(";
  protected final String TEXT_57 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_58 = NL + "    \tftp_";
  protected final String TEXT_59 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);" + NL + "\t";
  protected final String TEXT_60 = NL + "    \tftp_";
  protected final String TEXT_61 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);" + NL + "\t";
  protected final String TEXT_62 = NL + "\tftp_";
  protected final String TEXT_63 = ".setControlEncoding(";
  protected final String TEXT_64 = ");" + NL + "\t";
  protected final String TEXT_65 = NL + "\t\tlog.info(\"";
  protected final String TEXT_66 = " - Attempt to connect to '\" + ";
  protected final String TEXT_67 = " + \"' with username '\" +";
  protected final String TEXT_68 = "+ \"'.\");" + NL + "\t";
  protected final String TEXT_69 = NL + "\tftp_";
  protected final String TEXT_70 = ".connect();  " + NL + "\t" + NL + "\t";
  protected final String TEXT_71 = " " + NL + "\t\t        " + NL + "\t";
  protected final String TEXT_72 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_73 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_74 = ");";
  protected final String TEXT_75 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_76 = " = ";
  protected final String TEXT_77 = "; ";
  protected final String TEXT_78 = NL + "   \t" + NL + "\tftp_";
  protected final String TEXT_79 = ".login(";
  protected final String TEXT_80 = ", decryptedPassword_";
  protected final String TEXT_81 = ");  " + NL + "  \t";
  protected final String TEXT_82 = NL + "\t\tlog.info(\"";
  protected final String TEXT_83 = " - Connect to '\" + ";
  protected final String TEXT_84 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_85 = NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_86 = "\",ftp_";
  protected final String TEXT_87 = ");";
  protected final String TEXT_88 = NL + "\tclass MyUserInfo implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {" + NL + "\t";
  protected final String TEXT_89 = " " + NL + "      \t\tString decryptedPassphrase_";
  protected final String TEXT_90 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_91 = ");";
  protected final String TEXT_92 = NL + "      \t\tString decryptedPassphrase_";
  protected final String TEXT_93 = " = ";
  protected final String TEXT_94 = "; ";
  protected final String TEXT_95 = NL + NL + "\t\tString passphrase_";
  protected final String TEXT_96 = " = decryptedPassphrase_";
  protected final String TEXT_97 = ";" + NL + "" + NL + "\t\tpublic String getPassphrase() { return passphrase_";
  protected final String TEXT_98 = "; }" + NL + "" + NL + "\t\tpublic String getPassword() { return null; } " + NL + "" + NL + "\t\tpublic boolean promptPassword(String arg0) { return true; } " + NL + "" + NL + "\t\tpublic boolean promptPassphrase(String arg0) { return true; } " + NL + "" + NL + "\t\tpublic boolean promptYesNo(String arg0) { return true; } " + NL + "" + NL + "\t\tpublic void showMessage(String arg0) { } " + NL + "" + NL + "\t\tpublic String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "\t\tboolean[] echo) {" + NL + "\t\t" + NL + "    \t";
  protected final String TEXT_99 = " " + NL + "    \t" + NL + "    \t";
  protected final String TEXT_100 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_101 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_102 = ");";
  protected final String TEXT_103 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_104 = " = ";
  protected final String TEXT_105 = "; ";
  protected final String TEXT_106 = NL + "    \t" + NL + "\t\t\tString[] password_";
  protected final String TEXT_107 = " = {decryptedPassword_";
  protected final String TEXT_108 = "};" + NL + "\t\t\treturn password_";
  protected final String TEXT_109 = ";" + NL + "\t\t}" + NL + "\t};" + NL + "\tfinal com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_110 = " = new MyUserInfo();" + NL + "\tcom.jcraft.jsch.JSch jsch_";
  protected final String TEXT_111 = " = new com.jcraft.jsch.JSch(); " + NL + "" + NL + "\t";
  protected final String TEXT_112 = NL + "\t\t";
  protected final String TEXT_113 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_114 = " - SFTP authentication using a public key.\");" + NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_115 = " - Private key: '\" + ";
  protected final String TEXT_116 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_117 = NL + "\t\tjsch_";
  protected final String TEXT_118 = ".addIdentity(";
  protected final String TEXT_119 = ", defaultUserInfo_";
  protected final String TEXT_120 = ".getPassphrase());" + NL + "\t";
  protected final String TEXT_121 = NL + "\t" + NL + "\tcom.jcraft.jsch.Session session_";
  protected final String TEXT_122 = " = jsch_";
  protected final String TEXT_123 = ".getSession(";
  protected final String TEXT_124 = ", ";
  protected final String TEXT_125 = ", ";
  protected final String TEXT_126 = ");" + NL + "\tsession_";
  protected final String TEXT_127 = ".setConfig(\"PreferredAuthentications\", \"publickey,password,keyboard-interactive,gssapi-with-mic\");" + NL + "\t" + NL + "\t";
  protected final String TEXT_128 = " " + NL + "\t\t";
  protected final String TEXT_129 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_130 = " - SFTP authentication using a password.\");" + NL + "\t\t";
  protected final String TEXT_131 = NL + "\t        " + NL + "\t\t";
  protected final String TEXT_132 = NL + "    \t\t" + NL + "\t\t";
  protected final String TEXT_133 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_134 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_135 = ");";
  protected final String TEXT_136 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_137 = " = ";
  protected final String TEXT_138 = "; ";
  protected final String TEXT_139 = NL + "\t   \t" + NL + "\t\tsession_";
  protected final String TEXT_140 = ".setPassword(decryptedPassword_";
  protected final String TEXT_141 = "); " + NL + "\t";
  protected final String TEXT_142 = NL + NL + "\tsession_";
  protected final String TEXT_143 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_144 = "); " + NL + "\t";
  protected final String TEXT_145 = NL + "\t\tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "\t\t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_146 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "\t\t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "\t\t\t\tproxy_";
  protected final String TEXT_147 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "\t\t\t}" + NL + "\t\t\tsession_";
  protected final String TEXT_148 = ".setProxy(proxy_";
  protected final String TEXT_149 = ");" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_150 = NL + "\t";
  protected final String TEXT_151 = NL + "\t\tlog.info(\"";
  protected final String TEXT_152 = " - Attempt to connect to  '\" + ";
  protected final String TEXT_153 = " + \"' with username '\" + ";
  protected final String TEXT_154 = " + \"'.\");" + NL + "\t";
  protected final String TEXT_155 = NL + "\tsession_";
  protected final String TEXT_156 = ".connect();" + NL + "\tcom.jcraft.jsch. Channel channel_";
  protected final String TEXT_157 = " = session_";
  protected final String TEXT_158 = ".openChannel(\"sftp\"); " + NL + "\tchannel_";
  protected final String TEXT_159 = ".connect();" + NL + "\t";
  protected final String TEXT_160 = NL + "\t\tlog.info(\"";
  protected final String TEXT_161 = " - Connect to '\" + ";
  protected final String TEXT_162 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_163 = NL + "\tcom.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_164 = " = (com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_165 = ";" + NL + "\t" + NL + "\t";
  protected final String TEXT_166 = NL + "\t\tc_";
  protected final String TEXT_167 = ".setFilenameEncoding(";
  protected final String TEXT_168 = ");" + NL + "\t";
  protected final String TEXT_169 = NL + "\t" + NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_170 = "\", c_";
  protected final String TEXT_171 = ");";
  protected final String TEXT_172 = NL + NL + "\t";
  protected final String TEXT_173 = NL + NL + "\tclass MyTrust_";
  protected final String TEXT_174 = " {" + NL + "" + NL + "\t\tprivate javax.net.ssl.TrustManager[] getTrustManagers() " + NL + "\t\tthrows java.security.KeyStoreException, java.security.NoSuchAlgorithmException, " + NL + "\t\t\tjava.security.cert.CertificateException, java.security.UnrecoverableKeyException," + NL + "\t\t\tjava.io.IOException {" + NL + "\t\t\tjava.security.KeyStore ks = java.security.KeyStore.getInstance(\"JKS\");" + NL;
  protected final String TEXT_175 = " " + NL + "\t\t\t\tString decryptedKeyStorePassword_";
  protected final String TEXT_176 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_177 = ");";
  protected final String TEXT_178 = NL + "\t\t\t\tString decryptedKeyStorePassword_";
  protected final String TEXT_179 = " = ";
  protected final String TEXT_180 = "; ";
  protected final String TEXT_181 = NL + "\t\t\tks.load(new java.io.FileInputStream(";
  protected final String TEXT_182 = "), decryptedKeyStorePassword_";
  protected final String TEXT_183 = ".toCharArray());" + NL + "\t\t\tjavax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm());" + NL + "\t\t\ttmf.init(ks);" + NL + "\t\t\treturn tmf.getTrustManagers();" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t\tclass SSLSessionReuseFTPSClient_";
  protected final String TEXT_184 = " extends org.apache.commons.net.ftp.FTPSClient {" + NL + "" + NL + "\t\tpublic SSLSessionReuseFTPSClient_";
  protected final String TEXT_185 = "(boolean isImplicit, javax.net.ssl.SSLContext context) {" + NL + "\t\t\tsuper(isImplicit, context);" + NL + "\t\t}" + NL + "" + NL + "\t\t// changed to support TLS session resumption" + NL + "\t\t@Override" + NL + "\t\tprotected void _prepareDataSocket_(final java.net.Socket socket) throws IOException {" + NL + "\t\t\tif(socket instanceof javax.net.ssl.SSLSocket) {" + NL + "\t\t\t\tfinal javax.net.ssl.SSLSession session = ((javax.net.ssl.SSLSocket) _socket_).getSession();" + NL + "\t\t\t\tfinal javax.net.ssl.SSLSessionContext context = session.getSessionContext();" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tfinal java.lang.reflect.Field sessionHostPortCache = context.getClass().getDeclaredField(\"sessionHostPortCache\");" + NL + "\t\t\t\t\tsessionHostPortCache.setAccessible(true);" + NL + "\t\t\t\t\tfinal Object cache = sessionHostPortCache.get(context);" + NL + "\t\t\t\t\tfinal java.lang.reflect.Method putMethod = cache.getClass().getDeclaredMethod(\"put\", Object.class, Object.class);" + NL + "\t\t\t\t\tputMethod.setAccessible(true);" + NL + "\t\t\t\t\tfinal java.lang.reflect.Method getHostMethod = socket.getClass().getDeclaredMethod(\"getHost\");" + NL + "\t\t\t\t\tgetHostMethod.setAccessible(true);" + NL + "\t\t\t\t\tObject host = getHostMethod.invoke(socket);" + NL + "\t\t\t\t\tfinal String key = String.format(\"%s:%s\", host, String.valueOf(socket.getPort())).toLowerCase(java.util.Locale.ROOT);" + NL + "\t\t\t\t\tputMethod.invoke(cache, key, session);" + NL + "\t\t\t\t} catch(Exception e) {";
  protected final String TEXT_186 = NL + "\t\t\t\t\t\tlog.error(\"Can't adapt ftps client to support TLS session resumption\");";
  protected final String TEXT_187 = NL + "\t\t\t\t\tthrow new RuntimeException(e);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t} " + NL + "\tjavax.net.ssl.SSLContext sslContext_";
  protected final String TEXT_188 = " = null;" + NL + "\tjavax.net.ssl.TrustManager[] trustManager_";
  protected final String TEXT_189 = " = null;" + NL + "\tjavax.net.ssl.SSLSocketFactory sslSocketFactory_";
  protected final String TEXT_190 = " = null;" + NL + "\torg.apache.commons.net.ftp.FTPSClient ftp_";
  protected final String TEXT_191 = " = null;" + NL + "\tMyTrust_";
  protected final String TEXT_192 = " myTrust_";
  protected final String TEXT_193 = " = null;" + NL + "" + NL + "\ttry {" + NL + "\t\tsslContext_";
  protected final String TEXT_194 = " = javax.net.ssl.SSLContext.getInstance(\"SSL\");" + NL + "\t\tmyTrust_";
  protected final String TEXT_195 = " = new MyTrust_";
  protected final String TEXT_196 = "();" + NL + "\t\ttrustManager_";
  protected final String TEXT_197 = " = myTrust_";
  protected final String TEXT_198 = ".getTrustManagers();" + NL + "\t\tsslContext_";
  protected final String TEXT_199 = ".init(null, trustManager_";
  protected final String TEXT_200 = ", new java.security.SecureRandom());" + NL + "\t\tsslSocketFactory_";
  protected final String TEXT_201 = " = sslContext_";
  protected final String TEXT_202 = ".getSocketFactory();" + NL + "\t\tftp_";
  protected final String TEXT_203 = " = new SSLSessionReuseFTPSClient_";
  protected final String TEXT_204 = "(";
  protected final String TEXT_205 = ", sslContext_";
  protected final String TEXT_206 = ");" + NL + "\t\tftp_";
  protected final String TEXT_207 = ".setControlEncoding(";
  protected final String TEXT_208 = ");" + NL + "" + NL + "\t\t";
  protected final String TEXT_209 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_210 = " -FTPS security Mode is ";
  protected final String TEXT_211 = ".\");" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_212 = " - Attempt to connect to '\" + ";
  protected final String TEXT_213 = " + \"' with username '\" + ";
  protected final String TEXT_214 = "+ \"'.\");" + NL + "\t\t";
  protected final String TEXT_215 = NL + "\t\tftp_";
  protected final String TEXT_216 = ".connect(";
  protected final String TEXT_217 = ",";
  protected final String TEXT_218 = ");" + NL + "\t\t";
  protected final String TEXT_219 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_220 = " - Connect to '\" + ";
  protected final String TEXT_221 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_222 = NL + "\t\tftp_";
  protected final String TEXT_223 = ".setRemoteVerificationEnabled(";
  protected final String TEXT_224 = ");" + NL + "\t\t";
  protected final String TEXT_225 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_226 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_227 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_228 = ");";
  protected final String TEXT_229 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_230 = " = ";
  protected final String TEXT_231 = "; ";
  protected final String TEXT_232 = NL + NL + "\t\tboolean isLoginSuccessful_";
  protected final String TEXT_233 = " = ftp_";
  protected final String TEXT_234 = ".login(";
  protected final String TEXT_235 = ", decryptedPassword_";
  protected final String TEXT_236 = ");" + NL + "" + NL + "\t\tif (!isLoginSuccessful_";
  protected final String TEXT_237 = ") {" + NL + "\t\t\tthrow new RuntimeException(\"Login failed\");" + NL + "\t\t}" + NL + "" + NL + "\t\tftp_";
  protected final String TEXT_238 = ".setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);" + NL + "\t\tftp_";
  protected final String TEXT_239 = ".execPROT(";
  protected final String TEXT_240 = ");" + NL + "\t\tftp_";
  protected final String TEXT_241 = ".execPBSZ(";
  protected final String TEXT_242 = ");" + NL + "\t} catch (Exception e) {" + NL + "\t\t";
  protected final String TEXT_243 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_244 = " - Can't create connection: \" + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_245 = NL + "\t\tthrow e;" + NL + "\t}" + NL;
  protected final String TEXT_246 = NL + "\t\tftp_";
  protected final String TEXT_247 = ".enterLocalPassiveMode();";
  protected final String TEXT_248 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_249 = " - Using the passive mode.\");";
  protected final String TEXT_250 = NL + NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_251 = "\", ftp_";
  protected final String TEXT_252 = ");";
  protected final String TEXT_253 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_29);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String host = ElementParameterParser.getValue(node, "__HOST__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String ftpsPort = ElementParameterParser.getValue(node, "__FTPS_PORT__");
String user = ElementParameterParser.getValue(node, "__USER__");
boolean use_encoding = "true".equals(ElementParameterParser.getValue(node, "__USE_ENCODING__"));

String connectMode = ElementParameterParser.getValue(node, "__CONNECT_MODE__");
boolean useProxy = ("true").equals(ElementParameterParser.getValue(node, "__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node, "__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node, "__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node, "__PROXY_USERNAME__");
boolean sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
String authMethod = ElementParameterParser.getValue(node, "__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node, "__PRIVATEKEY__");
boolean ftps = ("true").equals(ElementParameterParser.getValue(node, "__FTPS__"));
String keystoreFile = ElementParameterParser.getValue(node, "__KEYSTORE_FILE__");
String sEncoding = ElementParameterParser.getValue(node, "__ENCODING__");
String securityMode = ElementParameterParser.getValue(node, "__SECURITY_MODE__");
String protectionLevel = ElementParameterParser.getValue(node, "__FTPS_PROT__");
String protectionBufferSize = ElementParameterParser.getValue(node, "__FTPS_PROTECTION_BUFF_SIZE__");
boolean useRemoteVerification = ("true").equals(ElementParameterParser.getValue(node, "__REMOTE_VERIFICATION__"));
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
String passwordFieldName = "";

if (useProxy) {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_37);
    
passwordFieldName = "__PROXY_PASSWORD__";
if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_40);
    } else {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
}

if (!sftp && !ftps) { // *** ftp *** //
  	if(isLog4jEnabled){
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append((("ACTIVE").equals(connectMode))?"\"Using the active mode.\"":"\"Using the passive mode.\"");
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_57);
    if (("ACTIVE").equals(connectMode)) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    } else {
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(sEncoding);
    stringBuffer.append(TEXT_64);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_68);
    }
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    
	passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_71);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_74);
    } else {
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    
} else if (!ftps) { // *** sftp *** //

    stringBuffer.append(TEXT_88);
    
        passwordFieldName = "__PASSPHRASE__";
        if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
        
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_91);
    } else {
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_94);
    }
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    
    	passwordFieldName = "__PASS__";
    	
    stringBuffer.append(TEXT_99);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_102);
    } else {
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_105);
    }
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    if (("PUBLICKEY").equals(authMethod)){
    stringBuffer.append(TEXT_112);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(privateKey);
    stringBuffer.append(TEXT_116);
    }
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    }
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    if (("PASSWORD").equals(authMethod)) {
    stringBuffer.append(TEXT_128);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    }
    stringBuffer.append(TEXT_131);
    
		passwordFieldName = "__PASS__";
		
    stringBuffer.append(TEXT_132);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_135);
    } else {
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_138);
    }
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    }
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    if (!useProxy) {
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    }
    stringBuffer.append(TEXT_150);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_154);
    }
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_162);
    }
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    if(use_encoding) {
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(sEncoding);
    stringBuffer.append(TEXT_168);
    }
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    
} else {  // *** ftps *** //

    stringBuffer.append(TEXT_172);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    
			passwordFieldName = "__KEYSTORE_PASS__";
			if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_177);
    
			} else {

    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_180);
    
			}

    stringBuffer.append(TEXT_181);
    stringBuffer.append(keystoreFile);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    
					if (isLog4jEnabled) {

    stringBuffer.append(TEXT_186);
    
					}

    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append("IMPLICIT".equals(securityMode));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(sEncoding );
    stringBuffer.append(TEXT_208);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(securityMode);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_214);
    }
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(ftpsPort);
    stringBuffer.append(TEXT_218);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_221);
    }
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(useRemoteVerification );
    stringBuffer.append(TEXT_224);
    
		passwordFieldName = "__PASS__";
		
    stringBuffer.append(TEXT_225);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_228);
    } else {
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_231);
    }
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(protectionLevel );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(protectionBufferSize );
    stringBuffer.append(TEXT_242);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    }
    stringBuffer.append(TEXT_245);
    
	if ("PASSIVE".equals(connectMode)) {

    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    
		if (isLog4jEnabled) {

    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    
		}
	}

    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_252);
    
}

    stringBuffer.append(TEXT_253);
    return stringBuffer.toString();
  }
}
