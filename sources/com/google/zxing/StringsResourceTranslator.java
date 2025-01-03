package com.google.zxing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class StringsResourceTranslator {
    public static final String APACHE_2_LICENSE = "<!--\n Copyright (C) 2015 ZXing authors\n\n Licensed under the Apache License, Version 2.0 (the \"License\");\n you may not use this file except in compliance with the License.\n You may obtain a copy of the License at\n\n      http://www.apache.org/licenses/LICENSE-2.0\n\n Unless required by applicable law or agreed to in writing, software\n distributed under the License is distributed on an \"AS IS\" BASIS,\n WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n See the License for the specific language governing permissions and\n limitations under the License.\n -->\n";
    public static final String API_KEY;
    public static final Pattern ENTRY_PATTERN;
    public static final Map<String, String> LANGUAGE_CODE_MASSAGINGS;
    public static final Pattern STRINGS_FILE_NAME_PATTERN;
    public static final Pattern TRANSLATE_RESPONSE_PATTERN;
    public static final Pattern VALUES_DIR_PATTERN;

    static {
        String property = System.getProperty("translateAPI.key");
        API_KEY = property;
        if (property == null) {
            throw new IllegalArgumentException("translateAPI.key is not specified");
        }
        ENTRY_PATTERN = Pattern.compile("<string name=\"([^\"]+)\".*>([^<]+)</string>");
        STRINGS_FILE_NAME_PATTERN = Pattern.compile("values-(.+)");
        TRANSLATE_RESPONSE_PATTERN = Pattern.compile("translatedText\":\\s*\"([^\"]+)\"");
        VALUES_DIR_PATTERN = Pattern.compile("values-[a-z]{2}(-[a-zA-Z]{2,3})?");
        HashMap hashMap = new HashMap(3);
        LANGUAGE_CODE_MASSAGINGS = hashMap;
        hashMap.put("zh-rCN", "zh-cn");
        LANGUAGE_CODE_MASSAGINGS.put("zh-rTW", "zh-tw");
    }

    public static CharSequence fetch(URI uri) throws IOException {
        URLConnection openConnection = uri.toURL().openConnection();
        openConnection.connect();
        StringBuilder sb = new StringBuilder(200);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openConnection.getInputStream(), StandardCharsets.UTF_8));
            try {
                char[] cArr = new char[8192];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (read <= 0) {
                        return sb;
                    }
                    sb.append(cArr, 0, read);
                }
            } finally {
                bufferedReader.close();
            }
        } finally {
        }
    }

    public static void main(String[] strArr) throws IOException {
        Path path = Paths.get(strArr[0], new String[0]);
        Path resolve = path.resolve("values").resolve("strings.xml");
        List subList = Arrays.asList(strArr).subList(1, strArr.length);
        try {
            DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(path, new DirectoryStream.Filter<Path>() { // from class: com.google.zxing.StringsResourceTranslator.1
                @Override // java.nio.file.DirectoryStream.Filter
                public boolean accept(Path path2) {
                    return Files.isDirectory(path2, new LinkOption[0]) && !Files.isSymbolicLink(path2) && StringsResourceTranslator.VALUES_DIR_PATTERN.matcher(path2.getFileName().toString()).matches();
                }
            });
            try {
                Iterator<Path> it = newDirectoryStream.iterator();
                while (it.hasNext()) {
                    translate(resolve, it.next().resolve("strings.xml"), subList);
                }
                if (newDirectoryStream != null) {
                    newDirectoryStream.close();
                }
            } finally {
            }
        } finally {
        }
    }

    public static Map<String, String> readLines(Path path) throws IOException {
        if (!Files.exists(path, new LinkOption[0])) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap();
        Iterator<String> it = Files.readAllLines(path, StandardCharsets.UTF_8).iterator();
        while (it.hasNext()) {
            Matcher matcher = ENTRY_PATTERN.matcher(it.next());
            if (matcher.find()) {
                treeMap.put(matcher.group(1), matcher.group(2));
            }
        }
        return treeMap;
    }

    public static void translate(Path path, Path path2, Collection<String> collection) throws IOException {
        Map<String, String> readLines = readLines(path);
        Map<String, String> readLines2 = readLines(path2);
        String path3 = path2.getParent().getFileName().toString();
        Matcher matcher = STRINGS_FILE_NAME_PATTERN.matcher(path3);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid parent dir: " + path3);
        }
        String group = matcher.group(1);
        String str = LANGUAGE_CODE_MASSAGINGS.get(group);
        if (str != null) {
            group = str;
        }
        System.out.println("Translating " + group);
        Path createTempFile = Files.createTempFile(null, null, new FileAttribute[0]);
        try {
            BufferedWriter newBufferedWriter = Files.newBufferedWriter(createTempFile, StandardCharsets.UTF_8, new OpenOption[0]);
            try {
                newBufferedWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
                newBufferedWriter.write(APACHE_2_LICENSE);
                newBufferedWriter.write("<resources>\n");
                boolean z = false;
                for (Map.Entry<String, String> entry : readLines.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    newBufferedWriter.write("  <string name=\"");
                    newBufferedWriter.write(key);
                    newBufferedWriter.write(34);
                    if (value.contains("%s") || value.contains("%f")) {
                        newBufferedWriter.write(" formatted=\"false\"");
                    }
                    newBufferedWriter.write(62);
                    String str2 = readLines2.get(key);
                    if (str2 == null || collection.contains(key)) {
                        str2 = translateString(value, group).replaceAll("'", "\\\\'");
                        z = true;
                    }
                    newBufferedWriter.write(str2);
                    newBufferedWriter.write("</string>\n");
                }
                newBufferedWriter.write("</resources>\n");
                newBufferedWriter.flush();
                if (newBufferedWriter != null) {
                    newBufferedWriter.close();
                }
                if (!z) {
                    Files.delete(createTempFile);
                } else {
                    System.out.println("  Writing translations");
                    Files.move(createTempFile, path2, StandardCopyOption.REPLACE_EXISTING);
                }
            } finally {
            }
        } finally {
        }
    }

    public static String translateString(String str, String str2) throws IOException {
        if ("en".equals(str2)) {
            return str;
        }
        String str3 = LANGUAGE_CODE_MASSAGINGS.get(str2);
        if (str3 != null) {
            str2 = str3;
        }
        System.out.println("  Need translation for " + str);
        CharSequence fetch = fetch(URI.create("https://www.googleapis.com/language/translate/v2?key=" + API_KEY + "&q=" + URLEncoder.encode(str, "UTF-8") + "&source=en&target=" + str2));
        Matcher matcher = TRANSLATE_RESPONSE_PATTERN.matcher(fetch);
        if (!matcher.find()) {
            System.err.println("No translate result");
            System.err.println(fetch);
            return str;
        }
        String replaceAll = matcher.group(1).replaceAll("&(amp;)?quot;", "\"").replaceAll("&(amp;)?#39;", "'");
        System.out.println("  Got translation " + replaceAll);
        return replaceAll;
    }
}
