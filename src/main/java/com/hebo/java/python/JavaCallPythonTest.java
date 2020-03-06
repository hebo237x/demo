package com.hebo.java.python;

import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import java.util.Properties;

/**
 * @author bo.he@ttpai.cn
 */
public class JavaCallPythonTest {

    public static void main(String[] args){
        Properties props = new Properties();
        props.put("python.home", "path to the Lib folder");
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "false");
        Properties preprops = System.getProperties();
        PythonInterpreter.initialize(preprops, props, new String[0]);


        // 1. Python面向函数式编程: 在Java中调用Python函数
        String pythonFunc = "C:\\ttpai\\python_workspace\\Python-100-Days\\Day01-15\\Day02\\code\\calculator_pow.py";

        PythonInterpreter pi1 = new PythonInterpreter();
        // 加载python程序
        pi1.execfile(pythonFunc);
        // 调用Python程序中的函数
        PyFunction pyf = pi1.get("pow", PyFunction.class);
        PyObject dddRes = pyf.__call__(Py.newInteger(2), Py.newInteger(3));
        System.out.println(dddRes);
        pi1.cleanup();
        pi1.close();

    }
}
