package org.talend.designer.codegen.translators.databasesnosql.mongodb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.Map;

public class TMongoDBGridFSPutBeginJava
{
  protected static String nl;
  public static synchronized TMongoDBGridFSPutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBGridFSPutBeginJava result = new TMongoDBGridFSPutBeginJava();
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
  protected final String TEXT_29 = NL + "\t    ";
  protected final String TEXT_30 = NL + "\t\t\tjava.util.logging.Logger.getLogger(\"org.mongodb.driver\").setLevel(java.util.logging.Level.OFF);" + NL + "\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\tjava.util.logging.Logger.getLogger(\"org.mongodb.driver\").setLevel(java.util.logging.Level.SEVERE);";
  protected final String TEXT_32 = NL + "            int nb_line_";
  protected final String TEXT_33 = " = 0;" + NL + "\t\t";
  protected final String TEXT_34 = NL + "\t\t\tcom.mongodb.MongoClient mongo_";
  protected final String TEXT_35 = "=null;" + NL + "\t\t\tcom.mongodb.client.MongoDatabase db_";
  protected final String TEXT_36 = "=null;" + NL + "\t\t";
  protected final String TEXT_37 = NL + "\t\t\tcom.mongodb.Mongo mongo_";
  protected final String TEXT_38 = "=null;" + NL + "\t\t\tcom.mongodb.DB db_";
  protected final String TEXT_39 = "=null;" + NL + "\t\t";
  protected final String TEXT_40 = NL + "\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t\t\tmongo_";
  protected final String TEXT_43 = "=(com.mongodb.MongoClient)globalMap.get(\"mongo_";
  protected final String TEXT_44 = "\");" + NL + "\t\t\t\t\t\tdb_";
  protected final String TEXT_45 = " = (com.mongodb.client.MongoDatabase) globalMap.get(\"db_";
  protected final String TEXT_46 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\t\tmongo_";
  protected final String TEXT_48 = "=(com.mongodb.Mongo)globalMap.get(\"mongo_";
  protected final String TEXT_49 = "\");" + NL + "\t\t\t\t\t\tdb_";
  protected final String TEXT_50 = " = (com.mongodb.DB) globalMap.get(\"db_";
  protected final String TEXT_51 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\t";
  protected final String TEXT_53 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_54 = " - Get an existing client from \" + \"";
  protected final String TEXT_55 = "\" + \".\");" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_56 = " - Get an existing DB from \" + \"";
  protected final String TEXT_57 = "\" + \".\");" + NL + "\t\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\ttry{ // link with the \"finally\" on the \"finally.javajet\"" + NL + "\t\t\t\t";
  protected final String TEXT_59 = NL + NL + "                // Empty client options" + NL + "                com.mongodb.MongoClientOptions clientOptions_";
  protected final String TEXT_60 = " = new com.mongodb.MongoClientOptions.Builder().build();";
  protected final String TEXT_61 = NL + "                    clientOptions_";
  protected final String TEXT_62 = " = new com.mongodb.MongoClientOptions.Builder()" + NL + "                    .socketFactory(javax.net.ssl.SSLSocketFactory.getDefault())" + NL + "                    .build();";
  protected final String TEXT_63 = NL + "                // Empty client credentials list" + NL + "                java.util.List<com.mongodb.MongoCredential> mongoCredentialList_";
  protected final String TEXT_64 = " = new java.util.ArrayList<com.mongodb.MongoCredential>();" + NL;
  protected final String TEXT_65 = NL + "                    com.mongodb.MongoCredential mongoCredential_";
  protected final String TEXT_66 = ";";
  protected final String TEXT_67 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_68 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_69 = ");";
  protected final String TEXT_70 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_71 = " = ";
  protected final String TEXT_72 = "; ";
  protected final String TEXT_73 = NL + "                    \t\t\tmongoCredential_";
  protected final String TEXT_74 = " = com.mongodb.MongoCredential.createCredential(";
  protected final String TEXT_75 = ", ";
  protected final String TEXT_76 = ", new String(decryptedPassword_";
  protected final String TEXT_77 = ").toCharArray());";
  protected final String TEXT_78 = NL + "                    \t\t\tmongoCredential_";
  protected final String TEXT_79 = " = com.mongodb.MongoCredential.createMongoCRCredential(";
  protected final String TEXT_80 = ", ";
  protected final String TEXT_81 = ", new String(decryptedPassword_";
  protected final String TEXT_82 = ").toCharArray());";
  protected final String TEXT_83 = NL + "                            mongoCredential_";
  protected final String TEXT_84 = " = com.mongodb.MongoCredential.createPlainCredential(";
  protected final String TEXT_85 = ", \"$external\", new String(decryptedPassword_";
  protected final String TEXT_86 = ").toCharArray());";
  protected final String TEXT_87 = NL + "                            mongoCredential_";
  protected final String TEXT_88 = " = com.mongodb.MongoCredential.createScramSha1Credential(";
  protected final String TEXT_89 = ", ";
  protected final String TEXT_90 = ", new String(decryptedPassword_";
  protected final String TEXT_91 = ").toCharArray());";
  protected final String TEXT_92 = NL + "                        System.setProperty(\"java.security.krb5.realm\", ";
  protected final String TEXT_93 = ");" + NL + "                        System.setProperty(\"java.security.krb5.kdc\", ";
  protected final String TEXT_94 = ");" + NL + "                        System.setProperty(\"javax.security.auth.useSubjectCredsOnly\", \"false\");" + NL + "                        mongoCredential_";
  protected final String TEXT_95 = " = com.mongodb.MongoCredential.createGSSAPICredential(";
  protected final String TEXT_96 = ");";
  protected final String TEXT_97 = NL + "                    mongoCredentialList_";
  protected final String TEXT_98 = ".add(mongoCredential_";
  protected final String TEXT_99 = ");";
  protected final String TEXT_100 = NL + "\t\t\t\t\tList<com.mongodb.ServerAddress> addrs_";
  protected final String TEXT_101 = " = new java.util.ArrayList<com.mongodb.ServerAddress>();" + NL + "\t\t\t\t\t";
  protected final String TEXT_102 = NL + "\t\t\t\t\t\taddrs_";
  protected final String TEXT_103 = ".add(new com.mongodb.ServerAddress(";
  protected final String TEXT_104 = ",";
  protected final String TEXT_105 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_106 = NL + "                    mongo_";
  protected final String TEXT_107 = " = new com.mongodb.MongoClient(addrs_";
  protected final String TEXT_108 = ", mongoCredentialList_";
  protected final String TEXT_109 = ", clientOptions_";
  protected final String TEXT_110 = ");";
  protected final String TEXT_111 = NL + "                    com.mongodb.ServerAddress serverAddress_";
  protected final String TEXT_112 = " = new com.mongodb.ServerAddress(";
  protected final String TEXT_113 = ", ";
  protected final String TEXT_114 = ");" + NL + "                    mongo_";
  protected final String TEXT_115 = " = new com.mongodb.MongoClient(serverAddress_";
  protected final String TEXT_116 = ", mongoCredentialList_";
  protected final String TEXT_117 = ", clientOptions_";
  protected final String TEXT_118 = ");";
  protected final String TEXT_119 = NL + "\t\t\t\t\t\t\tmongo_";
  protected final String TEXT_120 = ".addOption(com.mongodb.Bytes.QUERYOPTION_NOTIMEOUT);";
  protected final String TEXT_121 = NL + "\t\t\t\t\tdb_";
  protected final String TEXT_122 = " = mongo_";
  protected final String TEXT_123 = ".getDatabase(";
  protected final String TEXT_124 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_125 = NL + "\t\t\t\t\tdb_";
  protected final String TEXT_126 = " = mongo_";
  protected final String TEXT_127 = ".getDB(";
  protected final String TEXT_128 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_129 = NL + "\t\t\t\t";
  protected final String TEXT_130 = NL + "\t\t\t            mongo_";
  protected final String TEXT_131 = ".setReadPreference(com.mongodb.ReadPreference.primary());" + NL + "\t\t\t            ";
  protected final String TEXT_132 = NL + "\t\t\t            mongo_";
  protected final String TEXT_133 = ".setReadPreference(com.mongodb.ReadPreference.primaryPreferred());" + NL + "\t\t\t            ";
  protected final String TEXT_134 = NL + "\t\t\t            mongo_";
  protected final String TEXT_135 = ".setReadPreference(com.mongodb.ReadPreference.secondary());" + NL + "\t\t\t            ";
  protected final String TEXT_136 = NL + "\t\t\t            mongo_";
  protected final String TEXT_137 = ".setReadPreference(com.mongodb.ReadPreference.secondaryPreferred());" + NL + "\t\t\t            ";
  protected final String TEXT_138 = NL + "\t\t\t            mongo_";
  protected final String TEXT_139 = ".setReadPreference(com.mongodb.ReadPreference.nearest());" + NL + "\t\t\t            ";
  protected final String TEXT_140 = NL + "\t\t\t            // Unhandled" + NL + "\t\t\t            ";
  protected final String TEXT_141 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_142 = " - Connecting to \" + mongo_";
  protected final String TEXT_143 = ".getServerAddressList() + \".\");" + NL + "\t\t\t\t";
  protected final String TEXT_144 = NL + "\t\t\t";
  protected final String TEXT_145 = NL + "\t\t\t\t\tcom.mongodb.client.gridfs.GridFSBucket gridfs_";
  protected final String TEXT_146 = " = com.mongodb.client.gridfs.GridFSBuckets.create(db_";
  protected final String TEXT_147 = ", ";
  protected final String TEXT_148 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_149 = NL + "\t\t\t\t\tcom.mongodb.gridfs.GridFS gridfs_";
  protected final String TEXT_150 = " = new com.mongodb.gridfs.GridFS(db_";
  protected final String TEXT_151 = ", ";
  protected final String TEXT_152 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_153 = NL + "\t\t\t" + NL + "" + NL + "\t\t\tjava.util.List<String> msg_";
  protected final String TEXT_154 = " = new java.util.ArrayList<String>();" + NL + "\t\t\t" + NL + "\t\t\tclass FileInfo_";
  protected final String TEXT_155 = " {" + NL + "\t\t\t\tString newName;" + NL + "\t\t\t\tboolean setMetadata;" + NL + "\t\t\t\tString metadataJson;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tjava.util.List<java.util.Map<String,FileInfo_";
  protected final String TEXT_156 = ">> list_";
  protected final String TEXT_157 = " = new java.util.ArrayList<java.util.Map<String,FileInfo_";
  protected final String TEXT_158 = ">>();" + NL + "\t\t\t" + NL + "\t\t\tFileInfo_";
  protected final String TEXT_159 = " fileInfo_";
  protected final String TEXT_160 = " = null;\t" + NL + "\t\t\t";
  protected final String TEXT_161 = NL + "\t\t\t\tjava.util.Map<String,FileInfo_";
  protected final String TEXT_162 = "> map_";
  protected final String TEXT_163 = "_";
  protected final String TEXT_164 = " = new java.util.HashMap<String,FileInfo_";
  protected final String TEXT_165 = ">();" + NL + "\t\t\t\t" + NL + "\t\t\t\tfileInfo_";
  protected final String TEXT_166 = " = new FileInfo_";
  protected final String TEXT_167 = "();" + NL + "\t\t\t\t" + NL + "\t\t\t\tfileInfo_";
  protected final String TEXT_168 = ".newName = ";
  protected final String TEXT_169 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_170 = NL + "\t\t\t\tfileInfo_";
  protected final String TEXT_171 = ".setMetadata = ";
  protected final String TEXT_172 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_173 = NL + "\t\t\t\tfileInfo_";
  protected final String TEXT_174 = ".metadataJson = ";
  protected final String TEXT_175 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_176 = NL + "\t\t\t\t" + NL + "\t\t\t\tmap_";
  protected final String TEXT_177 = "_";
  protected final String TEXT_178 = ".put(";
  protected final String TEXT_179 = ", fileInfo_";
  protected final String TEXT_180 = ");" + NL + "\t\t\t \tlist_";
  protected final String TEXT_181 = ".add(map_";
  protected final String TEXT_182 = "_";
  protected final String TEXT_183 = ");       " + NL + "\t\t\t\t";
  protected final String TEXT_184 = NL + "\t\t\tString localdir_";
  protected final String TEXT_185 = "  = ";
  protected final String TEXT_186 = ";\t" + NL + "\t\t\tfor (java.util.Map<String, FileInfo_";
  protected final String TEXT_187 = "> map_";
  protected final String TEXT_188 = " : list_";
  protected final String TEXT_189 = ") {" + NL + "\t\t\t";
  protected final String TEXT_190 = NL;
  protected final String TEXT_191 = NL;

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
	
    
  	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
  	INode node = (INode)codeGenArgument.getArgument();
  	String cid = node.getUniqueName();

