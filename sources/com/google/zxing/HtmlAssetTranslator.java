package com.google.zxing;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public final class HtmlAssetTranslator {
    public static final Pattern COMMA = Pattern.compile(",");

    public static void main(String[] strArr) throws IOException {
        if (strArr.length < 3) {
            System.err.println("Usage: HtmlAssetTranslator android/assets/ (all|lang1[,lang2 ...]) (all|file1.html[ file2.html ...])");
            return;
        }
        Path path = Paths.get(strArr[0], new String[0]);
        Collection<String> parseLanguagesToTranslate = parseLanguagesToTranslate(path, strArr[1]);
        Collection<String> parseFileNamesToTranslate = parseFileNamesToTranslate(path, Arrays.asList(strArr).subList(2, strArr.length));
        Iterator<String> it = parseLanguagesToTranslate.iterator();
        while (it.hasNext()) {
            translateOneLanguage(path, it.next(), parseFileNamesToTranslate);
        }
    }

    public static Collection<String> parseFileNamesToTranslate(Path path, List<String> list) throws IOException {
        if (!"all".equals(list.get(0))) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        try {
            DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(path.resolve("html-en"), "*.html");
            try {
                Iterator<Path> it = newDirectoryStream.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getFileName().toString());
                }
                if (newDirectoryStream != null) {
                    newDirectoryStream.close();
                }
                return arrayList;
            } finally {
            }
        } finally {
        }
    }

    public static Collection<String> parseLanguagesToTranslate(Path path, String str) throws IOException {
        if (!"all".equals(str)) {
            return Arrays.asList(COMMA.split(str));
        }
        ArrayList arrayList = new ArrayList();
        try {
            DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(path, new DirectoryStream.Filter<Path>() { // from class: com.google.zxing.HtmlAssetTranslator.1
                @Override // java.nio.file.DirectoryStream.Filter
                public boolean accept(Path path2) {
                    String path3 = path2.getFileName().toString();
                    return Files.isDirectory(path2, new LinkOption[0]) && !Files.isSymbolicLink(path2) && path3.startsWith("html-") && !"html-en".equals(path3);
                }
            });
            try {
                Iterator<Path> it = newDirectoryStream.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getFileName().toString().substring(5));
                }
                if (newDirectoryStream != null) {
                    newDirectoryStream.close();
                }
                return arrayList;
            } finally {
            }
        } finally {
        }
    }

    public static boolean shouldTranslate(Node node) {
        String textContent;
        Node namedItem;
        String textContent2;
        NamedNodeMap attributes = node.getAttributes();
        if ((attributes == null || (namedItem = attributes.getNamedItem("class")) == null || (textContent2 = namedItem.getTextContent()) == null || !textContent2.contains("notranslate")) && !"script".equalsIgnoreCase(node.getNodeName()) && (textContent = node.getTextContent()) != null) {
            for (int i2 = 0; i2 < textContent.length(); i2++) {
                if (Character.isLetter(textContent.charAt(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void translateOneFile(String str, Path path, Path path2, String str2) throws IOException {
        Path resolve = path.resolve(path2.getFileName());
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(path2.toFile());
            Element documentElement = parse.getDocumentElement();
            documentElement.normalize();
            LinkedList linkedList = new LinkedList();
            linkedList.add(documentElement);
            while (true) {
                if (linkedList.isEmpty()) {
                    Text createTextNode = parse.createTextNode(str2);
                    Element createElement = parse.createElement("p");
                    createElement.appendChild(createTextNode);
                    documentElement.getElementsByTagName("body").item(0).appendChild(createElement);
                    try {
                        Files.write(resolve, Collections.singleton(((DOMImplementationLS) DOMImplementationRegistry.newInstance().getDOMImplementation("LS")).createLSSerializer().writeToString(parse).replaceAll("<\\?xml[^>]+>", "<!DOCTYPE HTML>")), StandardCharsets.UTF_8, new OpenOption[0]);
                        return;
                    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
                        throw new IllegalStateException(e2);
                    }
                }
                Node node = (Node) linkedList.poll();
                if (shouldTranslate(node)) {
                    NodeList childNodes = node.getChildNodes();
                    for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                        linkedList.add(childNodes.item(i2));
                    }
                }
                if (node.getNodeType() == 3) {
                    String textContent = node.getTextContent();
                    if (!textContent.trim().isEmpty()) {
                        node.setTextContent(String.valueOf(' ') + StringsResourceTranslator.translateString(textContent, str) + ' ');
                    }
                }
            }
        } catch (ParserConfigurationException e3) {
            throw new IllegalStateException(e3);
        } catch (SAXException e4) {
            throw new IOException(e4);
        }
    }

    public static void translateOneLanguage(Path path, String str, final Collection<String> collection) throws IOException {
        Path resolve = path.resolve("html-" + str);
        Files.createDirectories(resolve, new FileAttribute[0]);
        Path resolve2 = path.resolve("html-en");
        String translateString = StringsResourceTranslator.translateString("Translated by Google Translate.", str);
        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() { // from class: com.google.zxing.HtmlAssetTranslator.2
            @Override // java.nio.file.DirectoryStream.Filter
            public boolean accept(Path path2) {
                String path3 = path2.getFileName().toString();
                if (path3.endsWith(".html")) {
                    return collection.isEmpty() || collection.contains(path3);
                }
                return false;
            }
        };
        try {
            DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(resolve2, filter);
            try {
                Iterator<Path> it = newDirectoryStream.iterator();
                while (it.hasNext()) {
                    translateOneFile(str, resolve, it.next(), translateString);
                }
                if (newDirectoryStream != null) {
                    newDirectoryStream.close();
                }
            } finally {
            }
        } finally {
        }
    }
}
