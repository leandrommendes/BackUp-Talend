package org.talend.designer.codegen.translators.bigdata.dbfs;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TDBFSPutEndJava
{
  protected static String nl;
  public static synchronized TDBFSPutEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDBFSPutEndJava result = new TDBFSPutEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t" + NL + " \t}" + NL + "    msg_";
  protected final String TEXT_3 = ".add(nb_success_";
  protected final String TEXT_4 = " + \"/\"+nb_file_";
  protected final String TEXT_5 = "+\" files have been uploaded successful.\");  " + NL + "    \t" + NL + "\tStringBuffer sb_";
  protected final String TEXT_6 = " = new StringBuffer();" + NL + "    for (String item_";
  protected final String TEXT_7 = " : msg_";
  protected final String TEXT_8 = ") {" + NL + "        sb_";
  protected final String TEXT_9 = ".append(item_";
  protected final String TEXT_10 = ").append(\"\\n\");" + NL + "    }" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_11 = "_TRANSFER_MESSAGES\", sb_";
  protected final String TEXT_12 = ".toString());" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_13 = "_NB_FILE\",nb_file_";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\tlog.info(\"";
  protected final String TEXT_16 = " - \" + sb_";
  protected final String TEXT_17 = ".toString());";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();	
	String cid = node.getUniqueName();
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
	if(isLog4jEnabled) {

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
	}
	

    return stringBuffer.toString();
  }
}
