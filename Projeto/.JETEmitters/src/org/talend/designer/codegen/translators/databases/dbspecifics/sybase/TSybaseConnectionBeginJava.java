package org.talend.designer.codegen.translators.databases.dbspecifics.sybase;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSybaseConnectionBeginJava
{
  protected static String nl;
  public static synchronized TSybaseConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSybaseConnectionBeginJava result = new TSybaseConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\tString driverClass_";
  protected final String TEXT_2 = " = \"";
  protected final String TEXT_3 = "\";" + NL + "\t\t\tjava.lang.Class.forName(driverClass_";
  protected final String TEXT_4 = ");";
  protected final String TEXT_5 = NL + "\t\t\tSharedDBConnectionLog4j.initLogger(log,\"";
  protected final String TEXT_6 = "\");";
  protected final String TEXT_7 = NL + "\t\t\tString sharedConnectionName_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ";" + NL + "\t\t\tconn_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ".getDBConnection(\"";
  protected final String TEXT_12 = "\",url_";
  protected final String TEXT_13 = ",dbUser_";
  protected final String TEXT_14 = " , dbPwd_";
  protected final String TEXT_15 = " , sharedConnectionName_";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "\t\t\t\tconn_";
  protected final String TEXT_18 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_19 = ",dbUser_";
  protected final String TEXT_20 = ",dbPwd_";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\t\t\t\tconn_";
  protected final String TEXT_23 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_26 = " - Connection is set auto commit to '";
  protected final String TEXT_27 = "'.\");";
  protected final String TEXT_28 = NL + "\t\t\tconn_";
  protected final String TEXT_29 = ".setAutoCommit(";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "\t\tString url_";
  protected final String TEXT_32 = " = \"jdbc:sqlanywhere:Host=\" + ";
  protected final String TEXT_33 = " + \":\" + ";
  protected final String TEXT_34 = " + \";DatabaseName=\" + ";
  protected final String TEXT_35 = "; ";
  protected final String TEXT_36 = NL + "\t\tString url_";
  protected final String TEXT_37 = " = \"jdbc:sqlanywhere:Host=\" + ";
  protected final String TEXT_38 = " + \":\" + ";
  protected final String TEXT_39 = " + \";DatabaseName\" + ";
  protected final String TEXT_40 = " + \";\" + ";
  protected final String TEXT_41 = ";";
  protected final String TEXT_42 = NL + "\t\tString url_";
  protected final String TEXT_43 = " = \"jdbc:sybase:Tds:\" + ";
  protected final String TEXT_44 = " + \":\" + ";
  protected final String TEXT_45 = " + \"/\" + ";
  protected final String TEXT_46 = "; ";
  protected final String TEXT_47 = NL + "\t\tString url_";
  protected final String TEXT_48 = " = \"jdbc:sybase:Tds:\" + ";
  protected final String TEXT_49 = " + \":\" + ";
  protected final String TEXT_50 = " + \"/\" + ";
  protected final String TEXT_51 = " + \"?\" + ";
  protected final String TEXT_52 = ";";
  protected final String TEXT_53 = NL + NL + "\t";
  protected final String TEXT_54 = NL + "\t\tString dbUser_";
  protected final String TEXT_55 = " = ";
  protected final String TEXT_56 = ";";
  protected final String TEXT_57 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_58 = NL + "\t\t\tString dbPwd_";
  protected final String TEXT_59 = " = null;" + NL + "\t\t";
  protected final String TEXT_60 = NL + "\t\t\t";
  protected final String TEXT_61 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_62 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_65 = " = ";
  protected final String TEXT_66 = "; ";
  protected final String TEXT_67 = NL + "\t\t\tString dbPwd_";
  protected final String TEXT_68 = " = decryptedPassword_";
  protected final String TEXT_69 = ";" + NL + "\t\t";
  protected final String TEXT_70 = NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_71 = " = null;" + NL + "\t";
  protected final String TEXT_72 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_73 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_75 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_76 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_78 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_79 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_80 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_81 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_82 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_84 = " - Written records count: \" + nb_line_";
  protected final String TEXT_85 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_87 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_89 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_90 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_91 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_92 = " - Writing the record \" + nb_line_";
  protected final String TEXT_93 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_95 = " - Processing the record \" + nb_line_";
  protected final String TEXT_96 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_97 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_98 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_99 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_100 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_101 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_102 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_103 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_104 = " - Uses an existing connection ";
  protected final String TEXT_105 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_106 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_107 = " - Uses an existing connection. Connection URL: \" + conn_";
  protected final String TEXT_108 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_109 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_110 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_111 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_112 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_113 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_114 = NL + "\t\t\tconn_";
  protected final String TEXT_115 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_116 = ", dbUser_";
  protected final String TEXT_117 = ", dbPwd_";
  protected final String TEXT_118 = ");" + NL + "\t\t\t";
  protected final String TEXT_119 = NL + "\t\t\tconn_";
  protected final String TEXT_120 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_121 = ");" + NL + "\t\t\t";
  protected final String TEXT_122 = NL + "\t\t\tconn_";
  protected final String TEXT_123 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_124 = NL + "\t\t\tconn_";
  protected final String TEXT_125 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_126 = NL + "\t\t\tconn_";
  protected final String TEXT_127 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_128 = NL + "\t\t\t\tconn_";
  protected final String TEXT_129 = ".setAutoCommit(";
  protected final String TEXT_130 = ");" + NL + "\t\t\t";
  protected final String TEXT_131 = NL + "\t\t\t\tlog.";
  protected final String TEXT_132 = "(\"";
  protected final String TEXT_133 = " - \" + ";
  protected final String TEXT_134 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_135 = NL + "\t    \t\tlog.";
  protected final String TEXT_136 = "(\"";
  protected final String TEXT_137 = "\");" + NL + "\t\t\t";
  protected final String TEXT_138 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_139 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_140 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_141 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_142 = ": pstmt_";
  protected final String TEXT_143 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_144 = " += (countEach_";
  protected final String TEXT_145 = " < 0 ? 0 : ";
  protected final String TEXT_146 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_147 = NL + "\t";
  protected final String TEXT_148 = NL + "\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_149 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\tif (dataSources_";
  protected final String TEXT_150 = " == null) {";
  protected final String TEXT_151 = NL + "\t\t";
  protected final String TEXT_152 = NL + "\t\t";
  protected final String TEXT_153 = NL + NL + "\t\tglobalMap.put(\"conn_";
  protected final String TEXT_154 = "\", conn_";
  protected final String TEXT_155 = ");";
  protected final String TEXT_156 = NL + "\t} else {" + NL + "\t\tString dsAlias_";
  protected final String TEXT_157 = " = ";
  protected final String TEXT_158 = ";" + NL + "\t\tif (dataSources_";
  protected final String TEXT_159 = ".get(dsAlias_";
  protected final String TEXT_160 = ") == null) {" + NL + "   \t\t\tthrow new Exception(\"No DataSource with alias: \" + dsAlias_";
  protected final String TEXT_161 = " + \" available!\");" + NL + "      \t}" + NL + "\t\tconn_";
  protected final String TEXT_162 = " = dataSources_";
  protected final String TEXT_163 = ".get(dsAlias_";
  protected final String TEXT_164 = ").getConnection();" + NL + "\t\tglobalMap.put(\"conn_";
  protected final String TEXT_165 = "\", conn_";
  protected final String TEXT_166 = ");" + NL + "\t}";
  protected final String TEXT_167 = NL + "\tif (null != conn_";
  protected final String TEXT_168 = ") {" + NL + "\t\t";
  protected final String TEXT_169 = NL + "\t}";
  protected final String TEXT_170 = NL + "\t" + NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_171 = "\", conn_";
  protected final String TEXT_172 = ");" + NL + "\tglobalMap.put(\"host_";
  protected final String TEXT_173 = "\", ";
  protected final String TEXT_174 = ");" + NL + "\tglobalMap.put(\"port_";
  protected final String TEXT_175 = "\", ";
  protected final String TEXT_176 = ");" + NL + "\tglobalMap.put(\"db_";
  protected final String TEXT_177 = "\", ";
  protected final String TEXT_178 = ");" + NL + "\tglobalMap.put(\"user_";
  protected final String TEXT_179 = "\", ";
  protected final String TEXT_180 = ");" + NL + "\tglobalMap.put(\"pass_";
  protected final String TEXT_181 = "\", dbPwd_";
  protected final String TEXT_182 = ");" + NL + "\tglobalMap.put(\"dbschema_";
  protected final String TEXT_183 = "\", ";
  protected final String TEXT_184 = ");";
  protected final String TEXT_185 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	class DefaultConnectionUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
	    protected String dbport;
	    protected String dbname;
	    protected boolean isLog4jEnabled;
	    
	    public void beforeComponentProcess(INode node){
	    }
	    
		public void createURL(INode node) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		}
		
		public String getDirverClassName(INode node){
			return "";
		}
		
		public void classForName(INode node){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
		}
		
		//for example, postgresql jdbc and redshift jdbc both can process the url : jdbc:postgresql://, 
		//we need to adjust the register order to make sure to use postgresql jdbc to process it
		public void adjustDriverRegisterOrderForConflcit() {
		
		}
		
		public void useShareConnection(INode node) {
			String sharedConnectionName = ElementParameterParser.getValue(node, "__SHARED_CONNECTION_NAME__");
			String shareDBClass = "SharedDBConnection";
			if(isLog4jEnabled){
				shareDBClass = "SharedDBConnectionLog4j";

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(sharedConnectionName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(shareDBClass);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
		}
		
		public void createConnection(INode node) {
			this.createConnection(node, true);
		}

		public void createConnection(INode node, boolean needUserAndPassword) {
    			if(needUserAndPassword){
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    			} else {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    			}
		}

		public void setAutoCommit(INode node) {
			boolean setAutoCommit = "true".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_27);
    
			}

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_30);
    
		}
		
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultUtil class
	
	DefaultConnectionUtil connUtil = new DefaultConnectionUtil();

    
	class ConnectionUtil extends DefaultConnectionUtil{
	
		public void createURL(INode node) {
			super.createURL(node);
		    String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__") ;
			if("SYBSEIQ_16_SA".equals(dbVersion)){
				if(dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(dbhost );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(dbport );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(dbname );
    stringBuffer.append(TEXT_35);
    
				}
				else{

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(dbhost );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(dbport );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(dbname );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_41);
    
				}
			}
			else {

    
				if(dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(dbhost );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(dbport );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(dbname );
    stringBuffer.append(TEXT_46);
    
				} else {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(dbhost );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(dbport );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(dbname );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_52);
    
				}

    	
			}
		}
	
		public String getDirverClassName(INode node){
		        String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__") ;
			if("SYBSEIQ_16_SA".equals(dbVersion)){
                            return "sap.jdbc4.sqlanywhere.IDriver";
			}
			else if("SYBSEIQ_16".equals(dbVersion)){
			    return "com.sybase.jdbc4.jdbc.SybDriver";
			}else{
			    return "com.sybase.jdbc3.jdbc.SybDriver";
			}
		}
		
	}//end class
	connUtil = new ConnectionUtil();

    //----------------------------component codes-----------------------------------------
    stringBuffer.append(TEXT_53);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    String dbport = ElementParameterParser.getValue(node, "__PORT__");
    String dbschema = ElementParameterParser.getValue(node, "__DB_SCHEMA__");
    if(dbschema == null||dbschema.trim().length()==0) {
    	 dbschema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
    }
    String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
    String dbuser = ElementParameterParser.getValue(node, "__USER__");
    String dbpass = ElementParameterParser.getValue(node, "__PASS__");
    String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
    
	boolean isUseSharedConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_SHARED_CONNECTION__"));

    
	connUtil.beforeComponentProcess(node);
	connUtil.createURL(node);

    
	if (!"SSO".equals(ElementParameterParser.getValue(node, "__JDBC_URL__"))){

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append((dbuser != null && dbuser.trim().length() == 0)? "null":dbuser);
    stringBuffer.append(TEXT_56);
    //the tSQLiteConnection component not contain user and pass return null
    stringBuffer.append(TEXT_57);
    if(dbpass != null && dbpass.trim().length() == 0) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    } else {
			String passwordFieldName = "__PASS__";
		
    stringBuffer.append(TEXT_60);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_63);
    } else {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    }
    
	}

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
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
			
    stringBuffer.append(TEXT_72);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_73);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_74);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_77);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_80);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_83);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_88);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_90);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_91);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_94);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_97);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    
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
			
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    if (cid.contains("tImpala") || cid.contains("tHive")) {
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_105);
    } else if (!needUserAndPassword){
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    } else {
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    }
    stringBuffer.append(TEXT_113);
    
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
			
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    
			connect_end();
		}
		
		public void connectWithSSO(){
			connect_begin_noUser();
			
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    
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
			
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    
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
			
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    
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
			
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_130);
    
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
	    	
    stringBuffer.append(TEXT_131);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_134);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_135);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_137);
    
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
			
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_146);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    
	connUtil.adjustDriverRegisterOrderForConflcit();
	
	if(isUseSharedConnection){

    stringBuffer.append(TEXT_147);
    connUtil.useShareConnection(node);
    
	} else {
		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
		if(specify_alias){

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    
		}

    stringBuffer.append(TEXT_151);
    connUtil.classForName(node);
    stringBuffer.append(TEXT_152);
    
		log4jCodeGenerateUtil.debugConnectionParams(node);
		if ("SSO".equals(ElementParameterParser.getValue(node, "__JDBC_URL__"))){
			log4jCodeGenerateUtil.connect_begin_noUser();
			connUtil.createConnection(node, false);
		} else {
			log4jCodeGenerateUtil.connect_begin();
			connUtil.createConnection(node);
		}
		
		log4jCodeGenerateUtil.connect_end();
		
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    
		if(specify_alias){
			String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
		}
	}

    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    connUtil.setAutoCommit(node);
    stringBuffer.append(TEXT_169);
    
	connUtil.afterComponentProcess(node);

    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(TEXT_185);
    return stringBuffer.toString();
  }
}
