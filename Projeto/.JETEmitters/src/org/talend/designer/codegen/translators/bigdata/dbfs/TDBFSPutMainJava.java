package org.talend.designer.codegen.translators.bigdata.dbfs;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TDBFSPutMainJava
{
  protected static String nl;
  public static synchronized TDBFSPutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDBFSPutMainJava result = new TDBFSPutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "\t      \t\t\t\t" + NL + "   \t\tjava.util.Set<String> keySet_";
  protected final String TEXT_3 = " = map_";
  protected final String TEXT_4 = ".keySet();" + NL + "      \tfor (String key_";
  protected final String TEXT_5 = " : keySet_";
  protected final String TEXT_6 = "){     " + NL + "\t\t\tString tempdir_";
  protected final String TEXT_7 = " =  localdir_";
  protected final String TEXT_8 = ";" + NL + "\t\t\tString filemask_";
  protected final String TEXT_9 = " = key_";
  protected final String TEXT_10 = "; " + NL + "\t\t\tString dir_";
  protected final String TEXT_11 = " = null;" + NL + "            String mask_";
  protected final String TEXT_12 = " = filemask_";
  protected final String TEXT_13 = ".replaceAll(\"\\\\\\\\\", \"/\") ;" + NL + "\t\t\tint i_";
  protected final String TEXT_14 = " = mask_";
  protected final String TEXT_15 = ".lastIndexOf('/');" + NL + "  \t\t\tif (i_";
  protected final String TEXT_16 = "!=-1){" + NL + "\t\t\t\tdir_";
  protected final String TEXT_17 = " = mask_";
  protected final String TEXT_18 = ".substring(0, i_";
  protected final String TEXT_19 = "); " + NL + "\t\t\t\tmask_";
  protected final String TEXT_20 = " = mask_";
  protected final String TEXT_21 = ".substring(i_";
  protected final String TEXT_22 = "+1);\t " + NL + "    \t\t}" + NL + "    \t\tif (dir_";
  protected final String TEXT_23 = "!=null && !\"\".equals(dir_";
  protected final String TEXT_24 = ")) tempdir_";
  protected final String TEXT_25 = " = tempdir_";
  protected final String TEXT_26 = " + \"/\" + dir_";
  protected final String TEXT_27 = ";  " + NL + "            mask_";
  protected final String TEXT_28 = " = mask_";
  protected final String TEXT_29 = ".replaceAll(\"\\\\.\", \"\\\\\\\\.\").replaceAll(\"\\\\*\", \".*\");" + NL + "    \t\tfinal String finalMask_";
  protected final String TEXT_30 = " = mask_";
  protected final String TEXT_31 = ";" + NL + "    \t\tjava.io.File[] listings_";
  protected final String TEXT_32 = " = null;       " + NL + "        \tjava.io.File file_";
  protected final String TEXT_33 = " = new java.io.File(tempdir_";
  protected final String TEXT_34 = ");" + NL + "        \tif (file_";
  protected final String TEXT_35 = ".isDirectory()) {" + NL + "\t            listings_";
  protected final String TEXT_36 = " = file_";
  protected final String TEXT_37 = ".listFiles(new java.io.FileFilter() {" + NL + "\t                public boolean accept(java.io.File pathname) {" + NL + "\t                    boolean result = false;" + NL + "\t                    if (pathname != null && pathname.isFile()) {                      " + NL + "\t                            result = java.util.regex.Pattern.compile(finalMask_";
  protected final String TEXT_38 = ").matcher(pathname.getName()).find(); " + NL + "\t                    \t}" + NL + "\t                    return result;" + NL + "\t                }" + NL + "\t            });" + NL + "        \t} " + NL + "\t    \tif(listings_";
  protected final String TEXT_39 = " == null || listings_";
  protected final String TEXT_40 = ".length <= 0){" + NL + "\t    \t\tSystem.err.println(\"No match file(\"+key_";
  protected final String TEXT_41 = "+\") exists!\");" + NL + "\t    \t\t";
  protected final String TEXT_42 = NL + "       \t\t\tlog.error(\"";
  protected final String TEXT_43 = " - No match file(\"+key_";
  protected final String TEXT_44 = "+\") exists!\");" + NL + "        \t\t";
  protected final String TEXT_45 = NL + "\t    \t}else{" + NL + "\t    \t\tString localFilePath_";
  protected final String TEXT_46 = " = \"\";" + NL + "\t    \t\tString dbfsFilePath_";
  protected final String TEXT_47 = " = \"\";" + NL + "\t    \t\tfor (int m_";
  protected final String TEXT_48 = " = 0; m_";
  protected final String TEXT_49 = " < listings_";
  protected final String TEXT_50 = ".length; m_";
  protected final String TEXT_51 = "++){ " + NL + "\t     \t\t\tif (listings_";
  protected final String TEXT_52 = "[m_";
  protected final String TEXT_53 = "].getName().matches(mask_";
  protected final String TEXT_54 = ")){    " + NL + "\t     \t\t\t\tlocalFilePath_";
  protected final String TEXT_55 = " = listings_";
  protected final String TEXT_56 = "[m_";
  protected final String TEXT_57 = "].getAbsolutePath();" + NL + "\t     \t\t\t\tif(map_";
  protected final String TEXT_58 = ".get(key_";
  protected final String TEXT_59 = ") == null || map_";
  protected final String TEXT_60 = ".get(key_";
  protected final String TEXT_61 = ").isEmpty()){" + NL + "\t     \t\t\t\t\tdbfsFilePath_";
  protected final String TEXT_62 = " = java.nio.file.Paths.get(";
  protected final String TEXT_63 = ").resolve(java.nio.file.Paths.get(localFilePath_";
  protected final String TEXT_64 = ").getFileName().toString()).toString().replaceAll(\"\\\\\\\\\", \"/\");" + NL + "\t     \t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tdbfsFilePath_";
  protected final String TEXT_65 = " = java.nio.file.Paths.get(";
  protected final String TEXT_66 = ").resolve(map_";
  protected final String TEXT_67 = ".get(key_";
  protected final String TEXT_68 = ")).toString().replaceAll(\"\\\\\\\\\", \"/\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\tdbfs_";
  protected final String TEXT_69 = ".copyFromLocal(localFilePath_";
  protected final String TEXT_70 = ", dbfsFilePath_";
  protected final String TEXT_71 = ");" + NL + "\t\t    \t\t\t\t// add info to list will return" + NL + "\t\t    \t\t\t\tmsg_";
  protected final String TEXT_72 = ".add(\"file: \" + listings_";
  protected final String TEXT_73 = "[m_";
  protected final String TEXT_74 = "].getAbsolutePath() + \", size: \"" + NL + "\t\t                    \t+ listings_";
  protected final String TEXT_75 = "[m_";
  protected final String TEXT_76 = "].length() + \" bytes upload successfully\");" + NL + "\t\t                   " + NL + "\t\t    \t\t\t\tnb_success_";
  protected final String TEXT_77 = "++;" + NL + "\t\t    \t\t\t}catch(java.lang.Exception e) {" + NL + "\t\t                \t";
  protected final String TEXT_78 = NL + "            \t\t\t\tthrow(e);" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t\t\t\tSystem.err.print(e.getMessage());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_80 = NL + "       \t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_81 = " - \" + e.getMessage());" + NL + "        \t\t\t\t\t";
  protected final String TEXT_82 = NL + "\t\t                }" + NL + "\t\t\t\t\t\tnb_file_";
  protected final String TEXT_83 = "++;" + NL + "\t      \t\t\t}" + NL + "\t    \t\t}\t" + NL + "\t    \t}" + NL + "\t    }";
  protected final String TEXT_84 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String localdir = ElementParameterParser.getValue(node, "__LOCALDIR__");
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	String remotedir = ElementParameterParser.getValue(node, "__DATABRICKS_DBFS_FOLDER__");
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
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
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
  						      	if(("true").equals(dieOnError)){
							
    stringBuffer.append(TEXT_78);
    
								}else{
							
    stringBuffer.append(TEXT_79);
       
									if(isLog4jEnabled) {
							
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
        							}
								}
						    
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(TEXT_84);
    return stringBuffer.toString();
  }
}
