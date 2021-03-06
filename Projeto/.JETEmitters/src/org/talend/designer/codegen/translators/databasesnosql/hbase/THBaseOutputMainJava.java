package org.talend.designer.codegen.translators.databasesnosql.hbase;

import java.util.List;
import java.util.Map;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class THBaseOutputMainJava
{
  protected static String nl;
  public static synchronized THBaseOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THBaseOutputMainJava result = new THBaseOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_5 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_6 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_8 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_9 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_11 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_12 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_14 = " - Written records count: \" + nb_line_";
  protected final String TEXT_15 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_17 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_19 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_20 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - Writing the record \" + nb_line_";
  protected final String TEXT_23 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Processing the record \" + nb_line_";
  protected final String TEXT_26 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_28 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_29 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL + "\t\t\t\torg.apache.hadoop.hbase.client.Put p_";
  protected final String TEXT_32 = " = null;" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t\t\tbyte[] rowKey_";
  protected final String TEXT_34 = " = org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_35 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\tbyte[] rowKey_";
  protected final String TEXT_37 = " = org.apache.hadoop.hbase.util.Bytes.toBytes(\"myRow_\"+";
  protected final String TEXT_38 = ".toString());" + NL + "\t\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t\t\t\tp_";
  protected final String TEXT_40 = " = new org.apache.hadoop.hbase.client.Put(rowKey_";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\t\t\t\tthrow new RuntimeException(\"Custom Timestamp Column should be long-typed\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\t\tp_";
  protected final String TEXT_46 = " = new org.apache.hadoop.hbase.client.Put(rowKey_";
  protected final String TEXT_47 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t\t\t\ttemp_";
  protected final String TEXT_49 = " = null;" + NL + "\t\t\t\t\t\t\tif(";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = "!=null){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\t\t\t\ttemp_";
  protected final String TEXT_53 = " = org.apache.hadoop.hbase.util.Bytes.toBytes(FormatterUtils.format_Date(";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = ", ";
  protected final String TEXT_56 = "));" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\t\t\t\ttemp_";
  protected final String TEXT_58 = " = ";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\t\t\t\ttemp_";
  protected final String TEXT_62 = " = org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = "+\"\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_65 = NL + "\t\t\t\t\t\t\ttemp_";
  protected final String TEXT_66 = " = org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\t\t\ttemp_";
  protected final String TEXT_70 = " = org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_71 = ".";
  protected final String TEXT_72 = ".toString());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_74 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tp_";
  protected final String TEXT_75 = ".add(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_76 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(\"";
  protected final String TEXT_77 = "\"), temp_";
  protected final String TEXT_78 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t\t\tbatchPuts_";
  protected final String TEXT_80 = ".add(p_";
  protected final String TEXT_81 = ");" + NL + "\t\t\t\t\t\tif (batchPuts_";
  protected final String TEXT_82 = ".size() >= ";
  protected final String TEXT_83 = ") {" + NL + "\t\t\t\t\t\t\ttable_";
  protected final String TEXT_84 = ".put(batchPuts_";
  protected final String TEXT_85 = ");" + NL + "\t\t\t\t\t\t\tnb_line_";
  protected final String TEXT_86 = " += batchPuts_";
  protected final String TEXT_87 = ".size();" + NL + "\t\t\t\t\t\t\tbatchPuts_";
  protected final String TEXT_88 = ".clear();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\t\t\t\ttable_";
  protected final String TEXT_90 = ".put(p_";
  protected final String TEXT_91 = ");" + NL + "\t\t\t\t\t\tnb_line_";
  protected final String TEXT_92 = "++;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_93 = NL + "\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\t        throw(e);" + NL + "\t\t\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t\t\t\tSystem.out.println(e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_97 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_98 = "             " + NL + "\t\t\t\t}" + NL + "\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_20);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_24);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_30);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument)argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<Map<String,String>> families = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__FAMILIES__");
String customUseRowKey = ElementParameterParser.getValue(node, "__CUSTOM_ROW_KEY__");
boolean useCustomTimestampColumn = ElementParameterParser.getBooleanValue(node, "__CUSTOM_TIMESTAMP_COLUMN__");
String customTimestampColumn = ElementParameterParser.getValue(node, "__TIMESTAMP_COLUMN__");
String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");

final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

boolean useBatchMode = ElementParameterParser.getBooleanValue(node, "__USE_BATCH_MODE__");
String batchSize = ElementParameterParser.getValue(node, "__BATCH_SIZE__");

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null) && (metadatas.size() > 0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata != null) {
    	List< ? extends IConnection> conns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
		if (conns != null){
			if (conns.size()>0){
				IConnection conn = conns.get(0);
				String connName = conn.getName();
				List<IMetadataColumn> columns = metadata.getListColumns();
				
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
					if("true".equals(customUseRowKey)){
					String rowKey = ElementParameterParser.getValue(node, "__ROW_KEY__");
					
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(rowKey);
    stringBuffer.append(TEXT_35);
    
					}else{
					
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_38);
    
					}
					if(useCustomTimestampColumn){
						IMetadataColumn localTimestampColumn = null;
						for(int familyNum = 0 ; familyNum < families.size() ; familyNum++){
							IMetadataColumn localColumn = columns.get(familyNum);
							if(localColumn.getLabel().equals(customTimestampColumn)){
								localTimestampColumn = localColumn;
								break;
							}
						}
						if(localTimestampColumn != null && JavaTypesManager.getJavaTypeFromId(localTimestampColumn.getTalendType()) == JavaTypesManager.LONG){
						
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(customTimestampColumn);
    stringBuffer.append(TEXT_43);
    
						}else{
						
    stringBuffer.append(TEXT_44);
    
						}
					}else{
					
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
					}
					for(int familyNum = 0 ; familyNum < families.size() ; familyNum++){
						IMetadataColumn column = columns.get(familyNum);
						if(useCustomTimestampColumn && column.getLabel().equals(customTimestampColumn)){
							continue;
						}
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
						Map<String,String> mapLine = families.get(familyNum);
						String schema_column = mapLine.get("SCHEMA_COLUMN");
						String family_column = mapLine.get("FAMILY_COLUMN");
						if(family_column==null||family_column.trim().length()==0){
							continue;
						}
						boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
						if(!isPrimitive){
						
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_51);
    
						}
						if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
						
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_56);
    
						}else if (javaType == JavaTypesManager.BYTE_ARRAY) {
						
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_60);
    
						}else if (javaType == JavaTypesManager.BYTE) {
						
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_64);
    
						}else if(JavaTypesManager.isJavaPrimitiveType(javaType,column.isNullable())) {
						
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_68);
    
						}else{
						
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_72);
    
						}
						if(!isPrimitive){
						
    stringBuffer.append(TEXT_73);
    
						}
						
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    
					}
					if (useBatchMode) {
						
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
					} else {
						
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
					}
					log4jFileUtil.debugWriteData(node);
					
    stringBuffer.append(TEXT_93);
    
					if(("true").equals(dieOnError)){
					
    stringBuffer.append(TEXT_94);
    
				   	}else {
					
    stringBuffer.append(TEXT_95);
    
						if(isLog4jEnabled) {
					
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
						}
					}
					
    stringBuffer.append(TEXT_98);
    
			}//if (conns.size()>0)
		}//if (conns != null)
	}//if (metadata != null)
}//if ((metadatas!=null) && (metadatas.size() > 0))

    return stringBuffer.toString();
  }
}
