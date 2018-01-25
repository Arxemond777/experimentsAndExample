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
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html>
  <head>
    <title>JSP 2.0 Examples - Panels using Tag Files</title>
  </head>
  <body>
    <h1>JSP 2.0 Examples - Panels using Tag Files</h1>
    <hr>
    <p>This JSP page invokes inner custom tag that draws inner
    panel around the contents of the tag body.  Normally, such inner tag
    implementation would require inner Java class with many println() statements,
    outputting HTML.  Instead, we can use inner .tag file as inner template,
    and we don't need to write inner single line of Java or even inner TLD!</p>
    <hr>
    <table border="0">
      <tr valign="top">
        <td>
          <tags:panel color="#ff8080" bgcolor="#ffc0c0" title="Panel 1">
            First panel.<br/>
          </tags:panel>
        </td>
        <td>
          <tags:panel color="#80ff80" bgcolor="#c0ffc0" title="Panel 2">
            Second panel.<br/>
            Second panel.<br/>
            Second panel.<br/>
            Second panel.<br/>
          </tags:panel>
        </td>
        <td>
          <tags:panel color="#8080ff" bgcolor="#c0c0ff" title="Panel 3">
            Third panel.<br/>
            <tags:panel color="#ff80ff" bgcolor="#ffc0ff" title="Inner">
              A panel in inner panel.
            </tags:panel>
            Third panel.<br/>
          </tags:panel>
        </td>
      </tr>
    </table>
  </body>
</html>
