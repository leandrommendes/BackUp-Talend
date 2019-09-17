package org.talend.designer.codegen.translators.databases.dbspecifics.teradata;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.lang.StringBuilder;

public class TTeradataTPumpMainJava
{
  protected static String nl;
  public static synchronized TTeradataTPumpMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataTPumpMainJava result = new TTeradataTPumpMainJava();
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
  protected final String TEXT_29 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_30 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_31 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_33 = " - Uses an existing connection ";
  protected final String TEXT_34 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_36 = " - Uses an existing connection. Connection URL: \" + conn_";
  protected final String TEXT_37 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_39 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_40 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_41 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\tconn_";
  protected final String TEXT_44 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_45 = ", dbUser_";
  protected final String TEXT_46 = ", dbPwd_";
  protected final String TEXT_47 = ");" + NL + "\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\tconn_";
  protected final String TEXT_49 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_50 = ");" + NL + "\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\tconn_";
  protected final String TEXT_52 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\tconn_";
  protected final String TEXT_54 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_55 = NL + "\t\t\tconn_";
  protected final String TEXT_56 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\tconn_";
  protected final String TEXT_58 = ".setAutoCommit(";
  protected final String TEXT_59 = ");" + NL + "\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\tlog.";
  protected final String TEXT_61 = "(\"";
  protected final String TEXT_62 = " - \" + ";
  protected final String TEXT_63 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_64 = NL + "\t    \t\tlog.";
  protected final String TEXT_65 = "(\"";
  protected final String TEXT_66 = "\");" + NL + "\t\t\t";
  protected final String TEXT_67 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_68 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_70 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_71 = ": pstmt_";
  protected final String TEXT_72 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_73 = " += (countEach_";
  protected final String TEXT_74 = " < 0 ? 0 : ";
  protected final String TEXT_75 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_76 = NL + "String tableFullName_";
  protected final String TEXT_77 = " = ";
  protected final String TEXT_78 = " + \".\" + ";
  protected final String TEXT_79 = ";" + NL + "java.io.File file_";
  protected final String TEXT_80 = " = new java.io.File(";
  protected final String TEXT_81 = "+";
  protected final String TEXT_82 = "+";
  protected final String TEXT_83 = "\".script\"";
  protected final String TEXT_84 = "\".scr\"";
  protected final String TEXT_85 = ");" + NL;
  protected final String TEXT_86 = NL + "try{" + NL + "java.io.FileWriter fw_";
  protected final String TEXT_87 = " = new java.io.FileWriter(file_";
  protected final String TEXT_88 = ");" + NL + "StringBuilder script_";
  protected final String TEXT_89 = " = new StringBuilder();";
  protected final String TEXT_90 = NL + "\tfw_";
  protected final String TEXT_91 = ".write(\".LOGTABLE \"+";
  protected final String TEXT_92 = "+\".\"+";
  protected final String TEXT_93 = "+\"_lt;\"+\"";
  protected final String TEXT_94 = "\");";
  protected final String TEXT_95 = NL + "\tfw_";
  protected final String TEXT_96 = ".write(\".LOGTABLE \"+";
  protected final String TEXT_97 = "+\";\"+\"";
  protected final String TEXT_98 = "\");";
  protected final String TEXT_99 = NL + "\t        ";
  protected final String TEXT_100 = NL;
  protected final String TEXT_101 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_102 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_103 = ");";
  protected final String TEXT_104 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_105 = " = ";
  protected final String TEXT_106 = "; ";
  protected final String TEXT_107 = NL + NL + "fw_";
  protected final String TEXT_108 = ".write(\".LOGON \"+";
  protected final String TEXT_109 = "+\"/\"+";
  protected final String TEXT_110 = "+\",\"+decryptedPassword_";
  protected final String TEXT_111 = "+\";\"+\"";
  protected final String TEXT_112 = "\");" + NL;
  protected final String TEXT_113 = NL + "fw_";
  protected final String TEXT_114 = ".write(\".BEGIN LOAD \"+ ";
  protected final String TEXT_115 = " + \";\"+\"";
  protected final String TEXT_116 = "\");" + NL + "fw_";
  protected final String TEXT_117 = ".write(\".LAYOUT customer_layout;\"+\"";
  protected final String TEXT_118 = "\");";
  protected final String TEXT_119 = NL + "fw_";
  protected final String TEXT_120 = ".write(\".FIELD \"+\"";
  protected final String TEXT_121 = "\"+\" * VARCHAR(";
  protected final String TEXT_122 = ");\"+\"";
  protected final String TEXT_123 = "\");";
  protected final String TEXT_124 = NL + "fw_";
  protected final String TEXT_125 = ".write(\".DML LABEL DML_LABEL;\"+\"";
  protected final String TEXT_126 = "\");" + NL;
  protected final String TEXT_127 = NL + "fw_";
  protected final String TEXT_128 = ".write(\"UPDATE \"+tableFullName_";
  protected final String TEXT_129 = "+\" SET \"+\"";
  protected final String TEXT_130 = "\"" + NL + "\t+\" WHERE \"+\"";
  protected final String TEXT_131 = "\"+\";\"+\"";
  protected final String TEXT_132 = "\");";
  protected final String TEXT_133 = NL + "  ";
  protected final String TEXT_134 = NL + "\t\tfw_";
  protected final String TEXT_135 = ".write(\"UPDATE \"+tableFullName_";
  protected final String TEXT_136 = "+\" SET ";
  protected final String TEXT_137 = " WHERE (";
  protected final String TEXT_138 = ") ELSE INSERT INTO \"+tableFullName_";
  protected final String TEXT_139 = "+\" (";
  protected final String TEXT_140 = ") VAlUES(";
  protected final String TEXT_141 = ");";
  protected final String TEXT_142 = "\");";
  protected final String TEXT_143 = NL;
  protected final String TEXT_144 = NL + "fw_";
  protected final String TEXT_145 = ".write(\"INSERT INTO \"+tableFullName_";
  protected final String TEXT_146 = "+\"(\"" + NL + "\t+\"";
  protected final String TEXT_147 = "\"+\") VAlUES(\"+\"";
  protected final String TEXT_148 = "\"+\");\"+\"";
  protected final String TEXT_149 = "\");";
  protected final String TEXT_150 = NL + "fw_";
  protected final String TEXT_151 = ".write(\"DELETE FROM \"+tableFullName_";
  protected final String TEXT_152 = "+\" \"+";
  protected final String TEXT_153 = "+\" ;\"+\"";
  protected final String TEXT_154 = "\");";
  protected final String TEXT_155 = NL;
  protected final String TEXT_156 = NL + "fw_";
  protected final String TEXT_157 = ".write(\".IMPORT INFILE \\\"\"+";
  protected final String TEXT_158 = " +\"\\\"\");" + NL + "fw_";
  protected final String TEXT_159 = ".write(\" FROM 1 FORMAT VARText '\"+";
  protected final String TEXT_160 = "+\"' LAYOUT customer_layout APPLY DML_LABEL;\"+\"";
  protected final String TEXT_161 = "\");" + NL + "fw_";
  protected final String TEXT_162 = ".write(\".END LOAD;\"+\"";
  protected final String TEXT_163 = "\");" + NL + "fw_";
  protected final String TEXT_164 = ".write(\".LOGOFF;\"+\"";
  protected final String TEXT_165 = "\");" + NL;
  protected final String TEXT_166 = NL + "fw_";
  protected final String TEXT_167 = ".close();" + NL;
  protected final String TEXT_168 = NL + "\t\t\tString[] sb_";
  protected final String TEXT_169 = "= {\"cmd\",\"/c\",\"tpump -c \"+";
  protected final String TEXT_170 = "+\" < \\\"\"+";
  protected final String TEXT_171 = "+";
  protected final String TEXT_172 = "+\".script\\\" > \\\"\"+";
  protected final String TEXT_173 = "+\"\\\" 2>&1\"};" + NL + "\t\t";
  protected final String TEXT_174 = NL + "\t\t\tString[] sb_";
  protected final String TEXT_175 = "= {\"sh\",\"-c\",\"tpump -c \"+";
  protected final String TEXT_176 = "+\" < \\\"\"+";
  protected final String TEXT_177 = "+";
  protected final String TEXT_178 = "+\".scr\\\" > \\\"\"+";
  protected final String TEXT_179 = "+\"\\\" 2>&1\"};" + NL + "\t\t";
  protected final String TEXT_180 = NL + "\t\tString[] sb_";
  protected final String TEXT_181 = "= {\"cmd\",\"/c\",\"tpump < \\\"\"+";
  protected final String TEXT_182 = "+";
  protected final String TEXT_183 = "+\".script\\\" > \\\"\"+";
  protected final String TEXT_184 = "+\"\\\" 2>&1\"};" + NL + "\t";
  protected final String TEXT_185 = NL + "\t\tString[] sb_";
  protected final String TEXT_186 = "= {\"sh\",\"-c\",\"tpump < \\\"\"+";
  protected final String TEXT_187 = "+";
  protected final String TEXT_188 = "+\".scr\\\" > \\\"\"+";
  protected final String TEXT_189 = "+\"\\\" 2>&1\"};" + NL + "\t";
  protected final String TEXT_190 = NL + "\tString cmdStr_";
  protected final String TEXT_191 = " = java.util.Arrays.toString(sb_";
  protected final String TEXT_192 = ");" + NL + "    log.info(\"";
  protected final String TEXT_193 = " - Executing command: '\" + cmdStr_";
  protected final String TEXT_194 = " + \"'.\");";
  protected final String TEXT_195 = NL + "final Process process_";
  protected final String TEXT_196 = " = Runtime.getRuntime().exec(sb_";
  protected final String TEXT_197 = "); " + NL + "Thread normal_";
  protected final String TEXT_198 = " = new Thread() {" + NL + "    public void run() {" + NL + "    \ttry {" + NL + "    \t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_199 = ".getInputStream()));" + NL + "    \t\tString line = \"\";" + NL + "    \t\ttry {" + NL + "    \t\t\twhile((line = reader.readLine()) != null) {" + NL + "    \t\t\t   System.out.println(line);" + NL + "    \t        }" + NL + "    \t    } finally {" + NL + "    \t         reader.close();" + NL + "    \t    }" + NL + "        }catch(java.io.IOException ioe) {";
  protected final String TEXT_200 = NL + "    \t\tioe.printStackTrace();" + NL + "    \t}" + NL + "    }" + NL + "};" + NL + "normal_";
  protected final String TEXT_201 = ".start();" + NL + "" + NL + "Thread error_";
  protected final String TEXT_202 = " = new Thread() {" + NL + "\tpublic void run() {" + NL + "\t\ttry {" + NL + "\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_203 = ".getErrorStream()));" + NL + "\t\t\tString line = \"\";" + NL + "\t\t\ttry {" + NL + "\t\t\t\twhile((line = reader.readLine()) != null) {" + NL + "\t\t\t\t\tSystem.err.println(line);" + NL + "\t\t\t\t}" + NL + "\t\t\t} finally {" + NL + "\t\t\t\treader.close();" + NL + "\t\t\t}" + NL + "\t\t} catch(java.io.IOException ioe) {";
  protected final String TEXT_204 = NL + "\t\t   ioe.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "};" + NL + "error_";
  protected final String TEXT_205 = ".start();" + NL + "" + NL + "process_";
  protected final String TEXT_206 = ".waitFor();" + NL + "" + NL + "normal_";
  protected final String TEXT_207 = ".interrupt();" + NL + "" + NL + "error_";
  protected final String TEXT_208 = ".interrupt();" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_209 = "_EXIT_VALUE\", process_";
  protected final String TEXT_210 = ".exitValue());" + NL;
  protected final String TEXT_211 = NL + "\tif(process_";
  protected final String TEXT_212 = ".exitValue()>=";
  protected final String TEXT_213 = ") {" + NL + "\t\tthrow new RuntimeException(\"TPump returned exit code \"+process_";
  protected final String TEXT_214 = ".exitValue());" + NL + "\t}";
  protected final String TEXT_215 = NL + "    log.info(\"";
  protected final String TEXT_216 = " - Excute command:'\" + cmdStr_";
  protected final String TEXT_217 = " + \"' has finished.\");";
  protected final String TEXT_218 = NL + "}finally{" + NL + "\ttry{" + NL + "\t\tfile_";
  protected final String TEXT_219 = ".delete();" + NL + "\t}catch(Exception e_";
  protected final String TEXT_220 = "){";
  protected final String TEXT_221 = NL + "\t}" + NL + "}";
  protected final String TEXT_222 = NL;

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
	
    
	class DefaultLog4jCodeGenerateUtil extends DefaultLog4jFileUtil{

 		String connection = "";
 		boolean hasInit = false;
 		String dataAction ;
 		String dataOperationPrefix;
		String useBatchSize;
		String batchSize;
		String dbSchema;
 		boolean logCommitCounter = false;

		public DefaultLog4jCodeGenerateUtil(){
		}

		public DefaultLog4jCodeGenerateUtil(INode node) {
			super(node);
	    	init();
		}

	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }

		private void init() {
			if(hasInit){
				return;
			}
 			this.cid = node.getUniqueName();
			this.isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			String useConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
			if(useConn == null || "".equals(useConn) || "true".equals(useConn)){
				connection = ElementParameterParser.getValue(node,"__CONNECTION__");
				if(!"".equals(connection)){
					connection = "'" + connection+"' ";
				}
			}
			//for output
			dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
			if(dataAction != null && !("").equals(dataAction)){
				logCommitCounter=true;
			}
			useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
			batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");
			hasInit = true;
		}

		public void debugDriverClassName() {
			logInfo(node,"debug",cid+" - Driver ClassName: \"+driverClass_"+cid+"+\".");
		}

		public void debugConnectionParams(INode node) {
			beforeComponentProcess(node);
			debugDriverClassName();
		}

		public void useExistConnection(INode node){
			useExistConnection(node, true);
		}

		public void useExistConnection(INode node, boolean needUserAndPassword){
			beforeComponentProcess(node);
			if(isLog4jEnabled) {
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    if (cid.contains("tImpala") || cid.contains("tHive")) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_34);
    } else if (!needUserAndPassword){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    } else {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			if ("SSO".equals(ElementParameterParser.getValue(node, "__JDBC_URL__"))){
				connectWithSSO();
			} else {
				connect();
			}
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
			connect_end();
		}
		
		public void connectWithSSO(){
			connect_begin_noUser();
			
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    
			connect_end();
		}

		public void connect_begin(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"' with the username '\" + dbUser_"+cid+" + \"'.");
		}

		public void connect_begin_noUser(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"'.");
		}

		public void connect_end(){
			logInfo(node,"debug",cid+" - Connection to '\" + url_"+cid+" + \"' has succeeded.");
		}

		public void rollback(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection "+connection+"starting to rollback.");
			
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
			commit_end();
		}

		private void commit_begin(){
			if(logCommitCounter){
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit \" + commitCounter_"+cid+"+ \" records.");
			}else{
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit.");
			}
		}
		private void commit_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"commit has succeeded.");
		}

		public void close(INode node){
			beforeComponentProcess(node);
			close();
		}

		private void close(){
			close_begin();
			
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
			close_end();
		}

		public void close_begin(){
			logInfo(node,"debug",cid+" - Closing the connection "+connection+"to the database.");
		}
		public void close_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"to the database closed.");
		}

		public void autoCommit(INode node,boolean autoCommit){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection is set auto commit to '"+autoCommit+"'.");
			
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_59);
    
		}

		public void query(INode node){
			beforeComponentProcess(node);
			//for input
	 		String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
			logInfo(node,"debug",cid+" - Executing the query: '\" + "+dbquery +" + \"'.");
		}

		public void retrieveRecordsCount(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Retrieved records count: \"+nb_line_"+cid+" + \" .");
		}

		public void logError(INode node,String logLevel,String exception){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_60);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_63);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_64);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_66);
    
			}
	    }
		/**
		*batchType :
		*			1: do not get return value of executeBatch();
		*			2: get return value of executeBatch();
		*
		*/
		public void executeBatch(INode node,int batchType){
			beforeComponentProcess(node);
			boolean logBatch = ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize);
			if(logBatch){
				logInfo(node,"debug",cid+" - Executing the "+dataAction+" batch.");
			}
			if(batchType==1){
			
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_75);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String dbhost= ElementParameterParser.getValue(node, "__HOST__");
String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
String dbuser= ElementParameterParser.getValue(node, "__USER__");

