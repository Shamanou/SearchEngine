<%-- 
    Document   : search
    Created on : Sep 25, 2016, 7:36:37 PM
    Author     : Shamanou van Leeuwen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search results</title>
    </head>
    <body>
        <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
        <h1>Search Results</h1>
        <table class="pure-table">
        <thead>
            <tr>
                <th>Category</th>
                <th>Field</th>
                <th>Content</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${catalogs}" var="val">
                <tr class="pure-table-odd">
                    <td>catalog</td>
                    <td>language</td>
                    <td><c:out value="${val.getLanguage()}"/></td>
                </tr>
            </c:forEach>
            <c:forEach items="${datasets}" var="dataset">
                <c:forEach items="${dataset.getCreator()}" var='val'>
                    <tr class="pure-table-odd">
                        <td>dataset</td>
                        <td>creator</td>
                        <td><c:out value="${val}"/></td>
                    </tr>
                </c:forEach>
                <tr class="pure-table-odd">
                    <td>dataset</td>
                    <td>description</td>
                    <td><c:out value="${dataset.getDescription()}"/></td>
                </tr>
                <tr class="pure-table-odd">
                    <td>dataset</td>
                    <td>language</td>
                    <td><c:out value="${dataset.getLanguage()}"/></td>
                </tr>
                <tr class="pure-table-odd">
                    <td>dataset</td>
                    <td>label</td>
                    <td><c:out value="${dataset.getLabel()}"/></td>
                </tr>
                <c:forEach items="${dataset.getPublisher()}" var='val'>
                    <tr class="pure-table-odd">
                        <td>dataset</td>
                        <td>publisher</td>
                        <td><c:out value="${val}"/></td>
                    </tr>
                </c:forEach>
                <c:forEach items="${dataset.getKeyword()}" var='val'>
                    <tr class="pure-table-odd">
                        <td>dataset</td>
                        <td>keyword</td>
                        <td><c:out value="${val}"/></td>
                    </tr>
                </c:forEach>
            </c:forEach>
            <c:forEach items="${distributions}" var="distribution">
                <tr class="pure-table-odd">
                    <td>distribution</td>
                    <td>license</td>
                    <td><c:out value="${distribution.getLicense()}"/></td>
                </tr>
                <tr class="pure-table-odd">
                    <td>distribution</td>
                    <td>label</td>
                    <td><c:out value="${distribution.getLabel()}"/></td>
                </tr>
                <tr class="pure-table-odd">
                    <td>distribution</td>
                    <td>access url</td>
                    <td><c:out value="${distribution.getAccessUrl()}"/></td>
                </tr>
                <tr class="pure-table-odd">
                    <td>distribution</td>
                    <td>media type</td>
                    <td><c:out value="${distribution.getMediaType()}"/></td>
                </tr>
            </c:forEach>
            <c:forEach items="${fdps}" var="fdp">
                <tr class="pure-table-odd">
                    <td>fdp</td>
                    <td>api version</td>
                    <td><c:out value="${fdp.getApiVersion()}"/></td>
                </tr>
                <tr class="pure-table-odd">
                    <td>fdp</td>
                    <td>contact</td>
                    <td><c:out value="${fdp.getContact()}"/></td>
                </tr>
                <tr class="pure-table-odd">
                    <td>fdp</td>
                    <td>description</td>
                    <td><c:out value="${fdp.getDescription()}"/></td>
                </tr>
                <tr class="pure-table-odd">
                    <td>fdp</td>
                    <td>language</td>
                    <td><c:out value="${fdp.getLanguage()}"/></td>
                </tr>
                <tr class="pure-table-odd">
                    <td>fdp</td>
                    <td>license</td>
                    <td><c:out value="${fdp.getLicense()}"/></td>
                </tr>
                <tr class="pure-table-odd">
                    <td>fdp</td>
                    <td>publisher</td>
                    <td><c:out value="${fdp.getPublisher()}"/></td>
                </tr>
                <tr class="pure-table-odd">
                    <td>fdp</td>
                    <td>label</td>
                    <td><c:out value="${fdp.getLabel()}"/></td>
                </tr>
            </c:forEach>
        </tbody>
        </table>
    </body>
</html>
