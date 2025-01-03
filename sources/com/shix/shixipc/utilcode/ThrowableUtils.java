package com.shix.shixipc.utilcode;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class ThrowableUtils {
    public static final String LINE_SEP = System.getProperty("line.separator");

    public ThrowableUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String getFullStackTrace(Throwable th) {
        List<String> list;
        ArrayList arrayList = new ArrayList();
        while (th != null && !arrayList.contains(th)) {
            arrayList.add(th);
            th = th.getCause();
        }
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        int i2 = size - 1;
        List<String> stackFrameList = getStackFrameList((Throwable) arrayList.get(i2));
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (size != 0) {
                list = getStackFrameList((Throwable) arrayList.get(size - 1));
                removeCommonFrames(stackFrameList, list);
            } else {
                list = stackFrameList;
            }
            if (size == i2) {
                arrayList2.add(((Throwable) arrayList.get(size)).toString());
            } else {
                arrayList2.add(" Caused by: " + ((Throwable) arrayList.get(size)).toString());
            }
            arrayList2.addAll(stackFrameList);
            stackFrameList = list;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append(LINE_SEP);
        }
        return sb.toString();
    }

    public static List<String> getStackFrameList(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        StringTokenizer stringTokenizer = new StringTokenizer(stringWriter.toString(), LINE_SEP);
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf("at");
            if (indexOf != -1 && nextToken.substring(0, indexOf).trim().isEmpty()) {
                arrayList.add(nextToken);
                z = true;
            } else if (z) {
                break;
            }
        }
        return arrayList;
    }

    public static void removeCommonFrames(List<String> list, List<String> list2) {
        int size = list.size() - 1;
        for (int size2 = list2.size() - 1; size >= 0 && size2 >= 0; size2--) {
            if (list.get(size).equals(list2.get(size2))) {
                list.remove(size);
            }
            size--;
        }
    }
}