String table= ElementParameterParser.getValue(node, "__TABLE__");

String scriptPath= ElementParameterParser.getValue(node, "__SCRIPT_PATH__");
String execution= ElementParameterParser.getValue(node, "__EXECUTION__");
String action= ElementParameterParser.getValue(node, "__ACTION__");
String where= ElementParameterParser.getValue(node, "__WHERE__");
String loadFile= ElementParameterParser.getValue(node, "__LOAD_FILE__");
String separator= ElementParameterParser.getValue(node, "__FIELD_SEPARATOR__");
String errorFile= ElementParameterParser.getValue(node, "__ERROR_FILE__");
String beginLoad= ElementParameterParser.getValue(node, "__BEGINLOAD_ADVANCEDPARAM__");
boolean returnCodeDie= ElementParameterParser.getValue(node, "__RETURN_CODE_DIE__").equals("true");
String returnCode= ElementParameterParser.getValue(node, "__RETURN_CODE__");
boolean specifyLogTable= ElementParameterParser.getValue(node, "__SPECIFY_LOG_TABLE__").equals("true");
String logTable= ElementParameterParser.getValue(node, "__LOG_TABLE_TABLE__");

String defineCharset = ElementParameterParser.getValue(node, "__DEFINE_CHARSET__");
String charset = ElementParameterParser.getValue(node, "__CHARSET__");
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
//windows line separator as default
String lineSeparator = "\\r\\n";
if("Unix".equals(execution)){
	lineSeparator = "\\n";
}
if(!scriptPath.endsWith("/\"")){
	scriptPath = scriptPath+	"+\"/\"";
}
if(loadFile.indexOf("/") !=0 && ("Windows").equals(execution)){
	loadFile = loadFile.replaceAll("/", "\\\\\\\\");
}

