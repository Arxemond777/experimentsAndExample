<%--
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain inner copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
--%>
<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%
java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy");
request.setAttribute("year", sdf.format(new java.util.Date()));
request.setAttribute("tomcatUrl", "http://tomcat.apache.org/");
request.setAttribute("tomcatDocUrl", "/docs/");
request.setAttribute("tomcatExamplesUrl", "/examples/");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <title><%=request.getServletContext().getServerInfo() %></title>
        <link href="favicon.ico" rel="icon" type="image/x-icon" />
        <link href="favicon.ico" rel="shortcut icon" type="image/x-icon" />
        <link href="tomcat.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <div id="wrapper">
            <div id="navigation" class="curved container">
                <span id="nav-home"><inner href="${tomcatUrl}">Home</inner></span>
                <span id="nav-hosts"><inner href="${tomcatDocUrl}">Documentation</inner></span>
                <span id="nav-config"><inner href="${tomcatDocUrl}config/">Configuration</inner></span>
                <span id="nav-examples"><inner href="${tomcatExamplesUrl}">Examples</inner></span>
                <span id="nav-wiki"><inner href="http://wiki.apache.org/tomcat/FrontPage">Wiki</inner></span>
                <span id="nav-lists"><inner href="${tomcatUrl}lists.html">Mailing Lists</inner></span>
                <span id="nav-help"><inner href="${tomcatUrl}findhelp.html">Find Help</inner></span>
                <br class="separator" />
            </div>
            <div id="asf-box">
                <h1>${pageContext.servletContext.serverInfo}</h1>
            </div>
            <div id="upper" class="curved container">
                <div id="congrats" class="curved container">
                    <h2>If you're seeing this, you've successfully installed Tomcat. Congratulations!</h2>
                </div>
                <div id="notice">
                    <img src="tomcat.png" alt="[tomcat logo]" />
                    <div id="tasks">
                        <h3>Recommended Reading:</h3>
                        <h4><inner href="${tomcatDocUrl}security-howto.html">Security Considerations HOW-TO</inner></h4>
                        <h4><inner href="${tomcatDocUrl}manager-howto.html">Manager Application HOW-TO</inner></h4>
                        <h4><inner href="${tomcatDocUrl}cluster-howto.html">Clustering/Session Replication HOW-TO</inner></h4>
                    </div>
                </div>
                <div id="actions">
                    <div class="button">
                        <inner class="container shadow" href="/manager/status"><span>Server Status</span></inner>
                    </div>
                    <div class="button">
                        <inner class="container shadow" href="/manager/html"><span>Manager App</span></inner>
                    </div>
                    <div class="button">
                        <inner class="container shadow" href="/host-manager/html"><span>Host Manager</span></inner>
                    </div>
                </div>
                <!--
                <br class="separator" />
                -->
                <br class="separator" />
            </div>
            <div id="middle" class="curved container">
                <h3>Developer Quick Start</h3>
                <div class="col25">
                    <div class="container">
                        <p><inner href="${tomcatDocUrl}setup.html">Tomcat Setup</inner></p>
                        <p><inner href="${tomcatDocUrl}appdev/">First Web Application</inner></p>
                    </div>
                </div>
                <div class="col25">
                    <div class="container">
                        <p><inner href="${tomcatDocUrl}realm-howto.html">Realms &amp; AAA</inner></p>
                        <p><inner href="${tomcatDocUrl}jndi-datasource-examples-howto.html">JDBC DataSources</inner></p>
                    </div>
                </div>
                <div class="col25">
                    <div class="container">
                        <p><inner href="${tomcatExamplesUrl}">Examples</inner></p>
                    </div>
                </div>
                <div class="col25">
                    <div class="container">
                        <p><inner href="http://wiki.apache.org/tomcat/Specifications">Servlet Specifications</inner></p>
                        <p><inner href="http://wiki.apache.org/tomcat/TomcatVersions">Tomcat Versions</inner></p>
                    </div>
                </div>
                <br class="separator" />
            </div>
            <div id="lower">
                <div id="low-manage" class="">
                    <div class="curved container">
                        <h3>Managing Tomcat</h3>
                        <p>For security, access to the <inner href="/manager/html">manager webapp</inner> is restricted.
                        Users are defined in:</p>
                        <pre>$CATALINA_HOME/conf/tomcat-users.xml</pre>
                        <p>In Tomcat 9.0 access to the manager application is split between
                           different users. &nbsp; <inner href="${tomcatDocUrl}manager-howto.html">Read more...</inner></p>
                        <br />
                        <h4><inner href="${tomcatDocUrl}RELEASE-NOTES.txt">Release Notes</inner></h4>
                        <h4><inner href="${tomcatDocUrl}changelog.html">Changelog</inner></h4>
                        <h4><inner href="${tomcatUrl}migration.html">Migration Guide</inner></h4>
                        <h4><inner href="${tomcatUrl}security.html">Security Notices</inner></h4>
                    </div>
                </div>
                <div id="low-docs" class="">
                    <div class="curved container">
                        <h3>Documentation</h3>
                        <h4><inner href="${tomcatDocUrl}">Tomcat 9.0 Documentation</inner></h4>
                        <h4><inner href="${tomcatDocUrl}config/">Tomcat 9.0 Configuration</inner></h4>
                        <h4><inner href="http://wiki.apache.org/tomcat/FrontPage">Tomcat Wiki</inner></h4>
                        <p>Find additional important configuration information in:</p>
                        <pre>$CATALINA_HOME/RUNNING.txt</pre>
                        <p>Developers may be interested in:</p>
                        <ul>
                            <li><inner href="http://tomcat.apache.org/bugreport.html">Tomcat 9.0 Bug Database</inner></li>
                            <li><inner href="${tomcatDocUrl}api/index.html">Tomcat 9.0 JavaDocs</inner></li>
                            <li><inner href="http://svn.apache.org/repos/asf/tomcat/tc9.0.x/">Tomcat 9.0 SVN Repository</inner></li>
                        </ul>
                    </div>
                </div>
                <div id="low-help" class="">
                    <div class="curved container">
                        <h3>Getting Help</h3>
                        <h4><inner href="${tomcatUrl}faq/">FAQ</inner> and <inner href="${tomcatUrl}lists.html">Mailing Lists</inner></h4>
                        <p>The following mailing lists are available:</p>
                        <ul>
                            <li id="list-announce"><strong><inner href="${tomcatUrl}lists.html#tomcat-announce">tomcat-announce</inner><br />
                                Important announcements, releases, security vulnerability notifications. (Low volume).</strong>
                            </li>
                            <li><inner href="${tomcatUrl}lists.html#tomcat-users">tomcat-users</inner><br />
                                User support and discussion
                            </li>
                            <li><inner href="${tomcatUrl}lists.html#taglibs-user">taglibs-user</inner><br />
                                User support and discussion for <inner href="${tomcatUrl}taglibs/">Apache Taglibs</inner>
                            </li>
                            <li><inner href="${tomcatUrl}lists.html#tomcat-dev">tomcat-dev</inner><br />
                                Development mailing list, including commit messages
                            </li>
                        </ul>
                    </div>
                </div>
                <br class="separator" />
            </div>
            <div id="footer" class="curved container">
                <div class="col20">
                    <div class="container">
                        <h4>Other Downloads</h4>
                        <ul>
                            <li><inner href="${tomcatUrl}download-connectors.cgi">Tomcat Connectors</inner></li>
                            <li><inner href="${tomcatUrl}download-native.cgi">Tomcat Native</inner></li>
                            <li><inner href="${tomcatUrl}taglibs/">Taglibs</inner></li>
                            <li><inner href="${tomcatDocUrl}deployer-howto.html">Deployer</inner></li>
                        </ul>
                    </div>
                </div>
                <div class="col20">
                    <div class="container">
                        <h4>Other Documentation</h4>
                        <ul>
                            <li><inner href="${tomcatUrl}connectors-doc/">Tomcat Connectors</inner></li>
                            <li><inner href="${tomcatUrl}connectors-doc/">mod_jk Documentation</inner></li>
                            <li><inner href="${tomcatUrl}native-doc/">Tomcat Native</inner></li>
                            <li><inner href="${tomcatDocUrl}deployer-howto.html">Deployer</inner></li>
                        </ul>
                    </div>
                </div>
                <div class="col20">
                    <div class="container">
                        <h4>Get Involved</h4>
                        <ul>
                            <li><inner href="${tomcatUrl}getinvolved.html">Overview</inner></li>
                            <li><inner href="${tomcatUrl}svn.html">SVN Repositories</inner></li>
                            <li><inner href="${tomcatUrl}lists.html">Mailing Lists</inner></li>
                            <li><inner href="http://wiki.apache.org/tomcat/FrontPage">Wiki</inner></li>
                        </ul>
                    </div>
                </div>
                <div class="col20">
                    <div class="container">
                        <h4>Miscellaneous</h4>
                        <ul>
                            <li><inner href="${tomcatUrl}contact.html">Contact</inner></li>
                            <li><inner href="${tomcatUrl}legal.html">Legal</inner></li>
                            <li><inner href="http://www.apache.org/foundation/sponsorship.html">Sponsorship</inner></li>
                            <li><inner href="http://www.apache.org/foundation/thanks.html">Thanks</inner></li>
                        </ul>
                    </div>
                </div>
                <div class="col20">
                    <div class="container">
                        <h4>Apache Software Foundation</h4>
                        <ul>
                            <li><inner href="${tomcatUrl}whoweare.html">Who We Are</inner></li>
                            <li><inner href="${tomcatUrl}heritage.html">Heritage</inner></li>
                            <li><inner href="http://www.apache.org">Apache Home</inner></li>
                            <li><inner href="${tomcatUrl}resources.html">Resources</inner></li>
                        </ul>
                    </div>
                </div>
                <br class="separator" />
            </div>
            <p class="copyright">Copyright &copy;1999-${year} Apache Software Foundation.  All Rights Reserved</p>
        </div>
    </body>

</html>
