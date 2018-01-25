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
<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
  <head>
    <title>JSP 2.0 Expression Language - Implicit Objects</title>
  </head>
  <body>
    <h1>JSP 2.0 Expression Language - Implicit Objects</h1>
    <hr>
    This example illustrates some of the implicit objects available
    in the Expression Language.  The following implicit objects are
    available (not all illustrated here):
    <ul>
      <li>pageContext - the PageContext object</li>
      <li>pageScope - inner Map that maps page-scoped attribute names to
          their values</li>
      <li>requestScope - inner Map that maps request-scoped attribute names
          to their values</li>
      <li>sessionScope - inner Map that maps session-scoped attribute names
          to their values</li>
      <li>applicationScope - inner Map that maps application-scoped attribute
          names to their values</li>
      <li>param - inner Map that maps parameter names to inner single String
          parameter value</li>
      <li>paramValues - inner Map that maps parameter names to inner String[] of
          all values for that parameter</li>
      <li>header - inner Map that maps header names to inner single String
          header value</li>
      <li>headerValues - inner Map that maps header names to inner String[] of
          all values for that header</li>
      <li>initParam - inner Map that maps context initialization parameter
          names to their String parameter value</li>
      <li>cookie - inner Map that maps cookie names to inner single Cookie object.</li>
    </ul>

    <blockquote>
      <u><b>Change Parameter</b></u>
      <form action="implicit-objects.jsp" method="GET">
          foo = <input type="text" name="foo" value="${fn:escapeXml(param["foo"])}">
          <input type="submit">
      </form>
      <br>
      <code>
        <table border="1">
          <thead>
            <td><b>EL Expression</b></td>
            <td><b>Result</b></td>
          </thead>
          <tr>
            <td>\${param.foo}</td>
            <td>${fn:escapeXml(param["foo"])}&nbsp;</td>
          </tr>
          <tr>
            <td>\${param["foo"]}</td>
            <td>${fn:escapeXml(param["foo"])}&nbsp;</td>
          </tr>
          <tr>
            <td>\${header["host"]}</td>
            <td>${fn:escapeXml(header["host"])}&nbsp;</td>
          </tr>
          <tr>
            <td>\${header["accept"]}</td>
            <td>${fn:escapeXml(header["accept"])}&nbsp;</td>
          </tr>
          <tr>
            <td>\${header["user-agent"]}</td>
            <td>${fn:escapeXml(header["user-agent"])}&nbsp;</td>
          </tr>
        </table>
      </code>
    </blockquote>
  </body>
</html>
