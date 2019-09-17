package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;

public class TJMSInputBeginJava
{
  protected static String nl;
  public static synchronized TJMSInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJMSInputBeginJava result = new TJMSInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "                if(log.is";
  protected final String TEXT_3 = "Enabled())";
  protected final String TEXT_4 = NL + "            log.";
  protected final String TEXT_5 = "(\"";
  protected final String TEXT_6 = " - \" ";
  protected final String TEXT_7 = " + (";
  protected final String TEXT_8 = ") ";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "            if (log.isDebugEnabled()) {" + NL + "                class BytesLimit65535_";
  protected final String TEXT_11 = "{" + NL + "                    public void limitLog4jByte() throws Exception{" + NL + "                    StringBuilder ";
  protected final String TEXT_12 = " = new StringBuilder();";
  protected final String TEXT_13 = NL + "                    ";
  protected final String TEXT_14 = ".append(\"Parameters:\");";
  protected final String TEXT_15 = NL + "                            ";
  protected final String TEXT_16 = ".append(\"";
  protected final String TEXT_17 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_18 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_19 = NL + "                            ";
  protected final String TEXT_20 = ".append(\"";
  protected final String TEXT_21 = "\" + \" = \" + ";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "                        ";
  protected final String TEXT_24 = ".append(\" | \");";
  protected final String TEXT_25 = NL + "                    } " + NL + "                } " + NL + "            new BytesLimit65535_";
  protected final String TEXT_26 = "().limitLog4jByte();" + NL + "            }";
  protected final String TEXT_27 = NL + "            StringBuilder ";
  protected final String TEXT_28 = " = new StringBuilder();    ";
  protected final String TEXT_29 = NL + "                    ";
  protected final String TEXT_30 = ".append(";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "                    if(";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = " == null){";
  protected final String TEXT_36 = NL + "                        ";
  protected final String TEXT_37 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_38 = NL + "                        ";
  protected final String TEXT_39 = ".append(";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = ");" + NL + "                    }   ";
  protected final String TEXT_42 = NL + "                ";
  protected final String TEXT_43 = ".append(\"|\");";
  protected final String TEXT_44 = NL + NL + "\tjava.util.Hashtable props_";
  protected final String TEXT_45 = " = new java.util.Hashtable();" + NL + "\tprops_";
  protected final String TEXT_46 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, ";
  protected final String TEXT_47 = ");" + NL + "\tprops_";
  protected final String TEXT_48 = ".put(javax.naming.Context.PROVIDER_URL, ";
  protected final String TEXT_49 = ");" + NL + "\t";
  protected final String TEXT_50 = NL + "\tprops_";
  protected final String TEXT_51 = ".put(";
  protected final String TEXT_52 = ", ";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "\t" + NL + "\tjavax.naming.Context context_";
  protected final String TEXT_55 = " = new javax.naming.InitialContext(props_";
  protected final String TEXT_56 = ");" + NL + "\tjavax.jms.ConnectionFactory factory_";
  protected final String TEXT_57 = " = (javax.jms.ConnectionFactory) context_";
  protected final String TEXT_58 = ".lookup(";
  protected final String TEXT_59 = ");" + NL + "\t";
  protected final String TEXT_60 = NL + "        ";
  protected final String TEXT_61 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_62 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_65 = " = ";
  protected final String TEXT_66 = "; ";
  protected final String TEXT_67 = NL + NL + "\tjavax.jms.Connection connection_";
  protected final String TEXT_68 = " = factory_";
  protected final String TEXT_69 = ".createConnection(";
  protected final String TEXT_70 = ", decryptedPassword_";
  protected final String TEXT_71 = ");" + NL + "    resourceMap.put(\"connection_";
  protected final String TEXT_72 = "\",connection_";
  protected final String TEXT_73 = ");" + NL + "\t";
  protected final String TEXT_74 = NL + "\tconnection_";
  protected final String TEXT_75 = ".setClientID(";
  protected final String TEXT_76 = ");" + NL + "\t";
  protected final String TEXT_77 = NL + "\t" + NL + "\tjavax.jms.Session session_";
  protected final String TEXT_78 = " = connection_";
  protected final String TEXT_79 = ".createSession(false, javax.jms.Session.CLIENT_ACKNOWLEDGE);" + NL + "    resourceMap.put(\"session_";
  protected final String TEXT_80 = "\",session_";
  protected final String TEXT_81 = ");" + NL + "\t";
  protected final String TEXT_82 = NL + "\tjavax.jms.Destination dest_";
  protected final String TEXT_83 = " = (javax.jms.Destination)context_";
  protected final String TEXT_84 = ".lookup(";
  protected final String TEXT_85 = ");" + NL + "\t";
  protected final String TEXT_86 = NL + "\tjavax.jms.Destination dest_";
  protected final String TEXT_87 = " = session_";
  protected final String TEXT_88 = ".create";
  protected final String TEXT_89 = "(";
  protected final String TEXT_90 = ");" + NL + "\t";
  protected final String TEXT_91 = NL + "\tjavax.jms.MessageConsumer consumer_";
  protected final String TEXT_92 = " = session_";
  protected final String TEXT_93 = ".createDurableSubscriber((javax.jms.Topic)dest_";
  protected final String TEXT_94 = ",";
  protected final String TEXT_95 = ",";
  protected final String TEXT_96 = ",false);" + NL + "\t";
  protected final String TEXT_97 = NL + "\tjavax.jms.MessageConsumer consumer_";
  protected final String TEXT_98 = "\t= session_";
  protected final String TEXT_99 = ".createConsumer(dest_";
  protected final String TEXT_100 = ", ";
  protected final String TEXT_101 = ");" + NL + "\t";
  protected final String TEXT_102 = NL + "    resourceMap.put(\"consumer_";
  protected final String TEXT_103 = "\",consumer_";
  protected final String TEXT_104 = ");" + NL + "" + NL + "\tconnection_";
  protected final String TEXT_105 = ".start();" + NL + "" + NL + "\tSystem.out.println(\"Ready to receive message\");" + NL + "\tSystem.out.println(\"Waiting...\");" + NL + "\t";
  protected final String TEXT_106 = NL + "\t";
  protected final String TEXT_107 = NL + NL + "\tjavax.jms.Message message_";
  protected final String TEXT_108 = ";" + NL + "" + NL + "\tint nbline_";
  protected final String TEXT_109 = " = 0;" + NL + "" + NL + "\twhile ((message_";
  protected final String TEXT_110 = " = consumer_";
  protected final String TEXT_111 = ".receive(";
  protected final String TEXT_112 = "*1000)) != null) {" + NL + "\t\t";
  protected final String TEXT_113 = NL + "\t\t";
  protected final String TEXT_114 = ".message=message_";
  protected final String TEXT_115 = ";\t";
  protected final String TEXT_116 = NL + "\t\t";
  protected final String TEXT_117 = ".messageContent=ParserUtils.parseTo_Document(((javax.jms.ObjectMessage) message_";
  protected final String TEXT_118 = ").getObject().toString());";
  protected final String TEXT_119 = NL + "\t\t";
  protected final String TEXT_120 = ".messageContent=((javax.jms.TextMessage) message_";
  protected final String TEXT_121 = ").getText();";
  protected final String TEXT_122 = NL + NL + NL + "\t\t";
  protected final String TEXT_123 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
class BasicLogUtil{
    protected String cid  = "";
    protected org.talend.core.model.process.INode node = null;
    protected boolean log4jEnabled = false;
    private String logID = "";
    
