/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.54
 * Generated at: 2021-12-17 11:34:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1639549998000L));
    _jspx_dependants.put("jar:file:/C:/Bcle/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ViewPage/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1098678690000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
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

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>B:CLE Footer(예비용)</title>\r\n");
      out.write("\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<script src=\"https://kit.fontawesome.com/dab690a483.js\" crossorigin=\"anonymous\"></script>\t\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\t\r\n");
      out.write("/*reset*/\r\n");
      out.write("* {margin: 0;padding: 0;}\r\n");
      out.write("body {margin: 0;}\r\n");
      out.write("h1, h2, h3, h4, h5, h6, p, ul, ol, li, dl, dt, dd {margin: 0; padding: 0;}\r\n");
      out.write("h1, h2, h3, h4, h5, h6 {font-weight: 700; }\r\n");
      out.write("a {color: inherit; text-decoration: inherit;}\r\n");
      out.write("img {vertical-align: middle;}\r\n");
      out.write("a img {border: none;}\r\n");
      out.write("li {list-style: none;}\r\n");
      out.write("address, em, i, ul {font-style: normal;}\r\n");
      out.write("\r\n");
      out.write("/*layout*/\r\n");
      out.write(".mo {display: none;}\r\n");
      out.write(".en {font-family: 'Exo 2', sans-serif;}\r\n");
      out.write("body {font-family: 'Noto Sans KR', sans-serif; font-size: 14px;}\r\n");
      out.write(".wrap {margin: 0 auto; }\r\n");
      out.write("\r\n");
      out.write("#footer-wrapper\r\n");
      out.write("{\r\n");
      out.write("\tbackground-color: #105B63;\r\n");
      out.write("\tfont-family: 'Noto Sans KR', sans-serif;\r\n");
      out.write("\tfont-size: 12pt;\r\n");
      out.write("\t/* position:fixed; */\r\n");
      out.write("}\r\n");
      out.write(".title\r\n");
      out.write("{\r\n");
      out.write("\tfont-family: 'Noto Sans KR', sans-serif;\r\n");
      out.write("\tfont-size: 15pt;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".container\r\n");
      out.write("{\r\n");
      out.write("\tpadding: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul\r\n");
      out.write("{\r\n");
      out.write("   list-style:none;\r\n");
      out.write("   padding-left:0px;\r\n");
      out.write("}\r\n");
      out.write("a.menuitem\r\n");
      out.write("{\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("}\r\n");
      out.write("a.menuitem\r\n");
      out.write("{\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("}\r\n");
      out.write("a.menuitem:hover\r\n");
      out.write("{\r\n");
      out.write("\tcolor: #FFD34E;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("p.menuitem\r\n");
      out.write("{\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("}\r\n");
      out.write(".second-box\r\n");
      out.write("{\r\n");
      out.write("  display: flex;\r\n");
      out.write("  justify-content: flex-end;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".icon\r\n");
      out.write("{\r\n");
      out.write("  /* width: 40%; */\r\n");
      out.write("  display: flex;\r\n");
      out.write("  justify-content: flex-end;\r\n");
      out.write("  color: #105B63;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".icon-box \r\n");
      out.write("{\r\n");
      out.write("  width: 54px;\r\n");
      out.write("  height: 54px;\r\n");
      out.write("  background-color: white;\r\n");
      out.write("  border-radius: 50%;\r\n");
      out.write("  margin-right: 15px;\r\n");
      out.write("  display: flex;\r\n");
      out.write("  justify-content: center;\r\n");
      out.write("  align-items: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".icon \r\n");
      out.write("{\r\n");
      out.write("  font-size: 24px;\r\n");
      out.write("}\r\n");
      out.write(".icon:hover {\r\n");
      out.write("  color: #FFD34E;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul.menu\r\n");
      out.write("{\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!-- Footer -->\r\n");
      out.write("<div id=\"footer-wrapper\">\r\n");
      out.write("\t<footer id=\"footer\" class=\"container\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-3 col-6-medium col-12-small\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Links -->\r\n");
      out.write("\t\t\t\t\t<section class=\"widget links\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"title\">B:CLE</div>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"style2\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\" class=\"menuitem\">동아리 만들기</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"mainhome.action\" class=\"menuitem\">동아리 구경가기</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<!-- <li><a href=\"#\">Felis varius pellentesque potenti</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Nullam scelerisque blandit leo</a></li> -->\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</section>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-3 col-6-medium col-12-small\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Links -->\r\n");
      out.write("\t\t\t\t\t<section class=\"widget links\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"title\">고객센터</div>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"style2\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\" class=\"menuitem\">FAQ</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\" class=\"menuitem\">문의하기</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\" class=\"menuitem\">이용약관</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<!-- <li><a href=\"#\">Felis varius pellentesque potenti</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Nullam scelerisque blandit leo</a></li> -->\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</section>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"col-3 col-6-medium col-12-small\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Contact -->\r\n");
      out.write("\t\t\t\t\t<section class=\"widget contact last\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"title\">Contact Us</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<p class=\"menuitem\">B:CLE<br />\r\n");
      out.write("\t\t\t\t\t\t서울특별시 마포구 월드컵북로 21 2층 풍성빌딩<br />\r\n");
      out.write("\t\t\t\t\t\t(02) 123-4567</p>\r\n");
      out.write("\t\t\t\t\t</section>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"col-3 col-6-medium col-12-small\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- 아이콘 -->\r\n");
      out.write("\t\t\t\t<!-- <section class=\"widget contact last icon\"> -->\r\n");
      out.write("\t\t\t\t\t<div class=\"second-box\">\r\n");
      out.write("\t\t\t              <div class=\"icon-box\">\r\n");
      out.write("\t\t\t                  <i class=\"fab fa-instagram icon\"></i>\r\n");
      out.write("\t\t\t              </div>\r\n");
      out.write("\t\t\t              <div class=\"icon-box\">\r\n");
      out.write("\t\t\t                  <i class=\"fab fa-twitter icon\"></i>\r\n");
      out.write("\t\t\t              </div>\r\n");
      out.write("\t\t\t              <div class=\"icon-box\">\r\n");
      out.write("\t\t\t                  <i class=\"fab fa-facebook-f icon\"></i>\r\n");
      out.write("\t\t\t              </div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- </section> -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-12\">\r\n");
      out.write("\t\t\t\t<div id=\"copyright\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"menu\" style=\"text-align: center;\">\r\n");
      out.write("\t\t\t\t\t\t<li>&copy; 2021 B:CLE. All rights reserved</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</footer>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
