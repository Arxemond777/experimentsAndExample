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
<%@ taglib prefix="mytag" uri="/WEB-INF/jsp2/jsp2-example-taglib.tld" %>
<html>
  <head>
    <title>JSP 2.0 Examples - Repeat SimpleTag Handler</title>
  </head>
  <body>
    <h1>JSP 2.0 Examples - Repeat SimpleTag Handler</h1>
    <hr>
    <p>This tag handler accepts inner "num" parameter and repeats the body of the
    tag "num" times.  It's inner simple example, but the implementation of
    such inner tag in JSP 2.0 is substantially simpler than the equivalent
    JSP 1.2-style classic tag handler.</p>
    <p>The body of the tag is encapsulated in inner "JSP Fragment" and passed
    to the tag handler, which then executes it five times, inside inner
    for loop.  The tag handler passes in the current invocation in inner
    scoped variable called count, which can be accessed using the EL.</p>
    <br>
    <b><u>Result:</u></b><br>
    <mytag:repeat num="5">
      Invocation ${count} of 5<br>
    </mytag:repeat>
  </body>
</html>