    private BasicLogUtil(){}
    
    public BasicLogUtil(org.talend.core.model.process.INode node){
        this.node = node;
        String cidx = this.node.getUniqueName();
        if(cidx.matches("^.*?tAmazonAuroraOutput_\\d+_out$") || cidx.matches("^.*?tDBOutput_\\d+_out$")){
             cidx = cidx.substring(0,cidx.length()-4);// 4 ==> "_out".length();
        }
        this.cid = cidx;
        this.log4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(this.node.getProcess(), "__LOG4J_ACTIVATE__"));
        this.log4jEnabled = this.log4jEnabled &&
                            this.node.getComponent().isLog4JEnabled() && !"JOBLET".equals(node.getComponent().getComponentType().toString());
        this.logID = this.cid;
    }
    
    public String var(String varName){
        return varName + "_" + this.cid;
    }
    public String str(String content){
        return "\"" + content + "\"";
    }
    
    public void info(String... message){
        log4j("info", message);
    }
    
    public void debug(String... message){
        log4j("debug", message);
    }
    
    public void warn(String... message){
        log4j("warn", message);
    }
    
    public void error(String... message){
        log4j("error", message);
    }
    
    public void fatal(String... message){
        log4j("fatal", message);
    }
    
    public void trace(String... message){
        log4j("trace", message);
    }
    java.util.List<String> checkableList = java.util.Arrays.asList(new String[]{"info", "debug", "trace"});     
    public void log4j(String level, String... messages){
        if(this.log4jEnabled){
            if(checkableList.contains(level)){
            
    stringBuffer.append(TEXT_2);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_3);
    
            }
            
    stringBuffer.append(TEXT_4);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_6);
    for(String message : messages){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    
        }
    }
    
    public boolean isActive(){
        return this.log4jEnabled;
    }
}

