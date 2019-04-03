package com.uframe.generator.util;

import org.xml.sax.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
import java.util.regex.*;
import java.util.*;

public class XMLHelper
{
    public static Document getLoadingDoc(final String file) throws FileNotFoundException, SAXException, IOException {
        return getLoadingDoc(new FileInputStream(file));
    }
    
    static Document getLoadingDoc(final InputStream in) throws SAXException, IOException {
        final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(false);
        dbf.setValidating(false);
        dbf.setCoalescing(false);
        dbf.setIgnoringComments(false);
        try {
            final DocumentBuilder db = dbf.newDocumentBuilder();
            db.setEntityResolver(new EntityResolver() {
                @Override
                public InputSource resolveEntity(final String publicId, final String systemId) throws SAXException, IOException {
                    final InputSource is = new InputSource(new StringReader(""));
                    is.setSystemId(systemId);
                    return is;
                }
            });
            final InputSource is = new InputSource(in);
            return db.parse(is);
        }
        catch (ParserConfigurationException x) {
            throw new Error(x);
        }
    }
    
    private static NodeData treeWalk(final Element elm) {
        final NodeData nodeData = new NodeData();
        nodeData.attributes = attrbiuteToMap(elm.getAttributes());
        nodeData.nodeName = elm.getNodeName();
        nodeData.childs = new ArrayList<NodeData>();
        nodeData.innerXML = childsAsText(elm, new StringBuffer(), true).toString();
        nodeData.outerXML = nodeAsText(elm, new StringBuffer(), true).toString();
        nodeData.nodeValue = getNodeValue(elm);
        final NodeList childs = elm.getChildNodes();
        for (int i = 0; i < childs.getLength(); ++i) {
            final Node node = childs.item(i);
            if (node.getNodeType() == 1) {
                nodeData.childs.add(treeWalk((Element)node));
            }
        }
        return nodeData;
    }
    
    private static StringBuffer childsAsText(final Element elm, final StringBuffer sb, final boolean ignoreComments) {
        final NodeList childs = elm.getChildNodes();
        for (int i = 0; i < childs.getLength(); ++i) {
            final Node child = childs.item(i);
            nodeAsText(child, sb, ignoreComments);
        }
        return sb;
    }
    
    private static StringBuffer nodeAsText(final Node elm, final StringBuffer sb, final boolean ignoreComments) {
        if (elm.getNodeType() == 4) {
            final CDATASection cdata = (CDATASection)elm;
            sb.append("<![CDATA[");
            sb.append(cdata.getData());
            sb.append("]]>");
            return sb;
        }
        if (elm.getNodeType() == 8) {
            if (ignoreComments) {
                return sb;
            }
            final Comment c = (Comment)elm;
            sb.append("<!--");
            sb.append(c.getData());
            sb.append("-->");
            return sb;
        }
        else {
            if (elm.getNodeType() == 3) {
                final Text t = (Text)elm;
                sb.append(StringHelper.escapeXml(t.getData(), "<&"));
                return sb;
            }
            final NodeList childs = elm.getChildNodes();
            sb.append("<" + elm.getNodeName());
            attributes2String(elm, sb);
            if (childs.getLength() > 0) {
                sb.append(">");
                for (int i = 0; i < childs.getLength(); ++i) {
                    final Node child = childs.item(i);
                    nodeAsText(child, sb, ignoreComments);
                }
                sb.append("</" + elm.getNodeName() + ">");
            }
            else {
                sb.append("/>");
            }
            return sb;
        }
    }
    
    private static void attributes2String(final Node elm, final StringBuffer sb) {
        final NamedNodeMap attributes = elm.getAttributes();
        if (attributes != null && attributes.getLength() > 0) {
            sb.append(" ");
            for (int j = 0; j < attributes.getLength(); ++j) {
                sb.append(String.format("%s=\"%s\"", attributes.item(j).getNodeName(), StringHelper.escapeXml(attributes.item(j).getNodeValue(), "<&\"")));
                if (j < attributes.getLength() - 1) {
                    sb.append(" ");
                }
            }
        }
    }
    
    public static Map<String, String> attrbiuteToMap(final NamedNodeMap attributes) {
        if (attributes == null) {
            return new LinkedHashMap<String, String>();
        }
        final Map<String, String> result = new LinkedHashMap<String, String>();
        for (int i = 0; i < attributes.getLength(); ++i) {
            result.put(attributes.item(i).getNodeName(), attributes.item(i).getNodeValue());
        }
        return result;
    }
    