String dbmsId = "teradata_id";

List<IMetadataColumn> columnList = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		columnList = metadata.getListColumns();
	}
}

    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_82);
    if("Windows".equals(execution)){
    stringBuffer.append(TEXT_83);
    }else{
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    //build script---------------------------------------------------------
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
if(!specifyLogTable) {

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_94);
    
} else {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(logTable);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_98);
    
}

    stringBuffer.append(TEXT_99);
    
String passwordFieldName = "__PASS__";

    stringBuffer.append(TEXT_100);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_103);
    } else {
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_106);
    }
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    if(dbhost!=null && !"\"\"".equals(dbhost)){
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_112);
    //Layout---------------------------------------------------------------
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(beginLoad );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_118);
    
if(columnList!=null){
	for(IMetadataColumn column:columnList){	

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(column.getLength() == null ? 0 : column.getLength());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_123);
    
	}
}

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_126);
    //SQL statements-------------------------------------------------------
    
StringBuilder updateSetSQL = new StringBuilder();
StringBuilder updateWhereSQL = new StringBuilder();
StringBuilder insertColSQL = new StringBuilder();
StringBuilder insertValueSQL = new StringBuilder();
if(columnList!=null){
	String columnName = "";
 	for(IMetadataColumn column:columnList){	
 		columnName= column.getOriginalDbColumnName();
 		if(insertColSQL.length()>0){
 			insertColSQL.append(",");
 		}
 		insertColSQL.append(columnName);
 		
 		if(insertValueSQL.length()>0){
 			insertValueSQL.append(",");
 		}
 		insertValueSQL.append(":").append(columnName);
 		
 		if(column.isKey()){
 			if(updateWhereSQL.length()>0){
     			updateWhereSQL.append(" AND ");
     		}
     		updateWhereSQL.append(columnName).append("=:").append(columnName);
 		}else{
     		if(updateSetSQL.length()>0){
     			updateSetSQL.append(",");
     		}
     		updateSetSQL.append(columnName).append("=:").append(columnName);
 		}
	}
}
if(("Update").equals(action)){

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(updateSetSQL.toString());
    stringBuffer.append(TEXT_130);
    stringBuffer.append(updateWhereSQL);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_132);
    
}
    stringBuffer.append(TEXT_133);
     if(("InsertOrUpdate").equals(action)){ 
    stringBuffer.append(TEXT_134);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(updateSetSQL.toString());
    stringBuffer.append(TEXT_137);
    stringBuffer.append(updateWhereSQL);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(insertColSQL);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(insertValueSQL.toString());
    stringBuffer.append(TEXT_141);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_142);
     } 
    stringBuffer.append(TEXT_143);
    
if(("Insert").equals(action)){

    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(insertColSQL);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(insertValueSQL.toString());
    stringBuffer.append(TEXT_148);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_149);
    
}
if(("Delete").equals(action)){

    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(where);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_154);
    
}

    stringBuffer.append(TEXT_155);
    //Import file----------------------------------------------------------
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(loadFile);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_165);
    //write script to file-------------------------------------------------
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    //run tPump command----------------------------------------------------
    if("true".equals(defineCharset)) {
	if(!("".equals(charset))) {
		if("Windows".equals(execution)){
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(charset);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_173);
    }else{
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append( charset);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_179);
    }
	}
} else {
	if("Windows".equals(execution)){
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_184);
    }else{
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_189);
    }
}
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_190);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_194);
    }
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    log4jCodeGenerateUtil.logError(node,"error","ioe");
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    log4jCodeGenerateUtil.logError(node,"error","ioe");
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    
if(returnCodeDie) {

    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(returnCode);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    	
}

    if(isLog4jEnabled){
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_217);
    }
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    log4jCodeGenerateUtil.logError(node,"warn","e_"+cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(TEXT_222);
    return stringBuffer.toString();
  }
}