class LogUtil extends BasicLogUtil{
    
    private LogUtil(){
    }
    
    public LogUtil(org.talend.core.model.process.INode node){
        super(node);
    }
    
    public void startWork(){
        debug(str("Start to work."));
    }
    
    public void endWork(){
        debug(str("Done."));
    }
    
    public void logIgnoredException(String exception){
        warn(exception);
    }
    
    public void logPrintedException(String exception){
        error(exception);
    }
    
    public void logException(String exception){
        fatal(exception);
    }
    
    public void logCompSetting(){
    
    
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_14);
    
                    java.util.Set<org.talend.core.model.process.EParameterFieldType> ignoredParamsTypes = new java.util.HashSet<org.talend.core.model.process.EParameterFieldType>(); 
                    ignoredParamsTypes.addAll(
                        java.util.Arrays.asList(
                            org.talend.core.model.process.EParameterFieldType.SCHEMA_TYPE,
                            org.talend.core.model.process.EParameterFieldType.LABEL,
                            org.talend.core.model.process.EParameterFieldType.EXTERNAL,
                            org.talend.core.model.process.EParameterFieldType.MAPPING_TYPE,
                            org.talend.core.model.process.EParameterFieldType.IMAGE,
                            org.talend.core.model.process.EParameterFieldType.TNS_EDITOR,
                            org.talend.core.model.process.EParameterFieldType.WSDL2JAVA,
                            org.talend.core.model.process.EParameterFieldType.GENERATEGRAMMARCONTROLLER,
                            org.talend.core.model.process.EParameterFieldType.GENERATE_SURVIVORSHIP_RULES_CONTROLLER,
                            org.talend.core.model.process.EParameterFieldType.REFRESH_REPORTS,
                            org.talend.core.model.process.EParameterFieldType.BROWSE_REPORTS,
                            org.talend.core.model.process.EParameterFieldType.PALO_DIM_SELECTION,
                            org.talend.core.model.process.EParameterFieldType.GUESS_SCHEMA,
                            org.talend.core.model.process.EParameterFieldType.MATCH_RULE_IMEX_CONTROLLER,
                            org.talend.core.model.process.EParameterFieldType.MEMO_PERL,
                            org.talend.core.model.process.EParameterFieldType.DBTYPE_LIST,
                            org.talend.core.model.process.EParameterFieldType.VERSION,
                            org.talend.core.model.process.EParameterFieldType.TECHNICAL,
                            org.talend.core.model.process.EParameterFieldType.ICON_SELECTION,
                            org.talend.core.model.process.EParameterFieldType.JAVA_COMMAND,
                            org.talend.core.model.process.EParameterFieldType.TREE_TABLE,
                            org.talend.core.model.process.EParameterFieldType.VALIDATION_RULE_TYPE,
                            org.talend.core.model.process.EParameterFieldType.DCSCHEMA,
                            org.talend.core.model.process.EParameterFieldType.SURVIVOR_RELATION,
                            org.talend.core.model.process.EParameterFieldType.REST_RESPONSE_SCHEMA_TYPE
                            )
                    );
                    for(org.talend.core.model.process.IElementParameter ep : org.talend.core.model.utils.NodeUtil.getDisplayedParameters(node)){
                        if(!ep.isLog4JEnabled() || ignoredParamsTypes.contains(ep.getFieldType())){
                            continue;
                        }
                        String name = ep.getName();
                        if(org.talend.core.model.process.EParameterFieldType.PASSWORD.equals(ep.getFieldType())){
                            String epName = "__" + name + "__";
                            String password = "";
                            if(org.talend.core.model.process.ElementParameterParser.canEncrypt(node, epName)){
                                password = org.talend.core.model.process.ElementParameterParser.getEncryptedValue(node, epName);
                            }else{
                                String passwordValue = org.talend.core.model.process.ElementParameterParser.getValue(node, epName);
                                if (passwordValue == null || "".equals(passwordValue.trim())) {// for the value which empty
                                    passwordValue = "\"\"";
                                } 
                                password = "routines.system.PasswordEncryptUtil.encryptPassword(" + passwordValue + ")";
                            } 
                            
    stringBuffer.append(TEXT_15);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_18);
    
                        }else{
                            String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                            if(value.length()>10000){
                            value = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(value);
                            }
                            
    stringBuffer.append(TEXT_19);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_22);
    
                        }   
                        
    stringBuffer.append(TEXT_23);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_24);
    
                    }
                    debug(var("log4jParamters")); 
                    
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
        } 
        
    
    } 
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_27);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_28);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_29);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_32);
    
                }else{
                
    stringBuffer.append(TEXT_33);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_41);
    
                }
                
    stringBuffer.append(TEXT_42);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_43);
    
            }
        }
        trace(str("Content of the record "), nbline, str(": "), var("log4jSb"));
        
    
    }
}

