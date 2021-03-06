package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import java.util.List;

public class TUniqRowOutEndJava
{
  protected static String nl;
  public static synchronized TUniqRowOutEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniqRowOutEndJava result = new TUniqRowOutEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "            if (rowsInBuffer_1_";
  protected final String TEXT_2 = " > 0) {" + NL + "                java.util.Arrays.<rowStruct_";
  protected final String TEXT_3 = "> sort(buffer_1_";
  protected final String TEXT_4 = ", 0, rowsInBuffer_1_";
  protected final String TEXT_5 = ", comparator_1_";
  protected final String TEXT_6 = ");" + NL + "                " + NL + "                java.io.File file_";
  protected final String TEXT_7 = " = new java.io.File(temp_file_path_prefix_";
  protected final String TEXT_8 = " + files_1_";
  protected final String TEXT_9 = ".size());";
  protected final String TEXT_10 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_11 = " - Invoke request to delete file: \"+file_";
  protected final String TEXT_12 = ".getPath()+\" When VM exit.\");" + NL + "\t\t\t\t";
  protected final String TEXT_13 = NL + "                file_";
  protected final String TEXT_14 = ".deleteOnExit();";
  protected final String TEXT_15 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_16 = " - Writing the data into: \"+file_";
  protected final String TEXT_17 = ".getPath());" + NL + "\t\t\t\t";
  protected final String TEXT_18 = NL + "                java.io.ObjectOutputStream rw_";
  protected final String TEXT_19 = " = new java.io.ObjectOutputStream(new java.io.BufferedOutputStream(" + NL + "                        new java.io.FileOutputStream(file_";
  protected final String TEXT_20 = ")));" + NL + "                for (int i = 0; i < rowsInBuffer_1_";
  protected final String TEXT_21 = "; i++) {" + NL + "                    buffer_1_";
  protected final String TEXT_22 = "[i].writeData(rw_";
  protected final String TEXT_23 = ");" + NL + "                }" + NL + "                " + NL + "                rw_";
  protected final String TEXT_24 = ".close();" + NL + "\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_26 = " - Wrote successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_27 = NL + "                files_1_";
  protected final String TEXT_28 = ".add(file_";
  protected final String TEXT_29 = ");" + NL + "" + NL + "                rowsInBuffer_1_";
  protected final String TEXT_30 = " = 0;" + NL + "            }" + NL + "            buffer_1_";
  protected final String TEXT_31 = " = null;" + NL + "            " + NL + "" + NL + "            // ////////////////////////////////////" + NL + "            class FileRowIterator_";
  protected final String TEXT_32 = " implements java.util.Iterator<rowStruct_";
  protected final String TEXT_33 = "> {" + NL + "\t\t\t\t" + NL + "\t\t\t\tboolean isEndOfFile = false;" + NL + "\t\t\t\t" + NL + "                rowStruct_";
  protected final String TEXT_34 = "[] buffer;" + NL + "" + NL + "                ObjectInputStream ois;" + NL + "                " + NL + "                java.io.BufferedInputStream bis;" + NL + "                " + NL + "                rowStruct_";
  protected final String TEXT_35 = " tempRow;" + NL + "" + NL + "                int count = 0;" + NL + "" + NL + "                int index = 0;" + NL + "" + NL + "                public FileRowIterator_";
  protected final String TEXT_36 = "(java.io.File file, int bufferSize) throws IOException {" + NL + "                \tisEndOfFile = false;" + NL + "                \ttempRow = null;" + NL + "                \tbis = new java.io.BufferedInputStream(new java.io.FileInputStream(file));" + NL + "                    ois = new java.io.ObjectInputStream(bis);" + NL + "                    buffer = new rowStruct_";
  protected final String TEXT_37 = "[bufferSize];" + NL + "                }" + NL + "" + NL + "                private void load() {" + NL + "                    count = 0;" + NL + "                    index = 0;" + NL + "                    try {" + NL + "\t\t\t\t\t\tif (tempRow!=null) {" + NL + "\t\t\t\t\t\t\tbuffer[count++] = tempRow;" + NL + "\t\t\t\t\t\t\ttempRow = null;" + NL + "\t\t\t\t\t\t}" + NL + "                        while (!isEndOfFile && count < buffer.length) {" + NL + "                            buffer[count] = new rowStruct_";
  protected final String TEXT_38 = "();" + NL + "                            buffer[count].readData(ois);" + NL + "                            count++;" + NL + "                        }" + NL + "\t\t\t\t\t\tif (!isEndOfFile && count >= buffer.length && bis.available() == 0) {" + NL + "\t\t\t\t\t\t\ttempRow = new rowStruct_";
  protected final String TEXT_39 = "();" + NL + "\t\t\t\t\t\t\ttempRow.readData(ois);" + NL + "\t\t\t\t\t\t}" + NL + "                    } catch (java.lang.Exception e) {" + NL + "\t\t\t\t\t\tif(e.getCause() instanceof java.io.EOFException){" + NL + "\t\t\t\t\t\t\tthis.isEndOfFile = true; // the EOFException" + NL + "\t\t\t\t\t\t\ttempRow = null;" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tthrow new RuntimeException(e);" + NL + "\t\t\t\t\t\t}" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                public boolean hasNext() {" + NL + "                \treturn index < count || !isEndOfFile;" + NL + "                }" + NL + "" + NL + "                public rowStruct_";
  protected final String TEXT_40 = " next() {" + NL + "                    if (index >= count) {" + NL + "                        load();" + NL + "                    }" + NL + "" + NL + "\t\t\t\t\trowStruct_";
  protected final String TEXT_41 = " result = buffer[index];" + NL + "\t\t\t\t\t//release the reference asap to avoid the memory leak for the worst case" + NL + "\t\t\t\t\tbuffer[index] = null;" + NL + "\t\t\t\t\tindex++;" + NL + "\t\t\t\t\t" + NL + "                    return result;" + NL + "                }" + NL + "" + NL + "                public void remove() {" + NL + "                    throw new UnsupportedOperationException();" + NL + "                }" + NL + "" + NL + "                public void close() throws IOException {" + NL + "                \t//we release the buffer when calling close, but the worst case is that :" + NL + "                \t//all the close methods are called one by one at the last, so it's not enough." + NL + "            \t\tbuffer = null;" + NL + "                \t" + NL + "                    if (ois != null) {" + NL + "                        ois.close();" + NL + "                        ois = null;" + NL + "                    }" + NL + "                }" + NL + "            }" + NL;
  protected final String TEXT_42 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = ElementParameterParser.getValue(node, "__CID__");

String connName = "";
if (node.getIncomingConnections().size()==1) {
	IConnection conn = node.getIncomingConnections().get(0);
	connName = conn.getName();
}
final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
///////////////
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0) && !("").equals(connName)) {//HSS_____0
	IMetadataTable metadata = metadatas.get(0);
    List<IMetadataColumn> columnList = metadata.getListColumns();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    
				}
				
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
				}
				
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
				}
				
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    
}//HSS_____0

    stringBuffer.append(TEXT_42);
    return stringBuffer.toString();
  }
}