    String dbhost   = ElementParameterParser.getValue(node, "__HOST__");
    String dbname   = ElementParameterParser.getValue(node, "__DATABASE__");
    String dbuser   = ElementParameterParser.getValue(node, "__USERNAME__");
    boolean authentication="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REQUIRED_AUTHENTICATION__"));
    String authenticationMechanism = ElementParameterParser.getValue(node, "__AUTHENTICATION_MECHANISM__");
    String krbUserPrincipal = ElementParameterParser.getValue(node, "__KRB_USER_PRINCIPAL__");
    String krbRealm = ElementParameterParser.getValue(node, "__KRB_REALM__");
    String krbKdc = ElementParameterParser.getValue(node, "__KRB_KDC__");
    String dbpass   = ElementParameterParser.getValue(node, "__PASSWORD__");
    String mongoPort = ElementParameterParser.getValue(node, "__PORT__");
    String dbport = mongoPort.startsWith("context.") ? "Integer.valueOf(" + mongoPort + ").intValue()" : mongoPort.replace("\"", "");
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    String collection = ElementParameterParser.getValue(node,"__COLLECTION__");
    
  	String limit = ElementParameterParser.getValue(node,"__LIMIT__");

  	List<Map<String, String>> sorts = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SORT__");
  	boolean useReplicaSet="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_REPLICA_SET__"));
  	boolean setReadPreference = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_READ_PREFERENCE__"));
    String readPreference = ElementParameterParser.getValue(node, "__READ_PREFERENCE__");
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    boolean useAuthDB = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_AUTHENTICATION_DATABASE__"));
    String authDB = ElementParameterParser.getValue(node, "__AUTHENTICATION_DATABASE__");
    String usedAuthenticationDB = useAuthDB ? authDB : dbname;
    boolean queryOptionNoTimeOut;
    String dbversion;
	if(useExistingConnection){
	    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        INode connectionNode = NodeUtil.getNodeByUniqueName(node.getProcess(), connection);
        dbversion = ElementParameterParser.getValue(connectionNode, "__DB_VERSION__");
        queryOptionNoTimeOut = "true".equalsIgnoreCase(ElementParameterParser.getValue(connectionNode, "__QUERYOPTION_NOTIMEOUT__"));
    }else{
        dbversion = ElementParameterParser.getValue(node, "__DB_VERSION__");
        queryOptionNoTimeOut = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__QUERYOPTION_NOTIMEOUT__"));
    }
    boolean version_3_5_X = "MONGODB_3_5_X".equals(dbversion);
	
    stringBuffer.append(TEXT_29);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_30);
    }else{
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    if(version_3_5_X) {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    } else {
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    
      		if (useExistingConnection){
      			String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
				
    stringBuffer.append(TEXT_41);
    if(version_3_5_X) {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_46);
    } else {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_57);
    
				}
			}else{
			
    stringBuffer.append(TEXT_58);
    
	 			List<Map<String,String>> replicaAddrs= (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__REPLICA_SET__");

                boolean useSSL = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_SSL__"));
                
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
                if (useSSL) {
                    
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
                }
                
                // Client Credentials
                
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
                // Authentication
                if (authentication){
                    
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
                    if((authenticationMechanism.equals("NEGOTIATE_MEC"))||(authenticationMechanism.equals("PLAIN_MEC"))||(authenticationMechanism.equals("SCRAMSHA1_MEC"))){
                        String passwordFieldName = "__PASSWORD__";
                        
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_69);
    } else {
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_72);
    }
    
                        if(authenticationMechanism.equals("NEGOTIATE_MEC")){
                			if(dbversion.equals("MONGODB_3_0_X") || dbversion.equals("MONGODB_3_2_X") || version_3_5_X) {

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
                        
                			} else {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
                			}
                        } else if(authenticationMechanism.equals("PLAIN_MEC")){
                            
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
                        } else if(authenticationMechanism.equals("SCRAMSHA1_MEC")){
                            
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
                        }
                    } else { // GSSAPI SASL (KERBEROS)
                        
    stringBuffer.append(TEXT_92);
    stringBuffer.append(krbRealm);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(krbKdc);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(krbUserPrincipal);
    stringBuffer.append(TEXT_96);
    
                    }
                    
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    
                }

                // the client
				if(useReplicaSet){
				    
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
					for(Map<String,String> replicaAddr:replicaAddrs){
					
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(replicaAddr.get("REPLICA_HOST"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(replicaAddr.get("REPLICA_PORT"));
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
    
				}else{
                    
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    
				}

                if(queryOptionNoTimeOut){
                    
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    
                }

                
    if(version_3_5_X) {
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_124);
    } else {
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_128);
    }
    stringBuffer.append(TEXT_129);
    
			}

			if (setReadPreference) {
			        if (readPreference.equals("PRIMARY")) {
			            
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    
			        } else if (readPreference.equals("PRIMARY_PREFERRED")) {
			            
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    
			        } else if (readPreference.equals("SECONDARY")) {
			            
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
			        } else if (readPreference.equals("SECONDARY_PREFERRED")) {
			            
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
			        } else if (readPreference.equals("NEAREST")) {
			            
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    
			        } else {
			            
    stringBuffer.append(TEXT_140);
    
			        }
			}

			if(isLog4jEnabled){
			    
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    
			}
			log4jFileUtil.startRetriveDataInfo();

    
    boolean givenStringFileName = "STRING_FILENAME".equalsIgnoreCase(ElementParameterParser.getValue(node, "__QUERY_TYPE__"));
    String stringFileName = ElementParameterParser.getValue(node, "__FILENAME__");
    String query = ElementParameterParser.getValue(node,"__QUERY__");
    query = query.replaceAll("\n","");
    query = query.replaceAll("\r","");
    String bucketName = ElementParameterParser.getValue(node, "__BUCKET__");
    String localdir = ElementParameterParser.getValue(node, "__LOCALDIR__");
    List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");

			
    stringBuffer.append(TEXT_144);
    if(version_3_5_X) {
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_148);
    } else {
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(bucketName);
    stringBuffer.append(TEXT_152);
    }
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
			// Get filemasks
			for (int i=0; i<files.size(); i++) {
				Map<String, String> line = files.get(i);
				
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append( line.get("NEWNAME") );
    stringBuffer.append(TEXT_169);
    
				boolean setMetadata = "true".equals(line.get("SET_METADATA"));
				
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append( setMetadata );
    stringBuffer.append(TEXT_172);
    if(setMetadata) {
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append( line.get("METADATA") );
    stringBuffer.append(TEXT_175);
    }
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_178);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_183);
    
			}
			
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    

    stringBuffer.append(TEXT_190);
    stringBuffer.append(TEXT_191);
    return stringBuffer.toString();
  }
}