class LogHelper{
    
    java.util.Map<String, String> pastDict = null;
    
    public LogHelper(){
        pastDict = new java.util.HashMap<String, String>();
        pastDict.put("insert", "inserted");
        pastDict.put("update", "updated");
        pastDict.put("delete", "deleted");
        pastDict.put("upsert", "upserted");
    }   
    
    public String upperFirstChar(String data){ 
        return data.substring(0, 1).toUpperCase() + data.substring(1);
    }
    
    public String toPastTense(String data){
        return pastDict.get(data);
    }
}
LogHelper logHelper = new LogHelper();

LogUtil log = null;

    

CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
log = new LogUtil(node);
String contextProvider=ElementParameterParser.getValue(node, "__CONTEXT_PROVIDER__");
String connFacName=ElementParameterParser.getValue(node, "__CONN_FACTORY_NAME__");
String url=ElementParameterParser.getValue(node, "__SERVER_URL__");
String userIdentity=ElementParameterParser.getValue(node, "__USER_IDENTITY__");
String user=ElementParameterParser.getValue(node, "__USER__");

String from=ElementParameterParser.getValue(node, "__FROM__");
String timeout=ElementParameterParser.getValue(node, "__TIMEOUT__");
String messageSelector=ElementParameterParser.getValue(node, "__MSG_SELECTOR__");
String processingMode = ElementParameterParser.getValue(node, "__PROCESSING_MODE__");
String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");
boolean useJNDILookup="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_JNDI_LOOKUP__"));

List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");

boolean enableSubscription = "Topic".equals(msgType) && "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__ENABLE_SUB__"));
String clientID = ElementParameterParser.getValue(node, "__CLIENT_ID__");
String subscriberName = ElementParameterParser.getValue(node, "__SUBSCRIBER_NAME__");

IMetadataTable metadata=null;
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	metadata = metadatas.get(0);
}

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(contextProvider);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_49);
    
if(advProps.size() > 0){
	for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_53);
     
	} 
}

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(connFacName);
    stringBuffer.append(TEXT_59);
    
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
    if("true".equals(userIdentity)){
    stringBuffer.append(user );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    }
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
	if(enableSubscription && clientID != null && clientID.length() > 0){
	
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(clientID);
    stringBuffer.append(TEXT_76);
    
	}
	
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
	if(useJNDILookup){
	
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_85);
    
	}else{
	
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_90);
    
	}
	if(enableSubscription){
	
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(subscriberName);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(messageSelector);
    stringBuffer.append(TEXT_96);
    
	} else {
	
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(messageSelector);
    stringBuffer.append(TEXT_101);
    
	}
	
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    log.info(log.str("Ready to receive message."));
    stringBuffer.append(TEXT_106);
    log.info(log.str("Waiting..."));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append("-1".equals(timeout)?0:timeout);
    stringBuffer.append(TEXT_112);
    log.debug(log.str("Retrieving the message "), "(nbline_" + cid + "+1)", log.str("."));
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	List<IMetadataColumn> columnLists = metadata.getListColumns();
	for(IConnection conn:conns){
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			String firstConnName = conn.getName();
			if("RAW".equals(processingMode)){

    stringBuffer.append(TEXT_113);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    
			}else{
				if("id_Document".equals(metadata.getColumn("messageContent").getTalendType())){

    stringBuffer.append(TEXT_116);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    
				}else{

    stringBuffer.append(TEXT_119);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    
				}
			}
		}
	}
	


    stringBuffer.append(TEXT_122);
    stringBuffer.append(TEXT_123);
    return stringBuffer.toString();
  }
}