    public static String getTextValue(final Element valueEle) {
        if (valueEle == null) {
            throw new IllegalArgumentException("Element must not be null");
        }
        final StringBuilder sb = new StringBuilder();
        final NodeList nl = valueEle.getChildNodes();
        for (int i = 0; i < nl.getLength(); ++i) {
            final Node item = nl.item(i);
            if ((item instanceof CharacterData && !(item instanceof Comment)) || item instanceof EntityReference) {
                sb.append(item.getNodeValue());
            }
            else if (item instanceof Element) {
                sb.append(getTextValue((Element)item));
            }
        }
        return sb.toString();
    }
    
    public static String getNodeValue(final Node node) {
        if (node instanceof Comment) {
            return null;
        }
        if (node instanceof CharacterData) {
            return ((CharacterData)node).getData();
        }
        if (node instanceof EntityReference) {
            return node.getNodeValue();
        }
        if (node instanceof Element) {
            return getTextValue((Element)node);
        }
        return node.getNodeValue();
    }
    
    public NodeData parseXML(final InputStream in) throws SAXException, IOException {
        final Document doc = getLoadingDoc(in);
        return treeWalk(doc.getDocumentElement());
    }
    
    public NodeData parseXML(final File file) throws SAXException, IOException {
        final FileInputStream in = new FileInputStream(file);
        try {
            return this.parseXML(in);
        }
        finally {
            in.close();
        }
    }
    
    public static String getXMLEncoding(final InputStream inputStream) throws UnsupportedEncodingException, IOException {
        return getXMLEncoding(IOHelper.toString("UTF-8", inputStream));
    }
    
    public static String getXMLEncoding(final String s) {
        if (s == null) {
            return null;
        }
        final Pattern p = Pattern.compile("<\\?xml.*encoding=[\"'](.*)[\"']\\?>");
        final Matcher m = p.matcher(s);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }
    
    public static String removeXmlns(final File file) throws IOException {
        final InputStream forEncodingInput = new FileInputStream(file);
        final String encoding = getXMLEncoding(forEncodingInput);
        forEncodingInput.close();
        final InputStream input = new FileInputStream(file);
        String xml = IOHelper.toString(encoding, input);
        xml = removeXmlns(xml);
        input.close();
        return xml;
    }
    
    public static String removeXmlns(String s) {
        if (s == null) {
            return null;
        }
        s = s.replaceAll("(?s)xmlns=['\"].*?['\"]", "");
        s = s.replaceAll("(?s)\\w*:schemaLocation=['\"].*?['\"]", "");
        return s;
    }
    
    public static Map<String, String> parse2Attributes(final String attributes) {
        final Map result = new HashMap();
        final Pattern p = Pattern.compile("(\\w+?)=['\"](.*?)['\"]");
        final Matcher m = p.matcher(attributes);
        while (m.find()) {
            result.put(m.group(1), StringHelper.unescapeXml(m.group(2)));
        }
        return (Map<String, String>)result;
    }
    
    public static void main(final String[] args) throws FileNotFoundException, SAXException, IOException {
        final String file = "D:/dev/workspaces/alipay/ali-generator/generator/src/table_test.xml";
        final NodeData nd = new XMLHelper().parseXML(new FileInputStream(new File(file)));
        final Map table = nd.attributes;
        final List columns = nd.childs;
        System.out.println(table);
        System.out.println(columns);
    }
    
    public static class NodeData
    {
        public String nodeName;
        public String nodeValue;
        public String innerXML;
        public String outerXML;
        public Map<String, String> attributes;
        public List<NodeData> childs;
        
        public NodeData() {
            this.attributes = new HashMap<String, String>();
            this.childs = new ArrayList<NodeData>();
        }
        
        @Override
        public String toString() {
            return "nodeName=" + this.nodeName + ",attributes=" + this.attributes + " nodeValue=" + this.nodeValue + " child:\n" + this.childs;
        }
        
        public Map<String, String> nodeNameAsAttributes(final String nodeNameKey) {
            final Map map = new HashMap();
            map.putAll(this.attributes);
            map.put(nodeNameKey, this.nodeName);
            return (Map<String, String>)map;
        }
        
        public List<Map<String, String>> childsAsListMap() {
            final List<Map<String, String>> result = new ArrayList<Map<String, String>>();
            for (final NodeData c : this.childs) {
                final Map map = new LinkedHashMap();
                map.put(c.nodeName, c.nodeValue);
                result.add(map);
            }
            return result;
        }
    }
}
