package org.talend.designer.codegen.translators.databases.dbspecifics.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.designer.runprocess.ProcessorUtilities;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class THiveInMainJava
{
  protected static String nl;
  public static synchronized THiveInMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveInMainJava result = new THiveInMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjava.io.File localPigLatin_";
  protected final String TEXT_3 = " = new java.io.File(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".hive\");" + NL + "\tjava.io.FileWriter fw_";
  protected final String TEXT_4 = " = new java.io.FileWriter(localPigLatin_";
  protected final String TEXT_5 = ".getAbsoluteFile());" + NL + "\tjava.io.BufferedWriter bw_";
  protected final String TEXT_6 = " = new java.io.BufferedWriter(fw_";
  protected final String TEXT_7 = ");" + NL + "\tjava.lang.StringBuilder libjars_";
  protected final String TEXT_8 = " = new StringBuilder();";
  protected final String TEXT_9 = " " + NL + "\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_10 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = "; ";
  protected final String TEXT_15 = " " + NL + "\t\t\tfinal String wasbPassword_";
  protected final String TEXT_16 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\t\t\tfinal String wasbPassword_";
  protected final String TEXT_19 = " = ";
  protected final String TEXT_20 = "; ";
  protected final String TEXT_21 = NL + "\t\torg.talend.bigdata.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_22 = " = new org.talend.bigdata.launcher.fs.AzureFileSystem(\"DefaultEndpointsProtocol=https;\"" + NL + "\t\t\t+ \"AccountName=\"" + NL + "\t\t\t+ ";
  protected final String TEXT_23 = NL + "\t\t\t+ \";\"" + NL + "\t\t\t+ \"AccountKey=\" + wasbPassword_";
  protected final String TEXT_24 = ", ";
  protected final String TEXT_25 = ");" + NL + "\t\t\t\t" + NL + "\t\torg.talend.bigdata.launcher.webhcat.WebHCatJob instance_";
  protected final String TEXT_26 = " = new org.talend.bigdata.launcher.webhcat.QueryJob(azureFs_";
  protected final String TEXT_27 = ", org.talend.bigdata.launcher.utils.JobType.HIVE);" + NL + "\t\t\t\t\t\t" + NL + "\t\tinstance_";
  protected final String TEXT_28 = ".setCredentials(new org.talend.bigdata.launcher.security.HDInsightCredentials(";
  protected final String TEXT_29 = ", hdInsightPassword_";
  protected final String TEXT_30 = "));" + NL + "\t\tinstance_";
  protected final String TEXT_31 = ".setUsername(";
  protected final String TEXT_32 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_33 = ".setWebhcatEndpoint(\"https\", ";
  protected final String TEXT_34 = " + \":\" + ";
  protected final String TEXT_35 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_36 = ".setStatusFolder(org.talend.bigdata.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_37 = "));" + NL + "\t\tinstance_";
  protected final String TEXT_38 = ".setRemoteFolder(org.talend.bigdata.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_39 = "));";
  protected final String TEXT_40 = NL + "\t\torg.talend.bigdata.launcher.webhcat.WebHCatJob instance_";
  protected final String TEXT_41 = " = (org.talend.bigdata.launcher.webhcat.WebHCatJob) globalMap.get(\"conn_";
  protected final String TEXT_42 = "\");" + NL + "\t\t" + NL + "\t\torg.talend.bigdata.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_43 = " = instance_";
  protected final String TEXT_44 = ".getFileSystem();\t\t" + NL + "\t\t" + NL + "\t\tjava.util.List<String> connectionCommandList_";
  protected final String TEXT_45 = " = (java.util.List<String>)globalMap.get(\"commandList_";
  protected final String TEXT_46 = "\");" + NL + "\t\tfor(String command : connectionCommandList_";
  protected final String TEXT_47 = ") {" + NL + "\t\t\tbw_";
  protected final String TEXT_48 = ".write(command);" + NL + "\t\t}";
  protected final String TEXT_49 = NL + "\t((org.talend.bigdata.launcher.webhcat.QueryJob)instance_";
  protected final String TEXT_50 = ").setFileToExecute(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".hive\");" + NL + "\tString wasbPath_";
  protected final String TEXT_51 = " = azureFs_";
  protected final String TEXT_52 = ".getFileSystemPrefix() + \"/\"\t+ instance_";
  protected final String TEXT_53 = ".getRemoteFolder()\t+ \"/libjars/\";";
  protected final String TEXT_54 = NL + "                bw_";
  protected final String TEXT_55 = ".write(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_56 = " + \";\");" + NL + "                bw_";
  protected final String TEXT_57 = ".write(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_58 = " + \";\");" + NL + "                bw_";
  protected final String TEXT_59 = ".write(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_60 = " + \";\");";
  protected final String TEXT_61 = NL + "                    bw_";
  protected final String TEXT_62 = ".write(\"SET \"+";
  protected final String TEXT_63 = "+\"=\"+";
  protected final String TEXT_64 = " + \";\");";
  protected final String TEXT_65 = NL + "            String dbname_";
  protected final String TEXT_66 = " = ";
  protected final String TEXT_67 = ";" + NL + "            if (dbname_";
  protected final String TEXT_68 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_69 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_70 = ".trim())) {" + NL + "                bw_";
  protected final String TEXT_71 = ".write(\"use \" + dbname_";
  protected final String TEXT_72 = " + \";\");" + NL + "            }";
  protected final String TEXT_73 = NL + "\tjava.lang.StringBuilder libjars_";
  protected final String TEXT_74 = " = new StringBuilder();" + NL + "\tString stagingBucketPath_";
  protected final String TEXT_75 = " = \"\";";
  protected final String TEXT_76 = NL + "        java.util.List<String> connectionCommandList_";
  protected final String TEXT_77 = " = new java.util.ArrayList<String>();  ";
  protected final String TEXT_78 = NL + "            connectionCommandList_";
  protected final String TEXT_79 = ".add(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_80 = " + \";\");" + NL + "            connectionCommandList_";
  protected final String TEXT_81 = ".add(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_82 = " + \";\");" + NL + "            connectionCommandList_";
  protected final String TEXT_83 = ".add(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_84 = " + \";\");";
  protected final String TEXT_85 = NL + "                connectionCommandList_";
  protected final String TEXT_86 = ".add(\"SET \"+";
  protected final String TEXT_87 = "+\"=\"+";
  protected final String TEXT_88 = " + \";\");";
  protected final String TEXT_89 = NL + NL + "        String dbname_";
  protected final String TEXT_90 = " = ";
  protected final String TEXT_91 = ";" + NL + "        if(dbname_";
  protected final String TEXT_92 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_93 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_94 = ".trim())) {" + NL + "            connectionCommandList_";
  protected final String TEXT_95 = ".add(\"use \" + dbname_";
  protected final String TEXT_96 = " + \";\");" + NL + "        }" + NL + "        " + NL + "        stagingBucketPath_";
  protected final String TEXT_97 = " = ";
  protected final String TEXT_98 = ";" + NL + "" + NL + "        org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob instance_";
  protected final String TEXT_99 = " =" + NL + "            new org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob.Builder()" + NL + "            .withTalendJobName(projectName + \"_\" + jobName + \"_\" + jobVersion.replace(\".\",\"_\") + \"_\" + pid)" + NL + "            .withClusterName(";
  protected final String TEXT_100 = ")" + NL + "            .withRegion(";
  protected final String TEXT_101 = ")" + NL + "            .withProjectId(";
  protected final String TEXT_102 = ")" + NL + "            .withJarsBucket(";
  protected final String TEXT_103 = ")";
  protected final String TEXT_104 = NL + "                .withServiceAccountCredentialsPath(";
  protected final String TEXT_105 = ")";
  protected final String TEXT_106 = NL + NL + "            .withInitialisationQueries(connectionCommandList_";
  protected final String TEXT_107 = ")" + NL + "            .build();";
  protected final String TEXT_108 = NL + "            for (String command: connectionCommandList_";
  protected final String TEXT_109 = " ) {" + NL + "                log.debug(\"Initialization command from ";
  protected final String TEXT_110 = ": \" + command);" + NL + "            }";
  protected final String TEXT_111 = NL + "        org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob instance_";
  protected final String TEXT_112 = " = (org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob) globalMap.get(\"conn_";
  protected final String TEXT_113 = "\");" + NL + "        stagingBucketPath_";
  protected final String TEXT_114 = " = (String) globalMap.get(\"stagingBucket_";
  protected final String TEXT_115 = "\");" + NL + "        instance_";
  protected final String TEXT_116 = ".clearQueriesCache();" + NL + "        instance_";
  protected final String TEXT_117 = ".clearLibJars();";
  protected final String TEXT_118 = NL + "\t\t";
  protected final String TEXT_119 = NL + "\tjava.lang.StringBuilder libjars_";
  protected final String TEXT_120 = " = new StringBuilder();" + NL + "\tString stagingBucketPath_";
  protected final String TEXT_121 = " = \"\";";
  protected final String TEXT_122 = NL + "        java.util.List<String> connectionCommandList_";
  protected final String TEXT_123 = " = new java.util.ArrayList<String>();  ";
  protected final String TEXT_124 = NL + "            connectionCommandList_";
  protected final String TEXT_125 = ".add(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_126 = " + \";\");" + NL + "            connectionCommandList_";
  protected final String TEXT_127 = ".add(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_128 = " + \";\");" + NL + "            connectionCommandList_";
  protected final String TEXT_129 = ".add(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_130 = " + \";\");";
  protected final String TEXT_131 = NL + "                connectionCommandList_";
  protected final String TEXT_132 = ".add(\"SET \"+";
  protected final String TEXT_133 = "+\"=\"+";
  protected final String TEXT_134 = " + \";\");";
  protected final String TEXT_135 = NL + NL + "        String dbname_";
  protected final String TEXT_136 = " = ";
  protected final String TEXT_137 = ";" + NL + "        if(dbname_";
  protected final String TEXT_138 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_139 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_140 = ".trim())) {" + NL + "            connectionCommandList_";
  protected final String TEXT_141 = ".add(\"use \" + dbname_";
  protected final String TEXT_142 = " + \";\");" + NL + "        }" + NL + "" + NL + "\t \tString api_token_";
  protected final String TEXT_143 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_144 = ");" + NL + "\t" + NL + "\t\torg.talend.bigdata.launcher.qubole.QuboleHiveClient instance_";
  protected final String TEXT_145 = " =" + NL + "\t\t\tnew org.talend.bigdata.launcher.qubole.QuboleHiveClient.Builder()" + NL + "\t\t\t\t.setApiKey(api_token_";
  protected final String TEXT_146 = ")" + NL + "\t\t\t\t";
  protected final String TEXT_147 = " .setApiEndpoint(";
  protected final String TEXT_148 = ") ";
  protected final String TEXT_149 = NL + "\t\t\t\t.build();" + NL + "        ";
  protected final String TEXT_150 = NL + "            for (String command: connectionCommandList_";
  protected final String TEXT_151 = " ) {" + NL + "                log.debug(\"Initialization command from ";
  protected final String TEXT_152 = ": \" + command);" + NL + "            }";
  protected final String TEXT_153 = NL + "        org.talend.bigdata.launcher.qubole.QuboleHiveClient instance_";
  protected final String TEXT_154 = " = (org.talend.bigdata.launcher.qubole.QuboleHiveClient) globalMap.get(\"conn_";
  protected final String TEXT_155 = "\");" + NL + "        java.util.List<String> connectionCommandList_";
  protected final String TEXT_156 = " = null;" + NL + "        if (globalMap.containsKey(\"conn_init_statements_";
  protected final String TEXT_157 = "\")) {" + NL + "        \tconnectionCommandList_";
  protected final String TEXT_158 = " = (java.util.List<String>) globalMap.get(\"conn_init_statements_";
  protected final String TEXT_159 = "\");" + NL + "        \tglobalMap.remove(\"conn_init_statements_";
  protected final String TEXT_160 = "\");" + NL + "        }";
  protected final String TEXT_161 = NL + "\t\troutines.system.GetJarsToRegister getJarsToRegister_";
  protected final String TEXT_162 = " = new routines.system.GetJarsToRegister();";
  protected final String TEXT_163 = NL + "                        bw_";
  protected final String TEXT_164 = ".write(\"ADD JAR \" + wasbPath_";
  protected final String TEXT_165 = " + new java.io.File(getJarsToRegister_";
  protected final String TEXT_166 = ".replaceJarPaths(\"";
  protected final String TEXT_167 = "\")).getName() + \";\");" + NL + "                        libjars_";
  protected final String TEXT_168 = ".append(getJarsToRegister_";
  protected final String TEXT_169 = ".replaceJarPaths(\"";
  protected final String TEXT_170 = "\") + \",\");";
  protected final String TEXT_171 = NL + "                    \t// Qubole hive 1.2 supports parquet by default.";
  protected final String TEXT_172 = NL + "                            log.debug(\"Query for ";
  protected final String TEXT_173 = ": \" + \"ADD JAR \" + stagingBucketPath_";
  protected final String TEXT_174 = " + new java.io.File(getJarsToRegister_";
  protected final String TEXT_175 = ".replaceJarPaths(\"";
  protected final String TEXT_176 = "\")).getName() + \";\");";
  protected final String TEXT_177 = NL + "                        instance_";
  protected final String TEXT_178 = ".addQuery(\"ADD JAR \" + stagingBucketPath_";
  protected final String TEXT_179 = " + new java.io.File(getJarsToRegister_";
  protected final String TEXT_180 = ".replaceJarPaths(\"";
  protected final String TEXT_181 = "\")).getName() + \";\");" + NL + "                        libjars_";
  protected final String TEXT_182 = ".append(getJarsToRegister_";
  protected final String TEXT_183 = ".replaceJarPaths(\"";
  protected final String TEXT_184 = "\") + \",\");";
  protected final String TEXT_185 = NL + "        bw_";
  protected final String TEXT_186 = ".write(";
  protected final String TEXT_187 = " + \";\");" + NL + "        globalMap.put(\"";
  protected final String TEXT_188 = "_QUERY\", ";
  protected final String TEXT_189 = ");" + NL + "" + NL + "        bw_";
  protected final String TEXT_190 = ".close();" + NL + "" + NL + "        if (libjars_";
  protected final String TEXT_191 = ".length() > 0) {" + NL + "            instance_";
  protected final String TEXT_192 = ".setLibJars(libjars_";
  protected final String TEXT_193 = ".toString().substring(0, libjars_";
  protected final String TEXT_194 = ".length()-1));" + NL + "        }" + NL + "        instance_";
  protected final String TEXT_195 = ".callWS(instance_";
  protected final String TEXT_196 = ".sendFiles());" + NL + "        int exitCode_";
  protected final String TEXT_197 = " = instance_";
  protected final String TEXT_198 = ".execute();" + NL + "        if (exitCode_";
  protected final String TEXT_199 = " > 0) {" + NL;
  protected final String TEXT_200 = NL + "                throw new Exception(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_201 = NL + "                    log.error(\"";
  protected final String TEXT_202 = " - The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_203 = NL + "                    System.err.println(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_204 = NL + "        }" + NL + "        java.io.InputStream ";
  protected final String TEXT_205 = " = instance_";
  protected final String TEXT_206 = ".getStdOut();";
  protected final String TEXT_207 = NL + "            log.debug(\"Query for ";
  protected final String TEXT_208 = ": \" + ";
  protected final String TEXT_209 = ".replace(\"';'\", \"'\\\\;'\") + \";\");";
  protected final String TEXT_210 = NL + "        // First we dump the select query of the user into google storage" + NL + "        // In order to do that we modify the query to add as a prefix:" + NL + "        // INSERT OVERWRITE DIRECTORY '$GOOGLE_JARS_BUCKET/hivetmp/' ROW FORMAT DELIMITED FIELDS TERMINATED BY '\\t'" + NL;
  protected final String TEXT_211 = NL + "        instance_";
  protected final String TEXT_212 = ".addQuery(\"INSERT OVERWRITE DIRECTORY '\" + ";
  protected final String TEXT_213 = " + \"' ROW FORMAT DELIMITED FIELDS TERMINATED BY '\\t' \"" + NL + "                + ";
  protected final String TEXT_214 = ".replace(\"';'\", \"'\\\\;'\") + \";\");" + NL + "        if (libjars_";
  protected final String TEXT_215 = ".length() > 0) {" + NL + "            instance_";
  protected final String TEXT_216 = ".addLibJars(libjars_";
  protected final String TEXT_217 = ".toString().substring(0, libjars_";
  protected final String TEXT_218 = ".length()-1));" + NL + "        }" + NL + "        int exitCode_";
  protected final String TEXT_219 = " = instance_";
  protected final String TEXT_220 = ".executeJob();" + NL + "        System.out.println(instance_";
  protected final String TEXT_221 = ".getJobLog());" + NL + "" + NL + "        if (exitCode_";
  protected final String TEXT_222 = " > 0) {";
  protected final String TEXT_223 = NL + "                throw new Exception(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_224 = NL + "                    log.error(\"";
  protected final String TEXT_225 = " - The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_226 = NL + "                    System.err.println(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_227 = NL + "        }" + NL + "" + NL + "        // We have the Hive table dump on google storage, we now need to retrieve it and transmit it to the tFileInputDelimtied";
  protected final String TEXT_228 = NL + "        org.jets3t.service.impl.rest.httpclient.GoogleStorageService service_";
  protected final String TEXT_229 = " = null;" + NL + "        java.util.List<java.io.InputStream> inputStreamList_";
  protected final String TEXT_230 = " = new java.util.ArrayList<>();" + NL + "        try {";
  protected final String TEXT_231 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_232 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_233 = ");";
  protected final String TEXT_234 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_235 = " = ";
  protected final String TEXT_236 = "; ";
  protected final String TEXT_237 = NL + NL + "            org.jets3t.service.security.GSCredentials credentials_";
  protected final String TEXT_238 = " = new org.jets3t.service.security.GSCredentials(";
  protected final String TEXT_239 = ",decryptedPassword_";
  protected final String TEXT_240 = ");" + NL + "" + NL + "            service_";
  protected final String TEXT_241 = " = new org.jets3t.service.impl.rest.httpclient.GoogleStorageService(credentials_";
  protected final String TEXT_242 = ",\" ";
  protected final String TEXT_243 = "\",null);" + NL + "            service_";
  protected final String TEXT_244 = ".getAccountOwner();" + NL + "" + NL + "            java.util.regex.Matcher m = org.talend.bigdata.launcher.google.dataproc.DataprocJobUtil.GS_URI_PATTERN.matcher(";
  protected final String TEXT_245 = ");" + NL + "            if (m.find()) {" + NL + "                String bucketName_";
  protected final String TEXT_246 = " = m.group(1);" + NL + "                String objectKey_";
  protected final String TEXT_247 = " = m.group(2);" + NL + "" + NL + "                org.jets3t.service.model.GSObject[] objects_";
  protected final String TEXT_248 = " = service_";
  protected final String TEXT_249 = ".listObjects(" + NL + "                    bucketName_";
  protected final String TEXT_250 = "," + NL + "                    objectKey_";
  protected final String TEXT_251 = "," + NL + "                    null" + NL + "                    );" + NL + "                for (org.jets3t.service.model.GSObject objectSummary_";
  protected final String TEXT_252 = " : objects_";
  protected final String TEXT_253 = ") {" + NL + "                    String objkey_";
  protected final String TEXT_254 = " = objectSummary_";
  protected final String TEXT_255 = ".getKey();" + NL + "                    org.jets3t.service.model.GSObject obj_";
  protected final String TEXT_256 = " = service_";
  protected final String TEXT_257 = ".getObject(bucketName_";
  protected final String TEXT_258 = ", objkey_";
  protected final String TEXT_259 = ");" + NL + "                    System.out.println(obj_";
  protected final String TEXT_260 = ");" + NL + "                    if (obj_";
  protected final String TEXT_261 = " != null) {" + NL + "                        if (!obj_";
  protected final String TEXT_262 = ".isDirectoryPlaceholder()) {" + NL + "                            inputStreamList_";
  protected final String TEXT_263 = ".add(obj_";
  protected final String TEXT_264 = ".getDataInputStream());" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "            }" + NL + "        } catch (java.lang.Exception e_";
  protected final String TEXT_265 = ") {";
  protected final String TEXT_266 = NL + "                throw(e_";
  protected final String TEXT_267 = ");";
  protected final String TEXT_268 = NL + "                if (e_";
  protected final String TEXT_269 = " instanceof org.jets3t.service.ServiceException) {" + NL + "                    org.jets3t.service.ServiceException servError_";
  protected final String TEXT_270 = " = (org.jets3t.service.ServiceException)e_";
  protected final String TEXT_271 = ";";
  protected final String TEXT_272 = NL + "                        log.error(\"";
  protected final String TEXT_273 = " - \" + servError_";
  protected final String TEXT_274 = ".getErrorCode());";
  protected final String TEXT_275 = NL + "                        System.err.println(\"Exception in component ";
  protected final String TEXT_276 = ":\");" + NL + "                        System.err.println(servError_";
  protected final String TEXT_277 = ".getMessage());";
  protected final String TEXT_278 = NL + "                    if (servError_";
  protected final String TEXT_279 = ".getErrorCode() != null) {";
  protected final String TEXT_280 = NL + "                            log.error(\"";
  protected final String TEXT_281 = " - \" + servError_";
  protected final String TEXT_282 = ".getErrorMessage());";
  protected final String TEXT_283 = NL + "                            System.err.println(servError_";
  protected final String TEXT_284 = ".getErrorCode());";
  protected final String TEXT_285 = NL + "                    }" + NL + "                    if (servError_";
  protected final String TEXT_286 = ".getErrorMessage() != null) {";
  protected final String TEXT_287 = NL + "                            log.error(\"";
  protected final String TEXT_288 = " - \" + e_";
  protected final String TEXT_289 = ".getMessage());";
  protected final String TEXT_290 = NL + "                            System.err.println(servError_";
  protected final String TEXT_291 = ".getErrorMessage());";
  protected final String TEXT_292 = NL + "                    }" + NL + "                } else {";
  protected final String TEXT_293 = NL + "                        log.error(\"";
  protected final String TEXT_294 = " - \" + e_";
  protected final String TEXT_295 = ".getMessage());";
  protected final String TEXT_296 = NL + "                        System.err.println(e_";
  protected final String TEXT_297 = ".getMessage());";
  protected final String TEXT_298 = NL + "                }";
  protected final String TEXT_299 = NL + "        } finally {" + NL + "            if (service_";
  protected final String TEXT_300 = " != null) {" + NL + "                service_";
  protected final String TEXT_301 = ".shutdown();" + NL + "            }" + NL + "        }" + NL + "        java.io.InputStream ";
  protected final String TEXT_302 = " =" + NL + "                new java.io.SequenceInputStream(java.util.Collections.enumeration(inputStreamList_";
  protected final String TEXT_303 = "));";
  protected final String TEXT_304 = NL + "        \tString queries_";
  protected final String TEXT_305 = " = \"\";" + NL + "        \tif (connectionCommandList_";
  protected final String TEXT_306 = " != null) {" + NL + "        \t\tfor (String command : connectionCommandList_";
  protected final String TEXT_307 = ") {" + NL + "        \t\t\tqueries_";
  protected final String TEXT_308 = " += command;" + NL + "        \t\t\t";
  protected final String TEXT_309 = NL + "        \t\t\t\tlog.info(\"";
  protected final String TEXT_310 = " - configuration properties set: \" + command);" + NL + "        \t\t\t";
  protected final String TEXT_311 = NL + "        \t\t}" + NL + "        \t}" + NL + "        \t" + NL + "        \tString query_";
  protected final String TEXT_312 = " = ";
  protected final String TEXT_313 = ";" + NL + "        \tqueries_";
  protected final String TEXT_314 = " = queries_";
  protected final String TEXT_315 = " + query_";
  protected final String TEXT_316 = ";" + NL + "" + NL + "\t\t    org.talend.bigdata.launcher.qubole.QuboleHiveClient.Job job_";
  protected final String TEXT_317 = " =" + NL + "\t\t    \tnew org.talend.bigdata.launcher.qubole.QuboleHiveClient.Job(queries_";
  protected final String TEXT_318 = ");" + NL + "\t\t\tjob_";
  protected final String TEXT_319 = ".setJobName(\"";
  protected final String TEXT_320 = "\");" + NL + "\t\t\tjob_";
  protected final String TEXT_321 = ".setUserAgent(routines.system.Constant.getUserAgent(\"";
  protected final String TEXT_322 = "\"));" + NL + "        \t";
  protected final String TEXT_323 = NL + "\t\t\tjob_";
  protected final String TEXT_324 = ".setClusterLabel(";
  protected final String TEXT_325 = ");" + NL + "\t\t\t";
  protected final String TEXT_326 = NL + "\t\t\tString execution_result_";
  protected final String TEXT_327 = " = instance_";
  protected final String TEXT_328 = ".execute(job_";
  protected final String TEXT_329 = ");" + NL + "" + NL + "\t\t\tjava.io.InputStream ";
  protected final String TEXT_330 = " = new java.io.ByteArrayInputStream(execution_result_";
  protected final String TEXT_331 = ".getBytes());" + NL + "\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	final String cid = node.getUniqueName();
	String processId = node.getProcess().getId();

	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	boolean useParquet = "true".equals(ElementParameterParser.getValue(node,"__USE_PARQUET__"));
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	boolean isLog4jEnabled = "true".equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

	String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);

    String theDistribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
    String theVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
    
	final String studioVersion = org.talend.commons.utils.VersionUtils.getDisplayVersion();

	String quboleClusterLabel = null;
	String quboleEndpoint = null;
	String encryptedToken = null;
    if ("true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"))) { //with connection
        String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        for (INode pNode : node.getProcess().getNodesOfType("tHiveConnection")) {
            if (connection!=null && connection.equals(pNode.getUniqueName())) {
                theDistribution = ElementParameterParser.getValue(pNode, "__DISTRIBUTION__");
                theVersion = ElementParameterParser.getValue(pNode, "__HIVE_VERSION__");
               	if (ElementParameterParser.getBooleanValue(pNode, "__QUBOLE_CLUSTER__")) {
					quboleClusterLabel = ElementParameterParser.getValue(pNode, "__QUBOLE_CLUSTER_LABEL__");
				}
                
            }
        }
    } else { // without connection
	    encryptedToken = ElementParameterParser.getEncryptedValue(node, "__QUBOLE_API_TOKEN__");
		if (ElementParameterParser.getBooleanValue(node, "__QUBOLE_ENDPOINT__")) {
			quboleEndpoint = ElementParameterParser.getValue(node, "__QUBOLE_ENDPOINT_URL__");
		}
		if (ElementParameterParser.getBooleanValue(node, "__QUBOLE_CLUSTER__")) {
			quboleClusterLabel = ElementParameterParser.getValue(node, "__QUBOLE_CLUSTER_LABEL__");
		}
	}

    org.talend.hadoop.distribution.component.HiveComponent hiveDistrib = null;
    try {
        hiveDistrib = (org.talend.hadoop.distribution.component.HiveComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(theDistribution, theVersion);
    } catch (java.lang.Exception e) {
        e.printStackTrace();
        return "";
    }
    boolean isCustom = hiveDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;

    if (hiveDistrib.isExecutedThroughWebHCat()) {

    stringBuffer.append(TEXT_1);
    
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
	if("false".equals(useExistingConn)) {
		String passwordFieldName = "__HDINSIGHT_PASSWORD__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_11);
    
		} else {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_14);
    
		}
			
		passwordFieldName = "__WASB_PASSWORD__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_17);
    
		} else {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_20);
    
		}

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_USERNAME__"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_CONTAINER__"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HDINSIGHT_USERNAME__"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_USERNAME__"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_HOST__"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_PORT__"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(ElementParameterParser.getValue(node, "__STATUSDIR__"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(ElementParameterParser.getValue(node, "__REMOTE_FOLDER__"));
    stringBuffer.append(TEXT_39);
    
	} else {
		String azureConnection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(azureConnection);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(azureConnection);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
	}

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
        if ("false".equals(useExistingConn)) { // This variable is declared and initialized in the GetAzureConnection.javajet
            boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
            if (setMemory) {
                String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
                String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
                String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_60);
    
            }

            List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
            if (advProps!=null) {
                for(Map<String, String> item : advProps) {

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_64);
    
                }
            }

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
        }
    }
    if (hiveDistrib.isGoogleDataprocDistribution()) {

    
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
	if("false".equals(useExistingConn)) {

    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
        boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
        if(setMemory) {
            String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
            String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
            String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_84);
    
        }

        List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
        if(advProps!=null) {
            for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_88);
    
            }
        }

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_JARS_BUCKET__"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_CLUSTER_ID__"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_REGION__"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_PROJECT_ID__"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_JARS_BUCKET__"));
    stringBuffer.append(TEXT_103);
    
            if(ElementParameterParser.getBooleanValue(node, "__DEFINE_PATH_TO_GOOGLE_CREDENTIALS__")) {

    stringBuffer.append(TEXT_104);
    stringBuffer.append(ElementParameterParser.getValue(node, "__PATH_TO_GOOGLE_CREDENTIALS__"));
    stringBuffer.append(TEXT_105);
                  
            }

    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
        if(isLog4jEnabled) {

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    
        }
	} else {
		String dataprocConnection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(dataprocConnection);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(dataprocConnection);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    
	}

    
    }
    if (hiveDistrib.isQuboleDistribution()) {

    stringBuffer.append(TEXT_118);
    
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    
	if("false".equals(useExistingConn)) {

    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
        boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
        if(setMemory) {
            String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
            String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
            String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_130);
    
        }

        List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
        if(advProps!=null) {
            for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_134);
    
            }
        }

    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(encryptedToken);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
     if (quboleEndpoint != null) {
    stringBuffer.append(TEXT_147);
    stringBuffer.append(quboleEndpoint);
    stringBuffer.append(TEXT_148);
    } 
    stringBuffer.append(TEXT_149);
    
        if(isLog4jEnabled) {

    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    
        }
	} else {
		String quboleConnection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(quboleConnection);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(quboleConnection);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(quboleConnection);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(quboleConnection);
    stringBuffer.append(TEXT_160);
    
	}

    
	}

	// Register jars

	java.util.List<String> jarsToRegister = null;
	java.util.List<String> jars = null;
	String[] commandLine = new String[] {"<command>"};
	try {
		commandLine = ProcessorUtilities.getCommandLine("win32", true, processId, "",org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, new String[]{});
	} catch (ProcessorException e) {
		e.printStackTrace();
	}

	jarsToRegister = new java.util.ArrayList();

    if (useParquet) {
	  jarsToRegister.add("snappy-java");
	  jarsToRegister.add("parquet-hive-bundle");
	}
	jarsToRegister.add("jets3t");

	for (int j = 0; j < commandLine.length; j++) {
		if (commandLine[j].contains("jar")) {
			jars = java.util.Arrays.asList(commandLine[j].split(";"));
			break;
		}
	}


	if (jarsToRegister!=null && jars!=null) {

    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    
		for(int i=0; i<jarsToRegister.size(); i++) {
			String jarToRegister = jarsToRegister.get(i);
			for(int j=0; j<jars.size(); j++) {
                if (jars.get(j).contains(jarToRegister)) {
                    if (hiveDistrib.isExecutedThroughWebHCat()) {

    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_170);
    
                    } else if (hiveDistrib.isQuboleDistribution()) {
                    
    stringBuffer.append(TEXT_171);
    
                    } else { // dataproc
                        if (isLog4jEnabled) {

    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_176);
    
                        }

    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_184);
    
                    }
                }
            }
        }
    }
	// End of parquet format handling.

	if (hiveDistrib.isExecutedThroughWebHCat()) {

    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid.replaceAll("tHiveIn", "tHiveInput"));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    
            if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_200);
    
            } else {
                if (isLog4jEnabled) {

    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    
                } else {

    stringBuffer.append(TEXT_203);
    
                }
            }

    stringBuffer.append(TEXT_204);
    stringBuffer.append(ElementParameterParser.getValue(node, "__INPUT_STREAM_NAME__"));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    
    }

    if (hiveDistrib.isGoogleDataprocDistribution()) {
        if (isLog4jEnabled) {

    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_209);
    
        }

    stringBuffer.append(TEXT_210);
    
        String gsTempDir = "";
        if(ElementParameterParser.getBooleanValue(node,"__USE_EXISTING_CONNECTION__")) {
            String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
            for (INode pNode : node.getProcess().getNodesOfType("tHiveConnection")) {
                if (connection != null && connection.equals(pNode.getUniqueName())) {
                    gsTempDir = ElementParameterParser.getValue(pNode, "__GOOGLE_JARS_BUCKET__") + " + \"hivetemp\" ";
                    break;
                }
            }
        } else {
            gsTempDir = ElementParameterParser.getValue(node, "__GOOGLE_JARS_BUCKET__") + " + \"hivetemp\" ";
        }
        
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(gsTempDir);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    
            if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_223);
    
            } else {
                if (isLog4jEnabled) {

    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    
                } else {

    stringBuffer.append(TEXT_226);
    
                }
            }

    stringBuffer.append(TEXT_227);
    
        String accessKey = ElementParameterParser.getValue(node,"__ACCESS_KEY__");
        String passwordFieldName = "__SECRET_KEY__";
        final String GoogleTracker = org.talend.core.utils.TrackerUtil.getGoogleTracker();
        
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_233);
    } else {
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_236);
    }
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(GoogleTracker);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(gsTempDir);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    
            if (("true").equals(dieOnError)) {
            
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    
            } else {
            
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    
                    if (isLog4jEnabled) {
                    
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    
                    } else {
                    
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    
                    }
                    
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    
                        if (isLog4jEnabled) {
                        
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    
                        } else {
                        
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    
                        }
                        
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    
                        if (isLog4jEnabled) {
                        
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    
                        } else {
                        
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    
                        }
                        
    stringBuffer.append(TEXT_292);
    
                    if (isLog4jEnabled) {
                    
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    
                    } else {
                    
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    
                    }
                    
    stringBuffer.append(TEXT_298);
    
            }
            
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(ElementParameterParser.getValue(node, "__INPUT_STREAM_NAME__"));
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    
    }
    if (hiveDistrib.isQuboleDistribution()) { // qubole execution
        
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
     if (isLog4jEnabled) { 
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
     } 
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_312);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(studioVersion);
    stringBuffer.append(TEXT_322);
     if (quboleClusterLabel != null) { 
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(quboleClusterLabel);
    stringBuffer.append(TEXT_325);
     } 
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(ElementParameterParser.getValue(node, "__INPUT_STREAM_NAME__"));
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    
    }

    return stringBuffer.toString();
  }
}
