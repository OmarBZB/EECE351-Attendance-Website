/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.41
 * Generated at: 2020-12-10 23:30:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.io.*;

public final class ClassInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("java.io");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");

	String CurrentUser = (String) session.getAttribute("UserName");
if (CurrentUser == null || CurrentUser == "") {
	RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
	PrintWriter cout = response.getWriter();
	cout.println("<html><head>");
	cout.println("<h2 align=center><font color=red face =Verdana, Geneva, sans-serif size=+1>"
	+ "You are not logged in!</font></h2>");
	cout.println("</head><body></body></html>");
	rd.include(request, response);

} else {

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Attendance Server</title>\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"favicon.ico\" />\r\n");
      out.write("<style>\r\n");
      out.write("body {\r\n");
      out.write("\tbackground-image: linear-gradient(rgba(0, 0, 0, 0.55),\r\n");
      out.write("\t\trgba(0, 0, 0, 0.5)), url(backround.png);\r\n");
      out.write("\theight: 100vh;\r\n");
      out.write("\tbackground-size: cover;\r\n");
      out.write("\tbackground-position: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".button {\r\n");
      out.write("\tbackground-color: #4CAF50; /* Green */\r\n");
      out.write("\tborder: none;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tpadding: 15px 32px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\tfont-size: 16px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".LogOutbutton {\r\n");
      out.write("\tbackground-color: #4CAF50; /* Green */\r\n");
      out.write("\tborder: none;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tpadding: 15px 32px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\tfont-size: 16px;\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("\tmargin-top: 80px;\r\n");
      out.write("\tmargin-right: 120px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".container {\r\n");
      out.write("\theight: 200px;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".center {\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: 50%;\r\n");
      out.write("\tleft: 50%;\r\n");
      out.write("\t-ms-transform: translate(-50%, -50%);\r\n");
      out.write("\ttransform: translate(-50%, -50%);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".forms input {\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tz-index: 1;\r\n");
      out.write("\tmax-width: 200px;\r\n");
      out.write("\tmargin: 0 auto 100px;\r\n");
      out.write("\tpadding: 45px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tfont-family: \"Roboto\", sans-serif;\r\n");
      out.write("\toutline: 1;\r\n");
      out.write("\tbackground: #f2f2f2;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\tborder: 0;\r\n");
      out.write("\tmargin: 0 0 15px;\r\n");
      out.write("\tpadding: 15px;\r\n");
      out.write("\tbox-sizing: 14px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".formsSort input {\r\n");
      out.write("\tbackground-color: #4CAF50;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"header\">\r\n");
      out.write("\t\t<h1 align=\"center\">Welcome, Instructor ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${UserName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" !</h1>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"center\">\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<form action=\"LogoutFunc\" method=\"post\">\r\n");
      out.write("\t\t\t<input type=\"submit\" class=\"LogOutbutton\" value=\"Logout\" />\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"ShowHideButton\">\r\n");
      out.write("\t\t<div style=\"align: center\">\r\n");
      out.write("\t\t\t<button onclick=\"myFunctionUpdateButton()\" class=\"button\">Update\r\n");
      out.write("\t\t\t\tTable...</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"UpdateTableButton\"\r\n");
      out.write("\t\t\tstyle=\"display: none; margin: 25px 0px 0px; float: left; max-width: 700px;\">\r\n");
      out.write("\t\t\t<button onclick=\"myFunctionTimeButton()\" class=\"button\">Change\r\n");
      out.write("\t\t\t\tTime</button>\r\n");
      out.write("\t\t\t<div align=\"left\" id=\"UpdateTimeButton\"\r\n");
      out.write("\t\t\t\tstyle=\"display: none; margin: 20px 0px 0px; position: fixed;\">\r\n");
      out.write("\t\t\t\t<form class=\"forms\" method=\"post\" action=\"updateTime\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" placeholder=\"Enter Student ID\" name=\"studentID\" />\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" placeholder=\"Enter In Time (hh:mm:ss)\"\r\n");
      out.write("\t\t\t\t\t\tname=\"updatedInTime\" /> <input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\tplaceholder=\"Enter Out Time (hh:mm:ss)\" name=\"updatedOutTime\" />\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" value=Change-Time style=\"margin-bottom: 25px\">Change\r\n");
      out.write("\t\t\t\t\t\tTime</button>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<button onclick=\"myFunctionRemoveButton()\" class=\"button\">Remove\r\n");
      out.write("\t\t\t\tStudent</button>\r\n");
      out.write("\t\t\t<div id=\"RemoveStudentButton\"\r\n");
      out.write("\t\t\t\tstyle=\"display: none; margin: 20px 0px 0px; position: fixed;\">\r\n");
      out.write("\t\t\t\t<form class=\"forms\" method=\"post\" action=\"removeStudent\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" placeholder=\"Enter Student ID\" name=\"studentID\" />\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" value=Remove-Student>Remove Student</button>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<button onclick=\"myFunctionAddButton()\" class=\"button\">Add\r\n");
      out.write("\t\t\t\tStudent</button>\r\n");
      out.write("\t\t\t<div id=\"AddStudentButton\"\r\n");
      out.write("\t\t\t\tstyle=\"display: none; margin: 20px 0px 0px; position: fixed;\">\r\n");
      out.write("\t\t\t\t<form class=\"forms\" method=\"post\" action=\"addStudent\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" placeholder=\"Enter Student ID\" name=\"studentID\" />\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" placeholder=\"Enter Date Attended (yyyy:mm:dd)\"\r\n");
      out.write("\t\t\t\t\t\tname=\"dateAttended\" /> <input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\tplaceholder=\"Enter In Time (hh:mm:ss)\" name=\"updatedInTime\" /> <input\r\n");
      out.write("\t\t\t\t\t\ttype=\"text\" placeholder=\"Enter Out Time (hh:mm:ss)\"\r\n");
      out.write("\t\t\t\t\t\tname=\"updatedOutTime\" />\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" value=Remove-Student>Add Student</button>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<button onclick=\"myFunctionSortButton()\" class=\"button\">Sort\r\n");
      out.write("\t\t\t\tBy...</button>\r\n");
      out.write("\t\t\t<div id=\"SortButton\" style=\"display: none; margin: 20px 0px 0px; position: fixed;\">\r\n");
      out.write("\t\t\t\t<form class=\"formsSort\" method=\"post\" action=\"sortStudents\">\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" name=\"sortButton\" value=\"By ID\" /> <input\r\n");
      out.write("\t\t\t\t\t\ttype=\"submit\" name=\"sortButton\" value=\"By Date\" /> <input\r\n");
      out.write("\t\t\t\t\t\ttype=\"submit\" name=\"sortButton\" value=\"By In Time\" /> <input\r\n");
      out.write("\t\t\t\t\t\ttype=\"submit\" name=\"sortButton\" value=\"By Out Time\" /> <input\r\n");
      out.write("\t\t\t\t\t\ttype=\"submit\" name=\"sortButton\" value=\"By Total Time\" />\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div style=\"float: right; margin-right: 540px; position: :fixed;\">\r\n");
      out.write("\t\t\t<h2 align=\"center\">\r\n");
      out.write("\t\t\t\t<font><strong>EECE 351 Class</strong></font>\r\n");
      out.write("\t\t\t</h2>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<table cellpadding=\"5\" cellspacing=\"5\" border=\"1\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr bgcolor=\"#11749e\">\r\n");
      out.write("\t\t\t\t\t<td><b>id</b></td>\r\n");
      out.write("\t\t\t\t\t<td><b>date</b></td>\r\n");
      out.write("\t\t\t\t\t<td><b>in time</b></td>\r\n");
      out.write("\t\t\t\t\t<td><b>out time</b></td>\r\n");
      out.write("\t\t\t\t\t<td><b>total time</b></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");

					String sortOrder = (String) session.getAttribute("sortingOrder");
				ArrayList<ArrayList<String>> Rows = com.classes.getClass.getClassInfo(sortOrder);
				for (ArrayList<String> row : Rows) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<tr bgcolor=\"#a2e8eb\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(row.get(0));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(row.get(1));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(row.get(2));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(row.get(3));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(row.get(4));
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\t\tfunction myFunctionUpdateButton() {\r\n");
      out.write("\t\t\tvar thisButton = document.getElementById(\"UpdateTableButton\");\r\n");
      out.write("\t\t\tif (thisButton.style.display === \"none\") {\r\n");
      out.write("\t\t\t\tthisButton.style.display = \"block\";\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tthisButton.style.display = \"none\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tvar e1 = document.getElementById(\"UpdateTimeButton\");\r\n");
      out.write("\t\tvar e2 = document.getElementById(\"RemoveStudentButton\");\r\n");
      out.write("\t\tvar e3 = document.getElementById(\"AddStudentButton\");\r\n");
      out.write("\t\tvar e4 = document.getElementById(\"SortButton\");\r\n");
      out.write("\r\n");
      out.write("\t\tfunction myFunctionTimeButton() {\r\n");
      out.write("\t\t\tif (e1.style.display === \"none\") {\r\n");
      out.write("\t\t\t\tif(e2.style.display === \"block\")\r\n");
      out.write("\t\t\t\t\te2.style.display = \"none\";\r\n");
      out.write("\t\t\t\tif(e3.style.display === \"block\")\r\n");
      out.write("\t\t\t\t\te3.style.display = \"none\";\r\n");
      out.write("\t\t\t\tif(e4.style.display === \"block\")\r\n");
      out.write("\t\t\t\t\te4.style.display = \"none\";\r\n");
      out.write("\t\t\t\te1.style.display = \"block\";\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\te1.style.display = \"none\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction myFunctionRemoveButton() {\r\n");
      out.write("\t\t\tif (e2.style.display === \"none\") {\r\n");
      out.write("\t\t\t\tif(e1.style.display === \"block\")\r\n");
      out.write("\t\t\t\t\te1.style.display = \"none\";\r\n");
      out.write("\t\t\t\tif(e3.style.display === \"block\")\r\n");
      out.write("\t\t\t\t\te3.style.display = \"none\";\r\n");
      out.write("\t\t\t\tif(e4.style.display === \"block\")\r\n");
      out.write("\t\t\t\t\te4.style.display = \"none\";\r\n");
      out.write("\t\t\t\te2.style.display = \"block\";\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\te2.style.display = \"none\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction myFunctionAddButton() {\r\n");
      out.write("\t\t\tif (e3.style.display === \"none\") {\r\n");
      out.write("\t\t\t\tif(e1.style.display === \"block\")\r\n");
      out.write("\t\t\t\t\te1.style.display = \"none\";\r\n");
      out.write("\t\t\t\tif(e2.style.display === \"block\")\r\n");
      out.write("\t\t\t\t\te2.style.display = \"none\";\r\n");
      out.write("\t\t\t\tif(e4.style.display === \"block\")\r\n");
      out.write("\t\t\t\t\te4.style.display = \"none\";\r\n");
      out.write("\t\t\t\te3.style.display = \"block\";\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\te3.style.display = \"none\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction myFunctionSortButton() {\r\n");
      out.write("\t\t\tif (e4.style.display === \"none\") {\r\n");
      out.write("\t\t\t\tif(e1.style.display === \"block\")\r\n");
      out.write("\t\t\t\t\te1.style.display = \"none\";\r\n");
      out.write("\t\t\t\tif(e2.style.display === \"block\")\r\n");
      out.write("\t\t\t\t\te2.style.display = \"none\";\r\n");
      out.write("\t\t\t\tif(e3.style.display === \"block\")\r\n");
      out.write("\t\t\t\t\te3.style.display = \"none\";\r\n");
      out.write("\t\t\t\te4.style.display = \"block\";\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\te4.style.display = \"none\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");

	}

    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
