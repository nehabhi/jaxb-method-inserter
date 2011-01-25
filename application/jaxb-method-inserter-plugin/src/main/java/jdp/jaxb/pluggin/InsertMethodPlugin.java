package jdp.jaxb.pluggin;

import java.util.Collections;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import com.sun.tools.xjc.Options;
import com.sun.tools.xjc.Plugin;
import com.sun.tools.xjc.model.CPluginCustomization;
import com.sun.tools.xjc.outline.ClassOutline;
import com.sun.tools.xjc.outline.Outline;

public class InsertMethodPlugin extends Plugin {
    public String getOptionName() {
        return "Xmethod-injector";
    }

    private static final String NS = "http://jaxb.dev.java.net/plugin/method-injector";

    public List<String> getCustomizationURIs() {
        return Collections.singletonList(NS);
    }

    public boolean isCustomizationTagName(String nsUri, String localName) {
        return nsUri.equals(NS) && localName.equals("methods");
    }

    public String getUsage() {
        return "  -Xmethod-injector      :  inject methods that can then be used to add hooks into generated classes";
    }

 
    public boolean run(Outline model, Options opt, ErrorHandler errorHandler) throws SAXException {
        for (ClassOutline co : model.getClasses()) {
            CPluginCustomization c = co.target.getCustomizations().find(NS, "methods");
            if (c == null) {
                continue; // no customization --- nothing to inject here
            }
            c.markAsAcknowledged();

            NodeList nodeList = c.element.getChildNodes();
            int lenght = nodeList.getLength();
            for (int i = 0; i < lenght - 1; i++) {
                Node node = nodeList.item(i);
                forEachMethod(node, co);
            }
        }
        return true;
    }

    private void forEachMethod(Node node, ClassOutline co) {
        String returnType = node.getAttributes().getNamedItem("returnType").getNodeValue();
        String methodName = node.getAttributes().getNamedItem("methodName").getNodeValue();

        if (returnType == null || returnType.equals("") || methodName == null || methodName.equals("")) {
            return;
        }
        if (returnType.equals("byte")) {
            co.implClass.direct("\n    public " + returnType + " " + methodName + "() {\n        return ((Byte)jdp.jaxb.pluggin.MethodInvoker.invokeStaticMethod(this, \"" + methodName + "\")); \n    }\n");
        } else if (returnType.equals("short")) {
            co.implClass.direct("\n    public " + returnType + " " + methodName + "() {\n        return ((Short)jdp.jaxb.pluggin.MethodInvoker.invokeStaticMethod(this, \"" + methodName + "\")); \n    }\n");
        } else if (returnType.equals("int")) {
            co.implClass.direct("\n    public " + returnType + " " + methodName + "() {\n        return ((Integer)jdp.jaxb.pluggin.MethodInvoker.invokeStaticMethod(this, \"" + methodName + "\")); \n    }\n");
        } else if (returnType.equals("long")) {
            co.implClass.direct("\n    public " + returnType + " " + methodName + "() {\n        return ((Long)jdp.jaxb.pluggin.MethodInvoker.invokeStaticMethod(this, \"" + methodName + "\")); \n    }\n");
        } else if (returnType.equals("float")) {
            co.implClass.direct("\n    public " + returnType + " " + methodName + "() {\n        return ((Float)jdp.jaxb.pluggin.MethodInvoker.invokeStaticMethod(this, \"" + methodName + "\")); \n    }\n");
        } else if (returnType.equals("double")) {
            co.implClass.direct("\n    public " + returnType + " " + methodName + "() {\n        return ((Double)jdp.jaxb.pluggin.MethodInvoker.invokeStaticMethod(this, \"" + methodName + "\")); \n    }\n");
        } else if (returnType.equals("boolean")) {
            co.implClass.direct("\n    public " + returnType + " " + methodName + "() {\n        return ((Boolean)jdp.jaxb.pluggin.MethodInvoker.invokeStaticMethod(this, \"" + methodName + "\")); \n    }\n");
        } else if (returnType.equals("char")) {
            co.implClass.direct("\n    public " + returnType + " " + methodName + "() {\n        return ((Char)jdp.jaxb.pluggin.MethodInvoker.invokeStaticMethod(this, \"" + methodName + "\")); \n    }\n");
        } else {
            co.implClass.direct("\n    public " + returnType + " " + methodName + "() {\n        return  (" + returnType + ") jdp.jaxb.pluggin.MethodInvoker.invokeStaticMethod(this, \"" + methodName + "\"); \n    }\n");
        }
    }

}
