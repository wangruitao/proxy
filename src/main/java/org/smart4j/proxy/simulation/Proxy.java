package org.smart4j.proxy.simulation;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Proxy {

	public static Object newProxyInstance(Class<?> cls, InvocationHandler ih) {

		String javaFilePath = System.getProperty("user.dir") + "\\src";
		
		String methodStr = "";
		Method[] methods = cls.getMethods();
		String rt = "\r\n";
		
		for(Method m : methods) {
			
			methodStr += rt + rt + "	@Override                                                              " + rt
			+ "	public void " + m.getName() + "() {          "	+ rt
			+ "		try { " + rt
			+ "     	Method m =    "  + cls.getName() + ".class.getMethod(\"" + m.getName() + "\");  " + rt
			+ "			ih.invoke(this, m, null);" + rt
			+ "		} catch (Exception e) { " + rt
			+ "			e.printStackTrace();" + rt
			+ "		}	" + rt
			+ "	}";
		}
		
		
		String str =  "package org.smart4j.proxy.simulation;                                 "
				+ "import java.lang.reflect.Method;  " + rt
				+ "public class $Proxy implements " + cls.getName() + " {                         " + rt
				+ "                                                                        " + rt
				+ "	private  " + ih.getClass().getName() + " ih;                                          " + rt
				+ "	                                                                       " + rt
				+ "	public $Proxy(" + ih.getClass().getName() +  " ih) {                                " + rt
				+ "		super();                                                             " + rt
				+ "		this.ih = ih;                                                      " + rt
				+ "	}                                                                      " + rt
				+ methodStr + rt
				+ "}";
		
		String pathName = javaFilePath + "\\main\\java\\org\\smart4j\\proxy\\simulation\\$Proxy.java";
		try {
			FileWriter fos = new FileWriter(pathName);
			fos.write(str);
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 使用JavaCompiler 编译java文件 
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null); 
		Iterable<? extends JavaFileObject> fileObjects = fileManager.getJavaFileObjects(pathName);  
        CompilationTask cTask = compiler.getTask(null, fileManager, null, null, null, fileObjects);  
        cTask.call();  
        try {
			fileManager.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  
        
        Object obj = null;
        try {
			// 使用URLClassLoader加载class到内存  
			URL[] urls = new URL[] { new URL("file:/" + javaFilePath + "/main/java/") };
			URLClassLoader cLoader = new URLClassLoader(urls);
			Class<?> c = cLoader.loadClass("org.smart4j.proxy.simulation.$Proxy");
			// 利用class创建实例，反射执行方法  
			Constructor<?> constructor =  c.getConstructor(new Class[]{ih.getClass()});

			obj = constructor.newInstance(ih);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}
